public class ValidAnagramMain {
    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        System.out.println(solution.isAnagram4("anagram", "nagaram"));
        System.out.println(solution.isAnagram4("rat", "car"));
        System.out.println(solution.isAnagram4("ab", "a"));
    }
}
