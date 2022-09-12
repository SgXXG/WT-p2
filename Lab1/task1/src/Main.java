import java.util.Scanner;

    public class Main {
    static double square(double a){
        double result = a*a;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        System.out.println(x);
        System.out.println(y);

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
        System.out.print("Result: ");
        System.out.format("result = %.3f%n", result);
    }
}