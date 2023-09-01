import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.replace(c, map.get(c) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            Integer v = map.get(c);
            if (v != null && v > 0) {
                map.replace(c, v - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
