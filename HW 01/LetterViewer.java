/*  Name: Jerry Cai
*  PennKey: jycai
*
*  Execution: java LetterViewer
*
*  Prints out a program that shows letters and whatever the user presses/selects on the screen
*
*/

public class LetterViewer {
    public static void main(String[] args) {
        // Setting Font Size
        PennDraw.setCanvasSize(512, 512);
        PennDraw.setFontSize(64);
        
        // turn on animation
        PennDraw.enableAnimation(30);

        while (true) {
            // If loop checks for a key press.
            if (PennDraw.hasNextKeyTyped() == true) {
                // The key is pressed and store its value.
                char keyTyped = PennDraw.nextKeyTyped();
                String keyTypedString = keyTyped + "";
                
                // Draws the most recently pressed key.
                PennDraw.text(.5, .5, keyTypedString);
                
                // Advances frame after everything has been drawn for this loop
                PennDraw.advance();
                PennDraw.clear();
            }
            
            else {
                
            }
        }
    }
}