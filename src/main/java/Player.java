import java.util.ArrayList;
import java.util.Arrays;
/**
 * A player class thats represents a player by their name, age and cards in their hand. 
 * There are methods that return the size of the player's hand, 
 * a method that allows the player to take a card from the deck to add to their hand,
 * a method that allows the player to remove a card from their hand and add it to the discard pile,
 * a method that returns the player to return a card in their hand back into the deck 
 * a method that returns the player's name, age and cards in their hand. 
 */
public class Player {
    private String name;
    private int age;
    private ArrayList <Card> hand;
    /**
     * A constructor that takes in the a player's name age and cards to be added to their hand
     * @param name The player's name
     * @param age The player's age
     * @param card Cards that the player is going to have in their hand
     */
    public Player (String name, int age, Card[] card) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();

        if (card != null) {
            this.hand = new ArrayList<>(Arrays.asList(card));
        }
    }
    /**
     * A constructor that takes in a player's name and age and a default empty hand (no cards yet)
     * @param name The player's name
     * @param age The player's age
     */
    public Player (String name, int age) {
        this.name = name;
        this.age = age;
        this.hand = new ArrayList<>();
    }

    // Getters
    /**
     * Gets the player's name
     * @return player's name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the player's age
     * @return player's age
     */
    public int getAge(){
        return this.age;
    }
    /**
     * Get's the player's hand (their cards)
     * @return the player's hand as an array
     */
    public Card[] getHand() {
        Card[] handArray = new Card[this.hand.size()];
        return this.hand.toArray(handArray);
    }
    /**
     * A method that returns the amount of cards the player has in their hand
     * @return the size of the player's hand
     */
    public int size() {
        return this.hand.size();
    }
    /**
     * A method that allows a player to add a card from the deck into their hand
     * @param deck The deck where the player will add the card to their hand
     */
    public void draw (Deck deck) {
        if (deck != null) {
            Card drawnCard = deck.draw();
            if (drawnCard != null) {
                this.hand.add(drawnCard);
            }
        }
    }
    /**
     * A method that allows a player to remove a card from their hand and add it to the discard pile
     * @param card The card that the player wants to remove
     * @param discardPile Where the removed card is going to go
     * @return true if the card is in their hand, false otherwise
     */
    public boolean discardCard (Card card, DiscardPile discardPile) {
        if (card == null || discardPile == null) {
            return false;
        }
        for (int i = 0; i < this.hand.size(); i++) {
            if (this.hand.get(i).equals(card)) {
                discardPile.addCard(this.hand.remove(i));
                return true;
            }
        }
        return false;
    }
    /**
     * A method that allows the player to take a card in their hand and return it back into the deck 
     * @param card The card the player is going to remove from their hand
     * @param deck Where the removed card is going to go
     * @return true if the card is in their hand, false otherwise
     */
    public boolean returnCard (Card card, Deck deck) {
        if (card == null || deck == null) {
            return false;
        }
        for (int i = 0; i < this.hand.size(); i++) {
            if (this.hand.get(i).equals(card)) {
                deck.addCard(this.hand.remove(i));
                return true;
            }
        }
        return false;
    }
     /**
     * A method that returns all of the cards in the hand
     * If their are no cards in the hand, it returns just their name and age. 
     * @return all the cards in the hand in the format of: "Name, Age, Ace of hearts, King of Hearts, Queen of Hearts, Jack of Hearts, 9 of Spades."
     * (Basically puts the players name and age first and then adds a comma between each element to list all the cards)
     */
    public String toString() {
        String result = this.name + ", " + this.age + ", ";
        if (this.hand.size() == 0) {
            result += ".";
        }
        else {
            for (int i = 0; i < this.hand.size() - 1; i++) {
                result += this.hand.get(i).toString() + ", ";
            }
            result += this.hand.get(this.hand.size()-1).toString() + ".";
        }
        return result;
    }
}