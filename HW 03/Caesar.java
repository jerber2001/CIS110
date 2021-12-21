/**
* Name: Jerry Cai
* Pennkey: jycai
* Execution: java Caesar crack cipher.txt english.txt
*
* Program Description: Creates a program that implements a Caesar Cipher to 
* decrypt, encrypt and crack messages
*/

public class Caesar {
    
    /*
    * Description: converts a string to a symbol array,
    * where each element of the array is an
    * integer encoding of the corresponding
    * element of the string.
    * Input:  the message text to be converted
    * Output: integer encoding of the message
    */
    public static int[] stringToSymbolArray(String str) {
        // Takes a character, converts it into an int with shift of A spaces
        str = str.toUpperCase();
        int[] arr = new int[str.length()];
        //Takes each character in the string and converts into respective integer 
        for (int i = 0; i < str.length(); i++) {
            arr[i] = (int) str.charAt(i) - 'A';
        }
        return arr;
    }
    
    /*
    * Description: converts an array of symbols to a string,
    * where each element of the array is an
    * integer encoding of the corresponding
    * element of the string.
    * Input:  integer encoding of the message
    * Output: the message text
    */
    public static String symbolArrayToString(int[] symbols) {
        // Takes an array of integers and converts it back into string
        String str = ""; 
        for (int i = 0; i < symbols.length; i++) {
            str = str + (char) (symbols[i] + 'A');
        }
        return str;
    }
    
    /**
    * Function takes the previous symbol location and shifts its 
    * a given amount specified by the second parameter of the 
    * function
    * Input: integer encoding letter, integer of offset
    * Output: new integer encoding letter
    */
    public static int shift(int symbol, int offset) {
        int newSymbol = 0;
        // Implement the method by shifting the symbol by integer places
        if (symbol >= 0 && symbol < 26) {
            
            newSymbol = symbol + offset;
            
            if (newSymbol > 25) {
                return newSymbol % 26;
            } 
            return newSymbol; 
        } 
        return symbol;
    }
    
    /**
    * Function takes a given symbol and shifts it left by a given number of places
    * specified back
    * Input: a String of the encrypted message
    * Output:
    */
    public static int unshift(int symbol, int offset) {
        // Implement the method by shifting the symbol by integer places
        int newSymbol = 0;
        
        // Implement the method by shifting the symbol by integer places
        if (symbol >= 0 && symbol < 26) {
            
            newSymbol = symbol - offset;
            
            if (newSymbol < 0) {
                return newSymbol + 26;
            } 
            return newSymbol; 
        } 
        return symbol;
    }
    
    /**
    * Function: String is inputed and given key 
    * Input: takes the original message and encrypts each character an offset amount
    * Output: outputs a string with the encrypted message
    */
    public static String encrypt(String message, int key) {
        // Takes message input and converts into int[]
        int[] messageIntArray = stringToSymbolArray(message);
        String encryptedMessage = "";
        
        //Takes encrypted message and shifts each of the numbers
        for (int i = 0; i < messageIntArray.length; i++) {
            messageIntArray[i] = shift(messageIntArray[i], key);
        }

        //Takes shifted, message integer array and converts into a message
       encryptedMessage = symbolArrayToString(messageIntArray);
        return encryptedMessage;
    }
    
    /**
    * Function: String of the encrypted message is inputed and given integer key 
    * Input: takes the encrypted message and decrypts each character an offset amount
    * Output: outputs a string with the decrypted message
    * 
    */
    public static String decrypt(String message, int key) {
        // Takes message input and converts into int[]
        
        int[] messageIntArray = stringToSymbolArray(message);
        String decryptedMessage = "";
        
        //Takes encrypted message and shifts each of the numbers
        for (int i = 0; i < messageIntArray.length; i++) {
            messageIntArray[i] = unshift(messageIntArray[i], key);
        }

        //Takes shifted, message integer array and converts into a message
       decryptedMessage = symbolArrayToString(messageIntArray);

        return decryptedMessage;
    }
    
