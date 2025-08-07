import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int teamSize;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of players in each team (2 for 2-player game): ");
        teamSize = sc.nextInt();

        Player players[] = new Player[teamSize*2];
        players[0] = new Player("Alice", Symbol.X);
        players[1] = new Player("Bob", Symbol.O);
        
        Game game = new Game(players, 3);

        game.makeMove(0, 0);
        game.printBoard();

        game.makeMove(0, 1);
        game.printBoard();

        game.makeMove(2, 2);
        game.printBoard();

        game.makeMove(0, 2);
        game.printBoard();

        game.makeMove(1, 1);
        game.printBoard();
    }   
}
