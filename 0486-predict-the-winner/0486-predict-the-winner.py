class Solution(object):
    def predictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        n = len(nums)
        dp = nums[:]

        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                dp[j] = max(nums[i] - dp[j], nums[j] - dp[j - 1])

        return dp[n - 1] >= 0