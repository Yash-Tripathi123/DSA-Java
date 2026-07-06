class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean vis[] = new boolean[n];
        int provinces = 0;
        for(int i=0; i<n; i++){
        if(!vis[i]){
            provinces++;
            dfs(i, isConnected, vis);
        }
    }
        return provinces;
}

        private void dfs(int city, int[][] isConnected, boolean vis[]) {
            vis[city] = true;

            for(int j=0; j<isConnected.length; j++){
                if(isConnected[city][j]==1 && !vis[j]){
                    dfs(j, isConnected, vis);
                    
                }
            }
        }
}