import java.util.*;

public class RemoveDuplicatesfromSortedArray {

    // 정렬된 배열 중복 제거
//    public int removeDuplicates(int[] nums) {
//        Set<Integer> set = new TreeSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        int i = 0;
//        for (Integer num : set) {
//            nums[i++] = num;
//        }
//        for (int j = i; j < nums.length; j++) {
//            nums[j] = 0;
//        }
//        return set.size();
//    }

    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

}
