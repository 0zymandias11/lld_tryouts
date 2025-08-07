public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol symbol){
        for(int i=0;i<board.size;i++){
            boolean hasWon = true;
            for(int j=0;j<board.size();j++){
                if(board.getSymbol(i,j) !=symbol){
                    hasWon = false;
                    return hasWon;
                }
            }
        }
        return true;
    }
}
