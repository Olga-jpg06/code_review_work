import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void add() {
        assertEquals(13, calculator.add(7, 6));
        assertEquals(-9, calculator.add(5, -14));
        assertEquals(15, calculator.add(8, 7));
        assertEquals(-3, calculator.add(5, -8));
    }

    @Test
    void dif() {
        assertEquals(11, calculator.dif(15, 4));
        assertEquals(-5, calculator.dif(0, 5));
        assertEquals(10, calculator.dif(14, 4));
        assertEquals(-2, calculator.dif(3, 5));
    }

    @Test
    void div() {
        assertEquals(3, calculator.div(15, 5));
        assertEquals(0, calculator.div(7, 0));
        assertEquals(12, calculator.div(144, 12));
        assertEquals(0, calculator.div(10, 0));
    }

    @Test
    void times() {
        assertEquals(143, calculator.times(13, 11));
        assertEquals(0, calculator.times(3, 0));
        assertEquals(120, calculator.times(12, 10));
        assertEquals(0, calculator.times(5, 0));
    }

    @Test
    void solveSystem() {
        assertEquals(3, calculator.solveSystem());
    }

    @Test
    void solveQuadratic() {
        // Два корня: x² - 5x + 6 = 0 -> [2, 3]
        double[] roots1 = calculator.solveQuadratic(1, -5, 6);
        assertArrayEquals(new double[]{2.0, 3.0}, roots1, 0.0001);

        // Один корень: x² - 4x + 4 = 0 -> [2]
        double[] roots2 = calculator.solveQuadratic(1, -4, 4);
        assertArrayEquals(new double[]{2.0}, roots2, 0.0001);

        // Нет корней: x² + 1 = 0 -> []
        double[] roots3 = calculator.solveQuadratic(1, 0, 1);
        assertEquals(0, roots3.length);

        // Линейное: 2x + 4 = 0 -> [-2]
        double[] roots4 = calculator.solveQuadratic(0, 2, 4);
        assertArrayEquals(new double[]{-2.0}, roots4, 0.0001);

        // x² - 4 = 0 -> [-2, 2]
        double[] roots5 = calculator.solveQuadratic(1, 0, -4);
        assertArrayEquals(new double[]{-2.0, 2.0}, roots5, 0.0001);
    }

    @Test
    void solveBiquadratic() {
        // x⁴ - 5x² + 4 = 0 -> [-2, -1, 1, 2]
        double[] roots1 = calculator.solveBiquadratic(1, -5, 4);
        assertArrayEquals(new double[]{-2.0, -1.0, 1.0, 2.0}, roots1, 0.0001);

        // x⁴ - 4x² = 0 -> [-2, 0, 2]
        double[] roots2 = calculator.solveBiquadratic(1, -4, 0);
        assertArrayEquals(new double[]{-2.0, 0.0, 2.0}, roots2, 0.0001);

        // x⁴ + x² = 0 -> [0] (только 0)
        double[] roots3 = calculator.solveBiquadratic(1, 1, 0);
        assertArrayEquals(new double[]{0.0}, roots3, 0.0001);
    }
}
