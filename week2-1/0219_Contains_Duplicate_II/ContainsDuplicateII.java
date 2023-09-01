import java.util.*;

import static java.lang.Math.abs;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.computeIfAbsent(nums[i], key -> new ArrayList<>());
            list.add(i);
            if (list.size() >= 2) {
                set.add(nums[i]);
            }
        }
        System.out.println(set + " " + k);
        map.forEach((i, v) -> System.out.println(i + " " + v.toString()));

        for (Integer i : set) {
            List<Integer> list = map.get(i);
            for (int j = 0; j < list.size() - 1; j++) {
                for (int n = j + 1; n < list.size(); n++) {
                    if (abs(j - n) <= k) return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i])) {
//                System.out.println("[" + nums[i] + "] " + i + " - " + map.get(nums[i]) + " <= " + k);
//            }
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
