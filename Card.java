/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */
public class Card{

  // add the necessary instance fields here
  private Rank rank;
  private Suit suit;

   /**
     * Creates a new <code>Card</code> instance.
     *
     * @param rank  a <code>String</code> value
     *                  containing the rank of the card
     * @param suit  a <code>String</code> value
     *                  containing the suit of the card
     *                 
     */

     //* write the constructor here */

   public Card(Rank rank, Suit suit){
     this.rank = rank;
     this.suit = suit;
   }


    /**
     * Accesses this <code>Card's</code> suit.
     * @return this <code>Card's</code> suit.
     */
    public Suit getSuit(){
    return suit;
  }
     // * to be implemented in Activity 1 */

    /**
     * Accesses this <code>Card's</code> rank.
     * @return this <code>Card's</code> rank.
     */
    public Rank getRank() {
        return rank;
    }

    /** Compare this card with the argument.
     * @param otherCard the other card to compare to this
     * @return true if the rank, suit, and point value of this card
     *              are equal to those of the argument;
     *         false otherwise.
     */
    public boolean matches(Card otherCard) {
        return suit.equals(otherCard.suit) && rank.equals(otherCard.rank);
    }

    /**
     * Converts the rank, suit, and point value into a string in the format
     *     "[Rank] of [Suit] (point value = [PointValue])".
     * This provides a useful way of printing the contents
     * of a <code>Deck</code> in an easily readable format or performing
     * other similar functions.
     *
     * @return a <code>String</code> containing the rank, suit,
     *         and point value of the card.
     */

    @Override
    public String toString() {
        int pointValue = rank.getPointValue();
        String s = (pointValue <= 1)? rank.name() : Integer.toString(pointValue);
        return (s + suit.toString()).toLowerCase();
    }

  public static void main(String args[]){
    Card c1 = new Card(Rank.SIX, Suit.HEARTS);
    Card c2 = new Card(Rank.ACE, Suit.SPADES);
    Card c3 = new Card(Rank.ACE, Suit.SPADES);

    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c1.matches(c3));
    System.out.println(c2.matches(c3));

  }
}
