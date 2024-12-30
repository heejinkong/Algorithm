import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] board) {
      int answer = 0;
        int n = board.length;
        int m = board[0].length;
        
        int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};
        
        boolean[][] danger = new boolean[n][m];
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) { 
                    danger[i][j] = true; 
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            danger[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!danger[i][j]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}