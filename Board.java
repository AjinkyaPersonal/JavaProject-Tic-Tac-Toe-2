class Board {
    char board[][];
    int size;

    int count = 0;

    Board(int size){
        this.size = size;
        this.board = new char[this.size][this.size];
        for(int i=0 ; i<this.size ; i++){
            for(int j=0 ; j<this.size ; j++){
                board[i][j]= '-';
                count++;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(char arr[] : board){
            for(char c : arr){
                sb.append(c).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