    /**
    * Function: Takes filename of dictionary frequencies to store in an array
    * Input: Take the relative frequencies of the alphabet for english words
    * Output: An array of length 26 with given frequencies
    */
    public static double[] getDictionaryFrequencies(String filename) {
        // TODO: Implement
        In inStream = new In(filename);
        
        double[] dictFrequency = new double[26];
        
        for (int i = 0; i < 26; i++) {
            dictFrequency[i] = inStream.readDouble();
        }
        
        return dictFrequency;
    }
    
    /**
    * Function: Takes the relative letter frequencies for an inputed message string 
    * for each corresponding letter
    * Input: The integer array of each respective message
    * Output: A double array with the letter frequencies within a given message
    */
    public static double[] findFrequencies(int[] symbols) {
        // A loop that counts the frequency of each letter in 
        double[] findFrequency = new double[26];
        
        for (int i = 0; i < symbols.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (symbols[i] >= 0 && symbols[i] < 26 && symbols[i] == j) {
                    findFrequency[j]++;
                }
            }
        }
        
        //Letter Counter counts the characters that are not special symbols
        int letterCounter = 0;
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] >= 0 && symbols[i] < 26) {
                letterCounter++;
            }
        }
        
        //Storing Frequency in the array
        for (int i = 0; i < findFrequency.length; i++) {
            findFrequency[i] = findFrequency[i] / letterCounter;
        }
        
        return findFrequency;
    }
    
    /**
    * Score Frequencies gives the sum of the deviation between the message frequency
    * that of the english dictionary frequencies. The greater the frequency score, 
    * the less similar in letter frequency the message appears compared to english
    * Input: The array of letter frequencies of the given message and alphabet
    * Output: The frequency score of deviation is 
    */
    public static double scoreFrequencies(double[] english, double[] currentFreqs) {
        // Loop through the array for each letter and find their differences.
        //Find the sum of differences
        double freqScore = 0;
        
        for (int i = 0; i < 26; i++) {
            freqScore = freqScore + Math.abs(english[i] - currentFreqs[i]);
        }
        
        return freqScore;
    }
    
    /**
    * Function: Crack takes a given filename and first looks to decrypt the message. 
    * Then for each possible key of the alphabet, crack looks to determine one with 
    * the smallest frequency score, reflecting that of the english language alphabet.
    * Input: Strin filename of encrypted message and a String key or set of keys
    * Output:
    */
    
    public static String crack(String filename, String keyname) {
        //First find array with lowest score frequency

        double minValue = Double.MAX_VALUE; 
        int keyValue = 0;
        String decryptedMessage = "";
        
        //Cipher decrypts every key to get score frequency.
        //This identifies the smallest frequency score and obtains its keyValue.
        for (int i = 0; i < 26; i++) {
            
            double[] englishFreqs = getDictionaryFrequencies(keyname);
            double[] currentFreqs = findFrequencies(stringToSymbolArray(decrypt(filename, i)));
            
            double scoreFreq = scoreFrequencies(englishFreqs, currentFreqs);
                
            if (scoreFreq < minValue) {
                minValue = scoreFreq;
                keyValue = i;
            }
        }
        decryptedMessage = decrypt(filename, keyValue);
        
        return decryptedMessage;
    }

    
    /* Function: Takes in a text file, function along with a key as arguments. 
     * For each given function, the textfile and key are then passed through, 
     * and called in a SOPL function. 
     * Input: String 
     * Output: 
     * 
    */
    public static void main(String[] args) {
        
        String function = args[0];
        String filename1 = args[1];
        String key = args[2];
        // Depending on the function name, either a integer for the character key
        //is returned or all of the dictionary is called into the function
        if (function.equals("encrypt")) {
            //Passes through a text file with an original message and key Char value
            In inStream = new In(filename1);
            
            String readFile1 = inStream.readAll();
            //Prints out the encrypted message
            System.out.println(encrypt(readFile1, key.charAt(0) - 65));
            
        } else if (function.equals("decrypt")) {
            //Passes through a text file with an encrypted message and key Char value
            In inStream = new In(filename1);
            
            String readFile1 = inStream.readAll();
            //Prints out the decrypted message
            System.out.println(decrypt(readFile1, key.charAt(0) - 65));
            
        } else if (function.equals("crack")) {
            In inStream = new In(filename1);
            //Passes through a text file with an encrypted message and key text file
            String readFile1 = inStream.readAll();
            
            System.out.println(crack(readFile1, key));
        }
        
    }
    
}
