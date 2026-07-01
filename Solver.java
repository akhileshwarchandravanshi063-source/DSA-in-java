import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int[][] directions = new int[][]{{-1, 0},{1,0}, {0, 1}, {0, -1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        Queue<int[]> minDist = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){ // thief
                    dist[i][j] = 0;
                    minDist.add(new int[]{i,j});
                } 
                    
                else
                    dist[i][j] = -1;
            
            }
        }

        while(!minDist.isEmpty()){
            int[] row_col = minDist.poll();
            int row = row_col[0];
            int col = row_col[1];

            for(int[] dir: directions){
                int r = row + dir[0];
                int c = col + dir[1];

                // check bounds
                if(r < 0 || c < 0 || r >= m || c >= n || dist[r][c] != -1 )
                    continue;

                
                dist[r][c] = dist[row][col] + 1;
                minDist.add(new int[]{r, c});

                

            }
        }

        // perform Binary search to find the max path from (0,0) to (n-1, n-1)
        int left = 0, right = m + n - 1;
        int ans = 0;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(canReach(dist, mid)){ // found a valid path
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                System.out.println(dist[i][j]);
            }
        }

        
        return ans;
    }

    private boolean canReach(int[][] dist, int limit){
        int m = dist.length;
        int n = dist[0].length;
        if(dist[0][0] < limit || dist[m - 1][n - 1] < limit)
            return false;

        

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[m][n];

        queue.offer(new int[]{0, 0});
        visit[0][0] = true;


        while(!queue.isEmpty()){
            int[] row_col = queue.poll();
            int row = row_col[0];
            int col = row_col[1];

            if(row == m - 1 && col == n - 1) // path found
                return true;

            for(int[] dir: directions){
                int r = row + dir[0];
                int c = col + dir[1];

                // check bounds
                if(r < 0 || c < 0 || r >= m || c >= n || visit[r][c] )
                    continue;

                if(!visit[r][c] && dist[r][c] >= limit){ // can traverse further
                    visit[r][c] = true;
                    queue.offer(new int[]{r, c});

                }

            }

        }
        return false; // no path found
    }
}