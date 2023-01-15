public enum Rank{
  ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING;

  @Override
  public String toString(){
    int ord = this.ordinal();
    if (ord >= 1 && ord <= 9){
      return Integer.toString(ord+1);
    }
    return this.name().toLowerCase();
  }

}
