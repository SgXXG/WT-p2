import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите размер массива");
        Scanner scanner = new Scanner(System.in);
        System.out.print("N: ");
        int n = scanner.nextInt();
        int[] array;
        array = new int[n];

        for (int i = 0; i < n; i++){
            System.out.print("Введите элемент массива: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Array: ");
        for (int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println("\nИндексы простых чисел:");
        for (int i = 0; i < n; i++){
            boolean prime = isPrime(array[i]);
            if (prime){
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime (int num){
        int temp;
        boolean prime = true;

        for (int i=2; i<=num/2; i++) {
            temp = num % i;
            if (temp == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}