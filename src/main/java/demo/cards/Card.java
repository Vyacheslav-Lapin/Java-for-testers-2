package demo.cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card {

  Suit suit;
  Value value;

  public Card(Suit suit, Value value) {
    this.suit = suit;
    this.value = value;
  }

  static Card[] cards(Suit suit) {
    return new Card[] {
        new Card(suit, Value.SIX),
        new Card(suit, Value.SEVEN),
        new Card(suit, Value.EIGHT),
        new Card(suit, Value.NINE),
        new Card(suit, Value.TEN),
        new Card(suit, Value.JACK),
        new Card(suit, Value.QUEEN),
        new Card(suit, Value.KING),
        new Card(suit, Value.ACE)
    };
  }

  static Card[] cards() {
    Card[] cards = new Card[36];

    System.arraycopy(cards(Suit.CLUBS), 0, cards, 0, 9);
    System.arraycopy(cards(Suit.DIAMOND), 0, cards, 9, 9);
    System.arraycopy(cards(Suit.HEARTS), 0, cards, 18, 9);
    System.arraycopy(cards(Suit.SPADES), 0, cards, 27, 9);

//    MathArrays.shuffle(cards);
    List<Card> list = Arrays.asList(cards);
    Collections.shuffle(list);
    return list.toArray(new Card[0]);
  }
}
