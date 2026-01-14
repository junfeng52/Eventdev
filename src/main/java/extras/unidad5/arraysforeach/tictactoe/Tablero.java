package extras.unidad5.arraysforeach.tictactoe;

public class Tablero {
    public int filas = 3;
    public int columnas = 3;
    public Player[][] matrix = new Player[this.filas][this.columnas];
    public Tablero(){

    }

    public void reiniciarTablero(){
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                this.matrix[y][x] = null;
            }
        }
    }

    public Player getPos(int fila, int columna) {
        return this.matrix[fila][columna];
    }

    public void setPos(Player player, int fila, int columna){
        this.matrix[fila][columna] = player;
    }

    public String[] getTablero(){
        String[] result = new String[9];
        for (int pos = 0; pos < result.length; pos++) {
            for (int fila = 0; fila < this.filas; fila++) {
                for (int columna = 0; columna < this.columnas; columna++) {
                    System.out.println(getPos(fila, columna));
                    if (getPos(fila, columna) != null){
                        result[pos] = Character.toString(getPos(fila, columna).getName());
                    }else {
                        result[pos] = " ";
                    }
                }
            }
        }
        return result;
    }
}
