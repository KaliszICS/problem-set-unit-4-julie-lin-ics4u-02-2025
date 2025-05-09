import java.util.ArrayList;
import java.util.Arrays;
/**
 * The discard class creates a pile for discarded cards and also 
 * takes in the cards to add the the discard pile
 * There are methods that return the size of the discard pile, 
 * a method that allows you to add to the discard pile,
 * a method to remove cards from the discard pile and
 * a method that returns all the cards in the discard pile. 
 */
public class DiscardPile {
    private ArrayList<Card> discardCards;

    /**
     * Constructor to create a Discarded Cards object with the specified array of cards.
     *
     * @param cards An array of Card objects to be added to the discared cards.
     */
    public DiscardPile(Card[] cards) {
        this.discardCards = new ArrayList<>(Arrays.asList(cards));
    }
    /**
     * Consturctor that generates an empty discard pile. 
     */
    public DiscardPile() {
        this.discardCards = new ArrayList<>();
    }
    /**
     * Gets the number of discarded cards in the pile
     * @return the size of the discarded cards pile
     */
    public int size() {
        return this.discardCards.size();
    }
    /**
     * Method that adds the provided card into the discard pile.
     * @param card the card that is to be added to the discarded cards pile
     */
    public void addCard(Card card) {
        if (card != null) {
            this.discardCards.add(card);
        }
    }
    /**
     * The method which removes the specified card from the discard pile and returns it. 
     * @param card the card to be remove discarded pile
     * @return the discarded pile with the card removed, null if the card doesn't exist 
     */
    public Card removeCard(Card card) {
        if (card == null) {
            return null;
        }
        for (int i = 0; i < this.discardCards.size(); i++) {
            if (this.discardCards.get(i).equals(card)) {
                return this.discardCards.remove(i);
            }
        }
        return null;
    }
    /**
     * Method that returns an array of removed cards afrom the discard pile. 
     * If there are no cards in the discard pile, it returns an empty Card array.
     * @return Empty array if discarded pile is empty or else it return the array of removed cards.
     */
    public Card[] removeAll() {
        if (this.discardCards.size() == 0) { // Check if discard pile is empty
            return new Card[0]; // return empty array
        }
        Card [] removedCards = new Card[this.discardCards.size()]; // new array to hold the removed cards
        this.discardCards.toArray(removedCards); // copying the cards from the array list to the new array
        this.discardCards.clear(); // remove all the cards from the ArrayList
        return removedCards; // Return the array of removed cards 
    }
    /**
     * Method that returns all of the cards in the discarded pile
     * If their are no cards in the pile, it returns an empty string
     * @return all the cards in the discarded pile in the format of: "Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades."
     * (Basically adds a comma between each element to list all the cards)
     */
    public String toString() {
        if (this.discardCards.size() == 0) {
            return "";
        }
        String result = "";
        for (int i = 0; i < this.discardCards.size() - 1; i++) {
            result += this.discardCards.get(i).toString() + ", ";
        }
        result += this.discardCards.get(this.discardCards.size()-1).toString() + ".";
        return result; 
    }
}