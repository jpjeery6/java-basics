import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10,8,0,5,3}, new int[] {2,4,1,1,3}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for (int i=0; i<position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (p, q) -> (Double.compare(p[0], q[0])));
        Stack<Double> st = new Stack<>();
        st.add(cars[position.length-1][1]);
        for (int i= position.length-2; i>=0; i--) {
            if (cars[i][1] > st.peek()) st.add(cars[i][1]);
        }
        return st.size();
    }

}
