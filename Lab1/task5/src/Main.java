import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        int n;
        int[] array;
        Scanner in = new Scanner(System.in);

        try {

            System.out.print("N: ");
            n = in.nextInt();

            array = new int[n];
            for (int i = 0; i < n; i++){
                System.out.printf("Array[%d]: ", i);
                array[i] = in.nextInt();
            }

        } catch (Exception e) {
            System.out.println("Error");
            return;
        }

        int result = SequenceFinder.find(array);

        System.out.printf("result: %d", result);

    }
}

