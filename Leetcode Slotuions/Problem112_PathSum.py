class Solution(object):
    def hasPathSum(self, root, targetSum):
      
        if root == None:
            return False
        
        if root.left == None and root.right == None and targetSum - root.val == 0:
            return True
        
        return self.hasPathSum(root.left, targetSum - root.val) or self.hasPathSum(root.right,targetSum - root.val)
