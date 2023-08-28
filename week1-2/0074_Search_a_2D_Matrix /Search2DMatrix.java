import java.util.Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix3(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(searchMatrix3(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            System.out.println(Arrays.toString(arr));
            if (target <= arr[arr.length - 1]) {
                int left = 0;
                int right = arr.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[mid] == target) {
                        return true;
                    } else if (arr[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > matrix[mid][n - 1]) {
                left = mid + 1;
            } else if (target < matrix[mid][0])  {
                right = mid - 1;
            } else {
                int[] arr = matrix[mid];
                if (target <= arr[n - 1]) {
                    int innerLeft = 0;
                    int innerRight = n - 1;
                    while (innerLeft <= innerRight) {
                        int innerMid = (innerLeft + innerRight) / 2;
                        if (arr[innerMid] == target) {
                            return true;
                        } else if (arr[innerMid] < target) {
                            innerLeft = innerMid + 1;
                        } else {
                            innerRight = innerMid - 1;
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix3(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
