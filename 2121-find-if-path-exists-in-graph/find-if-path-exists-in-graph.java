class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> seen = new HashSet<>();

        //building adjacency list
        for(int[] edge: edges){
            int u = edge[0], v= edge[1];
            graph.computeIfAbsent(u, k-> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k-> new ArrayList<>()).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        seen.add(source);
        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination) return true;

            for(int nei : graph.getOrDefault(node, new ArrayList<>())){
                if(!seen.contains(nei)){
                    seen.add(nei);
                    q.add(nei);
                }
            }
        }
        return false;
    }
}


