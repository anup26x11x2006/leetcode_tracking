class Solution(object):
    def gcd(self, a, b):
        while b:
            a, b = b, a % b
        return a
    def gcdSum(self, nums):
        n = len(nums)
        result = []
        maxi = float('-inf')
        for i in range(n):
            maxi = max(maxi, nums[i])
            result.append(self.gcd(nums[i], maxi))
        result.sort()
        i, j = 0, n - 1
        total = 0
        while i < j:
            total += self.gcd(result[i], result[j])
            i += 1
            j -= 1
        return total