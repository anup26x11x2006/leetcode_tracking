class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty()) return "";
        string t = "^";
        for (char c : s) {
            t += '#';
            t += c;
        }
        t += "#$";
        int n = t.length();
        vector<int> P(n, 0);
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; ++i) {
            int mirror = 2 * C - i;
            if (i < R) {
                P[i] = min(R - i, P[mirror]);
            }
            while (t[i + (1 + P[i])] == t[i - (1 + P[i])]) {
                P[i]++;
            }
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;
        return s.substr(start, maxLen);
    }
};