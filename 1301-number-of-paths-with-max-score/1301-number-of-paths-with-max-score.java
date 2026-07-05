class Solution {
    int[][] cnt;
    Integer[][] dp;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(0).length();
        char[][] arr = new char[n][];
        dp = new Integer[n][m];
        cnt = new int[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = board.get(i).toCharArray();
        }
        arr[0][0] = arr[n - 1][m - 1] = '0';
        cnt[0][0] = 1;

        int max = find(n - 1, m - 1, arr, n, m);
        if (max < 0)
            return new int[] { 0, 0 };
        return new int[] { max, cnt[n - 1][m - 1] };
    }

    int inf = (int) 1e7;
    int MOD = (int) 1e9 + 7;

    int find(int i, int j, char[][] arr, int n, int m) {
        if (i == 0 && j == 0) {
            return 0;
        }
        if (dp[i][j] != null)
            return dp[i][j];

        int ans = -inf;
        int knt = 0;
        for (int[] d : dirs) {
            int x = i + d[0];
            int y = j + d[1];

            if (isValid(x, y, n, m) && arr[x][y] != 'X') {
                int res = find(x, y, arr, n, m) + arr[x][y] - '0';
                if (ans == res) {
                    knt += cnt[x][y];
                    knt %= MOD;
                } else if (res > ans) {
                    knt = cnt[x][y];
                    ans = res;
                }
            }
        }
        cnt[i][j] = knt;
        return dp[i][j] = ans;
    }

    int[][] dirs = { { -1, -1 }, { -1, 0 }, { 0, -1 } };

    boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}