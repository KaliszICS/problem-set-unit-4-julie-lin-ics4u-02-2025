/**
 * @author Julie Lin
 * Card class represents a playing card with a name, suit, and value.
 * It provides methods to get the card's name, suit, and value, as well as
 * methods to compare cards to get a string representation of the card and if two cards of name, suit and value are the same.
 */
public class Card {
    // Required Instance variables 
    private String name;
    private String suit;
    private int value;

    /**
     * Constructor to create a Card object with the specified name, suit, and value.
     *
     * @param name  The name of the card (e.g., "Ace", "2", "3", etc.)
     * @param suit  The suit of the card (e.g., "Hearts", "Clubs", "Diamonds", "Spades")
     * @param value The value of the card (e.g., 1 for Ace, 2 for 2, etc.)
     */
    public Card(String name, String suit, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }
    // getters
    /**
     * Get the name of the card.
     * @return
     */
    public String getName() {
        return this.name;
    }
    /**
     * Get the suit of the card.
     * @return
     */
    public String getSuit() {
        return this.suit;
    }
    /**
     * Get the value of the card.
     * @return
     */
    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }
    @Override
    public boolean equals(Object obj) {
        Card card = (Card)obj;
        if (obj == this) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        if (card.getName().equals(this.name) && card.getSuit().equals(this.suit) && card.getValue() == this.value) {
            return true;
        }
        return false;
    }
}