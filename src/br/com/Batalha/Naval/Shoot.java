package br.com.Batalha.Naval;

import java.util.Random;

public class Shoot {
    static Random randomShoot = new Random();
    static int localsX;
    static int localsY;
    static int lastLocalsX;
    static int lastLocalsY;
    static boolean isEnemyHit = false;
    static void randomShootFunc() {
        localsX = (randomShoot.nextInt(10));
        localsY = (randomShoot.nextInt(10));
        if(localsX == 0){
            localsX++;
        }
        if(localsY == 0){
            localsY++;
        }
        lastLocalsX = localsX;
        lastLocalsY = localsY;
    }
    static void validEnemyShoot(String[][] playerBoard, String[][] enemyBoard) {
        if(playerBoard[localsY][localsX] == "N" && enemyBoard[localsY][localsX] == "N"){
            System.out.println("Inimigo Acertou Tiro certeiro com navio posicionado");
            enemyBoard[localsY][localsX] = "X";
            Board.setBoardEnyme(enemyBoard);
            Board.setCountShipPlayer(Board.getCountShipPlayer()-1);
        }else if(playerBoard[localsY][localsX] == " " && playerBoard[localsY][localsX] == "N"){
            System.out.println("Inimigo Errou Tiro na água com navio posicionado");
            enemyBoard[localsY][localsX] = "n";
            Board.setBoardEnyme(enemyBoard);
        }
        else if(playerBoard[localsY][localsX] == "N"){
            System.out.println("Inimigo Acertou Tiro certeiro");
            enemyBoard[localsY][localsX] = "*";
            Board.setBoardEnyme(enemyBoard);
            isEnemyHit = true;
            Board.setCountShipPlayer(Board.getCountShipPlayer()-1);
        }else if(playerBoard[localsY][localsX] == " "){
            System.out.println("Inimigo Errou Tiro na água");
            enemyBoard[localsY][localsX] = "-";
            Board.setBoardEnyme(enemyBoard);
        }
    }

    static void areaShoot( String[][] playerBoard, String[][] enemyBoard , String y, String x) {
        String boardShootEnemy =  enemyBoard[Controler.control(y)][Controler.control(x)];
        String boardShootPlayer =  playerBoard[Controler.control(y)][Controler.control(x)];
        if(boardShootEnemy == "N" && boardShootPlayer == "N"){
            System.out.println("Acertou Tiro certeiro com navio posicionado");
            playerBoard[Controler.control(y)][Controler.control(x)] = "X";
            Board.setBoardPlayer(playerBoard);
            Board.setCountShipEnemy(Board.getCountShipEnemy()-1);
        }else if(boardShootEnemy == " " && boardShootPlayer == "N"){
            System.out.println("Errou Tiro na água com navio posicionado");
            playerBoard[Controler.control(y)][Controler.control(x)] = "n";
            Board.setBoardPlayer(playerBoard);
        }
        else if(boardShootEnemy == "N"){
            System.out.println("Acertou Tiro certeiro");
            playerBoard[Controler.control(y)][Controler.control(x)] = "*";
            Board.setBoardPlayer(playerBoard);
            Board.setCountShipEnemy(Board.getCountShipEnemy()-1);
        }else if(boardShootEnemy == " "){
            System.out.println("Errou Tiro na água");
            playerBoard[Controler.control(y)][Controler.control(x)] = "-";
            Board.setBoardPlayer(playerBoard);
        }

        randomShootFunc();

        if(playerBoard[localsY][localsX] == " " || playerBoard[localsY][localsX] == "N"){
            validEnemyShoot(playerBoard, enemyBoard);
        }else {
                randomShootFunc();
                validEnemyShoot(playerBoard, enemyBoard);

        }

        String[] colLegend = {" ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        Board.renderBoard(Board.getBoardPlayer(), PlayerType.PLAYER);
        Board.renderBoard(Board.getBoardEnyme(), PlayerType.ENEMY);

        if(isEnemyHit) {
            System.out.printf("O inimigo acertou seu navio em: %s - %s\n", colLegend[localsX], localsY-1);
            isEnemyHit = false;
        }

        System.out.printf("Para o inimigo restam: %s navios \nPara o Player restam: %s navios \n", Board.getCountShipEnemy(), Board.getCountShipPlayer());
    }
}
