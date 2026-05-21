public class Calculator {

    // Базовые арифметические операции
    public int add(int a, int b) {
        return a + b;
    }

    public int dif(int a, int b) {
        return a - b;
    }

    public int div(int a, int b) {
        if (b == 0) return 0; // Защита от деления на ноль
        return a / b;
    }

    public int times(int a, int b) {
        return a * b;
    }

    // Решение системы линейных уравнений (из первой версии)
    public int solveSystem() {
        // 2x + 3y = 8
        // 4x - y = 2
        // Решение: x = 1, y = 2
        
        int a1 = 2, b1 = 3, c1 = 8;
        int a2 = 4, b2 = -1, c2 = 2;
        
        int determinant = dif(times(a1, b2), times(a2, b1));
        int x = div(dif(times(c1, b2), times(c2, b1)), determinant);
        int y = div(dif(times(a1, c2), times(a2, c1)), determinant);
        
        // Возвращаем x + y = 1 + 2 = 3
        return add(x, y);
    }

    // Решение квадратного уравнения (возвращает массив double)
    public double[] solveQuadratic(double a, double b, double c) {
        // Проверка на линейное уравнение (a == 0)
        if (a == 0) {
            if (b == 0) {
                return new double[0]; // Нет решений или бесконечно много
            }
            return new double[] {-c / b}; // Один корень линейного уравнения
        }
        
        // Вычисление дискриминанта
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            return new double[0]; // Нет действительных корней
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            return new double[]{x}; // Один корень (кратности 2)
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);
            return new double[]{x1, x2}; // Два корня
        }
    }

    // Решение биквадратного уравнения ax⁴ + bx² + c = 0
    public double[] solveBiquadratic(double a, double b, double c) {
        // Проверка на вырожденный случай (a == 0)
        if (a == 0) {
            // Уравнение становится квадратным: bx² + c = 0
            if (b == 0) {
                return new double[0]; // Нет решений
            }
            // bx² + c = 0 => x² = -c/b
            double xSquared = -c / b;
            if (xSquared < 0) {
                return new double[0];
            } else if (xSquared == 0) {
                return new double[]{0.0};
            } else {
                double x = Math.sqrt(xSquared);
                return new double[]{-x, x};
            }
        }
        
        // Решение квадратного уравнения ay² + by + c = 0 относительно y = x²
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            return new double[0]; // Нет действительных корней
        }
        
        double sqrtD = Math.sqrt(discriminant);
        double y1 = (-b + sqrtD) / (2 * a);
        double y2 = (-b - sqrtD) / (2 * a);
        
        // Используем Set для избежания дубликатов
        java.util.Set<Double> roots = new java.util.HashSet<>();
        
        // Обратная замена: x² = y => x = ±√y
        if (y1 >= 0) {
            double x1 = Math.sqrt(y1);
            double x2 = -x1;
            roots.add(x1);
            roots.add(x2);
        }
        
        if (y2 >= 0) {
            double x3 = Math.sqrt(y2);
            double x4 = -x3;
            roots.add(x3);
            roots.add(x4);
        }
        
        // Преобразование Set в массив
        double[] result = new double[roots.size()];
        int i = 0;
        for (double root : roots) {
            result[i++] = root;
        }
        
        // Сортировка корней для удобства
        java.util.Arrays.sort(result);
        
        return result;
    }
}
