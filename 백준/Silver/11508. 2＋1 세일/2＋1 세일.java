import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            q.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 1;
        int sum = 0;
        while(!q.isEmpty()) {
            int num = q.poll();
            if(cnt % 3 != 0) {
                sum += num;
            }
            cnt++;
        }

        System.out.println(sum);

    }
}

