import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for(int[] pre : prerequisites){
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
            indegree[a]++;
        }

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;

        // BFS (Kahn’s Algorithm)
        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }
}