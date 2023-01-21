/**
 * Enumeration to represent the rank of a playing card
 */
public enum Rank{
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(0),
    QUEEN(0),
    KING(0);

    private final int pointValue;
    
    private Rank(int pointValue){
        this.pointValue = pointValue;  
    } 
  
    /**
     * Returns the point value associated with the rank of a card
     */
    public int getPointValue(){
        return pointValue;
    } 
    
    @Override
    public String toString(){
        if (pointValue >= 2 &&  pointValue <= 10){
          return Integer.toString(pointValue);
        }
    return this.name().toLowerCase();
    }
}
