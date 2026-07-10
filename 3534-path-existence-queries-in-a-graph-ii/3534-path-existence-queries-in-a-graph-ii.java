class Solution {

    public int[] pathExistenceQueries(
        int n,
        int[] nums,
        int maxDiff,
        int[][] queries
    ) {
        int[] idx = new int[n];
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Integer[] ord = new Integer[n];
        for (int i = 0; i < n; i++) {
            ord[i] = i;
        }

        Arrays.sort(ord, (a, b) -> Integer.compare(nums[a], nums[b]));

        for (int i = 0; i < n; i++) {
            idx[i] = ord[i];
            pos[idx[i]] = i;
        }

        int m = 32 - Integer.numberOfLeadingZeros(n);

        int[][] f = new int[n][m];

        int left = 0;
        for (int i = 0; i < n; i++) {
            while (left < i && nums[idx[i]] - nums[idx[left]] > maxDiff) {
                left++;
            }
            f[i][0] = left;
        }

        for (int j = 1; j < m; j++) {
            for (int i = 0; i < n; i++) {
                f[i][j] = f[f[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int x = pos[queries[k][0]];
            int y = pos[queries[k][1]];

            if (x > y) {
                int t = x;
                x = y;
                y = t;
            }

            if (x == y) {
                ans[k] = 0;
                continue;
            }

            int step = 0;

            for (int i = m - 1; i >= 0; i--) {
                if (f[y][i] > x) {
                    y = f[y][i];
                    step += 1 << i;
                }
            }

            ans[k] = f[y][0] <= x ? step + 1 : -1;
        }

        return ans;
    }
}