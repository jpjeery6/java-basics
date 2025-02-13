public class DupNum {


    static int findDup(int[] arr) {
        int i=0;
        int tmp;
        while (true) {
            tmp = arr[i];
            if (arr[i] == -1) return i;
            arr[i] = -1;
            i = tmp;
        }
    }

    public static void main(String[] args) {
        // int[] arr= { 1, 2, 4, 5, 2, 1};
        int[] arr = {1, 1, 4, 5, 2, 1};
//        int[] arr= { 3,3,3,1,1,1};
        System.out.println(findDup(arr));
    }
}
