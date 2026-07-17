import collections
import bisect
class Solution(object):
    def gcdValues(self, nums, queries):
        max_val = max(nums)        
        counts = [0] * (max_val + 1)
        for x in nums:
            counts[x] += 1            
        gcd_counts = [0] * (max_val + 1)        
        for g in range(max_val, 0, -1):
            total_multiples = 0
            for multiple in range(g, max_val + 1, g):
                total_multiples += counts[multiple]                
            pairs = (total_multiples * (total_multiples - 1)) // 2           
            for multiple in range(2 * g, max_val + 1, g):
                pairs -= gcd_counts[multiple]               
            gcd_counts[g] = pairs           
        prefix_sums = [0] * (max_val + 1)
        for i in range(1, max_val + 1):
            prefix_sums[i] = prefix_sums[i - 1] + gcd_counts[i]           
        res = []
        for q in queries:
            idx = bisect.bisect_right(prefix_sums, q)
            res.append(idx)            
        return res