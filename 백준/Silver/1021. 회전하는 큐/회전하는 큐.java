import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <=N; i++) {
            q.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] num = new int[M];
        for(int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for(int i = 0; i < M; i++) {
            int target = num[i];

            int idx = 0;
            for(Integer n : q) {
                if(n == target) {
                    break;
                }
                idx++;
            }
            if (idx <= q.size() / 2) {
                for (int j = 0; j < idx; j++) {
                    q.addLast(q.pollFirst());
                    cnt++;
                }
            } else {
                for (int j = 0; j < q.size() - idx; j++) {
                    q.addFirst(q.pollLast());
                    cnt++;
                }
            }
            q.pollFirst();
        }

        System.out.println(cnt);
    }
}
