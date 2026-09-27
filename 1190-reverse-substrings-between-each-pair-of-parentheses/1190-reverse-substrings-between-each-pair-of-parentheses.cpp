class Solution {
public:
    string reverseParentheses(string s) {
        int n = s.length();
        stack<int> openParenthesesIndices;
        vector<int> pair(n);

        for (int i = 0; i < n; ++i) {
            if (s[i] == '(') {
                openParenthesesIndices.push(i);
            }
            if (s[i] == ')') {
                int j = openParenthesesIndices.top();
                openParenthesesIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        string result;
        for (int currIndex = 0, direction = 1; currIndex < n;
             currIndex += direction) {
            if (s[currIndex] == '(' || s[currIndex] == ')') {
                currIndex = pair[currIndex];
                direction = -direction;
            } else {
                result += s[currIndex];
            }
        }
        return result;
    }
};