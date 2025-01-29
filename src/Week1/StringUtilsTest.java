package Week1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringUtilsTest {
    StringUtils stringUtils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
    }

    @Test
    void testReverseNull() {
        assertNull(stringUtils.reverse(null));
    }

    @Test
    void testReverseEmptyString() {
        assertEquals("", stringUtils.reverse(""));
    }
}
