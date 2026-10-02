class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        l1, l2 = len(nums1), len(nums2)
        if l1 > l2: 
            l1, l2 = l2, l1
            nums1, nums2 = nums2, nums1
        total = l1 + l2
        half = total // 2

        left, right = 0, l1
        while left <= right:
            i = (left + right) // 2
            j = half - i

            n1_left = -10000000 if i == 0 else nums1[i-1]
            n1_right = 10000000 if i == l1 else nums1[i]
            n2_left = -10000000 if j == 0 else nums2[j-1]
            n2_right = 10000000 if j == l2 else nums2[j]

            if (n1_left <= n2_right) and (n2_left <= n1_right):
                if total % 2:
                    return float(min(n2_right, n1_right))
                return (min(n2_right, n1_right) + max(n2_left, n1_left)) / 2.0
            elif n1_left > n2_right:
                right = i - 1
            else:
                left = i + 1