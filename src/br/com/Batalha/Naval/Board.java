package br.com.Batalha.Naval;


public class Board {

    public static String boardTabPlayer[][] = new String [11][11];
    public static String boardTabEnyme[][] = new String [11][11];


    public static String[][] getBoardPlayer() {
        return boardTabPlayer;
    }

    public static void setBoardPlayer(String[][] boardTab) {
        Board.boardTabPlayer = boardTab;
    }

    public static String[][] getBoardTabEnyme() {
        return boardTabEnyme;
    }

    public static void setBoardTabEnyme(String[][] boardTabEnyme) {
        Board.boardTabEnyme = boardTabEnyme;
    }

    static void renderBoard(String[][] board, PlayerType playerType) {

        CreateShip.renderShip(PlayerType.PLAYER);
        CreateShip.renderShip(PlayerType.ENEMY);

        String[] colLegend = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println("-----------------------------------------");
        if(playerType.name() == "PLAYER"){
            System.out.println("                  JOGADOR                   ");
        }else {
            System.out.println("                  MÁQUINA                   ");
        }
        for (int line = 0; line < 11; line++) {
            if(line==1){
                System.out.println("\n-----------------------------------------");
            }else {
                System.out.println("-----------------------------------------");
            }
            for (int col = 0; col < 11; col++) {

                if(line == 0 && col > 0){
                    System.out.printf("| %s ", col-1);
                }
                else if(col == 0 && line > 0){
                    System.out.printf("| %s ", colLegend[line]);
                }
                else if (col == 10) {
                    System.out.printf("|\n");
                }
                else if(col > 0 && line > 0){
                    System.out.printf("| %s ", board[line][col]);
                }
            }

        }
    }
}
