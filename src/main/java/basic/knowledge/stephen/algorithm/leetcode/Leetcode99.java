package basic.knowledge.stephen.algorithm.leetcode;

import java.util.Stack;

public class Leetcode99 {
    public static void main(String[] args) {
        Leetcode99 leetcode99 = new Leetcode99();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        leetcode99.recoverTree(root);
        System.out.println();
    }
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        int[] error = new int[2];
        TreeNode pre = null;
        while(!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                if(pre != null && pre.val > cur.val){
                    error[0] = error[0] == 0 ? pre.val : error[0];
                    error[1] = cur.val;
                }
                pre = cur;
                cur = cur.right;
            }
        }


        reverse(root,2, error[0], error[1]);
    }


    private void reverse(TreeNode root,int count,int x, int y){
        if(root == null){
            return;
        }

        if(root.val == x || root.val == y){
            root.val = root.val == y ? x : y;
            if(--count == 0){
                return;
            }
        }
        reverse(root.right,count,x,y);
        reverse(root.left,count,x,y);

    }
}
