class Solution {
public:
    bool isValid(string s) {
        if (s.length() % 2 != 0) return false;

        vector<char> stack(s.length());
        int head = 0;

        for (char c : s) {
            if (c == '(') {
                stack[head++] = ')';
            } else if (c == '{') {
                stack[head++] = '}';
            } else if (c == '[') {
                stack[head++] = ']';
            } else {
                if (head == 0 || stack[--head] != c) {
                    return false;
                }
            }
        }

        return head == 0;
    }
};