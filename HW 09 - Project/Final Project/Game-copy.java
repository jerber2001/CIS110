/**
 * Name: TODO
 * Pennkey: TODO
 * Execution: TODO
 *
 * Description: TODO
**/
// public class Game {
//     boolean isGameOver;
//     boolean alreadyClick;
//     int width;
//     int height;

// //     void drawGame() {}
// //     boolean handleClick() {}
// //     void resetGame() {}

//     public static void main(String[] args) {
//         Game test = new Game();
//         Board board = new Board();
//         int counter = 10;

//         test.drawGrid(board);
// //         PennDraw.enableAnimation(30);

//         test.FirstClick(board, counter);

//         test.displayArray(board.cellArray, board);

//         for (int i = 8; i >= 0; i--) {
//             for (int j = 0; j <= 8; j++) {
//                 test.countAdjacent();
//             }
//         }

//     }

//     int fClickX;
//     int fClickY;

//     public void drawGrid(Board b) {
// //         PennDraw.setCanvasSize(512, 512);
//         PennDraw.picture(0.5, 0.5, "grid.png", 540, 540);

//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 b.cellArray[i][j] = new NumberCell(0, j, 8 - i);
// //                 System.out.println(b.cellArray[i][j].getValue());
// //                 intArray[i][j] = 0;
//             }
//         }
//     }

//     //First Click Detected
//     public void FirstClick(Board b, int c) {
//         int k = 0;
//         while (k < c) {
//             if (PennDraw.mousePressed()) {
//             //Create a revealed cell
//             fClickX = (int) (PennDraw.mouseX() * 9);
//             fClickY = (int) (PennDraw.mouseY() * 9);

// //             PennDraw.picture(PennDraw.mouseX(), PennDraw.mouseY(), "mine.jpeg");
//             System.out.println("");
//             System.out.print(fClickX);
//             System.out.println(fClickY);

// //             //Generate random numbers to use for BombCell placements
// //             while (k < 10) {
// //                 int xCell = (int) (Math.random() * 9); //0 to 8
// //                 int yCell = (int) (Math.random() * 9); //0 to 8
// //                 int rIndex = 8 - yCell;
// //                 int cIndex = xCell;
// //                 double xPos = ( (xCell * (1.0 / 9)) + (1.0/18));
// //                 double yPos = ( (yCell * (1.0 / 9)) + (1.0/18));
// //                 double cellSize = 512 / 9.0 ;

// //                 //xPos and yPos cannot equal that
// //                     if (b.cellArray[8 - fClickY][fClickX].getValue() == 0 &&
// //                         fClickX != xCell &&
// //                         fClickY != yCell &&
// //                         k < 10) {
// //                         //Populates Cell Array with BombCell
// //                         Cell bombCell = new BombCell(9, xCell, yCell);
// //                         b.cellArray[rIndex][cIndex] = bombCell;

// //                         //Changes rIndex and cIndex of each cellArray
// //                         b.cellArray[rIndex][cIndex].setX(xCell);
// //                         b.cellArray[rIndex][cIndex].setY(yCell);

// //                         PennDraw.picture(xPos, yPos,"mine.jpeg", cellSize - 5, cellSize - 5);

// // //                         System.out.print(b.cellArray[rIndex][cIndex].getX());
// // //                         System.out.println(b.cellArray[rIndex][cIndex].getY());

// //                         k++;
// // //                         System.out.print();
// // //                         System.out.println("Bomb Loop");
// //                     }

// //                 }

//             //New Loop
//             for (int i = 8; i >= 0; i--) {
//                     for (int j = 0; j <= 8; j++) {
//                         double prob = Math.random();
//                         System.out.println("This is prob "+prob);

//                         int rIndex = i;
//                         int cIndex = j;
//                         int xCell = cIndex;
//                         int yCell = 8 - rIndex;

//                         if (k < c && prob < 0.2) {
//                             Cell bombCell = new BombCell(9, cIndex, 8 - rIndex);
//                             b.cellArray[rIndex][cIndex] = bombCell;

//                             double xPos = ( (cIndex * (1.0 / 9)) + (1.0/18));
//                             double yPos = ( ((8 - rIndex) * (1.0 / 9)) + (1.0/18));
//                             double cellSize = 512 / 9.0 ;

//                             //Changes rIndex and cIndex of each cellArray
//                             b.cellArray[rIndex][cIndex].setX(cIndex);
//                             b.cellArray[rIndex][cIndex].setY(8 - rIndex);

//                             System.out.print("Pos:"+xPos);
//                             System.out.println(yPos);

//                             PennDraw.picture(xPos, yPos,"mine.jpeg", cellSize - 5, cellSize - 5);

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
// //                         System.out.print(b.cellArray[i][j].getValue());
//                     }

//             }

//             }
//         }
//     }

//     public void countAdjacent(Cell[][] a, Cell thisCell) {
//         int x = thisCell.getX();
//         int y = thisCell.getY();
//         int counter = 0;

//         for (int m = -1; m < 2; m++) {
//             if ((x + m >= 0 && x + m <= 8)) {
//                 for (int n = -1; n < 2; n++) {
//                     if ((y + n >= 0 && y + n <= 8)) {
//                         if (n != 0 && m != 0 && a[y + n][x + m].getValue() == 9) {
//                             counter++;
//                         }
//                     }
//                 }
//             }

//         }
//         thisCell.setValue(counter);
// //         return counter;

//     }

//     public void displayArray(Cell[][] a, Board b) {
//         if (PennDraw.mousePressed()) {
//             for (int i = 8; i <= 0; i--) {
//                 for (int j = 0; j <= 8; j++) {
//     //                 b.cellArray[i][j] = new NumberCell(0, j, 8 - i);
//                     if (b.cellArray[i][j].getValue() != 9) {
//                         countAdjacent(a, b.cellArray[i][j]);

//     //                     int countAdj = countAdjacent(a, b.cellArray[i][j]);
//     //                     b.cellArray[i][j].setValue(countAdj);
//     //
//                     }
//                     System.out.print(b.cellArray[i][j].getValue());
//                     System.out.print("*");

//     //                 System.out.print("X:"+ b.cellArray[i][j].getX() +
//     //                                  "Y:"+ b.cellArray[i][j].getY() +
//     //                                  "V:"+ b.cellArray[i][j].getValue());
//                 }
//             System.out.println("");
//             }
//         }

//     }

// }

// //
