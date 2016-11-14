package arrays;

/**
 * This class rotate two dimension matrix on 90 degree left.
 */
public class Rotate {
    /**
     * Rotate matrix on to 90 degree right.
     * @param matrix - it is matrix for rotation.
     * @return rotate by 90 degree matrix from original matrix.
     */
    public final int[][] rotate90(final int[][] matrix) {
        int[][] resultMatrix = new int[matrix[0].length][matrix.length];

        for (int index = 0; index < matrix[0].length; index++) {
            for (int barrier = matrix.length - 1; barrier >= 0; barrier--) {
                resultMatrix[index][barrier] = matrix[barrier][index];
            }
        }
        return resultMatrix;
    }
}
