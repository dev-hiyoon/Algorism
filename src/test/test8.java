package test;

public class test8 {

    class Node {
        public int value;
        public int nextValue;

        public Node(int value, int nextValue) {
            this.value = value;
            this.nextValue = nextValue;
        }
    }

    public static void main(String[] args) {
        test8 t = new test8();
        System.out.println("################ " + t.check(new int[]{1, 3, 2, 4}, new int[]{4, 1, 3, 2}));
        System.out.println("################ " + t.check(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 3}));
        System.out.println("################ " + t.check(new int[]{1, 2, 2, 3, 3}, new int[]{2, 3, 3, 4, 5}));

    }

    public boolean check(int[] A, int[] B) {
        Node[] nodes = new Node[A.length + 1];
        nodes[0] = new Node(0, 0);
        for (int i = 0; i < A.length; i++) {
            Node n1 = new Node(A[i], B[i]);
            nodes[A[i]] = n1;

            if (nodes[B[i]] == null) {
                Node n2 = new Node(B[i], 0);
                nodes[B[i]] = n2;
            }
        }

        int cnt = 1;
        int initVal = A[0];
        int nextVal = B[0];
        while (cnt++ < A.length) {
            System.out.println("###### val: " + nextVal + ", nextVal: " + nodes[nextVal].nextValue);
            nextVal = nodes[nextVal].nextValue;
            if (nextVal == 0 || nextVal >= nodes.length || nodes[nextVal].value == initVal) {
                break;
            }
        }

        if (cnt == A.length && nodes[nextVal].value == initVal) {
            return true;
        } else {
            return false;
        }
    }
}
