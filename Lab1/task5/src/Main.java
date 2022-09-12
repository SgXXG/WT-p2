import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Введите количество элементов последовательности: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array;
        array = new int[n];

        for (int i = 0; i < array.length; i++){
            System.out.print("Введите элемент последовательности: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("Array:");
        System.out.println(Arrays.toString(array));

        ArrayList<Integer> newArrays = new ArrayList<Integer>();
        int count = 0;
        int sizeofarray = 1;

        int i = 1;
        newArrays.add(array[0]);
        for (int j = 1; j < array.length; j++){
            if (array[j] < newArrays.get(i)){
                newArrays.add(array[i]);
                i++;
            }
        }

        Integer[] array2 = newArrays.stream().toArray(Integer[]::new);

        System.out.println("Received array:");
        System.out.println(Arrays.toString(array2));
    }
}
