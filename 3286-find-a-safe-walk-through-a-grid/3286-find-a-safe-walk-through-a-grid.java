class Solution {
    static int[] row = { -1, 0, 1, 0 };
    int[] queue;
    int left = 0;
    int right = 0;
    int sz = 1;
    int mn;
    int m, n;

    public boolean findSafeWalk(List<List<Integer>> gridList, int health) {
        n = gridList.size();
        m = gridList.get(0).size();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = gridList.get(i).get(j);

        int startHealth = health - grid[0][0];
        if (startHealth <= 0)
            return false;

        int[][] bestHealth = new int[n][m];
        for (int[] row : bestHealth)
            Arrays.fill(row, -1);

        bestHealth[0][0] = startHealth;
        mn = m * n;
        queue = new int[mn];
        queue[0] = 0;

        while (sz > 0) {
            int cur = queue[left];
            int x = cur / m;
            int y = cur % m;
            int h = bestHealth[x][y];
            left = (left + 1) % mn;
            sz--;

            if (x == n - 1 && y == m - 1 && h >= 1)
                return true;

            for (int d = 0; d <= 3; d++) {
                int nx = x + row[d];
                int ny = y + row[3 - d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                int newHealth = h - grid[nx][ny];
                if (newHealth <= 0)
                    continue;

                if (newHealth > bestHealth[nx][ny]) {
                    bestHealth[nx][ny] = newHealth;
                    if (grid[nx][ny] == 0) {
                        left = (left - 1 + mn) % mn;
                        queue[left] = nx * m + ny;
                        if (sz == 0)
                            right = left;
                        sz++;
                    } else {
                        right = (right + 1) % mn;
                        queue[right] = nx * m + ny;
                        sz++;
                    }
                }
            }
        }
        return false;
    }
}