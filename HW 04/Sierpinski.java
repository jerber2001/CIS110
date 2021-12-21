// /*
//  * Name: Jerry Cai
//  * PennKey: jycai
//  * Recitation: 211
//  * Execution: java Sierpinski numLevels
//  * Description: Draws a Sierpinski carpet of square with different sizes
//  * /
//

public class Sierpinski {
    //main method that calls Sierpinski and gives specified dimensions of carpet
    public static void main(String[] args ){
        int numLevels = Integer.parseInt(args[0]); 
        Sierpinski(numLevels, (1.0 / 6.0), 0.5, 0.5);
        PennDraw.filledSquare(0.5, 0.5, (1.0 / 3.0) / 2);
        
        
    }
    
    public static void Sierpinski(int numLevels, double halfSideLength, 
                                  double x, double y) {
        PennDraw.enableAnimation(1000);
        
        if (numLevels < 1) {
            return ; 
            }
        
        PennDraw.filledSquare(x, y, halfSideLength);
            
        //Right       
        Sierpinski(numLevels - 1, halfSideLength / 3, x + 2 * halfSideLength, 
                      y);
        //Left
        Sierpinski(numLevels - 1, halfSideLength / 3, x - 2 * halfSideLength, 
                      y);
        //Up 
        Sierpinski(numLevels - 1, halfSideLength / 3, x, 
                      y + 2 * halfSideLength);
        
        //Down
        Sierpinski(numLevels - 1, halfSideLength / 3, x, 
                      y - 2 * halfSideLength);
        
        //Right Up      
        Sierpinski(numLevels - 1, halfSideLength / 3, x + 2 * halfSideLength, 
                      y + 2 * halfSideLength);
        //Left Up
        Sierpinski(numLevels - 1, halfSideLength / 3, x - 2 * halfSideLength, 
                      y + 2 * halfSideLength);
        //Right Down 
        Sierpinski(numLevels - 1, halfSideLength / 3, x + 2 * halfSideLength, 
                      y - 2 * halfSideLength);
        //Left Down
        Sierpinski(numLevels - 1, halfSideLength / 3, x - 2 * halfSideLength, 
                      y - 2 * halfSideLength);
        
        PennDraw.advance();
            
        return ;
    }
}