import java.util.AbstractList;
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        final int n = grid.length;
        final int m = grid[0].length;
        final int total = n * m;
        final int shift = k % total;

        return new AbstractList<List<Integer>>() {
            @Override
            public List<Integer> get(int i) {
                return new AbstractList<Integer>() {
                    @Override
                    public Integer get(int j) {
                        int target1D = i * m + j;
                        int source1D = (target1D + total - shift) % total;
                        return grid[source1D / m][source1D % m];
                    }

                    @Override
                    public int size() {
                        return m;
                    }
                };
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}