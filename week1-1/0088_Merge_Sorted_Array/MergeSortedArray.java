public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--; k--;
            }
            else {
                nums1[k] = nums2[j];
                j--; k--;
            }
        }
        while(j >= 0){
            nums1[k] = nums2[j];
            j--; k--;
        }
    }

    // 성능 개선 코드
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] result = new int[m + n]; // nums1 과 같은 크기의 병합용 배열 생성
//        int i = 0; // result 요소 인덱스
//        int j = 0; // nums1 요소 인덱스
//        int k = 0; // nums2 요소 인덱스
//        while (i < result.length) {
//            if (j < m && k < n) {
//                if (nums1[j] <= nums2[k]) {
//                    result[i] = nums1[j];
//                    j++;
//                } else {
//                    result[i] = nums2[k];
//                    k++;
//                }
//            } else if (j < m) {
//                result[i] = nums1[j];
//                j++;
//            } else if (k < n) {
//                result[i] = nums2[k];
//                k++;
//            }
//            i++;
//        }
//
//        // 병합한 결과 배열 요소를 nums1로 이동
//        System.arraycopy(result, 0, nums1, 0, nums1.length);
//    }

    // 풀이 코드 개선 : 코드에서 병합 과정을 arryycopy 메서드를 사용한 코드
    /*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1의 m번째 인덱스 부터 n개 만큼 nums2 요소를 복사
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }*/

    // 풀이 : for 문을 사용한 병합 후, 재정렬
    /*
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
     */
}
