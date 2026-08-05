class Solution {
    public boolean check(int[] arr) {
       int drop = 0;
        for(int i = 0; i<arr.length-1; i++)
        {
            if(arr[i]>arr[i+1])
            {
                drop++;
            }
            
        }
        if(arr[arr.length-1]>arr[0])
        {
            drop++;
        }
        
        return drop<=1; 
    }
}