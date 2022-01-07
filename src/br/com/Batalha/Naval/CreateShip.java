package br.com.Batalha.Naval;
import java.util.Random;
import java.util.function.Function;

public class CreateShip {
    public static void renderShip(PlayerType player){
        Random randomShip = new Random();

        int localsX[] = new int[11];
        int localsY[] = new int[11];

        for (int n = 0; n < 10; n++){
                localsX[n] = (randomShip.nextInt(10));
                if(localsX[n] == 0){
                    localsX[n]++;
                }
                localsY[n] = (randomShip.nextInt(10));
                if(localsY[n] == 0){
                    localsY[n]++;
                }
        }

        String locale[][] = new String [11][11];
        for(int n = 0; n < 10; n++){
            locale[localsX[n]][localsY[n]] = "N";
            if (player.name() == "PLAYER") {
                Board.setBoardPlayer(locale);
            } else {
                Board.setBoardTabEnyme(locale);
            }
        }

        if (player.name() == "PLAYER") {
            String board[][] = Board.getBoardPlayer();
            for (int line = 0; line < Board.getBoardPlayer().length; line++) {
               for (int col = 0; col < Board.getBoardPlayer().length; col++) {
                    if(board[line][col] != "N"){
                        locale[line][col] = " ";

                        Board.setBoardPlayer(locale);
                    }
                }
            }
        } else {
            String board[][] = Board.getBoardTabEnyme();
            for (int line = 0; line < Board.getBoardTabEnyme().length; line++) {
                for (int col = 0; col < Board.getBoardTabEnyme().length; col++) {
                    if(board[line][col] != "N"){
                        locale[line][col] = " ";

                        Board.setBoardTabEnyme(locale);
                    }
                }
            }
        }


    }
}