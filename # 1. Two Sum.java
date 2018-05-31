class Solution {
    public int[] twoSum(int[] nums, int target) {
        int x = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int index = 0;
        int results[] = new int[2];
        
        for (int i=0;i<nums.length;i++){
            //System.out.println(nums[i]);
            x = target - nums[i];
            //System.out.println(x);
            if (!hm.containsKey(x)){
                //System.out.println(hm.containsKey(x));
                hm.put(nums[i], index);
                index++;
            }
            else{
                results[0] = hm.get(x);
                results[1] = index;
                return results;
            }
        }
        return results;
    }
}