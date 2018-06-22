class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums.length<3) return 0;
        Arrays.sort(nums);

        int res = 0;
        for(int i = 0;i<nums.length-2;i ++) {
            int k = nums.length-1;
            for(int j = i+1;j<nums.length;j++) {
                int sum = nums[i]+nums[j];
                while(k > j && nums[k]+sum >= target) {
                    k--;
                }
                if(k <= j) break;
                res+=k-j;
            }
            
        }
        return res;
    }    
}