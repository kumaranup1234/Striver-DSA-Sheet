package Tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePostorder {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans  = new ArrayList<>();
        path(root, ans);
        return ans;
    }

    public static void path(TreeNode root, List<Integer> path) {
        if (root == null) return;

        path(root.left, path);
        path(root.right, path);
        path.add(root.val);
    }
}
