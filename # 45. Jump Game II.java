public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int maxCover = 0, lastCover = 0, steps = 0;
        
        for(int i = 0; i < nums.length && i <= maxCover; i++){
            if(i > lastCover){
                steps++;
                lastCover = maxCover;
            }
            if(i + nums[i] > maxCover)
                maxCover = i + nums[i];
        }
        
        if(maxCover >= nums.length - 1)                
            return steps;
        return 0;
    }
}