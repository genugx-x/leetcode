
[27. Remove Element](https://leetcode.com/problems/remove-element/)

배열의 요소를 제거하는 문제로 주어진 배열에 요소를 제거 하면 된다.

위 문제 링크에 제시된 예제 중 하나는 다음과 같다.

**Example 2:**

<pre><strong>Input:</strong> nums = [0,1,2,2,3,0,4,2], val = 2
<strong>Output:</strong> 5, nums = [0,1,4,0,3,_,_,_]
<strong>Explanation:</strong> Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
</pre>

intput 으로는 nums 배열과 제거할 요소로 val 변수를 입력 받는다.

위 예제와 같이 제공된 `val = 2`를 배열을 탐색하며 제거한 후 Output 으로 동작 후 남겨진 요소의 수를 반환하면 되었다.

하지만 요소만 제거한 상태의 새로운 배열을 반환하는 것이 아니라 `nums = [0,1,4,0,3,_,_,_]`와 같이 남은 요소는 0번째 인덱스부터 채워넣어줘야 하기 때문에 다른 문제풀이 사이트의 비슷 문제에 비해 조금은 더 생각하고 접근해 봐야했다.

우선 요소를 제거한 상태를 기록할 nums와 같은 길이의 배열 `int[] result`를 만들고 이곳에 nums를 반복문으로 탐색하며 val의 값과 다른 요소들만 순차적으로 채워준 후 nums로 복사하는 방식으로 구현하였다.

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length]; // 제거 대상이 아닌 요소로 채워질 결과 배열
        int j = 0; // result에 요소를 입력할 떄 쓰일 인덱스
        int k = 0; // return 시 남은 요소의 수
        for (int i = 0; i < result.length; i++) {
            if (nums[i] != val) { // nums[i] 값이 val과 다른 경우에만 result에 요소를 입력
                result[j] = nums[i]; 
                j++; 
                k++;
            }
        }

        // nums로 값 복사
        System.arraycopy(result, 0, nums, 0, nums.length);
        return k;
    }
}
```

문제 풀이에 통과는 했지만 아쉬운 부분들이 보인다. nums 내부에서 요소를 제거함과 동시에 남은 요소를 앞쪽의 인덱스로 옮기는 작업을 위해 result라는 배열을 사용하였는데 비효율적이라고 생각된다.

그렇다면 어떻게 nums 내부 배열 순회를 하면 좋을까 싶어 다른 풀이를 참고해 보았고 과정은 다음과 같다.

```java
int[] nums = [0, 1, 2, 2, 3, 0, 4, 2];
int val = 2;
```

위와 같은 예시가 주어졌으면 우선 nums의 처음과 마지막 인덱스를 지정할 변수 i, j를 정의한 후 다음과 같이 동작을 수행한다.

<img width="1702" alt="스크린샷 2023-08-24 오후 9 00 47" src="https://github.com/genugx-x/leetcode/assets/54730922/0d9a4159-4cdb-48ea-8cec-0f733a477c48">

0번째 인덱스부터 접근하는 변수 i와 마지막 인덱스부터 접근하는 변수 j는 각 인덱스의 요소가 val과 같은지 다른지 비교하는데
`j`의 요소가 `val`과 같다면 `j - 1` 인덱스로 이동하고 `i` 인덱스는 `val`과 다른 경우 다음 인덱스로 이동한다.

<img width="1711" alt="스크린샷 2023-08-24 오후 9 08 21" src="https://github.com/genugx-x/leetcode/assets/54730922/9e90d3a3-242f-4415-ab31-bb195a4c6020">

그러다 `i`의 요소가 val과 같은 경우 `j`는 현재 val과 다른 요소를 가지고 있기 때문에 교환해 준다. 그리고 다시 각 변수를 다음 위치로 이동한다.
이와 같은 과정으로 반복한다.

<img width="1712" alt="스크린샷 2023-08-24 오후 9 11 39" src="https://github.com/genugx-x/leetcode/assets/54730922/b5b37311-e08c-4e50-966c-00541a7befe9">

최종적으로는 `result` 부분과 같은 결과를 얻게 된다. 코드의 가독성은 떨어질 수 밖에 없지만 내 풀이 코드와 같이 불필요한 자원 낭비는 하지 않고 주어진 배열 안에서 해결 가능 하여 효율적인 동작을 하였다.


