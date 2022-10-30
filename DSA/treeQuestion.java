import java.util.HashMap;

public class treeQuestion{

    public static void main(String[] args) {
        

    }

    private static int solve(TreeNode root){
        HashMap<Integer,Integer> map = new HashMap<>();
        int mul=1;
        helper(root, 1, map);
        for(int level:map.keySet()){
            int num = map.get(level);
            if(num==0) continue;
            else mul=mul*num;
        }
        return mul;
    }

    private static int solve2(TreeNode root){
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=Integer.MIN_VALUE;
        helper2(root, 1, map);
        for(int level:map.keySet()){
            int num = map.get(level);
            max = Math.min(max, num);
        }
        return max;
    }

    private static void helper2(TreeNode root,int level,HashMap<Integer,Integer> map){
        if(root==null) return; 
        helper2(root.left, level+1,map);
        helper2(root.right, level+1,map);
        int prev = map.getOrDefault(level, Integer.MAX_VALUE);
        if(prev>root.val) map.put(level,root.val);
    }

    private static void helper(TreeNode root,int level,HashMap<Integer,Integer> map){
        if(root==null) return; 
        helper(root.left, level+1,map);
        helper(root.right, level+1,map);

        if(root.left==null || root.right==null) map.put(level,map.getOrDefault(level, 0)+root.val);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val=val;
    }
}
