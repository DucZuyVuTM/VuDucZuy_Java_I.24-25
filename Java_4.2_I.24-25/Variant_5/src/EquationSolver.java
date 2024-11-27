import java.util.Scanner;

// Интерфейс для поиска корней
interface RootFinder {
    void findRoots();
}

// Класс для линейного уравнения (Ax + B = 0)
class LinearEquation implements RootFinder {
    private double b;
    private double c;

    public LinearEquation(double b, double c) {
        this.b = b;
        this.c = c;
    }

    @Override
    public void findRoots() {
        if (b == 0) {
            if (c == 0) {
                System.out.println("Уравнение имеет бесконечное количество решений.");
            } else {
                System.out.println("Уравнение не имеет решений.");
            }
        } else {
            double root = -c / b;
            System.out.println("Корень уравнения: x = " + root);
        }
    }
}

// Класс для квадратного уравнения (Ax^2 + Bx + C = 0)
class QuadraticEquation implements RootFinder {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void findRoots() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + root1 + ", x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("Уравнение имеет один корень: x = " + root);
        } else {
            System.out.println("Уравнение не имеет действительных корней.");
        }
    }
}

// Основной класс программы
public class EquationSolver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ввод коэффициентов A, B, C
        System.out.print("Введите коэффициент A: ");
        double a = input.nextDouble();
        System.out.print("Введите коэффициент B: ");
        double b = input.nextDouble();
        System.out.print("Введите коэффициент C: ");
        double c = input.nextDouble();

        // Выбор типа уравнения
        RootFinder solver;
        if (a == 0) {
            // Если A = 0, это линейное уравнение
            solver = new LinearEquation(b, c);
        } else {
            // Если A ≠ 0, это квадратное уравнение
            solver = new QuadraticEquation(a, b, c);
        }

        // Поиск и вывод корней
        solver.findRoots();

        input.close();
    }
}
