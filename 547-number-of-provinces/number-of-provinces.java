class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int j=0;j<n;j++){
            if(!visited[j]){
                Queue<Integer> q = new LinkedList<>();
        // int source = 1;
        q.offer(j);
        visited[j] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei=0;nei<n;nei++){
                if(!visited[nei] && isConnected[curr][nei]==1){
                    q.offer(nei);
                    visited[nei] = true;
                }
            }
        }
        count++;
            }
        }
        return count;
    }
}