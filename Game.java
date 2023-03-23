import java.util.Scanner;

class Game {
    Board board;
    Player[] player;
    int noOfMoves;
    int turn;
    boolean gameOver;
    String zeroPattern;
    String crossPattern;

    static Scanner sc = new Scanner(System.in);

    Game(Board board , Player[] player){
        this.board = board;
        this.player = player;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;
        this.zeroPattern = "";
        this.crossPattern = "";
        for(int i=0 ; i<board.size ; i++){
            this.zeroPattern += 'X';
            this.crossPattern += 'O';
        }
    }

    public void play(){
        System.out.println("Game Started : \n");
        System.out.println(board);

        while(noOfMoves< board.size* board.size){
            this.noOfMoves++;
            int idxs[] = getIndex();
            int rn = idxs[0] , cn = idxs[1];
            board.board[rn][cn] = player[turn].symbol;

            if(this.noOfMoves>=2* board.size -1 && checkIfTheGameIsEnded()){
                System.out.println(board);
                this.gameOver = true;
                System.out.println("Player"+(turn+1) +" : " + player[turn].name + " has won the Game !!!");
                return;
            }
            turn = (turn+1)%2;
            System.out.println(board);
        }

        System.out.println("Game is Draw !!!");
    }
    public int[] getIndex(){
        while(true){
            System.out.println("Player"+(turn+1) +" : " + player[turn].name+"'s turn  , give index: ");
            int idx = sc.nextInt() - 1 ;
            int rn = idx/ board.size , cn = idx% board.size;
            if(rn<0 || cn<0 || rn>= board.size || cn>= board.size){
                System.out.println("Please Enter Valid Index (Index Out Of Bound).\n");
                continue;
            }
            if(board.board[rn][cn] !='-'){
                System.out.println("Position already filled , please try again . \n");
                continue;
            }
            return new int []{rn , cn};
        }
    }

    public boolean checkIfTheGameIsEnded(){
        StringBuilder sb;
//        Row checks
        for (int i = 0; i < board.size; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < board.size; j++) {
                sb.append(board.board[i][j]);
            }
            if(getResult(sb)){
                return true;
            }
        }
//        Col checks
        for (int i = 0; i < board.size; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < board.size; j++) {
                sb.append(board.board[j][i]);
            }
            if(getResult(sb)){
                return true;
            }
        }
//        Major Diagonal
        int i=0;
        int j=0;
        sb = new StringBuilder();
        while(i< board.size){
            sb.append(board.board[i][j]);
            i++;
            j++;
        }
        if(getResult(sb)){
            return true;
        }
//        Minor Diagonal
        i=0;
        j = board.size-1;
        sb = new StringBuilder();
        while(i< board.size){
            sb.append(board.board[i][j]);
            i++;
            j--;
        }
        if(getResult(sb)){
            return true;
        }

        return false;
    }
    public boolean getResult(StringBuilder sb){
        if(sb.toString().equals(zeroPattern) || sb.toString().equals(crossPattern)){
            return true;
        }
        return false;
    }

}
