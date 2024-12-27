import java.util.*;
import java.io.*;

public class Main {
     public static int N;
    public static List<List<Integer>> tree = new ArrayList<>();
    public static int[] parent;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        
        dfs(1);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        
        System.out.print(sb);
    }

    private static void dfs(int curr) {
        visited[curr] = true;
        for (int child : tree.get(curr)) {
            if (!visited[child]) {
                parent[child] = curr; 
                dfs(child);  
            }
        }
    }
}