import java.util.*;

public class RemoveDuplicatesfromSortedArray2 {

//    public int removeDuplicates(int[] nums) {
//        Map<Integer, Integer> map = new TreeMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 0);
//            }
//            map.replace(num, map.get(num) + 1);
//        }
//        int k = 0;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int count = entry.getValue();
//            if (count > 2) {
//                count = 2;
//            }
//            for (int i = 0; i < count; i++) {
//                nums[k++] = entry.getKey();
//            }
//        }
//        return k;
//    }

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 0);
            }
            int c = map.get(n);
            if (c < 2) {
                map.replace(n, c + 1);
                nums[i++] = n;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

}
