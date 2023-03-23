import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board :");
        int size = sc.nextInt();
        Board board = new Board(size);
        Player p[] = new Player[2];
        for (int i = 0; i < 2; i++) {

            System.out.println("Enter the name of player"+(i+1)+" :");
            String name = sc.next();
            p[i] = new Player(name);
        }

        System.out.println("Which Game would you like to play :");
        System.out.println("Enter 1 to play Two Player Game");
        System.out.println("Enter 2 to play One Player Game");
        int choice = sc.nextInt();

        switch(choice){
            case 1:{
                Game g1 = new Game(board,p);
                g1.play();
                break;
            } case 2 :{
                Game g2 = new OnePlayerGame(board , p , true);
                g2.play();
                break;
            } default:{
                break;
            }
        }

//



    }
}
