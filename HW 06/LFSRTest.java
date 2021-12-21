/**
 * Name: Jerry Cai
 * Pennkey: jycai
 * Execution: JUnit
 *
 * Description: JUnit tests each constructor and method for working functions, and
 * also verifies that Argument Exception errors are as expected
**/
import static org.junit.Assert.*;
import org.junit.*;

public class LFSRTest {
    // dummy test
    @Test
    public void dummyTest() {
        assertTrue(true);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNullSeed() {
        // should throw exception when seed is null
        LFSR broken = new LFSR(null, 5);
    }
    
    // Testing the LFSR constructor - Exception Tap
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidTap() {
        // should throw exception when tap number is invalid
        LFSR broken = new LFSR("10101", 10);
    }
    //Testing wrong numbers in seed - Exception Num
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithNumberType() {
        // should throw exception when number other than 1 or 0
        LFSR broken = new LFSR("1013", 2);
    }
    
    //     Constructor that works properly with toString - Normal Funct
    @Test
    public void testConstructorExpectedtoString() {
        LFSR broken = new LFSR("1010", 2);
        String expected = "1010";
        String actual = broken.toString();
        assertEquals(expected, actual);
    }
    
    // Testing the LFSR constructor - Exception Tap and Edge Case
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidTapSeedLength() {
        // should throw exception when tap number is invalid
        LFSR broken = new LFSR(3, 10);
    }
    
    //Constructor that works properly with getTapPosition - Normal Funct
    @Test
    public void testConstructorExpectedgetTapPosition() {
        LFSR broken = new LFSR("10101", 2);
        int expected = 2;
        int actual = broken.getTapPosition();
        assertEquals(expected, actual);
    }
    
    //nextBit() expected fail
    @Test(expected = IllegalArgumentException.class)
    public void testNextBitNoShift() {
        // should throw exception when seed is null
        LFSR broken = new LFSR("1", 2);
        broken.nextBit();
    }
    
    //nextBit() expected function
    @Test
    public void testNextBitExpected() {
        LFSR broken = new LFSR("00000", 1);
        int expected = 0;
        int actual = broken.nextBit();
        assertEquals(expected, actual);
    }
    
    //nextBit() Edge Cases - expected to fail
    @Test(expected = IllegalArgumentException.class)
    public void testNextBitZeros() {
        // should throw exception when tap number is invalid
        LFSR broken = new LFSR(0, 0);
        broken.nextBit();
    }
    
}
