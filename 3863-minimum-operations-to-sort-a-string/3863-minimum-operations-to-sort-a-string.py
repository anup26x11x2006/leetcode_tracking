class Solution(object):
    def minOperations(self, s):
        """
        :type s: str
        :rtype: int
        """
        n=len(s)
        if len(s)<=1: return 0
        if len(s)==2: return 0 if s[0] <= s[1] else -1
        if all(s[i] <= s[i+1] for i in range(n-1)):
            return 0
        mn,mx=min(s),max(s)
        if s[0] == mx and mn == s[-1]:
            if s.count(mn)>1 or s.count(mx) >1:
                return 2
            return 3
        if s[0] == mn or s[-1] == mx:
            return 1
        return 2    