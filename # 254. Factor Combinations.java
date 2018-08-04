public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        backtracking(2, n, temp, res);
        return res;
        
     }
     
     private void backtracking(int pre, int left, List<Integer> temp, List<List<Integer>> res) {
         if (left == 1 && temp.size() > 1) {
             res.add(new ArrayList<Integer>(temp));
         }
         for(int i = pre; i <= left; i++) {
             if (left % i == 0) {
                 temp.add(i);
                 backtracking(i, left / i, temp, res);
                 temp.remove(temp.size() - 1);
             }
         }
     } 
}