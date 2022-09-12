import java.util.Scanner;

    public class Main {
    static double square(double a){
        double result = a*a;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите x: ");
        double x = scanner.nextDouble();
        System.out.print("Введите y: ");
        double y = scanner.nextDouble();

        double temp = Math.sin(x+y);
        temp = temp + 1;

        double temp2 = x*2;
        double x2 = square(x);
        double y2 = square(y);
        double x2y2= x2 + y2 + 1;
        double fraction = temp2 / x2y2;
        double temp3 = x - Math.abs(fraction);
        temp3 = 2 + temp3;

        fraction = temp / temp3;

        double result = fraction + x;
        System.out.format("Result = %.3f%n", result);
    }
}