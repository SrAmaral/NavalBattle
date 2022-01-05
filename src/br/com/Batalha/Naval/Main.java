package br.com.Batalha.Naval;

public class Main {

    public static void main(String[] args) {

        String boardTab[][] = new String [11][11];
        for (int i = 0; i<boardTab.length; i++){
            for (int j = 0; j<boardTab.length; j++){
                boardTab[i][j] = " ";
            }
        }
        Board.renderBoard(boardTab);
    }
}
