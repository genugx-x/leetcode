[189. Rotate Array](https://leetcode.com/problems/rotate-array/)

이 문제는 주어진 nums 정수 배열과 이 배열의 요소 이동의 횟수 k를 사용해 배열의 요소를 회전 시켜주면 된다.

처음엔 너무 간단히 풀이를 진행 했다가 실패를 맛봤다.


문제의 요지는 위에서 설명한 것처럼 주어진 배열의 요소를 k만큼 이동시켜 주면 되는데 모든 배열의 요소를 1씩 이동시켰다가는 시간 제한으로 실패를 하게 된다.
아래는 실패한 코드다.
```java
// 실패: Time Limit Exceeded 
public void rotate(int[] nums, int k) {
    while (k-- > 0) {
        int n = nums[0];
        for (int j = 1; j < nums.length; j++) {
            int t = nums[j];
            nums[j] = n;
            n = t;
        }
        nums[0] = n;
    }
}
```

k 만큼 nums의 요소를 반복하면서 요소를 이동시켜 주었는데 정답은 맞지만 성능에서 실패하게 된다. 그래서 위 방식과는 달리 미리 하나의 요소를 k만큼 이동시킨 이후 해당 요소를 기준으로 나머지를 그대로 배열에 복사하는 방식으로 바뀌었다.
이렇게 되면 위의 방식처럼 하나하나 반복할 필요 없이 과정을 크게 단축시킬 수 있다.

1. nums의 요소를 회전시켜야하기 때문에 이를 위해 배열을 복제한다.
2. nums.length가 k보다 작은 경우에는 배열의 인덱스를 넘어가는 상황으로 % 연산을 사용해 배열의 길이 내로 k 값을 다시 계산한다.
3. 복제한 배열의 0번째 인덱스 요소부터 `nums[k] ~ nums[nums.length - k]`에 해당 길이만큼 복사한다.
4. 나머지 복사가 되지 않은 부분 `nums[0] ~ nums[k]`를 복사한다.

다음은 작성된 코드다.

```java
// Runtime: 0ms
public void rotate(int[] nums, int k) {
    int[] numsClone = nums.clone(); // 1
    if (nums.length < k) { // 2
        k = k % nums.length;
    }
    System.arraycopy(numsClone, 0, nums, k, nums.length - k); // 3
    System.arraycopy(numsClone, nums.length - k, nums, 0, k); // 4
}
```

k의 값을 통해 미리 이동된 인덱스를 파악하면 나머지는 배열의 값을 잘 넣어주기만 하면 간단하게 해결될 수 있었다.  
위 코드로 해결하기 이전에 작성한 코드는 다음과 같은데 이것은 for문을 사용해 요소의 값을 이동시켜주었고 정답이었지만 반복문으로 접근한 부분에서 Runtime이 매우 뒤처졌다.

```java
// Runtime: 2ms
public void rotate(int[] nums, int k) {
    int[] numsClone = nums.clone();
    for (int i = 0; i < numsClone.length; i++) {
        int n = i + k;
        if (n < nums.length) {
            nums[n] = numsClone[i];
        } else {
            nums[n % nums.length] = numsClone[i];
        }
    }
}
```
Java에 포함된 System.arraycopy() 성능이 일반 반복문보다 성능이 효율적인지는 더 확인해 봐야겠으나 배열의 일정 토막 부분을 복사하는 것에 있어서는 활용성이 높아 보인다. 


