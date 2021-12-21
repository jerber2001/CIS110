/**
 * Name: TODO
 * Pennkey: TODO
 * Execution: TODO
 *
 * Description: TODO
**/
import java.util.*;

public class Codec {
    
    public static void main(String[] args) {
        // //         charToIntArray('C');
        // //         encode("CAI");
        //         int[] testarray = encode("STEG0");
        // //         intArrayToChar(testarray);
        // //         intArrayToChar(charToIntArray('C'));
        // //         decode(encode("CAI"));
        // //         System.out.println(" ");
        // //         encrypt(testarray, "0110100", 5);
        //         System.out.println(decode(testarray));
//         encode(null);
        decode(null);
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    private static int[] charToIntArray(char ch) {
        int input = (int) ch;
//         String bin = "";
        
        //creates an array size of string length
//         int[] array = new int[bin.length()];
        int[] array = new int[7];

        //creates the binary string
        
//         for (int i = input; i != 0 ; i = i / 2) {
//             bin = (i % 2) + bin;
//         }
        int counter = 0;
        while (input != 0) {
            array[6 - counter] = (input % 2);
            input = input / 2;
            counter++;
        }
        
        
        
        //places values into string array
//         for (int i = 0; i < bin.length(); i++) {
//             //throw error if
//             if (bin.charAt(i) != '0' && bin.charAt(i) != '1') {
//                 throw new IllegalArgumentException("Must be 1 or 0");
//             }
//             if (bin.charAt(i) == '0') {
//                 array[i] = 0;
//             } else if (bin.charAt(i) == '1') {
//                 array[i] = 1;
//             }
//         }
        
        //printing test
        //         for (int i = 0; i < bin.length(); i++) {
        //             System.out.print(" " + array[i]);
        //         }
        
        return array;
        //         for(int i = ch; i != 0; i = i / 2) {
        //             i % 2;
        //         }
    }
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    private static char intArrayToChar(int[] bitString) {
        //convert bit to integer
        int counter = 0;
        for (int i = 0; i < bitString.length; i++) {
            int exp = bitString.length - i - 1;
            counter = counter + bitString[i] * (int) (Math.pow(2, exp));
        }
        //         System.out.println(counter);
        //         System.out.println((char) counter);
        return (char) counter;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public static int[] encode(String str) {
        //Write Error Messaages!!!!!!!!!!!!!
        //Null error statement
        if (str == null) {
            return null;
        }
        
        int counter = 0;
        int[] strArray = new int[(7 * str.length())];
        //counts at the character level
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) > 127) {
                throw new IllegalArgumentException("ASCII must be within range");
            }
            //finds the bitstring for each character
            int[] keeperArray = charToIntArray(str.charAt(i));
            //input values from charArray into strArray
            for (int j = 0; j < keeperArray.length; j++) {
                if (keeperArray[j] != 0 && keeperArray[j] != 1) {
                    throw new IllegalArgumentException("Must be 1 or 0");
                }
                strArray[counter] = keeperArray[j];
                counter++;
            }
        }
        
        //         printing test
        //         for (int i = 0; i < strArray.length; i++) {
        //             System.out.print(" " + strArray[i]);
        //         }
        
