class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int [] sHash = new int[256];
        int [] tHash = new int[256];
        
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        initTargetHash(tHash,t);
        int i = 0;
        int j = 0;
        
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && !isValid(sHash, tHash)) {
                sHash[s.charAt(j)]++;
                j++;
            }
            if (isValid(sHash, tHash)) {
                if (ans > j - i) {
                    ans = Math.min(ans, j - i);
                    minStr = s.substring(i, j);
                }
            }
            sHash[s.charAt(i)]--;
        }
        return minStr;
    }
    
    
    
    boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < sourceHash.length; i++) {
            if (targetHash[i] > sourceHash[i]) {
                return false;
            }
        }
        return true;
    }

    public void initTargetHash(int[] targetHash, String target) {
        for (int i = 0; i < target.length(); i++) {
            targetHash[target.charAt(i)]++;
        }
    }   
}