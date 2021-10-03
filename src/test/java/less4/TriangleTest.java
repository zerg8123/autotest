package less4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static less4.Triangle.calculateTriangleSquare;
import static org.junit.Assert.assertTrue;

public class TriangleTest {
    @Test
    void positiveTriangleTest() throws Exception {
        double result = calculateTriangleSquare(2, 2, 2);
        Assertions.assertEquals(3, result);
    }

    @Test
    void outOfBoundsTriangleTest() throws Exception {
        double result = calculateTriangleSquare(2, 2, 2);
        assertTrue(result <= 10 && result >= 0);
    }

}
