import java.util.ArrayList;

public class Deck{
  private ArrayList<Card> deck;
  private int size;

  public Deck(){
    deck = new ArrayList<Card>();
    for (Rank rank:Rank.values()){
      for (Suit suit:Suit.values()){
        deck.add(new Card(rank,suit));
      }
    }
    size = deck.size();
    shuffle();
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public int getSize(){
    return size;
  }

  public Card deal(){
    if (isEmpty()){
      return null;
    }
    size--;
    return deck.get(size);
  }

  private void shuffle(){
  };


}
