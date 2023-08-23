[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150)

이 문제는 오름차순으로 정렬된 두 개의 정수형 배열을 병합하는 문제이다. 문제의 예시 중 하나는 다음과 같다.

**Example 1:**

<pre><strong>Input:</strong> nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
<strong>Output:</strong> [1,2,2,3,5,6]
<strong>Explanation:</strong> The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [<u>1</u>,<u>2</u>,2,<u>3</u>,5,6] with the underlined elements coming from nums1.</pre>

위 예시처럼 nums1 배열에 nums2 배열을 병합하고 오름차순 정렬을 하면 되는 것이다.

```java
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // merge
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        // sort
        Arrays.sort(nums1);
    }
```

따라서 주어진 nums1배열에 nums2의 요소를 채워준 다음 이를 다시 정렬해주었고 문제는 어렵지 않게 통과했으나, 개선이 필요한 부분이 눈에 보였다.
우선 병합을 하는 과정의 코드를 다음과 같이 개선할 수 있었다.

```java
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // merge - nums1의 m번째 인덱스부터 n개 만큼 nums2의 0번째 인덱스에서 복사
        System.arraycopy(nums2, 0, nums1, m, n);

        // sort
        Arrays.sort(nums1);
    }
```

하지만 성능적으로는 개선이 됐다고 할 수는 없었다. 그렇다면 성능 개선이 필요한 부분은 어디일까? 내 생각에는 현재 병합과 정렬을 하는 과정이 나누어 동작하는 것이 불필요한 부분이 포함된 것 같았다.

특히 `Arrays.sort(nums1);`에서 다시 재정렬을 하는 과정을 없애는 것이 주요해 보였다. 문제에서 전달하는 배열들은 이미 정렬이 된 상태이기 때문이다.

따라서 병합할 배열을 새로 정의한 후 해당 배열에 nums1, nums2의 값을 비교하여 전체 요소를 순회하는 것은 한번에 처리하기로 하였다.

```java
    // 성능 개선 코드
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n]; // nums1 과 같은 크기의 병합용 배열 생성
        int i = 0; // result 요소 인덱스
        int j = 0; // nums1 요소 인덱스
        int k = 0; // nums2 요소 인덱스
        while (i < result.length) {
            if (j < m && k < n) {
                if (nums1[j] <= nums2[k]) {
                    result[i] = nums1[j];
                    j++;
                } else {
                    result[i] = nums2[k];
                    k++;
                }
            } else if (j < m) {
                result[i] = nums1[j];
                j++;
            } else if (k < n) {
                result[i] = nums2[k];
                k++;
            }
            i++;
        }

        // 병합한 결과 배열 요소를 nums1으로 이동
        System.arraycopy(result, 0, nums1, 0, nums1.length);
    }
```

위 코드를 통해 메모리 사용량은 확인이 되지 않았으나 Runtime 속도는 개선되었다. 아무래도 메모리 사용량을 개선하려면 새로운 배열 생성을 하기 보단 nums1 그대로 사용해 개선하는 것이 필요해 보였는데 배열을 0번째 인덱스 부터 순차적으로 접근하며 값을 오름차순으로 병합하는 경우 코드가 매우 복잡했었다. 그러다 다른 사람의 풀이를 통해 좋은 아이디어를 얻었는데 내가 원하는 방식으로 문제를 해결한 코드였다.

```java
    // 성능 개선 코드 - 다른 사람 풀이
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
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
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--; k--;
        }
    }
```

계속 0번째 인덱스 접근으로만 생각했었는데 반대로 마지막 인덱스 부터 접근하면 nums1의 경우 nums2를 병합해야 할 공간으로 '0'이 채워져 있고 이 때문에 순차적인 접근에서 따로 보관해야 할 저장소의 필요성이 없이 마지막 인덱스의 요소들끼리 비교하여 채워나가면 자연스럽게 nums1에 병합할 수 있었다.
