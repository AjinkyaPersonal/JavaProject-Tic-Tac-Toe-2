import java.util.*;
public class OnePlayerGame extends Game {
    boolean onePlayer;

    OnePlayerGame(Board board , Player player[] , boolean onePlayer){
        super(board , player);
        this.onePlayer = onePlayer;
    }

    @Override
    public int[] getIndex() {
        if(this.onePlayer && this.turn==1){
                while(true) {
                    int idx = (int)(Math.random() * (board.size* board.size -1))+1;
                    int rn = idx / board.size, cn = idx % board.size;
                    if (board.board[rn][cn] != '-') {
                        System.out.println("Position already filled , please try again . \n");
                        continue;
                    }
                    return new int[]{rn, cn};
                }
            }
        while (true) {
            System.out.println("Player" + (turn + 1) + " : " + player[turn].name + "'s turn  , give index: ");
            int idx = sc.nextInt() - 1;
            int rn = idx / board.size, cn = idx % board.size;
            if (rn < 0 || cn < 0 || rn >= board.size || cn >= board.size) {
                System.out.println("Please Enter Valid Index (Index Out Of Bound).\n");
                continue;
            }
            if (board.board[rn][cn] != '-') {
                System.out.println("Position already filled , please try again . \n");
                continue;
            }
            return new int[]{rn, cn};
        }
    }

}
