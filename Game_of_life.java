class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i =0; i<m; i++){
            for(int j =0; j<n; j++){
                int lives = countLives(board, i, j, m, n);
                if(board[i][j] == 1 && (lives <2 || lives > 3)){
                    board[i][j] = 3;
                }
                if(board[i][j] == 0 && (lives == 3)){
                    board[i][j] = 2;
                }
            }
        }
        for(int i =0; i<m ; i++){
         for(int j = 0; j<n; j++){
             if(board[i][j] == 3){
                 board[i][j] = 0;
             }
             if(board[i][j] == 2){
                 board[i][j] = 1;
             }
             
         }
        }
        
    }
    private int countLives(int[][] board, int i, int j,int m,int n){
        int result = 0;
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        for(int [] dir: dirs){
            int r = i+ dir[0];
            int c = j +dir[1];
            if(r >= 0 && r < m && c >=0 && c < n && (board[r][c] == 1 || board[r][c] == 3))
                result++;
        }
        return result;
        
    }
}
