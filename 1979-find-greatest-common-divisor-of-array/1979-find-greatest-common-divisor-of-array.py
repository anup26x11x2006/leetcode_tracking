class Solution(object):
    def findGCD(self, nums):
        large=max(nums)
        small=min(nums)     
        while small!=0:
            large,small=small,large%small
        return large
        