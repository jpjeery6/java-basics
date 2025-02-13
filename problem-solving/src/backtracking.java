import java.util.ArrayList;
import java.util.List;

public class backtracking {


        static int[] c;
        static List<List<Integer>> res;
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            c = candidates;
            res = new ArrayList<>();
            sum(0, target, new ArrayList<>());
            return res;
        }

        static void sum(int p, int remSum, List<Integer> sc) {
            if (remSum == 0) {
                res.add(new ArrayList<>(sc));
                return;
            }
            if (p == c.length) return;

            for (int i=0; c[p] *i <= remSum; i++) {
                for (int j=i;j>0; j--)
                    sc.add(c[p]);

                sum(p+1, remSum - c[p]*i, sc);

                for (int j=i;j>0; j--)
                    sc.remove(Integer.valueOf(c[p]));
            }

        }


    public static void main(String[] args) {
            int[] arr= {2,3,6,7};
            combinationSum(arr, 7);
    }
}
