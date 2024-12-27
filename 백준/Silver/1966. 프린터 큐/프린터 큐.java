import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            
            String[] arr = br.readLine().split(" ");
            Deque<int[]> q = new ArrayDeque<>();
            
            for(int i = 0 ; i < N; i++) {
                q.offer(new int[]{i, Integer.parseInt(arr[i])});
            }
            
            int print = 0;
            
            while(!q.isEmpty()){
                int[] curr = q.poll();
                boolean high = false;
                
                for(int[] doc : q) {
                    if(doc[1] > curr[1]) {
                        high = true;
                    }
                }
                
                if(high) {
                    q.offer(curr);
                } else {
                    print++;
                    if(curr[0] == M) {
                        sb.append(print).append("\n");
                    }
                }
            }
        }
        System.out.println(sb);
    }
}