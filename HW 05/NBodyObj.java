/**
* Name: Jerry Cai
* Pennkey: jycai
* Execution: java NBodyObj simulationTime timeStep fileName
*
* Description: Program output will return a working model of the solar system using
* using object oriented approach where bodies are their own object. Main class that
* will include Body and Space classes
**/

public class NBodyObj {
    // Main method that encapsulates the NBodyObj
    public static void main(String[] args) {
        // In Stream Passing Variables
        double simulationTime = Double.parseDouble(args[0]);
        double timeStep = Double.parseDouble(args[1]);
        String filename = args[2];
        
        Space s = new Space(filename);
        
        PennDraw.enableAnimation(30);
        
        // Time For Loop allows simulation to run
        for (double i = 0; i < simulationTime; i = i + timeStep) {
            s.simulate(timeStep);
            s.draw();
            PennDraw.advance();
            
        }
        
        //Prints out remaining numeric information with test cases
        System.out.println(s);
        PennDraw.disableAnimation();
        
    }
}
