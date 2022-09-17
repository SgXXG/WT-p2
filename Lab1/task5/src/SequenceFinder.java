import java.util.Arrays;

public class SequenceFinder {
    public static int find(int[] array){

        int[] lengthArray = new int[array.length];

        for (int i = 0; i < array.length; i++){

            lengthArray[i] = 1;
            int previousElement = 0;

            for (int j = i - 1; j >= 0; j--){

                if (array[i] > array[j] && array[j] > previousElement){
                    lengthArray[i] = lengthArray[j] + 1;
                    previousElement = array[j];
                }
            }
        }
        //System.out.println(Arrays.toString(lengthArray));

        return array.length - Arrays.stream(lengthArray).max().getAsInt();

    }
}
