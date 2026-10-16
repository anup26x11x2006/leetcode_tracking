class Solution {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[] boxes = new int[9];
    char[][] board;
    int[][] empties;
    int emptyCount;

    public void solveSudoku(char[][] board) {
        this.board = board;
        empties = new int[81][2];
        emptyCount = 0;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char num = board[r][c];
                if (num == '.' || num == '0') {
                    empties[emptyCount++] = new int[]{r, c};
                } else {
                    int d = num - '0';
                    int mask = 1 << d;
                    rows[r] |= mask;
                    cols[c] |= mask;
                    boxes[boxIndex(r, c)] |= mask;
                }
            }
        }
        help(0);
    }

    private int boxIndex(int r, int c) {
        return (r / 3) * 3 + (c / 3);
    }

    private boolean help(int idx) {
        if (idx == emptyCount) return true;

        int bestIdx = -1, bestOption = 10;
        for (int i = idx; i < emptyCount; i++) {
            int r = empties[i][0], c = empties[i][1];
            int used = rows[r] | cols[c] | boxes[boxIndex(r, c)];
            int options = 9 - Integer.bitCount(used & 0x3FE);
            if (options < bestOption) {
                bestOption = options;
                bestIdx = i;
                if (options == 1) break;
            }
        }

        if (bestIdx != idx) {
            int[] temp = empties[idx];
            empties[idx] = empties[bestIdx];
            empties[bestIdx] = temp;
        }

        int r = empties[idx][0], c = empties[idx][1];
        int used = rows[r] | cols[c] | boxes[boxIndex(r, c)];
        for (int d = 1; d <= 9; d++) {
            int mask = 1 << d;
            if ((used & mask) == 0) {
                rows[r] |= mask;
                cols[c] |= mask;
                boxes[boxIndex(r, c)] |= mask;
                board[r][c] = (char) ('0' + d);

                if (help(idx + 1)) return true;

                rows[r] &= ~mask;
                cols[c] &= ~mask;
                boxes[boxIndex(r, c)] &= ~mask;
                board[r][c] = '.';
            }
        }
        return false;
    }
}