const static auto fast_io = [](){ cin.tie(nullptr); ios::sync_with_stdio(false); return 0; }();

class Solution {
public:

    void consume_island(vector<vector<char>>&grid,int i, int j,int n ,int m)
    {
        if(i<0 || j<0 || i==n || j==m || grid[i][j]!='1')return;
        
        grid[i][j]='0';
        consume_island(grid,i-1,j,n,m);
        consume_island(grid,i+1,j,n,m);
        consume_island(grid,i,j+1,n,m);
        consume_island(grid,i,j-1,n,m);
    }

    int numIslands(vector<vector<char>>& grid) 
    {
        int n = grid.size();
        int m = grid[0].size();
        int islands=0;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == '1')
                {
                    islands++;
                    consume_island(grid,i,j,n,m);
                }
            }
        }
        return islands;
    }
};