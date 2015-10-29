package leetcode;

/**
 * Created by Xinghuang Leon Xu on 9/3/2015.
 */
public class SearchA2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
//
//    int rowCount;
//    int columnCount;
//
//    public boolean searchMatrix(int[][] matrix, int target) {
//        rowCount = matrix.length;
//        columnCount = matrix[0].length;
//        return searchMatrixWithBoundaries(matrix, target, 0, columnCount - 1, 0, 0, 0, rowCount - 1);
//    }
//
//    private boolean searchMatrixWithBoundaries(int[][] matrix, int target, int rowNum, int rowStartIndex, int rowEndIndex, int columnNum, int colStartIndex, int colEndIndex) {
//        int newRowIndex = binarySearchRow(matrix, target, rowNum, rowStartIndex, rowEndIndex);
//        if (matrix[rowNum][newRowIndex] == target) {
//            return true;
//        }
//        int newColumnIndex = binarySearchCol(matrix, target, columnNum, colStartIndex, colEndIndex);
//        if (matrix[newColumnIndex][columnNum] == target) {
//            return true;
//        }
//        return searchMatrixWithBoundaries(matrix, target, rowNum + 1, rowStartIndex + 1, newRowIndex, columnNum + 1, colStartIndex + 1, newColumnIndex);
//    }
//
//    private int binarySearchCol(int[][] matrix, int target, int columnNum, int colStartIndex, int colEndIndex) {
//        return 0;
//    }
//
//    private int binarySearchRow(int[][] matrix, int target, int rowNum, int rowStartIndex, int rowEndIndex) {
//        if (rowStartIndex >= rowEndIndex) {
//            return rowStartIndex;
//        } else {
//            int midIndex = (rowEndIndex + rowStartIndex) / 2;
//            if (matrix[rowNum][midIndex] == target) {
//                return midIndex;
//            } else if (matrix[rowNum][midIndex] < target) {
//                return binarySearchRow(matrix, target, rowNum, midIndex + 1, rowEndIndex);
//            } else {
//                return binarySearchRow(matrix, target, rowNum, rowStartIndex, midIndex - 1);
//            }
//        }
//    }
}
