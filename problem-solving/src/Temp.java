import java.util.HashMap;
import java.util.Map;

public class Temp {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * Output: [3,9,20,null,null,15,7]
     */
    class Solution1 {
        int[] preorder;
        int[] inorder;
        int index;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            this.index = 0;
            return fun(0, inorder.length - 1);
        }

        public TreeNode fun(int l, int r) {
            if(l > r) {
                return null;
            }
            int mid = find(preorder[index], l, r);
            index++;
            return new TreeNode(inorder[mid], fun(l, mid - 1), fun(mid + 1, r));
        }

        public int find(int num, int l, int r) {
            for(int i = l; i <= r; i++) {
                if(num == inorder[i]) {
                    return i;
                }
            }
            return -1;
        }
    }


    // -----------
    class Solution2 {
        public TreeNode buildTree(int[] P, int[] I) {
            Map<Integer, Integer> M = new HashMap<>();
            for (int i = 0; i < I.length; i++)
                M.put(I[i], i);
            return splitTree(P, M, 0, 0, I.length-1);
        }

        private TreeNode splitTree(int[] P, Map<Integer, Integer> M, int pix, int ileft, int iright) {
            int rval = P[pix], imid = M.get(rval);
            TreeNode root = new TreeNode(rval);
            if (imid > ileft)
                root.left = splitTree(P, M, pix+1, ileft, imid-1);
            if (imid < iright)
                root.right = splitTree(P, M, pix+imid-ileft+1, imid+1, iright);
            return root;
        }
    }
}
