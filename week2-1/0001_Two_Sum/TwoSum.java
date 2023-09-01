import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
                if (nums[i] == nums[j]) {
                    int k = j;
                    while (nums[i] == nums[k + 1]) {
                        k++;
                    }
                    i = k;
                    break;
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            Set<Integer> set = map.computeIfAbsent(n1, k -> new HashSet<>());
            for (int j = i + 1; j < nums.length; j++) {
                int n2 = nums[j];
                if (!set.contains(n2)) {
                    if (n1 + n2 == target) {
                        return new int[]{i, j};
                    }
                    set.add(n2);
                }
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n1 = nums[i];
            Set<Integer> set = map.computeIfAbsent(n1, k -> new HashSet<>());
            if (!set.isEmpty()) continue;
            for (int j = i + 1; j < nums.length; j++) {
                int n2 = nums[j];
                if (!set.contains(n2)) {
                    if (n1 + n2 == target) {
                        return new int[]{i, j};
                    }
                    set.add(n2);
                }
            }
        }
        return null;
    }

    public int[] twoSum4(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // log(n)
            List<Integer> list = map.computeIfAbsent(nums[i], k -> new ArrayList<>());
            if (list.size() < 2) {
                list.add(i);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> e1 : map.entrySet()) {
            int k1 = e1.getKey();
            List<Integer> v1 = e1.getValue();
            if (v1.size() == 2) {
                if (k1 + k1 == target) {
                    return new int[]{v1.get(0), v1.get(1)};
                }
            }
            set.add(k1);
            for (Map.Entry<Integer, List<Integer>> e2 : map.entrySet()) {
                int k2 = e2.getKey();
                List<Integer> v2 = e2.getValue();
                if (!set.contains(k2)) {
                    if (k1 + k2 == target) {
                        return new int[]{v1.get(0), v2.get(0)};
                    }
                }
            }
        }
        return null;
    }

    public int[] twoSum5(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // log(n)
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                int j = map.get(t);
                if (i != j)
                    return new int[] {i, j};
            }
        }
        return null;
    }

    public int[] twoSum6(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // log(n)
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        System.out.println(map);
        return null;
    }

    public int[] twoSum7(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println(map);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int index = map.get(target - nums[i]);
                if (index == i) continue;
                return new int[]{index, i};
            }
        }
        return new int[]{-1, -1};
    }
}
