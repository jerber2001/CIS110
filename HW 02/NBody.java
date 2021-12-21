    /*  Name: Jerry Cai
     *  PennKey: jycai
     *  Recitation: 211
     *
     *  Execution: java NBody simulationTime timeStep filename
     *
     *  Prints out a galaxy of planets orbiting each other. 
     *
     */

public class NBody {
    public static void main(String[] args) {
        
        double simulationTime = Double.parseDouble(args[0]);
        double timeStep = Double.parseDouble(args[1]);
        String filename = args[2];

//         System.out.println("Variables " + simulationTime + " " + timeStep);
        
        //Step 2C
        In inStream = new In(filename);

        int numBodies = inStream.readInt();
        double radius = inStream.readDouble();
        
        //Step 2B
        double[] m = new double[numBodies];
        double[] px = new double[numBodies];
        double[] py = new double[numBodies];
        double[] vx = new double[numBodies];
        double[] vy = new double[numBodies];
        String[] img = new String[numBodies];
        
        //Step 2D: Reading arrays from the text file
        for (int i = 0; i < numBodies; i++) {
            m[i] = inStream.readDouble();
            px[i] = inStream.readDouble();
            py[i] = inStream.readDouble();
            vx[i] = inStream.readDouble();
            vy[i] = inStream.readDouble();
            img[i] = inStream.readString();
        }
        
        //Step 2E Checkpoint
        //*** Print Information about txt file ***
        
        //3A PennDraw
        PennDraw.setXscale(-radius, radius);
        PennDraw.setYscale(-radius, radius);
        
        PennDraw.picture(0, 0, "starfield.jpg");
        
        for (int i = 0; i < numBodies; i++) {
            PennDraw.picture(px[i], py[i], img[i]);
        }
        
        //3C Checkpoint
       
        //4A Time Loop
        PennDraw.enableAnimation(30);
        
        double elapsedTime = 0;
        
        //Time Loop
        for (double i = 0; i < simulationTime; i = i + timeStep) {
            
            elapsedTime = elapsedTime + 1;
            
            //3A PennDraw
            PennDraw.setXscale(-radius, radius);
            PennDraw.setYscale(-radius, radius);
            
            PennDraw.picture(0, 0, "starfield.jpg");
            
            for (int j = 0; j < numBodies; j++) {
                double g = 6.67e-11;
                double fX = 0;
                double fY = 0;
                double dX = 0;
                double dY = 0;
                double d = 0;
                double aX = 0;
                double aY = 0;
                
                //Calculates the X,Y Components of Force
                for (int k = 0; k < numBodies; k++) {
                    if (k != j) {
                        dX = px[k] - px[j];
                        dY = py[k] - py[j];
                    
                        d = Math.sqrt((dX * dX) + (dY * dY));
                    
                        // Calculates X, Y Components of Force
                        fX = fX + ((g * m[j]) / (d * d)) * m[k] * (dX / d);
                        fY = fY + ((g * m[j]) / (d * d)) * m[k] * (dY / d);    
                    }  
                }
                
                //Acceleration
                aX = fX / m[j];
                aY = fY / m[j];
                
                //Velocities
                vx[j] = vx[j] + timeStep * aX;
                vy[j] = vy[j] + timeStep * aY;
                
                //Positions
                px[j] = px[j] + vx[j] * timeStep;
                py[j] = py[j] + vy[j] * timeStep;
                
                PennDraw.picture(px[j], py[j], img[j]);
            }

            PennDraw.advance();
        }
        
        //Final Checkpoint
        System.out.printf("%d\n", numBodies);
        System.out.printf("%.2e\n", radius);
        for (int i = 0; i < numBodies; i++) {
            System.out.printf("%12.5e %12.5e %12.5e %12.5e %12.5e %12s\n", m[i], px[i], py[i], vx[i], vy[i], img[i]);     
        }
    }
}

