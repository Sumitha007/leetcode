class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] list = new int[nums.length-k+1];
        int left = 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(!deque.isEmpty() && deque.peekFirst()<i-k+1)
            {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <nums[i])
            {
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1)
            {
                list[left++] = nums[deque.peekFirst()];
            }
        }
        return list;

    }
}