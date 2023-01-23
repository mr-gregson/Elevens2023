import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard(){
        super(BOARD_SIZE);
    }
    
    
    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    public boolean isLegal(List<Integer> selectedCards) {
        return containsPairSum11(selectedCards) || containsJQK(selectedCards);
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    public boolean anotherPlayIsPossible() {
        ArrayList<Integer> selected = new ArrayList<>();
        selected.add(0);
        selected.add(0);
        
        for (int i = 0; i < BOARD_SIZE; ++i){
            selected.set(0,i);
            for (int j = i+1; j < BOARD_SIZE; ++j){
                selected.set(1,j);
                if (containsPairSum11(selected))
                    return true;
                for (int k = j+1; k < BOARD_SIZE; ++k){
                    selected.add(k);
                    if (containsJQK(selected))
                        return true;
                    selected.remove(2);
                }
            }
        }
        return false;
    }
    
    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        if (selectedCards.size() == 2){
            Card card1 = cardAt(selectedCards.get(0));
            Card card2 = cardAt(selectedCards.get(1));
            if (card1 == null || card2 == null)
                return false;
            int pv1 = card1.getRank().getPointValue();
            int pv2 = card2.getRank().getPointValue();
            return pv1 + pv2 == 11;
        }
        return false;
    }
    

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        int[][] perms = {{0,1,2}, {0,2,1}, {1,0,2}, {1,2,0}, {2,0,1}, {2,1,0}};
        if (selectedCards.size() != 3) 
            return false;
        Card[] cards = new Card[3];
        for (int i = 0; i < 3; ++i) {
            cards[i] = cardAt(selectedCards.get(i));
            if (cards[i] == null) return false;
        }
        Rank[] ranks = new Rank[3];
        for (int i = 0; i < 3; ++i) 
            ranks[i] = cards[i].getRank();        
        for (int[] perm : perms){
            if (ranks[perm[0]] == Rank.JACK 
                && ranks[perm[1]] == Rank.QUEEN 
                && ranks[perm[2]] == Rank.KING) 
                return true; 
        }
        return false;
    }
}
