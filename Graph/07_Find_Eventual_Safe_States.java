class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rev.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];

        for (int u = 0; u < n; u++) {

            outdegree[u] = graph[u].length;

            for (int v : graph[u]) {
                rev.get(v).add(u);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0)
                q.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            ans.add(node);

            for (int prev : rev.get(node)) {

                outdegree[prev]--;

                if (outdegree[prev] == 0)
                    q.offer(prev);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}