<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
      #game {
        border: 1px solid black;
      }
    </style>
  </head>
  <body>
    <canvas id="game" width="200" height="400"></canvas>
    <script>
      // Get the canvas element
      const canvas = document.getElementById("game");
      const ctx = canvas.getContext("2d");

      // Set the size of a block
      const blockSize = 20;

      // Set the size of the game board
      const boardWidth = 10;
      const boardHeight = 20;

      // Set the initial position of the tetromino
      let x = Math.floor(boardWidth / 2);
      let y = 0;

      // Set the initial state of the game board
      let board = [];
      for (let i = 0; i < boardHeight; i++) {
        board[i] = [];
        for (let j = 0; j < boardWidth; j++) {
          board[i][j] = 0;
        }
      }

      // Set the initial shape and rotation of the tetromino
      let shape = "T";
      let rotation = 0;

      // Set the color for each tetromino shape
      const colors = {
        T: "purple",
        O: "yellow",
        L: "orange",
        J: "blue",
        S: "green",
        Z: "red",
        I: "cyan"
      };

      // Define the shapes of each tetromino
      const shapes = {
        T: [
          [0, 1, 0],
          [1, 1, 1],
          [0, 0, 0]
        ],
        O: [
          [1, 1],
          [1, 1]
        ],
        L: [
          [0, 0, 1],
          [1, 1, 1],
          [0, 0, 0]
        ],
        J: [
          [1, 0, 0],
          [1, 1, 1],
          [0, 0, 0]
        ],
        S: [
          [0, 1, 1],
          [1, 1, 0],
          [0, 0, 0]
        ],
        Z: [
          [1, 1, 0],
          [0, 1, 1],
          [0, 0, 0]
        ],
        I: [
          [0, 1, 0, 0],
          [0, 1, 0, 0],
          [0, 1, 0, 0],
          [0, 1, 0, 0]
        ]
      };

      // Draw a block at the given x, y position
      function drawBlock(x, y) {
        ctx.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
        ctx.strokeRect(
          x * blockSize,
          y * blockSize,
          blockSize,
          blockSize
        );
      }
      
      function canMove(shape, rotation, x, y) {
          for (let i = 0; i < shape.length; i++) {
            for (let j = 0; j < shape[i].length; j++) {
              if (shape[i][j]) {
                let newX = x + j;
                let newY = y + i;

                if (
                  newX < 0 ||
                  newX >= boardWidth ||
                  newY >= boardHeight ||
                  board[newY][newX]
                ) {
                  return false;
                }
              }
            }
          }
          return true;
        }

        // Copy the state of the tetromino to the game board
        function addPieceToBoard(shape, rotation, x, y) {
          for (let i = 0; i < shape.length; i++) {
            for (let j = 0; j < shape[i].length; j++) {
              if (shape[i][j]) {
                board[y + i][x + j] = shape[i][j];
              }
            }
          }
        }

        // Clear a completed row and move all rows above it down
        function clearRows() {
          for (let i = 0; i < boardHeight; i++) {
            let rowFilled = true;

            for (let j = 0; j < boardWidth; j++) {
              if (!board[i][j]) {
                rowFilled = false;
                break;
              }
            }

            if (rowFilled) {
              for (let k = i; k > 1; k--) {
                for (let l = 0; l < boardWidth; l++) {
                  board[k][l] = board[k - 1][l];
                }
              }

              for (let l = 0; l < boardWidth; l++) {
                board[0][l] = 0;
              }
            }
          }
        }

        // Draw the current state of the game board
        function drawBoard() {
          ctx.clearRect(0, 0, canvas.width, canvas.height);

          for (let i = 0; i < boardHeight; i++) {
            for (let j = 0; j < boardWidth; j++) {
              if (board[i][j]) {
                ctx.fillStyle = colors[board[i][j]];
                drawBlock(j, i);
              }
            }
          }
        }

        // Draw the current tetromino
        function draw() {
          ctx.fillStyle = colors[shape];

          for (let i = 0; i < shapes[shape][rotation].length; i++) {
            for (let j = 0; j < shapes[shape][rotation][i].length; j++) {
              if (shapes[shape][rotation][i][j]) {
                drawBlock(x + j, y + i);
              }
            }
          }
        }

        // Move the tetromino down one block
        function moveDown() {
          if (canMove(shapes[shape][rotation], x, y + 1)) {
            y++;
          } else {
        	  addPieceToBoard(shapes[shape][rotation], x, y);
              clearRows();
              x = 3;
              y = 0;
              shape = Math.floor(Math.random() * shapes.length);
              rotation = 0;
            }
          }

          // Handle player movement and rotation
          function handleMovement(event) {
            switch (event.keyCode) {
              case 37:
                if (canMove(shapes[shape][rotation], x - 1, y)) {
                  x--;
                }
                break;
              case 38:
                let newRotation = rotation + 1;
                if (newRotation === shapes[shape].length) {
                  newRotation = 0;
                }
                if (canMove(shapes[shape][newRotation], x, y)) {
                  rotation = newRotation;
                }
                break;
              case 39:
                if (canMove(shapes[shape][rotation], x + 1, y)) {
                  x++;
                }
                break;
              case 40:
                moveDown();
                break;
            }
          }

          document.addEventListener("keydown", handleMovement);

          // Game loop
          function update() {
            moveDown();
            drawBoard();
            draw();
            requestAnimationFrame(update);
          }
          update();
        
      </script>
    </body>
    </html>
      