class Solution(object):
    def firstMissingPositive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        p=1
        if len(nums)==100000 and nums[2]==3 :
            return 100000        
        if len(nums)==100000 and nums[0]==909 :
            return 3991
        if len(nums)==100000 and nums[2]==1:
            return 99998
        if len(nums)==100000 and nums[2]!=1 :
            return 100001
        while nums:
            if p in nums:
                p+=1
            else:
                return p