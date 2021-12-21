/**
 * Name: TODO
 * Pennkey: TODO
 * Execution: TODO
 *
 * Description: TODO
**/
public class RetrieveMessage {
    public static void main(String[] args) {
        String filename = args[0];
        String bitString = args[1];
        int tapPosition = Integer.parseInt(args[2]);
        
        System.out.println(functDecryptDecode(filename, bitString, tapPosition));
        
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public static String functDecryptDecode(String filename, 
                                            String bitString, 
                                            int tapPosition) {
        //Codec Creation
        //         Codec testCodec = new Codec();
        //Image Data Object Creation
        //         ImageData test = new ImageData();
        //Load filename into 2D array
        int[][] image2DArray = ImageData.load(filename);
        
        //         //Width
        //         int pRow = image2DArray.length;
        //         //Height
        //         int pCol = image2DArray[0].length;
        
        int totalArrayLength = 0;
        int counter = 0;
        
        for (int i = 0; i < image2DArray.length; i++) {
            //Iterate through columns
            for(int j = 0; j < image2DArray[i].length; j++) {
                totalArrayLength++;
            }
        }
        
        //Must be divisible by 7
        if (totalArrayLength % 7 != 0) {
            totalArrayLength = totalArrayLength - (totalArrayLength % 7);
        }
        
        //TotalArray Size
        int[] totalArray = new int[totalArrayLength];
        
        //Iterate through rows
        for (int i = 0; i < image2DArray.length; i++) {
            //Iterate through columns
            for(int j = 0; j < image2DArray[i].length; j++) {
                //Least significant digit
                
                //Length of 7
                if (counter < totalArrayLength) {
                    int lsd = 0;
                    lsd = image2DArray[i][j] % 2;
                    totalArray[counter] = lsd;
                    counter++;
                }
                
            }
        }
        
        //Debugging
        for (int i = 0; i < 20; i++) {
            System.out.print(totalArray[i]);
        }
        
        //         Decrypts the array
        Codec.decrypt(totalArray, bitString, tapPosition);
        
        //Decodes array
        String output = "";
        for (int i = 0; i < 20; i++) {
            output = output + totalArray[i];
        }
        //Debugging
        System.out.println(output);
        return Codec.decode(totalArray);
    }
    
}

//         ----------

//         ----------
//Prints out output Stringfor (int i = 0; i < totalArray.length; i++) {
//             System.out.println(output);
//         System.out.print(totalArray[2] + " ");

//     public RetrieveMessage() {
//     }
//     //Number of Pixels in rows and columns
//     int pRows = 0;
//     int pColumns = 0;
//     //TotalArray
//     int[] totalArray = new int[];
//     //Double Loop to read each row of array

//                 int[] keeperArray = new int[7];
//Takes char pixel and creates int array
//                 keeperArray = Codec.charToIntArray((char)  image2DArray[i][j]);

//
//                 totalArray[counter] = keeperArray[6];
//                 String keeperString = Codec.decode(totalArray[counter]);
//                 char keeperChar = keeperString.charAt(6);
//                 totalArray[counter] = Integer.parseInt(keeperChar);

//Inputing into the array
//                 totalArray[counter] = image2DArray[i][j];
//                 keeperArray = Codec.decode(totalArray[counter]);
//                 totalArray[counter] = keeperArray[6];
//                 //Decrypting the message
//                 totalArray[counter] = testCodec.decrypt(totalArray, 
//                 bitString, tapPosition);
//                 System.out.print(totalArray[counter] + " ");

