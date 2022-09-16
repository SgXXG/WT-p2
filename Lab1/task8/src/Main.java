import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        int[] arrayA, arrayB;
        Scanner in = new Scanner(System.in);

        arrayA = new int[] {1, 3, 5, 7};
        arrayB = new int[] {1, 2, 5, 6, 7, 9};

        int[] result = ArrayMerger.getMergeInstructions(arrayA, arrayB);

        System.out.println("result: ");
        for (int i = 0; i < arrayB.length; i++){
            System.out.printf("input %d after A[%d] \n", arrayB[i], result[i]);
        }

    }
}

