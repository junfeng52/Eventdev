package extras.unidad5.arraysforeach.tictactoe;

public class Player {
    private char name;

    public Player(char name){
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return Character.toString(this.name);
    }
}
