package extras.unidad4.semana14.arraysforeach.tictactoe;

import java.util.Scanner;

public class Game {
    private Tablero tablero = new Tablero();

    private Player player1 = new Player('X');
    private Player player2 = new Player('O');

    private int turno = 0;
    private Player playerTurno;
    private boolean running;

    public Game(){
        this.playerTurno = this.player1;
        this.reiniciar();
    }

    // Iniciar juego
    public void start(){
        Scanner scanner = new Scanner(System.in);
        String input;
        int fila;
        int columna;

        this.running = true;

        do{
            mostrarTablero();
            System.out.printf("Jugador %s donde quieres poner tu ficha (formato: 'y x'): ", this.playerTurno);
            input = scanner.nextLine();
            fila = Integer.parseInt(input.split(" ")[0]);
            columna = Integer.parseInt(input.split(" ")[1]);
            if(movimientoJugador(playerTurno, fila, columna)){
                if (esGanador(this.playerTurno)){
                    mostrarTablero();
                    System.out.printf("El jugador %s ha ganado.\n", this.playerTurno.getName());
                    stop();
                }else if(estaLleno()){
                    mostrarTablero();
                    System.out.println("Empate");
                    reiniciar();
                }else{
                    cambioDeTurno();
                }
            }
        }while (this.running);
    }

    // Parar juego;
    public void stop(){
        this.running = false;
    }

    // Validaciones
    public boolean estaLleno(){
        boolean result = false;
        int lleno = 0;

        for (int y = 0; y < this.tablero.filas; y++) {
            for (int x = 0; x < this.tablero.columnas; x++) {
                if (this.tablero.getPos(y, x) != null){
                    lleno++;
                }
            }
        }

        if(lleno >= 9){
            result = true;
        }

        return result;
    }

    public boolean esGanador(Player player){
        boolean result = false;
        for (int i = 0; i < 3; i++) {
            result = this.tablero.getPos(i,0) == player && this.tablero.getPos(i,1) == player && this.tablero.getPos(i,2) == player ||
                     this.tablero.getPos(0, i) == player && this.tablero.getPos(i, 1) == player && this.tablero.getPos(i, 2) == player;
        }
        result = result ||
                this.tablero.getPos(0,0) == player && this.tablero.getPos(1,1) == player && this.tablero.getPos(2,2) == player ||
                this.tablero.getPos(0,2) == player && this.tablero.getPos(1,1) == player && this.tablero.getPos(2,0) == player;
        return result;
    }

    // Movimiento jugador
    public boolean movimientoJugador(Player player, int fila, int columna){
        boolean movimientoValido = false;
        if(obtenerJugadorEn(fila, columna) == null && playerTurno == player){
            asignarJugadorEn(player, fila, columna);
            movimientoValido = true;
        }else if (playerTurno != player){
            System.out.println("No es el turno de este jugador");
        }else{
            System.out.println("Posicion no valida");
        }
        return movimientoValido;
    }

    // Mecanicas del juego
    private void cambioDeTurno(){
        if(playerTurno == player1){
            this.playerTurno = player2;
        }else{
            this.playerTurno = player1;
        }
        this.turno++;
    }

    public Player obtenerJugadorEn(int fila, int columna){
        return this.tablero.getPos(fila, columna);
    }

    public void asignarJugadorEn(Player player, int fila, int columna){
        this.tablero.setPos(player, fila, columna);
    }

    public void reiniciar(){
        this.tablero.reiniciarTablero();
    }

    // Mostrar
    public void mostrarTablero(){
        System.out.println(String.format("\n\n\n\n\nTURNO DEL JUGADOR: %s", playerTurno));
        System.out.println("  0   1   2");
        System.out.println("+---+---+---+");
        for (int fila = 0; fila < this.tablero.filas; fila++) {
            String pos1 = (obtenerJugadorEn(fila,0) != null)? Character.toString(obtenerJugadorEn(fila,0).getName()) : " ";
            String pos2= (obtenerJugadorEn(fila,1) != null)? Character.toString(obtenerJugadorEn(fila,1).getName()) : " ";
            String pos3= (obtenerJugadorEn(fila,2) != null)? Character.toString(obtenerJugadorEn(fila,2).getName()) : " ";
            System.out.printf("| %s | %s | %s | %d\n", pos1, pos2, pos3, fila);
            System.out.println("+---+---+---+");
        }
        System.out.println();

    }
}
