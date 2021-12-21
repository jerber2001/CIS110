// /**
//  * Name: Jerry Cai
//  * Pennkey: 
//  * Execution: java Game
//  *
//  * Primary class that handles game functions and tasks
// **/
// public class Game {
    
//     //Make Cell counter to count remaining cells
    
//     //Main method for running program loop
//     public static void main(String[] args) {
//         while (true) {
//             //Creates objects to be used in the game loop
//             Game test = new Game();
//             Board board = new Board();
//             int counter = 10;
//             boolean gameStart = true;
            
//             test.drawGrid(board);

//             test.FirstClick(board, counter);
            
//             //Populates array with values of the number array
//             for (int i = 0; i <= 8; i++) {
//                 for (int j = 0; j <= 8; j++) {
//                     System.out.print(board.cellArray[i][j].getValue());
//                 }
//                 System.out.println("");
//             }
            
//             //In Lieu of displayArray
//             for (int i = 0; i <= 8; i++) {
//                 for (int j = 0; j <= 8; j++) {
//                     test.countAdjacent(board.cellArray, board.cellArray[i][j]);
//                     System.out.print(board.cellArray[i][j].getValue());
//                 }
//                 System.out.println("");
//             }
            
//             System.out.println("");
//             System.out.println("Filled Array");
            
//             while (gameStart) {
//                 if (PennDraw.mousePressed()) {
//                     test.Reveal(board.cellArray,
//                     (int) (PennDraw.mouseX() * 9),
//                     (int) (PennDraw.mouseY() * 9));
                    
//                     int cellCounter = 0;
//                     //prints out counter
//                     for (int m = 0; m < 9; m++) {
//                         for (int n = 0; n < 9; n++) {
//                             if (board.cellArray[m][n].returnRevealed() == true) {
//                                 cellCounter++;
//                             }
//                         }
//                     }
//                     System.out.println(cellCounter);
                    
//                     //Presses on  Bomb
//                     if (board.cellArray
//                     [8 - (int) (PennDraw.mouseY() * 9)]
//                     [(int) (PennDraw.mouseX() * 9)].getValue() == 9) {
//                         PennDraw.setPenColor(PennDraw.BLACK);
//                         PennDraw.filledSquare(0.5, 0.5, 0.3);
//                         PennDraw.setPenColor(PennDraw.WHITE);
//                         PennDraw.text(0.5, 0.5, "You Lose!");
                        
//                         while (!PennDraw.mousePressed()) {
//                             gameStart = false;
//                         }

                        
//                         } else if (counter == 71) {
//                         PennDraw.setPenColor(PennDraw.BLACK);
//                         PennDraw.filledSquare(0.5, 0.5, 0.3);
//                         PennDraw.setPenColor(PennDraw.WHITE);
//                         PennDraw.text(0.5, 0.5, "You Win!");
//                         gameStart = false;
//                         while (!PennDraw.mousePressed()) {
//                             gameStart = false;
//                         }
//                     }
                    
//                 }
//             }
            
//         }
        
//     }
    
//     int fClickX;
//     int fClickY;
    
//     //Objects to Reset: 1. Screen 2. Array
//     /**
//      * Inputs: TODO
//      * Outputs: TODO
//      * Description: TODO
//     */
//     public void reset(Board b) {
//         PennDraw.clear();
//         b.cellArray = new Cell[9][9];
        
//     }
    
//     /**
//      * Inputs: TODO
//      * Outputs: TODO
//      * Description: TODO
//     */
//     public void drawGrid(Board b) {
//         //         PennDraw.setCanvasSize(512, 512);
//         PennDraw.picture(0.5, 0.5, "grid.png", 540, 540);
        
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 b.cellArray[i][j] = new NumberCell(0, j, 8 - i);
                
//             }
//         }
//     }
    
