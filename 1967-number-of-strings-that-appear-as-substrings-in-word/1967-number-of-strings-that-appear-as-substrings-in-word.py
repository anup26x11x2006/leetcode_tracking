class Solution:
    def numOfStrings(self, patterns, word):
        def check(pattern, word) :
            m = len(pattern)
            n = len(word)
            pi = [0] * m
            j = 0
            for i in range(1, m):
                while j and pattern[i] != pattern[j]:
                    j = pi[j - 1]
                if pattern[i] == pattern[j]:
                    j += 1
                pi[i] = j
            j = 0
            for i in range(n):
                while j and word[i] != pattern[j]:
                    j = pi[j - 1]
                if word[i] == pattern[j]:
                    j += 1
                if j == m:
                    return True
            return False

        res = 0
        for pattern in patterns:
            res += check(pattern, word)
        return res