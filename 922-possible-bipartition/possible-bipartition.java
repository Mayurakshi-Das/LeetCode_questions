class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] d : dislikes) {
            graph[d[0]].add(d[1]);
            graph[d[1]].add(d[0]);
        }
        int[] color = new int[n + 1];

        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {

            if (color[i] == -1) {
                if (!bfs(graph, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean bfs(List<Integer>[] graph, int[] color, int start) {

        Queue<Integer> q = new LinkedList();
        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node= q.poll();

            for (int neigh : graph[node]) {
                if (color[neigh] == -1) {
                    color[neigh] = 1 - color[node];
                    q.offer(neigh);
                } 
                else if (color[neigh] == color[node]) 
                    return false;
                
            }

        }

        return true;
    }     
}
