import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static List<Integer>[] tree;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[u].add(v);
            tree[v].add(u);
        }

        dp = new int[N + 1][2];

        dfs(1, -1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int node, int parent) {
        dp[node][0] = 0;  
        dp[node][1] = 1; 

        for (int child : tree[node]) {
            if (child != parent) {
                dfs(child, node);

                dp[node][0] += dp[child][1];

                dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
