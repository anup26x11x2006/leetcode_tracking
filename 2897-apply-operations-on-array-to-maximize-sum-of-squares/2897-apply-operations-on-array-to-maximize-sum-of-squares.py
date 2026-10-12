class Solution:
    def maxSum(self, nums, k):
        MOD = 10**9 + 7
        cnt = [0] * 30

        for num in nums:
            for i in range(30):
                if num & (1 << i):
                    cnt[i] += 1

        res = 0
        for _ in range(k):
            cur = 0
            for j in range(29, -1, -1):
                if cnt[j] > 0:
                    cur |= 1 << j
                    cnt[j] -= 1
            res = (res + cur * cur) % MOD

        return res