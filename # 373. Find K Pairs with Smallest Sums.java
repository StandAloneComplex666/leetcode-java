// a naive solution
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a,int[] b) -> (b[0] + b[1]) - (a[0] + a[1]));
        
        for (int num1 : nums1){
            for (int num2 : nums2){
                pq.offer(new int[]{num1, num2});
                if (pq.size() > k)
                    pq.poll();
            }
        }
        
        while (pq.size() > 0)
            result.add(0, pq.poll());
        
        return result;
    }
}