class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] nodeCount = new int[n];
        int[] edgeCount = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            nodeCount[i] = 1;
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            int rootU = find(u, parent);
            int rootV = find(v, parent);
            
            if (rootU != rootV) {
                parent[rootV] = rootU;
                nodeCount[rootU] += nodeCount[rootV];
                edgeCount[rootU] += edgeCount[rootV] + 1;
            } else {
                edgeCount[rootU]++;
            }
        }
        
        int completeComponents = 0;

        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                int nodes = nodeCount[i];
                int totalEdges = edgeCount[i];

                if (totalEdges == (nodes * (nodes - 1)) / 2) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }
}