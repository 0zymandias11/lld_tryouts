import java.util.List;

public class Game {
    GameState gameState;
    Board board;
    Player[] players;
    int currentPlayer = 0;

    public Game(Player[] players, int size) {
        this.players = players;
        this.board = new Board(size, List.of(new RowWinningStrategy(), 
                                    new ColumnWinningStrategy(), 
                                    new DiagonalWinningStrategy()));
        this.gameState = GameState.InProgress;
    }

    public synchronized void makeMove(int row, int col) throws Exception{
        if(gameState !=GameState.InProgress){
            throw new Exception("Game is not in progress");
        }
        if(!board.isValidMove(row, col)){
            throw new Exception("Invalid move");
        }

        Player player = players[currentPlayer];
        Symbol symbol = player.getSymbol();
        board.setSymbol(row, col, symbol);
        board.moveCount++;

        if(board.checkWinner(symbol)){
            gameState = GameState.Win;
            System.out.println("Player " + player.getName() + " wins!");
        }

        else if(board.isFull()){
            gameState = GameState.Draw;
            System.out.println("Player " + player.getName() + " wins!");
        }
        else{
            currentPlayer = (currentPlayer + 1) % players.length;
            System.out.println("Next turn: " + players[currentPlayer].getName());
        }

    }

    public synchronized boolean resetGame(){
        board.startNewGame();
        this.gameState = GameState.InProgress;
        return true;
    }


    public void printBoard() {
        board.print();
    }
}
