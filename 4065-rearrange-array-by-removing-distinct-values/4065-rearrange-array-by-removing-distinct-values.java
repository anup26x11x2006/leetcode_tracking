class Solution {
    public int[] rearrangeArray(int[] nums) {
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        int[] ans = new int[nums.length];
        int i = 0;
        while (!freq.isEmpty()) {
            for (int x : freq.keySet()) ans[i++] = x;
            freq.replaceAll((x, f) -> f - 1);
            freq.values().removeIf(f -> f == 0);
        }
        return ans;
    }
}