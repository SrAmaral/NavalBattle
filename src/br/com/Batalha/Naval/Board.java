package br.com.Batalha.Naval;


public class Board {

    public static String boardTabPlayer[][] = new String [11][11];
    public static String boardTabEnyme[][] = new String [11][11];

    public static int countShipPlayer = 0;
    public static int countShipEnemy = 0;

    public static int getCountShipPlayer() {
        return countShipPlayer;
    }

    public static void setCountShipPlayer(int countShipPlayer) {
        Board.countShipPlayer = countShipPlayer;
    }

    public static int getCountShipEnemy() {
        return countShipEnemy;
    }

    public static void setCountShipEnemy(int countShipEnemy) {
        Board.countShipEnemy = countShipEnemy;
    }

    public static String[][] getBoardPlayer() {
        return boardTabPlayer;
    }

    public static void setBoardPlayer(String[][] boardTab) {
        Board.boardTabPlayer = boardTab;
    }

    public static String[][] getBoardEnyme() {
        return boardTabEnyme;
    }

    public static void setBoardEnyme(String[][] boardTabEnyme) {
        Board.boardTabEnyme = boardTabEnyme;
    }

    static void renderBoard(String[][] board, PlayerType playerType) {

        String[] colLegend = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println("--------------------------------------------");
        if(playerType.name() == "PLAYER"){
            System.out.println("                  JOGADOR                   ");
        }else {
            System.out.println("                  MÁQUINA                   ");
        }
        for (int line = 0; line < board.length; line++) {
            if(line==1){
                System.out.println("--------------------------------------------");
            }else {
                System.out.println("--------------------------------------------");
            }
            for (int col = 0; col <= board.length; col++) {
                if(line == 0 && col > 0 && col < board.length){
                    System.out.printf("| %s ", col-1);
                }
                else if(col == 0 && line > 0){
                    System.out.printf("| %s ", colLegend[line]);
                }
                else if (col == board.length) {
                    System.out.printf("|\n");
                }
                else {
                    System.out.printf("| %s ", board[line][col]);
                }
            }

        }
    }
}
