class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        ArrayList<Integer> ans=new ArrayList<>();
        int top=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        while(left<=right && top<=down)
        {
            for(int i=left;i<=right;i++)
            {
                ans.add(matrix[top][i]);
            }
            top++;
            if(left<=right)
            {
                for(int i=top;i<=down;i++)
                {
                    ans.add(matrix[i][right]);
                }
                right--;
            }
            if(top<=down)
            {
                for(int i=right;i>=left;i--)
                {
                    ans.add(matrix[down][i]);
                }
                down--;
            }
            if(left<=right)
            {
                for(int i=down;i>=top;i--)
                {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}