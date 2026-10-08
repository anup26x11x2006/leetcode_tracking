class Solution(object):
    def threeSumClosest(self, nums, target):
        nums.sort()
        n = len(nums)

        closest = nums[0] + nums[1] + nums[2]

        for i in range(n - 2):
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            min_sum = nums[i] + nums[i + 1] + nums[i + 2]

            if min_sum > target:
                if abs(min_sum - target) < abs(closest - target):
                    closest = min_sum
                break

            max_sum = nums[i] + nums[n - 2] + nums[n - 1]

            if max_sum < target:
                if abs(max_sum - target) < abs(closest - target):
                    closest = max_sum
                continue

            left, right = i + 1, n - 1

            while left < right:
                total = nums[i] + nums[left] + nums[right]

                if abs(total - target) < abs(closest - target):
                    closest = total

                if total == target:
                    return target
                elif total < target:
                    left += 1
                else:
                    right -= 1

        return closest