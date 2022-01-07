package br.com.Batalha.Naval;

public class CreateGame {

        public static void createGame() {
            Board.renderBoard(Board.getBoardPlayer(), PlayerType.PLAYER);
            Board.renderBoard(Board.getBoardTabEnyme(), PlayerType.ENEMY);
        }
}
