class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {

        int[] arr = new int[2];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    arr[0]++;
                    break;
                }
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {

                if (nums2[i] == nums1[j]) {
                    arr[1]++;
                    break;
                }
            }
        }

        return arr;
    }
}