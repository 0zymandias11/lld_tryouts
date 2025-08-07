public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Symbol symbol){
        boolean diagonalMatch = true;

        for(int i=0;i<board.size();i++){
            if(board.getSymbol(i,i)!=symbol){
                diagonalMatch = false;
                break;
            }
        }

        if (diagonalMatch) 
            return true;

        diagonalMatch = true;

        for(int i=0;i<board.size();i++){
            if(board.getSymbol(i, board.size()-1-i)!=symbol){
                diagonalMatch = false;
                break;
            }
        }

        return diagonalMatch;
    }
}
