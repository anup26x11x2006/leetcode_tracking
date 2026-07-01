from collections import deque
import heapq

class Solution(object):
    def maximumSafenessFactor(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        row = len(grid)
        col = len(grid[0])

        if grid[0][0] == 1 or grid[row-1][col-1] == 1:
            return 0

        thief = []
        for r in range(row):
            for c in range(col):
                if grid[r][c] == 1:
                    thief.append((r, c))
                    grid[r][c] = 0
                else:
                    grid[r][c] = -1

        q = deque(thief)
        direction = [(1, 0), (-1, 0), (0, -1), (0, 1)]
        
        while q:
            r, c = q.popleft()
            for dr, dc in direction:
                nr, nc = r + dr, c + dc
                if 0 <= nr < row and 0 <= nc < col and grid[nr][nc] == -1:
                    grid[nr][nc] = grid[r][c] + 1
                    q.append((nr, nc))

        max_safeness = [[-1] * col for _ in range(row)]
        max_safeness[0][0] = grid[0][0]

        pq = [(-grid[0][0], 0, 0)]
        
        while pq:
            safeness, r, c = heapq.heappop(pq)
            safeness = -safeness
            if r == row - 1 and c == col - 1:
                return safeness
            for dr, dc in direction:
                nr, nc = r + dr, c + dc
                if 0 <= nr < row and 0 <= nc < col:
                    new_safeness = min(safeness, grid[nr][nc])
                    if new_safeness > max_safeness[nr][nc]:
                        max_safeness[nr][nc] = new_safeness
                        heapq.heappush(pq, (-new_safeness, nr, nc))
        return 0