import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int[] output = twoSum4(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(output));
        int[] output2 = twoSum4(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.toString(output2));
        int[] output3 = twoSum4(new int[]{-1, 0}, -1);
        System.out.println(Arrays.toString(output3));
        int[] output4 = twoSum4(new int[]{5, 25, 75}, 100);
        System.out.println(Arrays.toString(output4));
        int[] output5 = twoSum4(new int[]{12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86,
                88, 92, 124, 125, 136, 168, 173, 173, 180, 199, 212, 221, 227, 230, 277, 282, 306,
                314, 316, 321, 325, 328, 336, 337, 363, 365, 368, 370, 370, 371, 375, 384, 387,
                394, 400, 404, 414, 422, 422, 427, 430, 435, 457, 493, 506, 527, 531, 538, 541, 546,
                568, 583, 585, 587, 650, 652, 677, 691, 730, 737, 740, 751, 755, 764, 778, 783, 785,
                789, 794, 803, 809, 815, 847, 858, 863,
                863, 874, 887, 896, 916, 920, 926, 927, 930, 933, 957, 981, 997}, 542);
        System.out.println(Arrays.toString(output5));
    }


    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int t = target - numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == t) {
                    return new int[]{i + 1, j + 1};
                } else if (numbers[j] > t) {
                    break;
                }
            }
        }
        return null;
    }

    // 2, 7, 11, 15    9
    public static int[] twoSum3(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int t = target - numbers[i];
            // 다른 요소가 t인 것을 찾으면 됨
            // 탐색 범위는 i + 1 ~ numbers.length - 1
            int start = i + 1;
            int end = numbers.length;
            while (start < end) {
                int mid = (end - start) / 2 + start;
                if (numbers[mid] == t) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < t) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        return null;
    }

    // 2,7,11,15    9
    // 5, 25, 75    100
    public static int[] twoSum4(int[] numbers, int target) {
        int i = 0;
        while (i < numbers.length - 1) {
            int t = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            if (i == 23) {
                System.out.println(numbers[i] + " " + t);
            }
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                System.out.println(i + " - " + left + " " + right + " " + mid);
                if (numbers[mid] == t) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] < t) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            i++;
        }
        return null;
    }
}
