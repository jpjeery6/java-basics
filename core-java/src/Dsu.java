public class Dsu {
    private int n;
    private int[] parent;
    Dsu(int n) {
        this.n = n;
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = -1;
        }
    }

    int find(int x) {
        if(parent[x]<0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    void union(int x,int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            parent[px] = py;
        }
    }
}
class Driver {
    public static void main(String[] args) {
        Dsu dsu = new Dsu(5);
        dsu.union(1,2);
        dsu.union(2,3);
        dsu.union(3,1);
        System.out.println("done");
    }

}