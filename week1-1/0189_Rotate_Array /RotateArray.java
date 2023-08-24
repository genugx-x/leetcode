import java.util.Arrays;

public class RotateArray {

    // 성능에 문제 있음 배열 크기가 크고 k가 반복할 수록 해야할 작업수가 너무 많아짐
//    public void rotate(int[] nums, int k) {
//        while (k-- > 0) {
//            int n = nums[0];
//            for (int j = 1; j < nums.length; j++) {
//                int t = nums[j];
//                nums[j] = n;
//                n = t;
//            }
//            nums[0] = n;
//        }
//    }

    // 실패
//    public void rotate(int[] nums, int k) {
//        int count = 0;
//        int i = 0; // index
//        int iv = nums[i]; // i의 value
//        while (count < nums.length) {
//            int n = i + k;
//            if (n >= nums.length) {
//                int t = n % nums.length;
//                int tv = nums[t];
//                nums[t] = iv;
//                i = t;
//                iv = tv;
//            } else {
//                int nv = nums[n];
//                nums[n] = iv;
//                i = n;
//                iv = nv;
//            }
//            System.out.println(Arrays.toString(nums));
//            count++;
//        }
//    }

    // 통과
//    public void rotate(int[] nums, int k) {
//        int[] numsClone = nums.clone();
//        for (int i = 0; i < numsClone.length; i++) {
//            int n = i + k;
//            if (n < nums.length) {
//                nums[n] = numsClone[i];
//            } else {
//                nums[n % nums.length] = numsClone[i];
//            }
//        }
//    }

    // 2ms -> 0mx 속도 개선 코드
    public void rotate(int[] nums, int k) {
        int[] numsClone = nums.clone();
        if (nums.length < k) {
            k = k % nums.length;
        }
        System.arraycopy(numsClone, 0, nums, k, nums.length - k);
        System.arraycopy(numsClone, nums.length - k, nums, 0, k);
    }
}
