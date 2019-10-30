package demo.cards;

public class Druncard {

  static int[] tails = new int[]{18, 18};
  static int[] heads = new int[2];
  static Card[][] players = new Card[2][36];

  public static void main(String... __) {

    init();

    boolean winnerFirst = true;

    do {
      Card cardOfPlayer1 = getCardOfPlayer(0);
      Card cardOfPlayer2 = getCardOfPlayer(1);

      if (cardOfPlayer1.value.ordinal() > cardOfPlayer2.value.ordinal()) {
        players[0][tails[0]++] = cardOfPlayer1;
        players[0][tails[0]++] = cardOfPlayer2;
        winnerFirst = true;
      } else if (cardOfPlayer1.value.ordinal() < cardOfPlayer2.value.ordinal()) {
        players[1][tails[1]++] = cardOfPlayer1;
        players[1][tails[1]++] = cardOfPlayer2;
        winnerFirst = false;
      } else {
        players[0][tails[0]++] = cardOfPlayer1;
        players[1][tails[1]++] = cardOfPlayer2;
      }
    } while (heads[0] != tails[0]);

    System.out.println(winnerFirst ? "Первый игрок выиграл"
                           : "Второй игрок выиграл!");

  }

  private static Card getCardOfPlayer(int index) {
    return players[index][heads[index]++];
  }

  private static void init() {
    Card[] cards = Card.cards();
    System.arraycopy(cards, 0, players[0], 0, 18);
    System.arraycopy(cards, 18, players[1], 0, 18);
  }


}
