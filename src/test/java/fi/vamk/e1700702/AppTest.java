package fi.vamk.e1700702;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    // Check the length of invoice number which should be between 4 to 19
    @Test
    public void lengthIsCorrectTest()
    {
      assertTrue(App.lengthIsCorrect() > 3);
      assertTrue(App.lengthIsCorrect() < 20);
    }

    // check the numbers have been grouped into five
    @Test
    public void groupByFiveTest() {
      assertTrue(App.groupByFive());
    }

    // check reference number only contains numbers and spaces
    @Test
    public void numberAndSpacesTest() {
      assertTrue(App.numbersAndSpaces());
    }

    // check the checking number is correct
    @Test
    public void checkNumberIsCorrectTest() {
      assertTrue(App.checkNumberIsCorrect());
    }

}
