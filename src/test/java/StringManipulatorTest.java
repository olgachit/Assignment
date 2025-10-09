import Model.StringManipulator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {
    StringManipulator sm = new StringManipulator();
    @Test
    public void concatenateTest() {
        assertEquals("HelloWorld", sm.concatenate("Hello", "World"));
    }
    @Test
    public void findLengthTest() {
        assertEquals(5, sm.findLength("Hello"));
    }
    @Test
    public void convertToUpperCaseTest() {
        assertEquals("HELLO", sm.convertToUpperCase("hello"));
    }
    @Test
    public void convertToLowerCaseTest() {
        assertEquals("hello", sm.convertToLowerCase("HELLO"));
    }
    @Test
    public void containsSubstringTest() {
        assertTrue(sm.containsSubstring("HelloWorld", "World"));
        assertFalse(sm.containsSubstring("HelloWorld", "Hei"));
    }
}