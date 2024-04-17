/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    String smallestString="";
    public String smallestFromLeaf(TreeNode root) {
      dfs(root,"");
        return smallestString;
    }
    public void dfs(TreeNode root,String curString){
        if(root==null){
            return;
        }
       // char ch = root.val + 'a';
        curString = (char)(root.val + 'a') + curString;
        if(root.left==null && root.right==null){
        if(smallestString=="" || smallestString.compareTo(curString)>0){
            smallestString  = curString;    
            }
            return;      
        }
        dfs(root.left,curString);
        dfs(root.right,curString);
    }
}