class Solution(object):
    def reverseDegree(self, s):
        p = 0
        for i in range(len(s)):
            p += (123 - ord(s[i])) * (i+1)
        return p