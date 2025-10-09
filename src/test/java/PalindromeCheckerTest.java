import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import Model.PalindromeChecker;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
    }
}
