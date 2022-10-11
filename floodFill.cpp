class Solution {
    void helper(vector<vector<int>>&img, set<pair<int,int>>&vis, int r, int c, int n, int o){
        if(vis.count({r,c}) or r<0 or c<0 or r==img.size() or c==img[r].size() or img[r][c]!=o)
            return ;
        vis.insert({r,c});  
        img[r][c]=n;
        helper(img, vis, r-1, c, n, o);
        helper(img, vis, r, c+1, n, o);
        helper(img, vis, r+1, c, n, o);
        helper(img, vis, r, c-1, n, o);
    }
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        set<pair<int,int>> vis;
        helper(image, vis, sr, sc, newColor, image[sr][sc]);
        return image;
    }
};
