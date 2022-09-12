import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int shellSort(int array[]) {
        int array_length = array.length;
        int j, i;
        for (int element_gap = array_length / 2; element_gap > 0; element_gap = element_gap /2) {
            for (i = element_gap; i < array_length; i += 1) {
                int temprary_elemnt = array[i];
                for ( j = i; j >= element_gap && array[j - element_gap] > temprary_elemnt; j -= element_gap)
                    array[j] = array[j - element_gap];
                array[j] = temprary_elemnt;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
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

        System.out.println("Array : ");
        System.out.println(Arrays.toString(array));

        // Sort
        int shell = shellSort(array);

        System.out.println("Array sorted by Shell : ");
        System.out.println(Arrays.toString(array));
    }

}