

import java.util.*;
import java.io.*;

class Solution {
public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for (int t = 1; t <= T; t++) {
            int dump = Integer.parseInt(br.readLine());
            int[] arr = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int box : arr) {
                minHeap.add(box);
                maxHeap.add(box);
            }

            for (int i = 0; i < dump; i++) {
                int min = minHeap.poll();
                int max = maxHeap.poll();

                if (max - min <= 1) {
                    minHeap.add(min);
                    maxHeap.add(max);
                    break;
                }


                minHeap.add(min + 1);
                maxHeap.add(max - 1);


                maxHeap.add(min + 1);
                minHeap.add(max - 1);
            }

            int answer = maxHeap.peek() - minHeap.peek();
            System.out.println("#" + t + " " + answer);
        }
    }
}
