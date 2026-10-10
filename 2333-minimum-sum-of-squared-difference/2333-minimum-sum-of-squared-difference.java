class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
  long[] cnt = new long[100001];
  int n = nums1.length;
  long sumDiff = 0;
  int maxDiff = 0;
  for (int i = 0; i < n; i++) {
      int d = Math.abs(nums1[i] - nums2[i]);
      cnt[d]++;
      sumDiff += d;
      maxDiff = Math.max(maxDiff, d);
  }
  long chances = (long) k1 + k2;
  if (sumDiff <= chances) return 0;

  for (int v = maxDiff; v >= 1 && chances > 0; v--) {
      if (cnt[v] == 0) continue;
      long here = cnt[v];
      long move = Math.min(here, chances);
      cnt[v] -= move;
      cnt[v-1] += move;
      chances -= move;
  }

  long ans = 0;
  for (int v = 1; v <= maxDiff; v++) {
      ans += cnt[v] * (long) v * v;
  }
  return ans;

    }
}