[169. Majority Element](https://leetcode.com/problems/majority-element/)

주어진 배열에서 더 많은 요소의 값을 반환하는 문제로 Map을 활용하는 것이 적절해 보였다.

그 이유는 값에 따라 배열에 존재하는 개수를 기록하기에는 Key, Value를 사용하는 Map을 활용하고 결과를 집계하기 용이한 Stream을 사용하는 것이 코드의 가독성에도 나아 
보였다.

우선 nums를 반복문을 통해 요소에 접근하여 `Map<요소의 값, 값의 개수>`에 저장하면 이후는 문제에서 요구하는 답을 찾아 가져오기만 하면 된다.
Map의 Value에 값의 개수를 기록했기 때문에 가장 큰 Value의 Key를 반환하면 끝이다.

풀이를 통과한 코드는 다음과 같다.

```java
public int majorityElement(int[] nums) {
    // Map<요소의 값, 값의 개수>
    Map<Integer, Integer> map = new HashMap<>();
    
    // Map에 nums 요소의 값과 개수를 기록
    for (int num : nums) {
        if (!map.containsKey(num)) {
            map.put(num, 0);
        }
        map.replace(num, map.get(num) + 1);
    }
    
    // 개수가 가장 많은 요소의 값을 반환
    return map.entrySet()
            .stream()
            .max(Comparator.comparing(Map.Entry::getValue))
            .get()
            .getKey();
}
```
내가 풀이한 코드의 경우 값의 종류가 2개가 아닌 더 많은 경우에 적절해 보였고 이 문제에 가장 심플하게 접근한 풀이를 찾았다.
```java
public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    return nums[n/2];
}
```
정말 간단하게도 nums를 정렬한 후 n/2의 요소값을 반환한다. 이 코드를 보면서 문제를 조금 더 어렵게 접근하지 않았나라는 생각이 든다.






