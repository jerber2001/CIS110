// /*
//  * Name: Jerry Cai
//  * PennKey: jycai
//  * Recitation: 211
//  * Description: These are recursive functions that will test base cases provided 
//  in another file FingerExercisesStudentTests.java
//  * /
 
 public class FingerExercises {
    //First Question 1: Writes a Euclid algorithm to find the greatest common
    //denominator
     public static int gcd(int a, int b) {
         //If else statement looks at divisibility of each integer
         if (a < b) {
             return gcd(b, a);
         } else if (a == b) {
             return b;
         } else if (b == 0) {
             return a;
         }
         return gcd(b, a%b);
     } 
     //First Question 2.1: Finds the sum of consecutive integers between 2 numbers
     public static int sumBetween(int a, int b) {
         //If else statement moves from starting integer and cumulatively takes sums
         if (b == a) {
             return a;
         }
         return b + sumBetween(a, b - 1);
     }
     
     //First Question 2.2: Finds the sum of consecutive integers between 1 and n
     public static int sumTo(int x) {
         //If else statement moves from starting integer and cumulatively takes sums
         
         if (x == 1) {
             return 1;
         }
         return x + sumTo(x - 1);
     }
     
     //First Question 3: Finds the second largest number within an array
     public static int findSecondLargestHelper(int largest, int secondLargest, int index, int[] nums) {
         int currentLargest = largest;
         int currentSecondLargest = secondLargest;
         //If else staatement moves through the array index, comparing each value to
         //the current largest and secondlargest values. Replaces if necessary
         if (index == nums.length) {
             return secondLargest;
         } else if (nums[index] >= currentLargest) {
             currentSecondLargest = currentLargest;
             currentLargest = nums[index];
             return findSecondLargestHelper(currentLargest, currentSecondLargest, index + 1, nums);
         } else if (nums[index] < currentLargest && nums[index] >= currentSecondLargest) {
             currentSecondLargest = nums[index];
             return findSecondLargestHelper(currentLargest, currentSecondLargest, index + 1, nums);
         }
         return findSecondLargestHelper(currentLargest, currentSecondLargest, index + 1, nums);
     }
     
     public static int findSecondLargest(int[] nums) {
        return findSecondLargestHelper(Integer.MIN_VALUE, Integer.MIN_VALUE, 0, nums);
    }
     
     
     //First Question 4: Finds the sum of all digits within an integer
     public static int sumOfDigits(int x) {
         //If loop takes the last digit and adds to accumulator variable
         if (x / 10 == 0) {
             return x;
         }
         return x % 10 + sumOfDigits(x / 10);
     }

     //First Question 6: Computes the log of n number given its base
     public static int log(int base, int n) {
         //Takes the division of number and counts the times of division
         int logCounter = 0;
         if (n == base) {
             return 1;
         } else if (n < base) {
             return 0;
         }
         logCounter++;
         return logCounter + log(base, n / base);
     }
 }





 