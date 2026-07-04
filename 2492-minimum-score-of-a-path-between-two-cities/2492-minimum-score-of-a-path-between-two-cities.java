class Solution {
    private int[] parent;
    private int[] minEdge;

    public int minScore(int n, int[][] roads) {
        parent = new int[n+1];
        minEdge = new int[n+1];

        for (int i=0; i<=n; ++i) {
            parent[i] = i;
            minEdge[i] = Integer.MAX_VALUE;
        }

        for (int[] road : roads) {
            union(road[0], road[1], road[2]);
        }

        return minEdge[find(1)];
    }

    private int find(int x) {
        // path compression
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int a, int b, int d) {
        int parentA = find(a);
        int parentB = find(b);
        if (parentA != parentB) {
            parent[parentA] = parentB;
            minEdge[parentB] = Math.min(minEdge[parentB], Math.min(minEdge[parentA], d));
        } else {
            minEdge[parentA] = Math.min(minEdge[parentA], d);
        }
    }
}