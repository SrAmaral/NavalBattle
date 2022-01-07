package br.com.Batalha.Naval;

import java.util.Scanner;

public class CreateGame {

        public static void createGame() {
            CreateShip.renderShip(PlayerType.PLAYER);
            Board.renderBoard(Board.getBoardPlayer(),PlayerType.PLAYER);
            CreateShip.renderShip(PlayerType.ENEMY);

            Scanner sc = new Scanner(System.in);
            String nowShootX;
            String nowShootY;
            String auxCamp[][];


            while(true){
                auxCamp= Board.getBoardPlayer();
                System.out.println("Informe uma letra de A a J");
                nowShootY = sc.next();
                System.out.println("Informe uma numero de 0 a 9");
                nowShootX = sc.next();
                Shoot.areaShoot(auxCamp ,auxCamp[Controler.control(nowShootY)][Controler.control(nowShootX)]);
            }
        }
}
