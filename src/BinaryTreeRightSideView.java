// 199:https://leetcode.com/problems/binary-tree-right-side-view/description/

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left=left;
        System.out.println(new Solution199().rightSideView(root));

    }
}
class Solution199{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        res.add(root.val);
        TreeNode node;
        boolean isStart = false;

        while (!queue.isEmpty()){
             node=queue.poll();
             if(node!=null){
                 if(node.right!=null) queue.add(node.right);
                 if(node.left!=null) queue.add(node.left);
                 if(isStart) {
                     res.add(node.val);
                     isStart=false;
                 }

             }else {
                 if(!queue.isEmpty()){
                     queue.add(null);
                     isStart=true;
                 }
             }
        }

        return res;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val=x;}
}
