class Solution:
    def checkValidString(self, s):
        open_count = 0
        close_count = 0
        length = len(s) - 1
        for i in range(length + 1):
            if s[i] == '(' or s[i] == '*':
                open_count += 1
            else:
                open_count -= 1
            if s[length - i] == ')' or s[length - i] == '*':
                close_count += 1
            else:
                close_count -= 1
            if open_count < 0 or close_count < 0:
                return False
        return True