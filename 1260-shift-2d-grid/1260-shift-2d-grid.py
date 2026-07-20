class Solution(object):
    def shiftGrid(self, grid, k):
        """
        :type grid: List[List[int]]
        :type k: int
        :rtype: List[List[int]]
        """
        number_of_rows = len(grid)
        row_length = len(grid[0])
        all_nums = [num for row in grid for num in row]
    
        moving_num = k % len(all_nums)
        moved_nums = all_nums[-moving_num:] + all_nums[:-moving_num]

        result = []
        for row_index in range(number_of_rows):
            result.append(moved_nums[row_index*row_length : (row_index+1)*row_length])
        return result