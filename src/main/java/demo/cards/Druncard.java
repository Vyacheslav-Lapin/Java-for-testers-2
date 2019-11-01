package demo.cards;

import org.jetbrains.annotations.NotNull;

public class Druncard {

  public static final int KOLODA = 36;

  static int[] tails = new int[]{18, 18};
  static int[] heads = new int[2];
  static Card[][] players = new Card[2][KOLODA];

  public static void main(String... __) {

    init();

    boolean winnerFirst = true;

    do {
      Card cardOfPlayer1 = getCardOfPlayer(0);
      Card cardOfPlayer2 = getCardOfPlayer(1);

      int winner = cardOfPlayer1.compareTo(cardOfPlayer2);
      if (winner > 0) {
        setCard(0, cardOfPlayer1, cardOfPlayer2);
        winnerFirst = true;
      } else if (winner < 0) {
        setCard(1, cardOfPlayer1, cardOfPlayer2);
        winnerFirst = false;
      } else {
        setCard(0, cardOfPlayer1);
        setCard(1, cardOfPlayer2);
      }
    } while (heads[0] != tails[0]);

    System.out.println(winnerFirst ? "Первый игрок выиграл"
                           : "Второй игрок выиграл!");

  }

  public static void setCard(int playerIndex, @NotNull Card... cards) {
    for (Card card : cards)
      players[playerIndex][nextTail(playerIndex)] = card;
  }

  private static int nextTail(int playerIndex) {
    return tails[playerIndex] = (tails[playerIndex] + 1) % KOLODA;
  }

  private static int nextHead(int playerIndex) {
    return (heads[playerIndex] + 1) % KOLODA;
  }

  private static Card getCardOfPlayer(int index) {
    return players[index][nextHead(index)];
  }

  private static void init() {
    Card[] cards = Card.cards();
    System.arraycopy(cards, 0, players[0], 0, 18);
    System.arraycopy(cards, 18, players[1], 0, 18);
  }


}
