import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); 

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int M = Integer.parseInt(st.nextToken()); 

            int[] spaceMap = new int[N + 1];
            int[] carMap = new int[M + 1];
            int[] parkingArr = new int[M + 1]; 
            int total = 0;
            
            for (int i = 1; i <= N; i++) {
                spaceMap[i] = Integer.parseInt(br.readLine());
            }
            
            for (int i = 1; i <= M; i++) {
                carMap[i] = Integer.parseInt(br.readLine());
            }

            Queue<Integer> waitQueue = new LinkedList<>();
            PriorityQueue<Integer> emptyQueue = new PriorityQueue<>();
            
            for (int i = 1; i <= N; i++) {
                emptyQueue.add(i);
            }
            
            for (int i = 0; i < 2 * M; i++) {
                int car = Integer.parseInt(br.readLine());

                if (car > 0) { 
                    if (emptyQueue.isEmpty()) { 
                        waitQueue.add(car);
                    } else { 
                        int parkingNum = emptyQueue.poll();
                        parkingArr[car] = parkingNum;
                    }
                } else { 
                    int carNum = -car;
                    int parkingNum = parkingArr[carNum]; 
                    total += carMap[carNum] * spaceMap[parkingNum]; 
                    emptyQueue.add(parkingNum); 

                    
                    if (!waitQueue.isEmpty()) {
                        int waitingCar = waitQueue.poll();
                        int newParkingNum = emptyQueue.poll();
                        parkingArr[waitingCar] = newParkingNum;
                    }
                }
            }

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
