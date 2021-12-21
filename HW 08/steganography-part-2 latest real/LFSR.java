/**
* Name: Jerry Cai
* Pennkey: jycai
* Execution: java LFSR
*
* Description:
**/
public class LFSR {
    
    //Main Method
    public static void main(String[] args) {
        LFSR lfsr = new LFSR("01101000010", 8);
        for (int i = 0; i < 10; i++) {
            int bit = lfsr.nextBit();
            System.out.println(lfsr.toString() + " " + bit);
        }
        
    }
    
    //Fields of LFSR Class
    int[] seedArray;
    int seedInt;
    String seed;
    int tapPosition;
    
    //Constructor for LFSR that takes the seed as string and integer tapPosition
    public LFSR(String seed, int tapPosition) {
        this.seed = seed;
        this.tapPosition = tapPosition;
        boolean notBinary = false;
        
        //Checks to see if seed is null
        if (seed == null) {
            throw new IllegalArgumentException("Null Error");
        }
        
        //Checks each character within the seed for 0 and 1
        for (int i = 0; i < seed.length(); i++) {
            if (seed.charAt(i) == '1' || seed.charAt(i) == '0') {
                notBinary = false;
            } else {
                notBinary = true;
            }
        }
        
        //Checks to make sure Illegal Argument Errors are accounted for
        if (notBinary == true) {
            throw new IllegalArgumentException("Not Binary");
        } else if (tapPosition < 0 || tapPosition >= seed.length()) {
            throw new IllegalArgumentException("Tap Position");
        }
        
        //Fill array with seed digits
        seedArray = new int[seed.length()];
        
        for (int i = 0; i < seed.length(); i++) {
            //Char at is either 1 or 0
            if (seed.charAt(i) == '1') {
                seedArray[i] = 1;
            } else if (seed.charAt(i) == '0') {
                seedArray[i] = 0;
            }
        }
        
    }
    //Constructor for LFSR that randomly generates string and takes tapPosition
    public LFSR(int seedLength, int tapPosition) {
        int randomBit;
        this.tapPosition = tapPosition;
        String seed = "";
        
        if (seedLength < 0) {
            throw new IllegalArgumentException("Seed Length Error");
        } else if (tapPosition < 0 || tapPosition >= seedLength) {
            throw new IllegalArgumentException("Tap Position Error");
        }
        
        //Creates the seed string from the output bits
        for (int i = 0; i < seedLength; i++) {
            randomBit = (int) (Math.random() * 2);
            if (randomBit < 1) {
                seed = seed + 0;
            } else {
                seed = seed + 1;
            }
        }
        
        //Fill array with seed digits
        seedArray = new int[seed.length()];
        
        for (int i = 0; i < seed.length(); i++) {
            //Char at is either 1 or 0
            if (seed.charAt(i) == '1') {
                seedArray[i] = 1;
            } else if (seed.charAt(i) == '0') {
                seedArray[i] = 0;
            }
        }
        
    }
    
    /**
    * Inputs: None
    * Outputs: String value of seed
    * Description: The function takes the 0 and 1 integers from seedArray
    * and creates a seed string
    */
    public String toString() {
        seed = "";
        for (int i = 0; i < seedArray.length; i++) {
            seed = seed + seedArray[i];
        }
        return seed;
    }
    
    /**
    * Inputs: None
    * Outputs: Integer value of tapPosition
    * Description: The function returns the bit at the tapPosition
    */
    public int getTapPosition() {
        return tapPosition;
    }
    
    /**
    * Inputs: None
    * Outputs: Integer value of the resulting bit from the XOR operation
    * Description: For a given bit register, the XOR operation is applied
    * and linear register shift is applied to the seedArray. The XOR resulting
    * value is then returned
    */
    public int nextBit() {
        //Taking bits at given locations
        int tapInt = seedArray[seedArray.length - tapPosition - 1];
        int XOR = tapInt ^ seedArray[0];
        
        //Shift each cell to left, and place XOR in right
        
        for (int i = 1; i < seed.length(); i++) {
            seedArray[i - 1] = seedArray[i];
            if (i == seed.length() - 1) {
                seedArray[seed.length() - 1] = XOR;
            }
        }
        return XOR;
    }
    
}
