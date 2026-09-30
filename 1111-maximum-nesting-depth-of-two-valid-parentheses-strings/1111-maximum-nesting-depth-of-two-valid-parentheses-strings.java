class Solution {

    public int[] maxDepthAfterSplit(String seq) {
        int length = seq.length();
        int[] ans = new int[length];
        for (int i = 0; i < length; ++i) {
            ans[i] = (i & 1) ^ (seq.charAt(i) == '(' ? 1 : 0);
        }
        return ans;
    }
}