// 173:https://leetcode.com/problems/binary-search-tree-iterator/description/

import java.util.Stack;

public class BinarySearchTreeIterator {
    public static void main(String[] args){

    }
}
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BSTIterator{

    private Stack<TreeNode> stack = new Stack<TreeNode>();


    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node =stack.pop();
        pushAll(node.right);
        return node.val;
    }

    private void pushAll(TreeNode root){
        for(;root!=null;stack.add(root),root=root.left);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
