
    class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
    
        queue<pair<pair<int,int>,int>>q;
        
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i =0; i<n ; i++){
            for(int j =0 ; j<m ; j++){
                if(grid[i][j]==2){
                   q.push({{i,j},0}); 
                    grid[i][j]=2;
                }
            }
        }
        int ans =0;
        
        while(!q.empty()){
            int r = q.front().first.first;
            int c = q.front().first.second;
            int t = q.front().second;
            ans = max( ans , t);
            q.pop();
            int row[] ={-1,0,1,0};
            int col[] ={0,1,0,-1};
    
            for(int i =0 ; i<4; i++){
                int x , y;
                x = r+ row[i];
                y = c+ col[i];
    
                if( x>=0 && x<n && y>=0 && y<m && grid[x][y]==1){
                    q.push({{x,y},t+1});
                    grid[x][y]=2;
                }
            }
        }
        
        for(int i =0 ; i<n ;i++){
            for(int j =0; j<m ; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return ans;
        
    }
};
