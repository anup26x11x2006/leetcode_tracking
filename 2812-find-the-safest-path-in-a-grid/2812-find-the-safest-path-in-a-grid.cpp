class Solution {
public:
    int maximumSafenessFactor(vector<vector<int>>& grid) {
        ios_base::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
        int n = grid.size();
        int m = grid[0].size();
        if(grid[0][0] || grid[n - 1][m - 1])return 0;
        vector<vector<int>>dist = vector<vector<int>>(n ,vector<int>(m, 0));
        vector<vector<int>>vis = vector<vector<int>>(n ,vector<int>(m, 0));
        queue<pair<int, int>>pq;
        for(int i=0;i<n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == 1)pq.push({i, j});
                if(grid[i][j] == 1)vis[i][j] = 1;
            }
        }
        int dista = 0;
        while(!pq.empty()) {
            int s = pq.size();
            for(int i=0;i<s;i++) {
                int x = pq.front().first;
                int y = pq.front().second;
                dist[x][y] = dista;
                pq.pop();
                if(x - 1 >= 0 && grid[x - 1][y] == 0){pq.push({x - 1, y});grid[x - 1][y] = -1;}
                if(y - 1 >= 0 && grid[x][y - 1] == 0){pq.push({x, y - 1});grid[x][y - 1] = -1;}
                if(x + 1 < n && grid[x + 1][y] == 0){pq.push({x + 1, y});grid[x + 1][y] = -1;}
                if(y + 1 < m && grid[x][y + 1] == 0){pq.push({x, y + 1}); grid[x][y + 1] = -1;}
            }
            dista++;
        }
        priority_queue<pair<int, pair<int, int>>>pqq;
        pqq.push({dist[0][0], {0, 0}});
        vis[0][0] = true;
        while(!pqq.empty()) {
            auto it = pqq.top();
            pqq.pop();
            int cost = it.first;
            int x = it.second.first;
            int y = it.second.second;
            // vis[x][y] = true;
            if(x == n - 1 && y == m - 1)return cost;
            if(x - 1 >= 0 && vis[x - 1][y] == 0){pqq.push({min(dist[x - 1][y],cost), {x - 1, y}});vis[x - 1][y] = true;}
            if(y - 1 >= 0 && vis[x][y - 1] == 0){pqq.push({min(dist[x][y - 1], cost), {x, y - 1}});vis[x][y - 1] = true;}
            if(x + 1 < n && vis[x + 1][y] == 0){pqq.push({min(dist[x + 1][y], cost), {x + 1, y}});vis[x + 1][y] = true;}
            if(y + 1 < m && vis[x][y + 1] == 0){pqq.push({min(dist[x][y + 1], cost), {x, y + 1}}); vis[x][y + 1] = true;}
        }
        return 0;
    }
};