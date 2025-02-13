import java.util.Stack;

public class MaxAreaHistogram {

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        // [2,1,5,6,2,3]
        //  0 1 2 3 4 5
        // -1 -1 1 2 1 4
        //   1  6  4  4  6  6
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        // left smaller
        for (int i=0; i< heights.length; i++) {
            while(!st.empty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) left[i] = -1; else left[i] = st.peek();
            st.push(i);
        }
        st.clear();
        System.out.println(left);

        // right smaller
        for (int i= heights.length-1; i >=0; i--) {
            while(!st.empty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty()) right[i] = heights.length; else right[i] = st.peek();
            st.push(i);
        }
        System.out.println(right);

        int max = 0;
        for (int i=0; i< heights.length; i++) {
            int area = (right[i] - left[i] - 1) * heights[i];
            max = Math.max(area, max);
        }
        return max;
    }

}
