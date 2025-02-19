public class Sorting {

    public static int[] sortArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

}
