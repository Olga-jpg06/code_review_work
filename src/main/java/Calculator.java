import java.util.*;

public class Calculator {

    // Базовые арифметические операции
    public int add(int a, int b) {
        return a + b;
    }

    public int dif(int a, int b) {
        return a - b;
    }

    public int div(int a, int b) {
        if (b == 0) return 0;
        return a / b;
    }

    public int times(int a, int b) {
        return a * b;
    }

    // Решение системы линейных уравнений
    public int solveSystem() {
        int a1 = 2, b1 = 3, c1 = 8;
        int a2 = 4, b2 = -1, c2 = 2;
        
        int determinant = dif(times(a1, b2), times(a2, b1));
        int x = div(dif(times(c1, b2), times(c2, b1)), determinant);
        int y = div(dif(times(a1, c2), times(a2, c1)), determinant);
        
        return add(x, y);
    }

    // Решение квадратного уравнения
    public double[] solveQuadratic(double a, double b, double c) {
        // Линейное уравнение (a == 0)
        if (a == 0) {
            if (b == 0) {
                return new double[0];
            }
            return new double[]{-c / b};
        }
        
        // Дискриминант
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            return new double[]{x};
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);
            // Сортируем корни для предсказуемого порядка
            double[] result = {Math.min(x1, x2), Math.max(x1, x2)};
            return result;
        }
    }

    // Решение биквадратного уравнения ax⁴ + bx² + c = 0
    public double[] solveBiquadratic(double a, double b, double c) {
        // Если a == 0, сводится к квадратному
        if (a == 0) {
            return solveQuadratic(b, 0, c);
        }
        
        // Решаем квадратное уравнение относительно y = x²
        double[] yRoots = solveQuadratic(a, b, c);
        
        Set<Double> rootsSet = new TreeSet<>();
        
        for (double y : yRoots) {
            if (y > 0) {
                double sqrtY = Math.sqrt(y);
                rootsSet.add(-sqrtY);
                rootsSet.add(sqrtY);
            } else if (Math.abs(y) < 1e-10) { // y == 0
                rootsSet.add(0.0);
            }
            // Если y < 0 - нет действительных корней
        }
        
        // Преобразуем Set в массив
        double[] result = new double[rootsSet.size()];
        int i = 0;
        for (double root : rootsSet) {
            result[i++] = root;
        }
        
        return result;
    }
}
