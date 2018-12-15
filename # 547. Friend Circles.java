/*
Step 1 : Build graph.
Step 2: Create visited nodes array
Step 3 : Iterate visited array and Engage DFS to mark visited
Step 3.5 : If visited array has been marked true already, friend is already part of circle. else it's a new circle.
Step 4 : return circle
*/

class Solution {
    public int findCircleNum(int[][] M) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < M.length; i++){ // Step 1
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1){
                    if(!graph.containsKey(i)) graph.put(i, new ArrayList<>());
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[M.length]; // Step 2
        int circles = 0;
        for(int i = 0; i<visited.length; i++){ //Step 3
            if(visited[i]){ //Step 3.5
                continue;
            } else{
                circles++;
                dfs(graph, i, visited);
            }
        }
        return circles; //Step 4
    }
    private void dfs(HashMap<Integer, List<Integer>> graph, int student, boolean[] visited){
        if(visited[student]) return;
        visited[student] = true;
        for(int friend : graph.get(student)){
            dfs(graph, friend, visited);
        }
    }
}

// union find solution, much faster than the first dfs version:
class Solution {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind(M.length);
        for(int i = 0; i < M.length; ++i) {
            for(int j = i + 1; j < M.length; ++j) {
                if(M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        
        return uf.count;
    }
    
    class UnionFind {
        int[] parent;
        int count;
        public UnionFind(int capacity) {
            this.parent = new int[capacity];
            for(int i = 0; i < capacity; ++i) {
                parent[i] = i;
            }
            
            this.count = capacity;
        }
        
        public int find(int p) {
            while(p != parent[p]) {
                p = parent[p];
            }
            
            return p;
        }
        
        public void union(int p, int q) {
            int pp  = find(p);
            int pq = find(q);
            if(pp != pq) {
                int min = Math.min(pp, pq);
                parent[p] = min;
                parent[q] = min;
                parent[pp] = min;
                parent[pq] = min;
                --count;
            }
        }
    }
}