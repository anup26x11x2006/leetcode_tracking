class Solution 
{
    public int totalNQueens(int n) 
    {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                board[i][j]='.';
            }
        } 
        return helper(board,0);
    }
    public static int helper(char[][] board, int row)
    {
        int n =board.length;
        if(row==n) return 1;
        int count =0;
        for(int j=0;j<n;j++)
        {
            if(isSafe(board,row,j))
            {
                board[row][j]='Q';
                count+=helper(board,row+1);
                board[row][j]='.';
            }
        }
        return count;
    }
    public static boolean isSafe(char[][]board,int row,int col)
    {
        // check col
        int n =board.length;
        for(int i=0;i<row;i++)
        {
            if(board[i][col]=='Q') return false;
        }
        // check row
        for(int j=0;j<n;j++)
        {
            if(board[row][j]=='Q' && j != col) return false;
        }
        // left upper diagonal
        int i=row;
        int j=col;
        while(i>=0 && j>=0)
        {
            if(board[i][j]=='Q') return false;
            i--;
            j--;
        }
        // right upper
        i= row;
        j=col;
        while(i>=0 && j<n)
        {
            if(board[i][j]=='Q') return false;
            i--;
            j++;
        }
        return true;
    }
}