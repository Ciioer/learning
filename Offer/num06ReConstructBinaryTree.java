package Offer;

import java.util.Arrays;

public class num06ReConstructBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
          if(pre==null||in==null){
              return null;
          }
          if(pre.length==0||in.length==0){
              return null;
          }
          if(pre.length!=in.length){
              return null;
          }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i <pre.length ; i++) {
            if(in[i]==pre[0]){
                root.left =reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right =reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }

}
