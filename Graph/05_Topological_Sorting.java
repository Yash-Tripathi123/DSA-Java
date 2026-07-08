class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
         
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        //created Adjecency list 01
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        //fill adjecency matrix
        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);  // u->v
        }
        // create indegree
        int indegree[] = new int[V];
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        // queue for indegree 0
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        //apply bfs
          ArrayList<Integer> topo = new ArrayList<>();

         while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;

                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
           return topo;
    }
}