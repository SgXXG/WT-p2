public class ArrayMerger {

    public static int[] getMergeInstructions(int[] a, int[] b) {

        int i = 0, j = 0, k = -1;
        int[] result = new int[b.length];

        while (i < a.length && j < b.length) {

            if (a[i] <= b[j]) {
                k = i++;
            } else {
                result[j++] = k;
            }

        }

        while (j < b.length) {
            result[j++] = a.length - 1;
        }

        return result;

    }

}