        return strArray;
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public static String decode(int[] bits) {
        int[] bitArray = bits;
        String str = "";
        int counter = 0;
        int nullIndex = 0;
        //Error Statements
        if (bits == null) {
            return null;
        }
        //Take 7 bit segments for each char
        for (int i = 0; i < (bitArray.length / 7); i++) {
            //              char decodeChar = 0;
            int[] keeperArray = new int[7];
            for (int j = 0; j < 7; j++) {
                if (counter < bitArray.length) {
                    keeperArray[j] = bitArray[counter];
                }
                counter++;
                //                 System.out.print(keeperArray[j]);
            }
            
            //If character is null
            
            //              System.out.println(decodeChar);
            
            if (intArrayToChar(keeperArray) > 127) {
                throw new IllegalArgumentException("ASCII must be within range");
            }
            str = str + intArrayToChar(keeperArray);
        }
        
        //         for (int i = 0; i < str.length(); i++) {
        //             if (str.charAt(i) == '\0') {
        //                 nullIndex = i;
        //                 break;
        //             }
        //         }
        //         System.out.println(str);
        return str; //str.substring(0, str.indexOf('\0'));
    }
    
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public static void encrypt(int[] message, String seed, int tapPosition) {
        // Perform LFSR on the seed to generate a random bit stream
        LFSR lfsr = new LFSR(seed, tapPosition);
        
        //Error Messages
        if (seed == null) {
            throw new IllegalArgumentException("Null seed");
        } else if (tapPosition > seed.length() || tapPosition < 0) {
            throw new IllegalArgumentException("Invalid tap position");
        }
        
        //Seed contains other than
        for (int i = 0; i < seed.length(); i++) {
            if (seed.charAt(i) != '0' && seed.charAt(i) != '1') {
                throw new IllegalArgumentException("Seed not binary");
            }
        }
        
        if (message == null) {
        }
        
        else if (message.length % 7 != 0) {
            throw new IllegalArgumentException("Wrong length");
        }
        
        for (int i = 0; i < message.length; i++) {
            if (message[i] != 0 && message[i] != 1) {
                throw new IllegalArgumentException("Characters are not binary");
            }
            
            message[i] = message[i] ^ lfsr.nextBit();
            //             System.out.print(message[i] + " ");
        }
    }
    /**
     * Inputs: TODO
     * Outputs: TODO
     * Description: TODO
    */
    public static void decrypt(int[] cipher, String seed, int tapPosition) {
        encrypt(cipher, seed, tapPosition);
    }
}
//     public static int[] encode(String str) {
// //Write Error Messaages!!!!!!!!!!!!!
//         //Null error statement
//         if (str.equals(null)) {
//             return null;
//         }
//         int counter = 0;
//         int[] strArray = new int[(7 * str.length())];
//         //counts at the character level
//         for (int i = 0; i < str.length(); i++) {
//             //
//             if (str.charAt(i) > 127) {
//                 throw new IllegalArgumentException("ASCII must be within range");
//             }
//             //finds the bitstring for each character
//             int[] keeperArray = charToIntArray(str.charAt(i));
//             //input values from charArray into strArray
//                 for (int j = 0; j < keeperArray.length; j++) {
//                     strArray[counter] = keeperArray[j];
//                     counter++;
//                 }
//         }

// //         printing test
//         for (int i = 0; i < strArray.length; i++) {
//             System.out.print(" " + strArray[i]);
//         }

//         return strArray;
//     }

//     public static String decode(int[] bits) {
//         int[] bitArray = bits;
//         String str = "";
//         int counter = 0;
//         //Error Statements
// //         if (bits.equals(null)) {
// //             throw new IllegalArgumentException("Bit cannot be null");
// //         } else if (bits.length % 7 != 0) {
// //             throw new IllegalArgumentException("Bit length is not 7 multiple");
// //         }

//         //Take 7 bit segments for each char
//          for (int i = 0; i < (bitArray.length / 7); i++) {
// //              char decodeChar = 0;
//              int[] keeperArray = new int[7];
//              for (int j = 0; j < 7; j++) {
//                 if (counter < bitArray.length) {
//                     keeperArray[j] = bitArray[counter];
//                 }
//                 //Place values into keeper array

// //                 if (keeperArray[j] != 0 && keeperArray[j] != 1) {
// //                     throw new IllegalArgumentException("Bit must be either 0 or 1");
// //                 }
//                 counter++;
// //                 System.out.print(keeperArray[j]);
//              }

// //              System.out.println(decodeChar);
//              str = str + intArrayToChar(keeperArray);
//          }
// //         System.out.println(str);
//         return str;
//     }
