/**
* Name: Jerry Cai
* Pennkey: jycai
* Execution: java Body
*
* Description: Creates a Body class which allows for celestial bodies to be
* instantiated for every celestial body
**/
public class Body {
    
    /**
    * DO NOT EDIT ANY CODE BELOW THIS LINE
    *
    * You will get a style warning that reads:
    * "Variable '[some name]' must be private and have get/set methods."
    * Ignore any style warnings of this form. Our tests rely on these
    * variables being public. We will discuss public vs. private next week
    * in class. You are not expected to know it now.
    */
    public double px, py; //position
    public double vx, vy; //velocity
    public double m; //mass
    public String img; //image file
    
    public static final double G = 6.67e-11; //gravity constant
    
    /*DO NOT EDIT ANY CODE ABOVE THIS LINE*/
    
    /**
    * Constructor: This creates a new instance of a body object.
    */
    public Body(double mass, double posX, double posY,
    double velX, double velY, String imageFile) {
        m = mass;
        px = posX;
        py = posY;
        vx = velX;
        vy = velY;
        img = imageFile;
        
    }
    
    /**
    * Description: returns a string representation of the body for the
    * purposes of printing. We will discuss toString methods in class.
    *
    * DO NOT EDIT THIS METHOD AT ALL!
    */
    public String toString() {
        return String.format("%12.5e %12.5e %12.5e %12.5e %12.5e %12s",
        m, px, py, vx, vy, img);
    }
    
    /**
    * Inputs: Another Body object that is other affecing body
    * Outputs: A double of the distanace between 2 bodies
    * Description: Finds the x distance between 2 bodies
    */
    public double distanceToX(Body other) {
        return other.px - px; // dummy return
    }
    
    /**
    * Inputs: Another Body object that is other affecing body
    * Outputs: A double of the distanace between 2 bodies
    * Description: Finds the y distance between 2 bodies
    */
    public double distanceToY(Body other) {
        return other.py - py; // dummy return
    }
    
    /**
    * Inputs: Another Body object that is other affecing body
    * Outputs: A double of the distanace between 2 bodies
    * Description: Finds the radial distance between 2 bodies
    */
    public double distanceTo(Body other) {
        return Math.sqrt((distanceToX(other) * distanceToX(other)) +
        (distanceToY(other) * distanceToY(other)));
        // dummy return
    }
    
    /**
    * Inputs: Another Body object that is other affecing body
    * Outputs: A double value of the force acting upon a body
    * Description: Calculates the total force acting upon a body
    */
    public double force(Body other) {
        //TODO: Implement this method
        double m1 = m;
        double m2 = other.m;
        double d = distanceTo(other);
        return G * m1 * m2 / (d * d); // dummy return
    }
    
    /**
    * Inputs: Another Body object that is other affecing body
    * Outputs: A double value of the x component force acting upon a body
    * Description: Calculates the X Component of force acting upon a body
    */
    public double forceX(Body other) {
        double dx = distanceToX(other);
        double d = distanceTo(other);
        return force(other) * dx / d; // dummy return
    }
    
    /**
    * Inputs: Another Body object that is other affecing body
    * Outputs: A double value of the y component force acting upon a body
    * Description: Calculates the Y Component of force acting upon a body
    */
    public double forceY(Body other) {
        double dy = distanceToY(other);
        double d = distanceTo(other);
        return force(other) * dy / d; // dummy return
    }
    
    /**
    * Inputs: None
    * Outputs: None, just use of PennDraw function that creates image on coordinates
    * Description: The function draws the images of given bodies
    */
    public void draw() {
        PennDraw.picture(px, py, img);
    }
    
    /**
    * Inputs: Double value of timeStep
    * Outputs: None, just updating of x and y coordinates
    * Description: Move updates the x and y coordinates for each body
    */
    public void move(double timeStep) {
        px = px + timeStep * vx;
        py = py + timeStep * vy;
    }
    
    /**
    * Inputs: Body object other and timeStep double
    * Outputs: None
    * Description: Calculates acceleration from and updates velocity values
    */
    public void getAffectedBy(Body other, double timeStep) {
        double ax = forceX(other) / m;
        double ay = forceY(other) / m;
        
        vx = vx + timeStep * ax;
        vy = vy + timeStep * ay;
    }
}
