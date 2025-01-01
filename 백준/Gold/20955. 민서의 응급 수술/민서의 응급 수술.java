import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        int components = 0;
        int invalidEdges = 0; 

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int[] result = bfs(i);
                int nodes = result[0];
                int edges = result[1];

                if (edges != nodes - 1) {
                    invalidEdges += (edges - (nodes - 1)); 
                }
                components++;
            }
        }

        int neededEdges = components - 1; 
        System.out.println(neededEdges + invalidEdges);
    }

    private static int[] bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        int nodes = 0;
        int edges = 0;

        while (!q.isEmpty()) {
            int target = q.poll();
            nodes++; // 방문한 노드 개수 증가

            for (int next : list[target]) {
                edges++;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        edges /= 2;
        return new int[]{nodes, edges};
    }
}
