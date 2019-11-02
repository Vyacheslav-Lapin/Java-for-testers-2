package demo.cards;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class Druncard {

  public static final int KOLODA = 36;

  static int[] tails = {18, 18};
  static int[] heads = new int[2];
  static Card[][] players = new Card[2][KOLODA];

  public static void main(String... __) {

    init();

    int winner;
    do {
      Card cardOfPlayer1 = getCardOfPlayer(0);
      Card cardOfPlayer2 = getCardOfPlayer(1);

      winner = cardOfPlayer1.compareTo(cardOfPlayer2);

      log.info("Игрок №1 ходит картой {}, игрок №2 - картой {}, победил{}",
          cardOfPlayer1,
          cardOfPlayer2,
          winner > 0
              ? " игрок №1"
              : winner < 0 ? " игрок №2" : "а дружба!");

      if (winner > 0) setCard(0, cardOfPlayer1, cardOfPlayer2);
      else if (winner < 0) setCard(1, cardOfPlayer1, cardOfPlayer2);
      else {
        setCard(0, cardOfPlayer1);
        setCard(1, cardOfPlayer2);
      }
    } while (heads[0] != tails[0]);

    log.info(winner > 0 ? "Первый игрок выиграл" : "Второй игрок выиграл!");

  }

  public static void setCard(int playerIndex, @NotNull Card... cards) {
    for (Card card : cards)
      players[playerIndex][next(tails, playerIndex)] = card;
  }

  private static int next(@NotNull int[] arr, int playerIndex) {
    try {
      return arr[playerIndex];
    } finally {
      arr[playerIndex] = (arr[playerIndex] + 1) % KOLODA;
    }
  }

  private static Card getCardOfPlayer(int index) {
    return players[index][next(heads, index)];
  }

  private static void init() {
    Card[] cards = Card.cards();
    System.arraycopy(cards, 0, players[0], 0, 18);
    System.arraycopy(cards, 18, players[1], 0, 18);
  }


}
