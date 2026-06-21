class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        boolean[][] vis = new boolean[n][n];
        //define a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{grid[0][0],0,0});
        vis[0][0] = true;
        int result = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int t = curr[0];
            int r = curr[1];
            int c = curr[2];
            result = Math.max(result, t);
            if(r==n-1 && c==n-1) return result;
            for(int[] d: dirs){
                int nr = r+d[0], nc= c+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && !vis[nr][nc]){
                    vis[nr][nc]=true;
                    pq.add(new int[]{grid[nr][nc],nr,nc});
                }
            }
        }
        return result;
    }
}