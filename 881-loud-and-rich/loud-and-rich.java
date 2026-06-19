class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] rich: richer){
            adj.get(rich[0]).add(rich[1]);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int x = adj.get(i).get(j);
                indegree[x]++;
            }
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = i;
        }

        //BFS
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);

        }
        int[] toposort = new int[n];
        while(!q.isEmpty()){
            int val = q.poll();
            for(int node : adj.get(val)){
                if(quiet[ans[val]] < quiet[ans[node]]){
                    ans[node] = ans[val];
                }
                indegree[node] --;
                if(indegree[node] ==0){
                    q.offer(node);
                }
            }
        }
        return ans;
    }
}