[80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

이 문제는 이전 [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) 문제와 같이 요소의 중복을 제거하는 문제지만 조금은 더 난이도가 있었다.

다른 부분은 요소의 중복을 제거하지만 같은 요소가 두 번까지는 입력될 수 있도록 하는 것이다.

<pre><strong>Input:</strong> nums = [0,0,1,1,1,1,2,3,3]
<strong>Output:</strong> 7, nums = [0,0,1,1,2,3,3,_,_]
<strong>Explanation:</strong> Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

이전 문제에서는 Set을 활용해 중복 제거에 활용했는데 이번엔 두 번까지는 중복이 되는 경우라 다음 세가지 경우를 생각해 주는게 필요해 보였다.

1. 값이 없는 경우
2. 값이 1개인 경우
3. 동일한 값이 2개 이상인 경우

어차피 값이 없는 경우는 요소가 없기 때문에 신경쓸 필요는 없지만 값이 1개인 경우와 중복된 값이 있고 2개 이상인 경우에 대해 생각은 해봐야 했었다.

따라서 Map을 활용하기로 했다.

- Map<요소, 요소의 갯수>

nums를 순회 하면서 Map에 해당 요소를 key로 등록하고 value로는 중복된 갯수를 2까지 증가시켜 이를 통해 중복된 값을 2개까지는 nums에 입력한다.


```java
public int removeDuplicates(int[] nums) {
    // key: 요소의 값, value: 값의 갯수
    Map<Integer, Integer> map = new HashMap<>();
    int i = 0; // nums에 값을 새로 입력할 때 쓰일 인덱스 변수
    for (int n : nums) {
        if (!map.containsKey(n)) { // map에 nums 요소가 없는 경우에 key를 추가
            map.put(n, 0); // value는 0으로 초기화한다.
        }
        int c = map.get(n);
        if (c < 2) { // 요소의 갯수가 2 미만인 경우 nums에 값을 새로 입력한다.
            map.replace(n, c + 1);
            nums[i++] = n;
        }
    }
    return i;
}
```

이전 [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) 문제를 통해 불필요한 nums 반복을 이번 문제에선 개선 하였고 풀이에 통과 하였다. 하지만 map을 활용한 부분에서 역시나 동작 시간이 다른 풀이들에 비해서 느리다.  
이런 컬렉션을 사용하기보단 기본 문법의 동작을 통한 접근이 효율적인 것 같다.

```java
...
for (int i = 2; i < n; i++) {
    if (nums[i] != nums[k - 2]) {
        nums[k] = nums[i];
        k++;
    }
}
...
```
위와 같이 다른 풀이 코드의 일부분에서 기본적인 문법으로 문제를 해결하고 더 나은 성능을 보였다.


