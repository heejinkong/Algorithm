
import java.io.*;
import java.util.*;

public class Main{
static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph.get(n1).add(n2);
                graph.get(n2).add(n1);
            }

            visited = new boolean[N + 1];
            int treeCnt = 0;

            for(int i = 1; i < N + 1; i++) {
                if(!visited[i]) {
                    if(bfs(i)) treeCnt++;
                }
            }

            if (treeCnt == 0) {
                sb.append("Case ").append(T++).append(": No trees.");
            } else if (treeCnt == 1) {
                sb.append("Case ").append(T++).append(": There is one tree.");
            } else {
                sb.append("Case ").append(T++).append(": A forest of ").append(treeCnt).append(" trees.");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;

        int node = 0;
        int edge = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            node++;

            for (int next : graph.get(curr)) {
                edge++;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        edge /= 2;

        return edge == (node - 1) ? true : false;
    }
}