//     //First Click Detected
//     /**
//      * Inputs: TODO
//      * Outputs: TODO
//      * Description: TODO
//     */
//     public void FirstClick(Board b, int c) {
//         int k = 0;
//         while (k < c) {
//             if (PennDraw.mousePressed()) {
//                 //Create a revealed cell
//                 fClickX = (int) (PennDraw.mouseX() * 9);
//                 fClickY = (int) (PennDraw.mouseY() * 9);
                
//                 System.out.println("");
//                 System.out.print(fClickX);
//                 System.out.println(fClickY);
                
//                 //New Loop
//                 for (int i = 8; i >= 0; i--) {
//                     for (int j = 0; j <= 8; j++) {
//                         double prob = Math.random();
//                         System.out.println("This is prob "+prob);
                        
//                         int rIndex = i;
//                         int cIndex = j;
//                         int xCell = cIndex;
//                         int yCell = 8 - rIndex;
                        
//                         if (k < c && prob < 0.15) {
//                             Cell bombCell = new BombCell(9, cIndex, 8 - rIndex);
//                             b.cellArray[rIndex][cIndex] = bombCell;
                            
//                             double xPos = ( (cIndex * (1.0 / 9)) + (1.0/18));
//                             double yPos = ( ((8 - rIndex) * (1.0 / 9)) + (1.0/18));
//                             double cellSize = (512 / 9.0) - 5;
                            
//                             //Changes rIndex and cIndex of each cellArray
//                             b.cellArray[rIndex][cIndex].setX(cIndex);
//                             b.cellArray[rIndex][cIndex].setY(8 - rIndex);
                            
//                             System.out.print("Pos:"+xPos);
//                             System.out.println(yPos);
                            
                            
//                             System.out.print("Index:"+rIndex);
//                             System.out.println(cIndex);
                            
//                             System.out.print("Cell:"+xCell);
//                             System.out.println(yCell);
                            
//                             System.out.print("Pos"+b.cellArray[rIndex][cIndex].getX());
//                             System.out.println(b.cellArray[rIndex][cIndex].getY());
                            
//                             System.out.print(b.cellArray[rIndex][cIndex].getX());
//                             System.out.println(b.cellArray[rIndex][cIndex].getY());
                            
//                             k++;
//                             System.out.println("K Value = " + k + "Value = " + b.cellArray[rIndex][cIndex].getValue());
//                         }
//                         //                         System.out.print(b.cellArray[i][j].getValue());
//                     }
                    
//                 }
                
//             }
//         }
//     }
    
//     /**
//      * Inputs: TODO
//      * Outputs: TODO
//      * Description: TODO
//     */
//     public void countAdjacent(Cell[][] a, Cell thisCell) {
//         int x = thisCell.getX();
//         int y = thisCell.getY();
//         int counter = 0;
        
//         //If the cell is a mine, immediately set value
//         if (thisCell.getValue() != 9) {
//             thisCell.setValue(counter);
//             } else if (thisCell.getValue() == 9) {
//             thisCell.setValue(9);
//         }
        
//         for (int m = -1; m < 2; m++) {
//             if ((x + m >= 0 && x + m <= 8)) {
//                 for (int n = -1; n < 2; n++) {
//                     if ((y + n >= 0 && y + n <= 8)) {
//                         if (thisCell.getValue() != 9 && a[8 - (y + n)][x + m].getValue() == 9) {
//                             counter++;
//                         }
                        
//                     }
//                 }
//             }
            
//         }
        
//         if (thisCell.getValue() != 9) {
//             thisCell.setValue(counter);
//         }

//     }
    
//     /**
//      * Inputs: TODO
//      * Outputs: TODO
//      * Description: TODO
//     */
//     public void displayArray(Cell[][] a, Board b) {
//         if (PennDraw.mousePressed()) {
//             for (int i = 8; i <= 0; i--) {
//                 for (int j = 0; j <= 8; j++) {
//                     //                 b.cellArray[i][j] = new NumberCell(0, j, 8 - i);
//                     if (b.cellArray[i][j].getValue() != 9) {
//                         countAdjacent(a, b.cellArray[i][j]);

//                     }
//                     System.out.print("*");

//                 }
//                 System.out.println("");
//             }
//         }
        
