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
  
  private static int randInt(int max){
      return (int) (Math.random() * (max+1));
  }

  public void shuffle(){
      for (int i = 0; i < deck.size(); ++i){
          int pos = randInt(i);
          Card temp = deck.get(i);
          deck.set(i, deck.get(pos));
          deck.set(pos, temp);
      }
      size = deck.size();
  };


}
