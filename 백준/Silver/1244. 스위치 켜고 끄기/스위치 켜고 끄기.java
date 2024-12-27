import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N =Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            
            if(s == 1) {
                for(int j = 1; j <= N; j++) {
                    if(j % num == 0) {
                        arr[j] = (arr[j] == 1) ? 0 : 1;
                    }
                }
            } else if(s == 2) {
                arr[num] = (arr[num] == 1) ? 0 : 1;
                int left = num - 1;
                int right = num + 1;
                
                while(left >= 1 && right <= N && arr[left] == arr[right]) {
                    arr[left] = (arr[left] == 1) ? 0 : 1;
                    arr[right] = (arr[right] == 1) ? 0 : 1;
                    left--;
                    right++;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
