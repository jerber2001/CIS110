/*  Name: Jerry Cai
*  PennKey: jycai
*
*  Execution: java Rivalry
*
*  Prints out a racing program between Penn and our beloved rival, Dartmouth
*
*/
public class Rivalry {    
    public static void main(String[] args) {
        boolean rivalOneWins = false;       // has contestant 1 won the race?
        boolean rivalTwoWins = false;  // has contestant 2 won the race?

        /* the width of 1 pixel in window coordinate
         * use this variable when you get to the movement portion of the program 
         */
        double ONE_PIXEL = 4.0 / 512;

        // Declare variables for random integer, set the initial image positions before the starting line
        double rand_int;
        double xPos1 = 0.1;
        double xPos2 = 0.1;
        String victoryMessage = "";
            
        // Set the frame rate to 10 
        PennDraw.enableAnimation(10);
        
        //the loop in which he race takes place
        while (!rivalOneWins && !rivalTwoWins) {

            // Clears the screen
            PennDraw.clear();
            // Draws the start line
            PennDraw.line(0.3, 0, 0.3, 1);
            // Draws the finish line
            PennDraw.line(0.8, 0, 0.8, 1);
            // Draws the contestants (Penn and Dartmouth)
            
            //EXTRA CREDIT: Draws Contestant 1 Penn
            PennDraw.setPenColor(PennDraw.BLUE);
            PennDraw.filledRectangle(xPos1, 0.75, 0.05, 0.05);
            PennDraw.ellipse(xPos1, 0.75, 0.05, 0.05);
            PennDraw.setFontSize(20);
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.text(xPos1, 0.75, "Penn");
            
            
            //EXTRA CREDIT: Draws Contestant 2 Dartmouth
            PennDraw.setPenColor(PennDraw.GREEN);
            PennDraw.filledRectangle(xPos2, 0.25, 0.05, 0.05);
            PennDraw.ellipse(xPos2, 0.25, 0.05, 0.05);
            PennDraw.setFontSize(20);
            PennDraw.setPenColor(PennDraw.BLACK);
            PennDraw.text(xPos2, 0.25, "Fartmouth");
           
            // Random variable rand_var 
            double rand_var1 = Math.random();
            double rand_var2 = Math.random();
            // Determines whether the first contestant's position changes
            if (rand_var1 < 0.54) {
                xPos1 = xPos1 + ONE_PIXEL;
            } else {
                
            }
            
            // Determines whether the second contestant's position changes
            if (rand_var2 < 0.46) {
                xPos2 = xPos2 + ONE_PIXEL;
            } else {
                
            }
            
            // Based on current position, determines if anyone has won
            if (xPos1 >= 0.8 ) {
                PennDraw.setPenColor(PennDraw.BLUE);
                victoryMessage = "Penn Wins!";
                rivalOneWins = true;
            } else if (xPos1 == 0.8 && xPos2 == 0.8 ) {
                victoryMessage = "It's a Tie!";
                rivalOneWins = true;
            } else if (xPos2 >= 0.8) {
                PennDraw.setPenColor(PennDraw.GREEN);
                victoryMessage = "Dartmouth Wins!";
                rivalTwoWins = true;
            } else {
               
            }

            PennDraw.advance(); 
        }
       
        // the race is over so turn off animation
        PennDraw.disableAnimation(); 
        // TODO - draw text containing a victory message in the sketch
        PennDraw.setFontSize(64);
        PennDraw.text(0.5, 0.5, victoryMessage);
    }
}