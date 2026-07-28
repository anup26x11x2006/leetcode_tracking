class Solution {
public:
    string smallestPalindrome(string s) {
        int n = s.size();
        int counts[26] = {0};

        for(int i = 0; i < n / 2; ++i) {
            counts[s[i] - 'a']++;
        }

        int idx = 0;
        for(int i = 0; i < 26; ++i) {
            while(counts[i]-- > 0) {
                s[idx++] = (char)(i + 'a');
            }
        }

        for(int i = 0; i < n / 2; ++i) {
            s[n - 1 - i] = s[i];
        }
        
        return s;
    }
};