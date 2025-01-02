import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<int[]>[] tree; 
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        tree = new ArrayList[N + 1]; 
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) { 
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); 

            tree[u].add(new int[]{v, w}); 
            tree[v].add(new int[]{u, w}); 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1]; 
            System.out.println(dfs(a, b, 0)); 
        }
    }

    private static int dfs(int curr, int target, int distance) {
        if (curr == target) {
            return distance; 
        }

        visited[curr] = true; 

        for (int[] edge : tree[curr]) {
            int next = edge[0]; 
            int weight = edge[1]; 

            if (!visited[next]) { 
                int result = dfs(next, target, distance + weight); 
                if (result != -1) { 
                    return result;
                }
            }
        }

        return -1; 
    }
}
