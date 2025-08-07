import java.util.List;

public class Board {
    Cell[][] board;
    int size;
    int moveCount;
    List<WinningStrategy> winningStrategies;

    Board(int size, List<WinningStrategy> winningStrategies){
        this.size = size;
        this.winningStrategies = winningStrategies;
        this.board = new Cell[size][size];
        this.moveCount = 0;
        startNewGame();
    }

    int size(){
        return this.size;
    }

    Symbol getSymbol(int i, int j){
        return board[i][j].getSymbol();
    }

    void startNewGame(){
        for(int i=0;i<size();i++){
            for(int j=0;j<size();j++){
                board[i][j] = new Cell();
            }
        }
    }

    boolean isFull(){
        return moveCount == size*size;
    }

    void printBoard(){
        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size();j++){
                System.out.print(board[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    int getSize(){
        return this.size();
    }

    boolean isValidMove(int i, int j){
        if((i>=0 && i<size() && (j>=0 && j<size()) && board[i][j].isEmpty()))
            return true;
        return false;
    }

    public void setSymbol(int i, int j, Symbol symbol){
        board[i][j].setSymbol(symbol);
    }


    public boolean checkWinner(Symbol symbol){
        for(WinningStrategy winningStrategy: winningStrategies){
            if(winningStrategy.checkWinner(this, symbol)){
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col].getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
