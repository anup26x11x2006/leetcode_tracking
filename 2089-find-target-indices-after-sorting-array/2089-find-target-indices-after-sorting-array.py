class Solution:
    def targetIndices(self, nums, target):
        cnt1 = 0
        cnt2 = 0
        for num in nums:
            if num < target:
                cnt1 += 1
            elif num == target:
                cnt2 += 1
        res = list(range(cnt1, cnt1 + cnt2))
        return res