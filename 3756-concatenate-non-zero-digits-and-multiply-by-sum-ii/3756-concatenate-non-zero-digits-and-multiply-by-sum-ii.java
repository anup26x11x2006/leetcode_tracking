class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        long MOD = 1_000_000_007;
        int len = s.length();
        
        long[] preSum = new long[len + 1];
        long[] preProduct = new long[len + 1];
        int[] nonZeroCnt = new int[len + 1];
        long[] p10 = new long[len + 1];

        p10[0] = 1;
        for (int i = 0; i < len; i++) {
            p10[i + 1] = (p10[i] * 10) % MOD;
            
            int digit = s.charAt(i) - '0';
            preSum[i + 1] = preSum[i] + digit;
            
            if (digit == 0) {
                preProduct[i + 1] = preProduct[i];
                nonZeroCnt[i + 1] = nonZeroCnt[i];
            } else {
                preProduct[i + 1] = (preProduct[i] * 10 + digit) % MOD;
                nonZeroCnt[i + 1] = nonZeroCnt[i] + 1;
            }
        }
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            long sum = preSum[end + 1] - preSum[start];

            int cnt = nonZeroCnt[end + 1] - nonZeroCnt[start];

            long subtract = (preProduct[start] * p10[cnt]) % MOD;
            long x = (preProduct[end + 1] - subtract + MOD) % MOD;

            res[i] = (int) ((x * sum) % MOD);
        }
        
        return res;
    }
}