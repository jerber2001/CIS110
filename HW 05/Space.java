/**
* Name: Jerry Cai
* Pennkey: jycai
* Execution: java Space
*
* Description: Creates a space class so that space object that contains the
* simulation of the solar system can be instantiated
* system
**/
public class Space {
    
    /**
    * DO NOT EDIT ANY CODE BELOW THIS LINE
    *
    * You will get a style warning that reads:
    * "Variable '[some name]' must be private and have get/set methods."
    * Ignore any style warnings of this form. Our tests rely on these
    * variables being public. We will discuss public vs. private next week
    * in class. You are not expected to know it now.
    */
    public Body[] bodies; //array of Body objects in the space
    public double radius; //radius of the universe
    
    /* DO NOT EDIT ANY CODE ABOVE THIS LINE */
    
    /**
    * Constructor: This creates a new instance of a space object.
    */
    public Space(String filename) {
        //Reads from txt file values to instantiate object fields
        In inStream1 = new In(filename);
        int numBodies = inStream1.readInt();
        radius = inStream1.readDouble();
        
        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);
        
        bodies = new Body[numBodies];
        
        //Instantiates objects in array with given values from InStream1
        for (int i = 0; i < numBodies; i++) {
            double m = inStream1.readDouble();
            double px = inStream1.readDouble();
            double py = inStream1.readDouble();
            double vx = inStream1.readDouble();
            double vy = inStream1.readDouble();
            String img = inStream1.readString();
            
            bodies[i] = new Body(m, px, py, vx, vy, img);
            
        }
    }
    
    /**
    * Description: returns a string representation of space for the purposes
    * of printing. We have discussed toString methods in class.
    *
    * DO NOT EDIT THIS METHOD AT ALL!
    */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("" + bodies.length + "\n");
        sb.append(String.format("%.2e\n", radius) + "\n");
        for (int i = 0; i < bodies.length; i++) {
            sb.append(bodies[i].toString() + "\n");
        }
        return sb.toString();
    }
    
    /**
    * Inputs: None
    * Outputs: None
    * Description: Draws the starfield at (0,0) for the solar system
    */
    public void draw() {
        PennDraw.picture(0.0, 0.0, "starfield.jpg");
        
        for (int i = 0; i < bodies.length; i++) {
            PennDraw.picture(bodies[i].px, bodies[i].py, bodies[i].img);
        }
    }
    
    /**
    * Inputs: double timeStep value
    * Outputs: None
    * Description: This simulates the acceleration and forces of bodies acting on
    */
    public void simulate(double timeStep) {
        //Get Affected By Loops
        for (int i = 0; i < bodies.length; i++) {
            for (int j = 0; j < bodies.length; j++) {
                if (i != j) {
                    bodies[i].getAffectedBy(bodies[j], timeStep);
                }
                
            }
        }
        
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].move(timeStep);
        }
        
    }
    
    public static void main(String[] args) {
        Space s = new Space("solarSystem.txt");
        s.draw();
    }
    
}
