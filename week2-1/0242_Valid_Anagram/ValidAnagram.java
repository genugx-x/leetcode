import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.replace(c, map.get(c) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer v = map.get(c);
            if (v != null && v > 0) {
                map.replace(c, v - 1);
            } else {
                return false;
            }
        }
        return map.entrySet().stream()
                .allMatch(entry -> entry.getValue() == 0);
    }

    public boolean isAnagram2(String s, String t) {
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        return Arrays.toString(ta).contains(Arrays.toString(sa));
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();

        Arrays.sort(sa);
        Arrays.sort(ta);
        for (int i = 0; i < ta.length; i++) {
            if (ta[i] != sa[i]) return false;
        }
        return true;
    }

//    public boolean isAnagram4(String s, String t) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        char[] sa = s.toCharArray();
//        char[] ta = t.toCharArray();
//
//        for (int i = 0; i < sa.length; i++) {
//            if (!map.containsKey(sa[i])) {
//                map.put(sa[i], 0);
//            }
//            map.replace(sa[i], map.get(sa[i]) + 1);
//            if (!map.containsKey(ta[i])) {
//                map.put(ta[i], 0);
//            }
//            map.replace(sa[i], map.get(sa[i]) - 1);
//        }
//
//        return map.entrySet().stream()
//                .allMatch(entry -> entry.getValue() == 0);
//    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];

        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < sa.length; i++) {
            count[sa[i] - 97]++;
            count[ta[i] - 97]--;
        }
        for (int i : count) {
            if (i != 0) return false;
        }
        return true;
    }
}
