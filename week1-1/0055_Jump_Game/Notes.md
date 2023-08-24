[55. Jump Game](https://leetcode.com/problems/jump-game/)

주어진 배열의 요소의 값만큼 인덱스를 이동하여 마지막 인덱스에 도착하는 경우의 유무를 찾는 문제다.

```
Input: nums = [2,3,1,1,4]
```

예를 들어 위 nums의 0번째 값 2는 1번 또는 2번 인덱스로 점프할 수 있다. 따라서 0번째에서 이동할 수 있는 `경우의 수`는 2가지다.

여기서 `경우의 수`가 매우 중요하다고 보았다.

이 경우의 수들 중 최적의 경로로 마지막 인덱스에 도착할 수 있는지를 찾는 게 이 문제의 핵심이다.

모든 경우의 수를 찾아도 마지막 인덱스에 도달하지 못하면 정답은 false다.

이 문제를 해결하기 위해서 사용한 DFS(깊이 우선 탐색) 알고리즘을 사용했다. 최종적으로 nums의 마지막 인덱스(가장 깊은 노드)에 도달하는 경우를 찾아야 하기 떄문이다.


이를 위해 방문 했던 곳을 재방문하는 것을 방지하기 위한 `boolean[] visited`와 반복적인 탐색을 위한 재귀적인 함수 동작을 구현하여 코드를 작성했다.

```java
class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true; // nums의 길이가 1인 경우에는 출발지와 도착지가 동일하기 때문에 true 반환
        boolean[] visited = new boolean[nums.length]; // 중복 탐색을 방지
        visited[0] = true; // 출발지 방문 체크
        return jump(visited, nums, 0); // 출발 지점은 0번째로 고정
    }

    private boolean jump(boolean[] visited, int[] nums, int i) {
        boolean result = false;
        for (int j = 1; j <= nums[i]; j++) {
            if (i + j < visited.length && !visited[i + j]) {
                visited[i + j] = true;
                if (i + j == nums.length - 1) { // i + j 가 마지막 인덱스인 경우
                    result = true;
                }
                if (result) break;
                result = jump(visited, nums, i + j);
            }
        }
        return result;
    }
}
```

문제 풀이에 통과는 했지만 DFS로 접근할 것인지 BFS를 사용할 것인지 아니면 다른 접근방식이 더 효율적인 측면이 있을지 확인해 볼 필요성을 느낀다.

우선 BFS 보단 DFS 방식을 선택한건 문제에서 요구하는건 가장 마지막 인덱스에 접근해야 하기 떄문에 깊이 우선이 더 알맞다고 생각했다. 물론 상황에 따라 BFS가 더 빠른 경우도 있을 것이다. 그리고 경우의 수 중 중복을 체크해야하기 때문에 탐색 알고리즘이 대체적으로는 알맞아 보인다.

하지만 다음과 같은 풀이 코드를 보았다.

```java
    // Runtime = 4ms
    public boolean canJump(int[] nums) {
        int i = 0;

        if (nums.length == 4 && nums[1] == 5)
            return true;

        if (nums.length == 7 && nums[2] == 8 && nums[3] == 2)
            return true;
        if (nums.length == 10 && nums[2] == 1 && nums[3] == 2 && nums[4] == 5)
            return true;
        if (nums.length == 7 && nums[2] == 2 && nums[3] == 2)
            return true;
        if (nums.length == 5 && nums[2] == 0 && nums[3] == 1)
            return true;
        if (nums.length == 12 && nums[2] == 3 && nums[3] == 2)
            return true;
        if (nums.length > 20 && nums[2] == 4 && nums[3] == 4)
            return true;
        if (nums.length > 20 && nums[0] == 5 && nums[1] == 1 && nums[2] == 4)
            return false;
        if (nums.length > 20 && nums[2] == 4 && nums[3] == 5)
            return true;
        if (nums.length > 20 && nums[2] == 1 && nums[3] == 5)
            return true;
        if (nums.length > 20 && nums[2] == 2 && nums[3] == 2)
            return true;
        if (nums.length > 20 && nums[0] == 3 && nums[3] == 1)
            return true;
        if (nums.length > 20 && nums[0] == 1 && nums[5] == 1 && nums[nums.length - 2] == 0)
            return false;
        if (nums.length > 20 && nums[0] == 1 && nums[1] == 1 && nums[2] == 1)
            return true;
        if (nums.length > 20 && nums[0] == 1 && nums[1] == 1 && nums[2] == 1)
            return true;
        if (nums.length > 20 && nums[8] == 1000)
            return true;
        if (nums.length == 6 && nums[3] == 1)
            return true;
        if (nums.length == 5 && nums[3] == 0 && nums[0] == 3 && nums[1] == 2 && nums[4] == 1)
            return true;

        if (nums.length == 1)
            return true;

        while (true) {
            i = i + nums[i];

            if (i >= nums.length - 1) {
                return true;
            }

            if (nums[i] == 0)
                return false;


        }
    }
```

내 코드의 Runtime은 780ms 였지만 이건 4ms로 기록이 되어있다. 내가 작성한 코드의 풀이 또한 결국 해당 문제를 통과 했기 때문에 정답이지만 이 정도의 차이가 있다면 이 코드가 더 나은 정답이라 생각이 든다.
