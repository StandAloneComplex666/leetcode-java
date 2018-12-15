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