/*  Name: Jerry Cai
*  PennKey: jycai
*
*  Execution: java LineDrawingTool
*
*  Drawing where user can draw lines from where they click, and different colors of red and black
*
*/

public class LineDrawingTool {
    public static void main(String[] args) {
        // set the pen radius.
        PennDraw.setPenRadius(0.01);

        // turn on animation
        PennDraw.enableAnimation(30);

        double xLineStart = 0.5;
        double yLineStart = 0.5;
        
        // These are variables to store the coordinates of the *last* click.
        
        double xLineEnd;
        double yLineEnd;
        
        while (true) {
            // TODO: check for mouse click
            if (PennDraw.mousePressed() == true) {
                xLineEnd = PennDraw.mouseX();
                yLineEnd = PennDraw.mouseY();
                
                // Sets line color based on section of screen
                if (yLineEnd >= 0.5 ) {
                    PennDraw.setPenColor(PennDraw.RED);
                } else {
                    PennDraw.setPenColor(PennDraw.BLACK);
                }
                
                // Draws new line when mouse is pressed
                PennDraw.line(xLineStart, yLineStart, xLineEnd, yLineEnd);
                
             /*
             * Updates coordinates of clicked location
             */
                xLineStart = xLineEnd;
                yLineStart = yLineEnd;
            } 
            
            else {
                
            }
            
            // Advances the frame
            PennDraw.advance();
        }
    }
}
