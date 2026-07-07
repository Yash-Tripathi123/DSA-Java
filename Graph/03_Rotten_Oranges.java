class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // Add all rotten oranges to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2)
                    q.offer(new int[]{i, j});

                else if (grid[i][j] == 1)
                    fresh++;
            }
        }

        if (fresh == 0)
            return 0;

        int minutes = 0;

        int[][] dir = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while (!q.isEmpty()) {

            int size = q.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] cell = q.poll();

                for (int[] d : dir) {

                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];

                    if (r >= 0 && c >= 0 && r < rows && c < cols &&
                        grid[r][c] == 1) {

                        grid[r][c] = 2;
                        fresh--;
                        rottenThisMinute = true;
                        q.offer(new int[]{r, c});
                    }
                }
            }

            if (rottenThisMinute)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}