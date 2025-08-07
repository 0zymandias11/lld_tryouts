public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol symbol){
        for(int i=0;i<board.size();i++){
            boolean hasWon = true;
            for(int j=0;j<board.size();j++){
                if(board.getSymbol(j,i)!=symbol)
                {
                    hasWon = false;
                    break; // Exit the inner loop if a mismatch is found
                }
            }
            if(hasWon) {
                return true; // Return true immediately if a winning row is found
            }
        }
        return false;
    }
}
