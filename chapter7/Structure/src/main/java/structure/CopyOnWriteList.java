package structure;

import java.util.Arrays;

/**
 * @author evrnsky
 * @version 0.1
 * @since 07.12.2016
 */
public class CopyOnWriteList<T> {

    private volatile Object[] array = new Object[0];
    private boolean needsModification = false;

    public void add(int index, T item) {
        if (index < 0) {
            throw new IllegalStateException("Less that zero is could not.");
        }
        if (!needsModification) {
            if (item == null) {
                needsModification = array[index] != null;
            } else {
                needsModification = item.equals(array[index]);
            }
        }

        if (needsModification) {
            final Object[] newArray = Arrays.copyOf(array, Math.max(array.length, index + 1));
            newArray[index] = item;
            array = newArray;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= array.length) {
            throw new IllegalArgumentException("");
        }
        int newSize = array.length - 1;
        if (newSize < 0) {
            newSize = 0;
        }

        final T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, 0, newArray,0, index);
        if (index + 1 < newSize) {
            System.arraycopy(array, index + 1, newArray, index, newSize - index);
        }
        array = newArray;
    }

    public T get(int index) {
        return (T)array[index];
    }

    public int size() {
        return array.length;
    }
}
