class Solution {

    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int median = findKth(nums.clone(), (n + 1) / 2);

        int left = 0;
        int i = 0;
        int right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i, n)] > median) {

                swap(nums,
                        newIndex(left++, n),
                        newIndex(i++, n));

            } else if (nums[newIndex(i, n)] < median) {

                swap(nums,
                        newIndex(right--, n),
                        newIndex(i, n));

            } else {

                i++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int findKth(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        k = nums.length - k;

        while (left <= right) {
            int pivot = partition(nums, left, right);

            if (pivot == k)
                return nums[pivot];
            else if (pivot < k)
                left = pivot + 1;
            else
                right = pivot - 1;
        }

        return -1;
    }

    private int partition(int[] nums, int left, int right) {

        int pivot = nums[right];

        int i = left;

        for (int j = left; j < right; j++) {

            if (nums[j] <= pivot) {

                swap(nums, i, j);

                i++;
            }
        }

        swap(nums, i, right);

        return i;
    }
}