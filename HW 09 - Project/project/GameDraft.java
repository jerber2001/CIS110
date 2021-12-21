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
        
//         board.drawGrid();
// //         PennDraw.enableAnimation(30);
        
//         while (true) {

//             test.FirstClick();
//         }

//     }
    
//     int fClickX;
//     int fClickY;
       
//     Board b = new Board();
    
    
//     //First Click Detected
//     public void FirstClick() {
       
//         if (PennDraw.mousePressed()) {
//             //Create a revealed cell
//             fClickX = (int) (PennDraw.mouseX() * 9);
//             fClickY = (int) (PennDraw.mouseY() * 9);
            
// //             PennDraw.picture(PennDraw.mouseX(), PennDraw.mouseY(), "mine.jpeg");
            
//             System.out.println(fClickX);
//             System.out.println(fClickY);

//             int k = 0;
//             //Generate random numbers to use for BombCell placements
//             while (k < 10) {
//                 int xCell = (int) (Math.random() * 9);
//                 int yCell = (int) (Math.random() * 9);
//                 int rIndex = 8 - yCell;
//                 int cIndex = xCell;
//                 double xPos = ( (xCell * 0.1) + (1.0/18));
//                 double yPos = ( (yCell * 0.1) + (1.0/18));
//                 double cellSize = 512 / 9.0 ;
                
                
                

//                 //xPos and yPos cannot equal that 
//                     if (b.cellArray[8 - fClickY][fClickX].value == 0 && 
//                         fClickX != xCell && 
//                         fClickY != yCell) {
                        
//                         //Populates Cell Array with BombCell
//                         b.cellArray[rIndex][cIndex] = new NumberCell(9, xCell, yCell);
                        
//                         //Changes rIndex and cIndex of each cellArray
// //                         b.cellArray[rIndex][cIndex].xPos = xCell;
// //                         b.cellArray[rIndex][cIndex].yPos = yCell;
                            
//                         PennDraw.picture(xPos, yPos,"mine.jpeg", cellSize - 5, cellSize - 5);
                        
//                         System.out.print(b.cellArray[rIndex][cIndex].xPos);
//                         System.out.print(b.cellArray[rIndex][cIndex].yPos);
//                         System.out.println(" " +b.cellArray[rIndex][cIndex].value);
                        
                        
//                         k++;
// //                         System.out.println("Bomb Loop");
//                     }
                    
//             }
            
//             //Start iterating through the array and assigning cells 
// //             for (int i = 0; i < 9; i++) {
// //                 for (int j = 0; j < 9; j++) {
// //                     //If current cell is not a bomb
// //                     if (b.cellArray[i][j].value != 9) {
// //                         //Adjacent Count 
// //                        b.cellArray[i][j].value = countAdjacent(b.cellArray, b.cellArray[i][j]); 
// //                     }
 
                    
// //                 }
// //             }
//         }

//     }
    
// //     public int countAdjacent(Cell[][] a, Cell thisCell) {
// //         int x = thisCell.xPos;
// //         int y = thisCell.yPos;
// //         int counter = 0;
        
// //         for (int m = -1; m < 2; m++) {
// //             if ((x + m >= 0 && x + m <= 8)) {
// //                 for (int n = -1; n < 2; n++) {
// //                     if ((y + n >= 0 && y + n <= 8)) {
// //                         if (a[y + n][x + m].value == 9) {
// //                             counter++;
// //                         }
// //                     } 
// //                 }
// //             } 
            
// //         }
// //         return counter;
        
// //     }

    
// }

// //         int xTL = x - 1;
// //         int xTM = x;
// //         int xTR = x + 1;
// //         int xML = x - 1
// //         int xMR = x + 1
// //         int xBL = x - 1;
// //         int xBM = x;
// //         int xBR = x + 1;
            
// //         int yTL =  - 1;
// //         int yTM = ;
// //         int yTR =  + 1;
// //         int yML =  - 1
// //         int yMR =  + 1
// //         int yBL =  - 1;
// //         int yBM = ;
// //         int yBR =  + 1;    
            
// //         //Check i-1 and i+1
// //         if ((xTL !< 0 && xTL !> 8) && (yTL - 1 !< 0 && yTL !> 8)) {
            
// //         } 