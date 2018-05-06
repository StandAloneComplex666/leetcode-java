class solution{
	List<int[]> result = new Arraylist<>();
	public List<int[]> pacificAtlantic(int[][] matrix){
		if (matrix.length == 0 || matrix[0].length == 0){
			return result;
		}
		char[][] visited = new char[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++){
			dfs(matrix, 0, i, visited, 'P');
		}
		for (int i = 0; i < matrix.length; i++) {           
                dfs (matrix, i, 0, visited,'P');           
        }
        for (int i = 0; i < matrix[0].length; i++) {           
                dfs (matrix, matrix.length - 1, i, visited,'A');          
        }
        for (int i = 0; i < matrix.length; i++) {            
                dfs (matrix, i, matrix[0].length - 1, visited, 'A');           
        }
        return result;
	} 
	public void dfs(int[][] matrix, int i, int j, char[][] visited, char o){
		if( i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length){
			return;
		}
		if(o == 'A' && visited[i][j] = 'P'){
			result.add(new int[]{i,j});
		}
		if (visited[i][j] == o){
			return;
		}
		visited[i][j] = o;
		if (i+1 < matrix.length && matrix[i][j] <= matrix[i+1][j]){
			dfs (matrix, i+1, j, visited, o);
		}
		if (i-1 >= 0 && matrix[i][j] <= matrix[i-1][j]){
			dfs (matrix, i-1, j, visited, o);
		}
		if (j+1 <matrix[0].length && matrix[i][j] <= matrix[i][j+1]){
			dfs (matrix, i, j+1, visited, o);
		}
		if (j-1 >=0 && matrix[i][j] < matrix[i][j-1] ){
			dfs (matrix, i, j-1, visited, o);
		}
	}
}
