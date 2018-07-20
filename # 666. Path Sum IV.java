class Solution {
public int pathSum(int[] nums) {
        Arrays.sort(nums);
        int[][] leaves = new int[5][9];
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int d = nums[i] / 100;
            int l = nums[i] / 10 % 10;
            if (leaves[d][l] == 0) leaves[d][l] = 1;
            leaves[d - 1][(l + 1) / 2] += leaves[d][l];
            res +=  (nums[i] % 10) * leaves[d][l];
        }
        return res;
    }
}