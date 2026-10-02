import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] s = new char[2 * n];
        solve(ans, s, 0, 0, 0, n);
        return ans;
    }

    private void solve(List<String> ans, char[] s, int pos,
                       int open, int close, int n) {

        if (pos == s.length) {
            ans.add(new String(s));
            return;
        }

        if (open < n) {
            s[pos] = '(';
            solve(ans, s, pos + 1, open + 1, close, n);
        }

        if (close < open) {
            s[pos] = ')';
            solve(ans, s, pos + 1, open, close + 1, n);
        }
    }
}