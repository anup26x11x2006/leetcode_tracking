class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int remaining = n;

        for(int i=0;i<n;i++){
            boolean covered = false;
            int a  = intervals[i][0];
            int b = intervals[i][1];

            for(int j=0;j<n;j++){
                if(i==j) continue;

                int c = intervals[j][0];
                int d = intervals[j][1];

                if(c<=a && b<=d){
                    covered = true;
                    break;
                }
            }
            if (covered){
                remaining--;
            }
        }
        return remaining;
    }
}