class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        int total = 1 << n; 
        for (int i = 0; i < total; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}