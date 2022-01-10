package br.com.Batalha.Naval;
import java.util.Random;
import java.util.function.Function;

import static br.com.Batalha.Naval.Board.getCountShipEnemy;
import static br.com.Batalha.Naval.Board.getCountShipPlayer;

public class CreateShip {
    public static void renderShip(PlayerType player){
        Random randomShip = new Random();

        int localsX[] = new int[11];
        int localsY[] = new int[11];

        for (int n = 0; n < 10; n++){
                localsX[n] = Math.round(randomShip.nextInt(100)/10);
                if(localsX[n] == 0){
                    localsX[n]++;
                }
                localsY[n] = Math.round(randomShip.nextInt(100)/10);
                if(localsY[n] == 0){
                    localsY[n]++;
                }
        }


        String locale[][] = new String [11][11];
        for(int n = 0; n < 10; n++){
            if(locale[localsX[n]][localsY[n]] != "N"){
                locale[localsX[n]][localsY[n]] = "N";
            }else {
                if(localsX[n] < 11 && localsY[n] < 11){
                    locale[localsX[n+1]][localsY[n+1]] = "N";
                }else{
                    locale[localsX[n-1]][localsY[n-1]] = "N";
                }

            }

            if (player.name() == "PLAYER") {
                Board.setBoardPlayer(locale);
            } else {
                Board.setBoardEnyme(locale);
            }
        }

        if (player.name() == "PLAYER") {
            String board[][] = Board.getBoardPlayer();
            for (int line = 0; line < Board.getBoardPlayer().length; line++) {
               for (int col = 0; col < Board.getBoardPlayer().length; col++) {
                    if(board[line][col] != "N"){
                        locale[line][col] = " ";

                        Board.setBoardPlayer(locale);
                    }else {
                        Board.setCountShipPlayer(getCountShipPlayer() + 1);
                    }
                }
            }
        } else {
            String board[][] = Board.getBoardEnyme();
            for (int line = 0; line < Board.getBoardEnyme().length; line++) {
                for (int col = 0; col < Board.getBoardEnyme().length; col++) {
                    if(board[line][col] != "N"){
                        locale[line][col] = " ";

                        Board.setBoardEnyme(locale);
                    }
                    else {
                        Board.setCountShipEnemy(getCountShipEnemy() + 1);
                    }
                }
            }
        }


    }
}