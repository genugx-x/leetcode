public class SearchInsertPosition {

    public static void main(String[] args) {
        int answer1 = searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(answer1);
        int answer2 = searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(answer2);
        int answer3 = searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(answer3);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
