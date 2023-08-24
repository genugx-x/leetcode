[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

오름차순으로 정렬된 정수 배열의 중복 요소를 제거하는 문제였다.
따라서 요소를 저장할 때 중복되지 않는 요소만 저장하는 Set을 사용하였고 다음과 같은 과정으로 코드 계획을 세웠다.

```java
    1. Set 정의 및 생성
    2. nums 값을 순회하며 Set에 추가
    3. Set을 순회하며 nums에 값을 새로 입력
    4. nums에 중복 제거후 잔여 공간은 0으로 입력
```

위의 계획대로 다음과 같이 코드를 작성하여 문제를 통과하였다.

```java
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = 0;
        for (Integer num : set) {
            nums[i++] = num;
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
        return set.size();
    }
```

하지만 내 코드는 Runtime 시간이 꽤 느린 것으로 나왔다.
아무래도 Set을 사용하기 위해 nums 순회를 한번 더 한 것에서 차이가 발생한 것으로 보인다.
그래서 nums를 한번만 순회하는 코드로 변경해보았다.

nums의 요소와 이전 요소를 비교하며 값이 같지 않은 경우 별도로 지정한 인덱스에 값을 넣는 방식을 계획했다.

```java
int k = 1; // nums에 값을 입력 할 인덱스 - 1번 인덱스부터 중복되지 않는 인덱스를 입력하기 때문에 1로 시작
for (1부터 nums만큼 반복) { 
    if (현재 요소의 값과 이전 요소의 값이 다른 경우) {
        nums[k] = nums[현재 요소의 인덱스];
        k++; 
    }
}
```

이렇게 코드를 작성하게 되면 이전의 방식처럼 불필요한 동작을 크게 줄여 소요시간을 단축할 수 있을 것이다. 이 계획대로 코드를 다음과 같이 작성하고 풀이에 통과 하였다.

```java
public int removeDuplicates(int[] nums) {
    int k = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[k++] = nums[i];
        }
    }
    return k;
}
```

처음 풀이에 통과한 코드는 약 5ms 소요시간이 걸린 것에 비해 위 코드는 1ms 뿐이 소요되지 않는 것을 확인할 수 있었다.
다음으로는 다른 풀이 코드를 확인 하는 중에 Set을 사용한 코드가 눈에 보여 가져왔다.

```java
public int removeDuplicates(int[] nums) {
    HashSet<Integer> set=new HashSet<>();
    int count=0;
    for(int i=0;i<nums.length;i++){
        if(!set.contains(nums[i])){
            set.add(nums[i]);
            nums[count++]=nums[i];
        }
    }
    return set.size();
}
```

이 풀이는 나와 같이 Set을 사용했지만 나보다 더 효율적으로 활용했다. nums를 반복문을 통해 접근하면서 Set에 없는 요소, 즉 중복되는 값이 없을 때 nums에 값을 입력 하여 nums를 한번만 순회하며 중복제거와 동시에 요소를 재배치 하였다.
