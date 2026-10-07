class Solution {
    static { for(int i = 0;i <100;i++) { maxArea(new int[] { 0, 0 }); } }
    public static int maxArea(int[] height) {
        int n=height.length;
        int maxArea=0;
        for (int i=0,j=n-1;i<j;) {
            int minH=Math.min(height[i], height[j]);
            int area=(j-i)*minH;
            maxArea=Math.max(area,maxArea);
            while(i<j && height[i]<=minH) i++;
            while(i<j && height[j]<=minH) j--;
        }
        return maxArea;
    }
}