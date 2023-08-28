public class ValidPalindrome {

    public static void main(String[] args) {
        boolean answer = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(answer);
    }

    /*
    모든 대문자를 소문자로 변환하고 영숫자가 아닌 모든 문자를 제거한 후
    앞뒤로 동일하게 읽는 경우 구문은 회문입니다. 영숫자 문자에는 문자와 숫자가 포함됩니다.

    문자열 s가 주어지면 회문이면 true를 반환하고 그렇지 않으면 false를 반환합니다.
     */
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < chars.length) {
            if (validate(chars[i])) {
                if (validate(chars[j])) {
                    System.out.println(chars[i] + " " + chars[j]);
                    if (toLowerCase(chars[i]) == toLowerCase(chars[j])) {
                        i++;
                        j--;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    j--;
                }
            } else {
                i++;
            }

            if (i == j) {
                break;
            } else if (j - 1 == i) {
                break;
            }
        }
        return true;
    }

    private static boolean validate(char c) {
        return (48 <= c && c <= 57) ||
                (65 <= c && c <= 90) ||
                (97 <= c && c <= 122);
    }

    private static char toLowerCase(char c) {
        return (97 <= c && c <= 122) ? (char) (c - 32) : c;
    }
}
