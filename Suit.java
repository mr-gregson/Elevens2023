public enum Suit{
  CLUBS,
  DIAMONDS,
  HEARTS,
  SPADES;

  @Override
  public String toString(){
    return this.name().toLowerCase();
  }
}
