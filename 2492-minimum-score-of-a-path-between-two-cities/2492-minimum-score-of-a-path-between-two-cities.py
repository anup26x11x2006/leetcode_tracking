class Solution:
    def minScore(self, n, roads):
        root = list(range(n + 1))

        def find(i):
            root[i] = find(root[i]) if root[i] != i else i
            return root[i]

        for x, y, _ in roads:
            root[find(x)] = find(y)

        res, g1 = 10001, find(1)
        for x, _, d in roads:
            if find(x) == g1:
                res = min(res, d)

        return res