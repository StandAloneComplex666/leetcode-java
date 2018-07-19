class Solution {
    public int[][] imageSmoother(int[][] M) {
        int n = M.length, m = M[0].length, sum = 0, cnt = 0; 
        int[][] ans = new int[n][m];
        int[][] dir = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; 
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                sum = 0; cnt = 0; 
                for (int k = 0; k < 9; k++) {
                    if (0 <= i + dir[k][0] && i + dir[k][0] < n && 0 <= j + dir[k][1] && j + dir[k][1] < m) {
                        sum = sum + M[i + dir[k][0]][j + dir[k][1]]; 
                        cnt++;
                    }
                }                
                ans[i][j] = sum/cnt; 
            }
        
        return ans; 
    }
}