class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<List<Integer>>();
        int[] numbers = new int[]{1,2,3,4,5,6,7,8,9};
        helper(numbers, k, n, 0,new ArrayList<>(), 0);
        return result;
    }
    private void helper(int[] numbers, int k, int target, int index, List<Integer> list, int counter){
        if (counter > k) return;
        if (target == 0){
            if (counter == k) result.add(new ArrayList<>(list));
            return;    
        }
        for (int i = index; i < numbers.length;i++ ){
            if (target < numbers[i]) break;
            list.add(numbers[i]);
            helper(numbers, k, target - numbers[i], i+1, list, counter+1);
            //here if I choose index + 1 instead of i + 1, I will get the answer of duplicate numbers like(1,3,3),(2,2,3)
            list.remove(list.size() - 1);
        }
    }
}