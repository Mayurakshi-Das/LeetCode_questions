class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low =0;
        int high = n-1;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[n-1]) low = mid+1;
            else high = mid;
        }
        int rotate = low;
        low=0; high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int real = (mid+rotate)%n;
            if(nums[real]==target) return real;
            if(nums[real]<target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}