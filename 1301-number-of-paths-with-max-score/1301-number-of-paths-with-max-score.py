
class Solution:
    def pathsWithMaxScore(self, board):
        n = len(board)
        MOD = 10**9 + 7

        dp_score = [[-1] * n for _ in range(n)]
        dp_count = [[0] * n for _ in range(n)]

        dp_score[n - 1][n - 1] = 0
        dp_count[n - 1][n - 1] = 1

        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if board[i][j] == 'X' or (i == n - 1 and j == n - 1):
                    continue

                best_score = -1
                ways = 0

                for ni, nj in ((i + 1, j), (i, j + 1), (i + 1, j + 1)):
                    if ni < n and nj < n and dp_score[ni][nj] != -1:
                        if dp_score[ni][nj] > best_score:
                            best_score = dp_score[ni][nj]
                            ways = dp_count[ni][nj]
                        elif dp_score[ni][nj] == best_score:
                            ways = (ways + dp_count[ni][nj]) % MOD

                if best_score == -1:
                    continue

                val = 0 if board[i][j] in "SE" else int(board[i][j])
                dp_score[i][j] = best_score + val
                dp_count[i][j] = ways

        if dp_score[0][0] == -1:
            return [0, 0]

        return [dp_score[0][0], dp_count[0][0]]