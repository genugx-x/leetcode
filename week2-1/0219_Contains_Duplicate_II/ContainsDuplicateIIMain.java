public class ContainsDuplicateIIMain {
    public static void main(String[] args) {
        ContainsDuplicateII solution = new ContainsDuplicateII();
        System.out.println(solution.containsNearbyDuplicate2(new int[]{1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate2(new int[]{1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate2(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(solution.containsNearbyDuplicate2(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3}, 2));
    }
}
