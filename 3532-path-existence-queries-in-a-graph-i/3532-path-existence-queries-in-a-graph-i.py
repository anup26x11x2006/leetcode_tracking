class Solution:
    def pathExistenceQueries(self, n, nums, maxDiff, queries):
        comp = [0] * n

        for i in range(1, n):
            if nums[i] - nums[i - 1] <= maxDiff:
                comp[i] = comp[i - 1]
            else:
                comp[i] = comp[i - 1] + 1

        return [comp[u] == comp[v] for u, v in queries]