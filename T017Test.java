import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.*;

public class T017Test {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void letterCombinations() throws Exception {
        List<String> res = new ArrayList<>(Arrays.asList(new String[]{"d","e","f"}));
        assertEquals(res,(new T017()).letterCombinations("3"));
        assertSame(res,(new T017()).letterCombinations("3"));
    }

}