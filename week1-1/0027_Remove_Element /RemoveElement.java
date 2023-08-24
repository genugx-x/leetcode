class RemoveElement {
    public int removeElement2(int[] nums, int val) {
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

    public int removeElement(int[] nums, int val) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            if (nums[e] == val) {
                e--;
            } else {
                if (nums[s] == val) {
                    int temp = nums[e];
                    nums[e] = nums[s];
                    nums[s] = temp;
                    s++;
                    e--;
                } else {
                    s++;
                }
            }
        }
        return e + 1;
    }
}
