package arrays;

/**
 * Implementation of bubble sort algorithm.
 * Sorting an integer array by bubble sort algorithm.
 */
public class BubbleSort {
   /**
    * Sorting integer array by ascending.
    * @param array for sorting.
    */
    public final void sort(final int[] array) {
        int barrier;
        for (int index = 0; index < array.length; index++) {
            for (barrier = index + 1; barrier < array.length; barrier++) {
                if (array[index] > array[barrier]) {
                    int replaceValue = array[barrier];
                    array[barrier] = array[index];
                    array[index] = replaceValue;
                }
            }
        }
    }
}
