#include <bits/stdc++.h>
using namespace std;

class Solution
{

public:
    int maxDepth(TreeNode *root)
    {
        if (!root)
            return -1;

        return 1 + max(maxDepth(root->left), maxDepth(root->right));
    }

    int diameterOfBinaryTree(TreeNode *root)
    {
        if (!root)
            return -1;

        return max(diameterOfBinaryTree(root->left), diameterOfBinaryTree(root->right), 2 + maxDepth(root->left) + maxDepth(root->right));
    }
};