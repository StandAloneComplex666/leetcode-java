class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<Integer>();
        
        // sort so we can only search in one direction
        Arrays.sort(nums);
        
        // the number of numbers lower than the key that are divisors of the key
        // and also present in nums (e.g. 8 = 4 + 2 + 1 = filtered by [8, 2, 1] = 2)
        int[] counts = new int[nums.length];
        
        // "lower and divisible" number's index
        int[] subi = new int[nums.length];
        Arrays.fill(subi, -1);
        
        for (int i=0;i<nums.length-1;i++) {
            for (int j=i+1;j<nums.length;j++) {
                
                if (counts[i] + 1 > counts[j] && divides(nums[i], nums[j])) {
                    counts[j] = counts[i] + 1;
                    subi[j] = i;
                }
            }
        }
        
        // find the largest subset (count with the most smaller numbers)
        int maxc = 0;
        int maxi = 0;
        for (int i=0;i<nums.length;i++) {
            if (counts[i] > maxc) {
                maxc = counts[i];
                maxi = i;
            }
        }
        
        // jump through links to earlier indices until we get to the lowest num in theset
        List<Integer> tr = new ArrayList<>();
        int currenti = maxi;
        while (currenti >= 0) {
            tr.add(nums[currenti]);
            currenti = subi[currenti];
        }
                 
        return tr;
    }
    
    private boolean divides(int a, int b) {
        // only need one side divisibility (i.e. a % b == 0 || b % a == 0 is fine)

        // 0 will match with everything
        // 1 will match with everything
        // all others need to be big % small = 0
        
        if (a == 0 && b == 0) return false;
        if (a == 1 || b == 1 || a == 0 || b == 0) return true;
        if (a == b) return true;
        
        return Math.max(a, b) % Math.min(a, b) == 0;
    }
}