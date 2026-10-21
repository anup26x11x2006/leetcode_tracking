class Solution {
    private int rows;
    private int cols;
    private Set<String> visited;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new HashSet<>();

        Map<Character, Integer> count = new HashMap<>();
        for (char c : word.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        if (count.getOrDefault(word.charAt(0), 0) > count.getOrDefault(word.charAt(word.length() - 1), 0)) {
            word = new StringBuilder(word).reverse().toString();
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int k) {
        if (k == word.length()) {
            return true;
        }

        if (r < 0 || r >= rows || c < 0 || c >= cols || visited.contains(r + "," + c) || board[r][c] != word.charAt(k)) {
            return false;
        }

        visited.add(r + "," + c);
        boolean res = dfs(board, word, r + 1, c, k + 1) ||
                      dfs(board, word, r - 1, c, k + 1) ||
                      dfs(board, word, r, c + 1, k + 1) ||
                      dfs(board, word, r, c - 1, k + 1);
        visited.remove(r + "," + c);
        return res;
    }    
}