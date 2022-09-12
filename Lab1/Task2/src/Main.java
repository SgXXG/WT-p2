import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // top
        int x0 = -4;
        int y0 = 5;
        int x1 = 4;
        int y1 = 0;

        // down
        int x2 = -6;
        int y2 = 0;
        int x3 = 6;
        int y3 = -3;

        // User point
        System.out.println("Введите вашу точку:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату x: ");
        int x = scanner.nextInt();
        System.out.print("Введите координату y: ");
        int y = scanner.nextInt();

        boolean res1 = Affilate(x1, y1, x0, y0, x, y);
        boolean res2 = Affilate(x3, y3, x2, y2, x, y);
        boolean result = res1 || res2;

        System.out.print("Result: " + result);
    }
    // Checking point
    public static boolean Affilate(int x0, int y0, int x1, int y1, int x, int y) {
        boolean result = x >= x1 && x <= x0 && y >= y0 && y <= y1;
        return result;
    }
}