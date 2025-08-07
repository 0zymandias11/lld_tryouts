public class Cell {
    Symbol symbol;

    Cell(){
        this.symbol = null;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    public boolean isEmpty(){
        return this.symbol==null;
    }
}
