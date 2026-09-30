class Solution:
    def maxDepthAfterSplit(self, seq):
        ans = list()
        for i, ch in enumerate(seq):
            if ch == "(":
                ans.append(i % 2)
            else:
                ans.append(1 - i % 2)
        return ans