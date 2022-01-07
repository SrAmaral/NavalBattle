package br.com.Batalha.Naval;

public class Shoot {
    static void areaShoot( String[][] board , String boardShoot) {
        if(boardShoot == "N"){
            System.out.println("Acertou");
        }else{
            System.out.println("Errou");
        }

        Board.renderBoard(board, PlayerType.PLAYER);
    }
}
