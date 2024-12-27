import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static char[][] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        tree = new char[N][3];


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree[i][0] = st.nextToken().charAt(0);
            tree[i][1] = st.nextToken().charAt(0);
            tree[i][2] = st.nextToken().charAt(0);
        }

        preorder_traverse(0);
        System.out.println();
        inorder_traverse(0);
        System.out.println();
        postorder_traverse(0);
    }

    private static void preorder_traverse(int node) {
        System.out.print(tree[node][0]);

        if(tree[node][1] != '.') {
            for(int i = 0; i < N; i++) {
                if(tree[node][1] == tree[i][0]) {
                    preorder_traverse(i);
                }
            }
        }

        if(tree[node][2] != '.') {
            for(int i = 0; i < N; i++) {
                if(tree[node][2] == tree[i][0]) {
                    preorder_traverse(i);
                }
            }
        }
    }

    private static void inorder_traverse(int node) {
        if(tree[node][1] != '.') {
            for(int i = 0; i < N; i++) {
                if(tree[node][1] == tree[i][0]) {
                    inorder_traverse(i);
                }
            }
        }

        System.out.print(tree[node][0]);

        if(tree[node][2] != '.') {
            for(int i = 0; i < N; i++) {
                if(tree[node][2] == tree[i][0]) {
                    inorder_traverse(i);
                }
            }
        }
    }

    private static void postorder_traverse(int node) {
        if(tree[node][1] != '.') {
            for(int i = 0; i < N; i++) {
                if(tree[node][1] == tree[i][0]) {
                    postorder_traverse(i);
                }
            }
        }

        if(tree[node][2] != '.') {
            for(int i = 0; i < N; i++) {
                if(tree[node][2] == tree[i][0]) {
                    postorder_traverse(i);
                }
            }
        }
        System.out.print(tree[node][0]);
    }
}
