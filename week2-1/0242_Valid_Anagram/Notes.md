[242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)

1. 문제
   애너그램(Anagram) 검증 문제로 애너그램이란 단어나 문장을 구성하고 있는 문자의 순서를 바꾸어 다른 단어나 문장을 만드는 것이다. 정확히는 구성하고 있는 문자를 단 한번씩만 사용하여 다른 단어 또는 문장으로 만든다.
   따라서 문제에서 주어지는 인자는 두 문자열 s와 t가 주어지고 t와 s가 같은 철자면 true를 반환하고 아니면 false를 반환한다.
2. 문제 분석

   - 주어진 두 문자열을 비교하기 알맞은 형태로 변환한다.
   - 문자열을 우선 문자로 나눈다 (ex: "cat" -> {'c', 'a', 't'})
   - 문자로 나눈 문자열을 찾을 필요없이 순서대로 비교하기 위해 정렬한다. (ex: {'c', 'a', 't'} -> {'a', 'c', 't'})
   - s, t 문자열을 위 과정대로 변환한 문자 배열을 차례로 비교하며 다른 문자가 섞여있다면 false를 반환 모든 문자가 일치한다면 true를 반환한다.
3. 풀이 과정

   1. 두 문자열 s와 t의 길이가 다르다면 무조건 false를 반환한다.
   2. s와 t 문자열을 각 char[]로 변환한 후 정렬한다.
   3. 정렬한 두 배열을 반복문을 통해 순환하며 같은 인덱스의 다른값이 있다면 false를 반환한다.
   4. 모든 배열을 순환하면 true를 반환한다.

   이와 같은 과정으로 1차 풀이 코드를 작성하였다.

   ```java
   public boolean isAnagram(String s, String t) {
       // 1 두 문자열의 길이가 다르면 false
       if (s.length() != t.length()) {
           return false;
       }
       // 2 문자열 -> 문자 배열 변환
       char[] sa = s.toCharArray();
       char[] ta = t.toCharArray();
   
       // 3 정렬
       Arrays.sort(sa);
       Arrays.sort(ta);

       // 4 각 인덱스의 문자 비교. 두 문자가 다르다면 false
       for (int i = 0; i < ta.length; i++) {
           if (ta[i] != sa[i]) return false;
       }

       return true;
   }
   ```
   하지만 3번 부분의 정렬 과정에서 두 문자열을 변환한 char형 배열을 순회하기 때문에 비효율적이다.
   그래서 접근 방법을 변경했다.

   - 문제에서 주어지는 두 문자열은 소문자로만 제공하기 때문에 아스키 코드의 일정 범위로 접근할 수 있다.
   - 그리고 이 문자가 등장하는 횟수를 기록하는 배열에 문자의 아스키 코드값을 활용한다. 
   - 예를 들어 97(a) ~ 122(z) 가 있다면 문자는 총 26개고 이 개수 만큼의 배열을 생성한다. (ex. int[] count = new int[26])
   - 그리고 각 문자가 등장하는 경우 `chars[i] = 'a'` 라고 할때 `count[chars[i] - 97]`을 하게 되면 count[0]에 접근할 것이고 각 t, s의 문자를 통해 한쪽은 'counts[0]--', 'counts[0]++' 연산을 한다.
   - 이렇게 s, t의 모든 문자를 반복하며 count 배열에 표시하고 count의 모든 값이 0이면 true, 아닌 경우는 false를 반환한다.

4. 최종 코드
   ```java
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
   ```

