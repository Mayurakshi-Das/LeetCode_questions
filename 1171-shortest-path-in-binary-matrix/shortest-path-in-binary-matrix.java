class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        if(n==1) return 1;
        int[][] dirs = {
            {-1, -1}, {-1, 0}, {-1, 1}, 
            {0, -1},          {0, 1},   
            {1, -1},  {1, 0}, {1, 1}
        };

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1], dist = curr[2];
            if(r==n-1 && c==n-1) return dist;
            for(int[] d: dirs){
                int nrow = r + d[0];
                int ncol = c + d[1];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n &&
                    grid[nrow][ncol] == 0 && !visited[nrow][ncol]) {

                    visited[nrow][ncol] = true; 
                    q.offer(new int[]{nrow, ncol, dist + 1}); 
                }
            }
        }
        return -1;
    }
}


