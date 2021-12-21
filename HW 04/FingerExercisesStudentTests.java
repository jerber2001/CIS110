// /*
//  * Name: Jerry Cai
//  * PennKey: jycai
//  * Recitation: 211
//  * Execution: JUnit "Execute All"
//  * Description: These are test cases that I have written for the recursive
//  functions
//  * /
// 
import static org.junit.Assert.*;
import org.junit.*;

public class FingerExercisesStudentTests {
  /**
   * This is where you will write your test cases.
   */
   
    public void TestGCDFortyAndTwelve() {
        int expected = 4;
        int actual = FingerExercises.gcd(40, 12);
        assertEquals("gcd of 12 and 40", expected, actual);
   }
    
   // This is for compilation purposes
   @Test
   public void TestIgnoreThis() {
     assertTrue(true);
   }
   
    // Question 1: Tests for duplicate numbers to return itself
    @Test
    public void TestGCDFortyAndForty() {
        int expected = 40;
        int actual = FingerExercises.gcd(40, 40);
        assertEquals("gcd of 40 and 40", expected, actual);
   }
   
   //Question 2.1: Tests for sum between 0 and 1, which is 1
    @Test
    public void TestSumTo1() {
        int expected = 1;
        int actual = FingerExercises.sumTo(1);
        assertEquals("cum sum to 1", expected, actual);
    } 
    
   //Question 2.2: Tests for sum between negative numbers -5 and -4
   @Test
   public void TestCumSumBetweenNegative5andNegative4() {
       int expected = -9;
       int actual = FingerExercises.sumBetween(-5, -4);
       assertEquals("cum sum between -5 and -4", expected, actual);
   }
    
   //Question 3: Tests for second largest number in array with duplicates
    @Test
    public void TestSecondLargestJerry() {
        int expected = 1;
        int actual = FingerExercises.findSecondLargest(new int[] {0, 0, 0, 1, 1});
        assertEquals("finding the second largest of {0, 0, 0, 1, 1}", expected, actual);   
    }
    
    //Question 4: Sum of digits should be 1 (I could not find others that are int)
    @Test
    public void TestSumOfDigits() {
        int expected = 1;
        int actual = FingerExercises.sumOfDigits(10000000);
        assertEquals("finding the sum of digits", expected, actual);   
    }   
        
    //Question 6: Tested the edge case that Log5 with base 5 should be 1
    @Test
    public void TestLog5Base5()  {
        int expected = 1;
        int actual = FingerExercises.log(5, 5);
        assertEquals("log base 5 of 5", expected, actual);
   }  

}
