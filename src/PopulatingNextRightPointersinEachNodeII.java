import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
    public static void main(String[] args){
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        TreeLinkNode leftLeft = new TreeLinkNode(4);
        TreeLinkNode leftRight = new TreeLinkNode(5);
        TreeLinkNode rightRight = new TreeLinkNode(7);
        root.left=left;
        root.right=right;
//        left.left=leftLeft;
//        left.right=leftRight;
//        right.right=rightRight;

        new Solution().connect(root);
    }
}
class TreeLinkNode{
    int val;
    TreeLinkNode left,right,next;
    TreeLinkNode(int x) {val=x;};
}
class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        TreeLinkNode node;
        TreeLinkNode prenode=null;

        while(!queue.isEmpty()){
            node = queue.poll();
            if(node==null ){
                if(!queue.isEmpty()){
                    queue.add(null);
                    prenode=null;
                }
                continue;
            }else {
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                if(prenode!=null)
                    prenode.next=node;
                    prenode=node;
            }
        }
    }
}