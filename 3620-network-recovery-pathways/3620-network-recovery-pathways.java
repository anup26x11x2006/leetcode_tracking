class Solution {
    private int[] head, next, to, weight;
    private long k;
    private int n;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.n = online.length;
        this.k = k;

        int m = edges.length;
        this.head = new int[n];
        this.next = new int[m];
        this.to = new int[m];
        this.weight = new int[m];
        Arrays.fill(head, -1);
        int left = Integer.MAX_VALUE, right = 0;
        for(int i = 0; i < m; i++) {
            int a = edges[i][0], b = edges[i][1], c = edges[i][2];
            if(online[a] && online[b]) {
                to[i] = b;
                next[i] = head[a];
                weight[i] = c;
                head[a] = i;

                if(c > right) right = c;
                if(c < left) left = c;
            }
        }

        if(!check(0)) return -1;

        while(left < right) {
            int mid = left + right + 1 >>> 1;
            if(check(mid)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private static final int[] queue = new int[50001];
    private static final long[] sum = new long[50001];
    private boolean check(int threshold) {
        long[] dist = new long[n];
        Arrays.fill(dist, k + 1);
        dist[0] = 0;

        int read = 0, write = 1;
        while(read < write) {
            int current = queue[read];
            long val = sum[read++];
            if(val > dist[current]) continue;
            for(int i = head[current]; i != -1; i = next[i]) {
                if(weight[i] < threshold) continue;
                int nextIndex = to[i];
                long d = val + weight[i];
                if(d < dist[nextIndex]) {
                    if(nextIndex == n - 1) return true;
                    dist[nextIndex] = d;
                    sum[write] = d;
                    queue[write++] = nextIndex;
                }
            }
        }
        return false;
    }
    private static final class Node {
        private final int index;
        private final long dist;
        private Node(int index, long dist) {
            this.index = index;
            this.dist = dist;
        }
    }
}