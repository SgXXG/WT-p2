import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Границы отрезка
        System.out.println("Введите границы отрезка");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        int a = scanner.nextInt();
        System.out.print("b: ");
        int b = scanner.nextInt();

        System.out.println("Введите шаг");
        System.out.print("h: ");
        double h = scanner.nextDouble();

        double x = a;
        System.out.println("Значение аргумента      Значение функции");
        while (x <= b){
            double function = Math.tan(x);
            System.out.format("arg = %.3f\t\t\t\t", x);

            System.out.format("function = %.6f%n", function);
            x += h;
        }


    }
}