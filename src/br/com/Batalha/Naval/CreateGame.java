package br.com.Batalha.Naval;

import java.util.Scanner;

public class CreateGame {

        public static void createGame() {
            CreateShip.renderShip(PlayerType.PLAYER);
            System.out.printf("Para o inimigo restam: %s navios \nPara o Player restam: %s navios \n", Board.getCountShipEnemy(), Board.getCountShipPlayer());
            Board.renderBoard(Board.getBoardPlayer(),PlayerType.PLAYER);
            CreateShip.renderShip(PlayerType.ENEMY);
            System.out.printf("Para o inimigo restam: %s navios \nPara o Player restam: %s navios \n", Board.getCountShipEnemy(), Board.getCountShipPlayer());
            Board.renderBoard(Board.getBoardEnyme(),PlayerType.ENEMY);


            Scanner sc = new Scanner(System.in);
            String nowShootX;
            String nowShootY;
            String enemyCamp[][];
            String playerCamp[][];


            while(true){
                enemyCamp= Board.getBoardEnyme();
                playerCamp= Board.getBoardPlayer();
                System.out.println("Informe uma letra de A a J");
                nowShootY = sc.next();
                System.out.println("Informe uma numero de 0 a 9");
                nowShootX = sc.next();
                Shoot.areaShoot(playerCamp, enemyCamp ,nowShootY, nowShootX);

                if(Board.getCountShipEnemy() == 0){
                    System.out.println("Parabens o Joagor venceu a batalha");
                    Board.renderBoard(Board.getBoardPlayer(),PlayerType.PLAYER);
                    Board.renderBoard(Board.getBoardEnyme(),PlayerType.ENEMY);
                    break;
                }else if(Board.getCountShipPlayer() == 0){
                    System.out.println("Eitaaa a maquina te venceu, seja melhora da proxima vez");
                    Board.renderBoard(Board.getBoardEnyme(),PlayerType.ENEMY);
                    Board.renderBoard(Board.getBoardPlayer(),PlayerType.PLAYER);
                    break;
                }

            }
        }
}
