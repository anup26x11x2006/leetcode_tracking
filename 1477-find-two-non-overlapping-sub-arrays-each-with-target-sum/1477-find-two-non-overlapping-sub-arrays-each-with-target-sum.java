class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLen = new int[n];
        int l = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        int best = Integer.MAX_VALUE;
        
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            
            while (sum > target) {
                sum -= arr[l++];
            }
            
            if (sum == target) {
                int currLen = r - l + 1;
                
                if (l > 0 && minLen[l - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currLen + minLen[l - 1]);
                }
                
                best = Math.min(best, currLen);
            }
            
            minLen[r] = best;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}