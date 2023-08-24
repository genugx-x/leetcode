public class JumpGame {

    // 0번 인덱스 출발
    // 마지막 인덱스에 도달 가능한지 여부가 정답
    // 각각의 요소는 최대 뛸 수 있는 거리, 예를 들어 4라면 1~4칸을 점프할 수 있다는 의미
    // 2,3,1,1,4 - true
    // 3,2,1,0,4 - false
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        return jump(visited, nums, 0);
    }

    private boolean jump(boolean[] visited, int[] nums, int i) {
        boolean result = false;
        for (int j = 1; j <= nums[i]; j++) {
            if (i + j < visited.length && !visited[i + j]) {
                visited[i + j] = true;
                if (i + j == nums.length - 1) {
                    result = true;
                }
                if (result) break;
                result = jump(visited, nums, i + j);
            }
        }
        return result;
    }
}
