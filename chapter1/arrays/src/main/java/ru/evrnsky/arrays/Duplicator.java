package ru.evrnsky.arrays;
/**
 * It class which remove from string all duplicates.
 * It operates as follow: find duplicate and set cell in array in null.
 * Next move all null to end of string array.
 */
public class Duplicator {

    /**
     * This method removed duplicates from String array.
     *
     * @param array for remove duplicates.
     * @return array without duplicates.
     */
    public final String[] removeDuplicates(final String[] array) {
        int length = markDuplicates(array);
        replaceNullToEnd(array);
        String[] result = new String[length];

        System.arraycopy(array, 0, result, 0, length);
        return result;
    }

    /**
     * Mark all duplicates null.
     * @param array - array for marking duplicates.
     * @return length - count of unique values in array.
     */
    private int markDuplicates(final String[] array) {
        int length = 0;
        int barrier;
        for (int index = 0; index < array.length; index++) {
            for (barrier = index + 1; barrier < array.length; barrier++) {
                if (array[index] != null && array[index].equals(array[barrier])) {
                        array[barrier] = null;
                        length++;
                    }
                }
            }
        return length;
    }

    /**
     * Move all null to end of array.
     * @param array string array, where duplicates marked as null.
     */
    private void replaceNullToEnd(final String[] array) {
        for (int index = 0; index < array.length; index++) {
            for (int barrier = index + 1; barrier < array.length; barrier++) {
                if (array[index] == null && array[barrier] != null) {
                    String copyString = array[barrier];
                    array[index] = copyString;
                    array[barrier] = null;
                }
            }
        }
    }
}
