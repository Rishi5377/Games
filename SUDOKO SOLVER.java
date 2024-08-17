class SUDOKO{
    public boolean check(char[][] board,int row,int col,int n){
        // col
        for(int i=0;i<board.length;i++){
            if(board[i][col] == (char)(n+'0')){
                return false;
            }
            if(board[row][i] == (char)(n+'0')){
                return false;
            } 
        }   
        // grid 
        int sr = 3*(row/3);
        int sc = 3*(row/3);
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j] == (char)(n+'0'));
                return false;
            }
        }
        return true;
    }
    public boolean ans(char[][] board,int row,int col){
        int nrow = 0;
        int ncol = 0;
        // To move the line ffrom one row to another
        if(col == board.length-1){
            nrow = row+1;
            ncol = 0;
        }else{
            ncol = col+1;
            nrow = 0;
        }
        if(board[row][col] == '.'){
            if(ans(board, nrow, ncol)){
                return true;
            }
        }else{
            for(int i=1;i<=9;i++){
                if(check(board, nrow, col, i)){
                    board[row][col] = (char)(i+'0');
                    if(ans(board, nrow, ncol))
                    return true;
                    else
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
   
        public void sudoko(char[][] board){
            ans(board,0,0);
        }
        
}