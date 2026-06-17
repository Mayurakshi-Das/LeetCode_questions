class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int n = rows*cols;
        //make adjacency matrix
        List<List<int[]>> adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());

            }
            //define directions
            int[][] dirs ={{1,0},{0,1},{-1,0},{0,-1}};
            for(int r=0;r<rows;r++){
                for(int c=0;c<cols;c++){
                    int node = r*cols+c;
                    for(int[]dir:dirs){
                        int nr = r +dir[0];
                        int nc = c + dir[1];
                        if(nr >=0 && nr< rows && nc >=0 && nc<cols){
                            int neigh = nr *cols+nc;
                            int weight = Math.abs(heights[r][c] - heights[nr][nc]);
                            adj.get(node).add(new int[]{neigh, weight});
                        }
                    }
                }
            }
            //performing dijkstra
            int[] effort = new int[n];
            Arrays.fill(effort, Integer.MAX_VALUE);
            effort[0] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
            boolean[] visited = new boolean[n];
            while(!pq.isEmpty()){
                int[] curr = pq.poll();
                int node = curr[0];
                int currEffort = curr[1];

                if(node == n-1) return currEffort;
                if(visited[node]) continue;
                visited[node]=true;
                for (int[] edge : adj.get(node)) {
                int neigh = edge[0];
                int weight = edge[1];
                int newEffort = Math.max(currEffort, weight);
                if (newEffort < effort[neigh]) {
                    effort[neigh] = newEffort;
                    pq.offer(new int[]{neigh, newEffort});
                }
            }
            }
            return 0;
    }
}