//     }
    
    
//     /**
//      * Inputs: TODO
//      * Outputs: TODO
//      * Description: TODO
//     */
//     public void Reveal(Cell[][] a, int x, int y) {
//         int clickX = x;
//         int clickY = y;
//         int rIndex = 8 - clickY;
//         int cIndex = clickX;
//         double xPos = ( (cIndex * (1.0 / 9)) + (1.0/18));
//         double yPos = ( ((8 - rIndex) * (1.0 / 9)) + (1.0/18));
//         //Checking Corner Conditions
        
//         int rIndex0 = rIndex + 1;
//         int rIndex1 = rIndex;
//         int rIndex2 = rIndex - 1;
        
//         int cIndex0 = cIndex + 1;
//         int cIndex1 = cIndex;
//         int cIndex2 = cIndex - 1;
        
//         if (a[rIndex][cIndex].getValue() != 0 && (a[rIndex][cIndex].returnRevealed() == false)  ) {
//             placeCells(a[rIndex][cIndex], rIndex, cIndex);
            
//             } else if (a[rIndex][cIndex].getValue() == 0) {
//             placeCells(a[rIndex][cIndex], rIndex, cIndex);
            
//             if ((rIndex0 >= 0 && rIndex0 < 9) && (cIndex0 >= 0 && cIndex0 < 9) ) {
//                 if (a[rIndex0][cIndex0].getValue() != 0) {
//                     placeCells(a[rIndex0][cIndex0], rIndex0, cIndex0);
//                     } else if (a[rIndex0][cIndex0].getValue() == 0) {
//                     placeCells(a[rIndex0][cIndex0], rIndex0, cIndex0);
//                     Reveal(a, cIndex0, 8 - rIndex0);
//                 }
//             }
            
//             //R0 C1
//             if ((rIndex0 >= 0 && rIndex0 < 9) &&
//             (cIndex1 >= 0 && cIndex1 < 9) &&
//             (a[rIndex0][cIndex1].returnRevealed() == false)) {
//                 if (a[rIndex0][cIndex1].getValue() != 0) {
//                     placeCells(a[rIndex0][cIndex1], rIndex0, cIndex1);
//                     } else if (a[rIndex0][cIndex1].getValue() == 0) {
//                     placeCells(a[rIndex0][cIndex1], rIndex0, cIndex1);
//                     Reveal(a, cIndex1, 8 - rIndex0);
//                 }
//             }
            
//             //R0 C2
//             if ((rIndex0 >= 0 && rIndex0 < 9) &&
//             (cIndex2 >= 0 && cIndex2 < 9) &&
//             (a[rIndex0][cIndex2].returnRevealed() == false) ) {
//                 if (a[rIndex0][cIndex2].getValue() != 0) {
//                     placeCells(a[rIndex0][cIndex2], rIndex0, cIndex2);
//                     } else if (a[rIndex0][cIndex2].getValue() == 0) {
//                     placeCells(a[rIndex0][cIndex2], rIndex0, cIndex2);
//                     Reveal(a, cIndex2, 8 - rIndex0);
//                 }
//             }
            
//             //R1 C0
//             if ((rIndex1 >= 0 && rIndex1 < 9) &&
//             (cIndex0 >= 0 && cIndex0 < 9) &&
//             (a[rIndex1][cIndex0].returnRevealed() == false)) {
//                 if (a[rIndex1][cIndex0].getValue() != 0) {
//                     placeCells(a[rIndex1][cIndex0], rIndex1, cIndex0);
//                     } else if (a[rIndex1][cIndex0].getValue() == 0) {
//                     placeCells(a[rIndex1][cIndex0], rIndex1, cIndex0);
//                     Reveal(a, cIndex0, 8 - rIndex1);
//                 }
//             }
            
