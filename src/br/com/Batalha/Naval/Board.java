package br.com.Batalha.Naval;

public class Board {
    static void renderBoard(String[][] boardData) {
        String[] colLegend = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println("--------------------------------------------");
        System.out.println("                  JOGADOR                   ");
        System.out.println("--------------------------------------------");
        for (int line = 0; line <= boardData.length; line++) {
            if(line>0){
                System.out.println("\n--------------------------------------------");
            }
            for (int col = 0; col < boardData.length; col++) {
                if(line == 0 && col > 0){
                    System.out.printf("| %s ", col-1);
                } else {
                    if(col == 0){
                        System.out.printf("| %s ", colLegend[line]);
                    }else{
                        System.out.printf("| %s ", boardData[line][col]);
                    }
                }
                if (col == boardData.length) {
                    System.out.printf("| %s |\n", boardData[line][col]);
                }
            }

        }
    }
}
