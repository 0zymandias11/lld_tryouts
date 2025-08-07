public class Player {
    String name;
    Symbol symbol;
    Player(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }
    
    String getName(){
        return name;
    }

    Symbol getSymbol(){
        return symbol;
    }
}