//             //R1 C1
//             if ((rIndex1 >= 0 && rIndex1 < 9) &&
//             (cIndex1 >= 0 && cIndex1 < 9) &&
//             (a[rIndex1][cIndex1].returnRevealed() == false)) {
//                 if (a[rIndex1][cIndex1].getValue() != 0) {
//                     placeCells(a[rIndex1][cIndex1], rIndex1, cIndex1);
//                     } else if (a[rIndex1][cIndex1].getValue() == 0) {
//                     placeCells(a[rIndex1][cIndex1], rIndex1, cIndex1);
//                     Reveal(a, cIndex1, 8 - rIndex1);
//                 }
//             }
            
//             //R1 C2
//             if ((rIndex1 >= 0 && rIndex1 < 9) &&
//             (cIndex2 >= 0 && cIndex2 < 9) &&
//             (a[rIndex1][cIndex2].returnRevealed() == false)) {
//                 if (a[rIndex1][cIndex2].getValue() != 0) {
//                     placeCells(a[rIndex1][cIndex2], rIndex1, cIndex2);
//                     } else if (a[rIndex1][cIndex2].getValue() == 0) {
//                     placeCells(a[rIndex1][cIndex2], rIndex1, cIndex2);
//                     Reveal(a, cIndex2, 8 - rIndex1);
//                 }
//             }
            
//             //R2 C0
//             if ((rIndex2 >= 0 && rIndex2 < 9) &&
//             (cIndex0 >= 0 && cIndex0 < 9) &&
//             (a[rIndex2][cIndex0].returnRevealed() == false)) {
//                 if (a[rIndex2][cIndex0].getValue() != 0) {
//                     placeCells(a[rIndex2][cIndex0], rIndex2, cIndex0);
//                     } else if (a[rIndex2][cIndex0].getValue() == 0) {
//                     placeCells(a[rIndex2][cIndex0], rIndex2, cIndex0);
//                     Reveal(a, cIndex0, 8 - rIndex2);
//                 }
//             }
            
//             //R2 C1
//             if ((rIndex2 >= 0 && rIndex2 < 9) &&
//             (cIndex1 >= 0 && cIndex1 < 9) &&
//             (a[rIndex2][cIndex1].returnRevealed() == false)) {
//                 if (a[rIndex2][cIndex1].getValue() != 0) {
//                     placeCells(a[rIndex2][cIndex1], rIndex2, cIndex1);
//                     } else if (a[rIndex2][cIndex1].getValue() == 0) {
//                     placeCells(a[rIndex2][cIndex1], rIndex2, cIndex1);
//                     Reveal(a, cIndex1, 8 - rIndex2);
//                 }
//             }
            
//             //R2 C2
//             if ((rIndex2 >= 0 && rIndex2 < 9) &&
//             (cIndex2 >= 0 && cIndex2 < 9) &&
//             (a[rIndex2][cIndex2].returnRevealed() == false)) {
//                 if (a[rIndex2][cIndex2].getValue() != 0) {
//                     placeCells(a[rIndex2][cIndex2], rIndex2, cIndex2);
//                     } else if (a[rIndex2][cIndex2].getValue() == 0) {
//                     placeCells(a[rIndex2][cIndex2], rIndex2, cIndex2);
//                     Reveal(a, cIndex2, 8 - rIndex2);
//                 }
//             }
//         }
        
//     }
    
//     /**
//      * Inputs: TODO
//      * Outputs: TODO
//      * Description: TODO
//     */
//     public void placeCells(Cell c, int rIndex, int cIndex) {
//         //clicked cell x and y position
        
//         double xPos = ( (cIndex * (1.0 / 9)) + (1.0/18));
//         double yPos = ( ((8 - rIndex) * (1.0 / 9)) + (1.0/18));
        
//         double cellSize = (512 / 9.0) - 5;
        
//         //get number value
//         int value = c.getValue();
//         String filename = "";
//         if (value != 9) {
//             filename = "cell" + value + ".png";
//             } else if (value == 9) {
//             filename = "mine.png";
//         }
        
//         //draw cell at clicked location
//         PennDraw.picture(xPos, yPos, filename, cellSize, cellSize );
//         c.setRevealed();
//     }
    
// }

