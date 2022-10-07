class Solution {
public:
    
    void helper(TreeNode* root,TreeNode* par,int val,int depth,int lr){
        if(depth==0){
            if(lr==1){
                TreeNode* r=new TreeNode(val);
                par->right=r;
                r->right=root;
            }
            else if(lr==-1){
                TreeNode* l=new TreeNode(val);
                par->left=l;
                l->left=root;
            }
            return;
        }
        if(!root)return;
        helper(root->left,root,val,depth-1,-1);
        helper(root->right,root,val,depth-1,1);
    }
    
    TreeNode* addOneRow(TreeNode* root, int val, int depth) {
        if(depth==1){ TreeNode* r=new TreeNode(val); r->left=root;return r;}
        helper(root,NULL,val,depth-1,0);
        return root;
    }
};