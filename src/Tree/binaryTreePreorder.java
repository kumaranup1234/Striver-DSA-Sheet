package Tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePreorder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();
        path(root, ans);
        return ans;
    }

    public static void path(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        ans.add(root.val);
        path(root.left, ans);
        path(root.right, ans);
    }
}
