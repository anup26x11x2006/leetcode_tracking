class Solution:
    def maxActiveSectionsAfterTrade(self, s):
        n = len(s)
        ones = s.count('1')

        l, r = 0, n - 1
        while l < n and s[l] == '1':
            l += 1
        while r >= 0 and s[r] == '1':
            r -= 1

        if l > r:
            return ones

        store = []
        length = 1

        for i in range(l + 1, r + 1):
            if s[i] == s[i - 1]:
                length += 1
            else:
                store.append((length, s[i - 1]))
                length = 1

        store.append((length, s[r]))

        maxRange = 0
        for i in range(0, len(store) - 2, 2):
            gain = store[i][0] + store[i + 2][0]
            maxRange = max(maxRange, gain)

        return ones + maxRange