import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Deck class assigns the playing card its name, suit and value.
 * It also creates the unshuffled deck of cards - Ace through King of each suit.
 * It provides methods that return the amount of cards in the deck, returns the top card in the deck drawn and shuffles the cards in the deck
 * There are also 2 additional methods that allows adding cards to the deck and then reshuffling the deck with the added card. 
 */
public class Deck {

    private ArrayList<Card> deck;

    /**
     * Constructor to create a Deck object with the specified array of cards.
     *
     * @param cards An array of Card objects to initialize the deck.
     */
    public Deck(Card[] cards) {
        this.deck = new ArrayList<>(Arrays.asList(cards));
    }
    /**
     * Default constructor to create a standard deck of 52 playing cards.
     * The deck contains cards from four suits: Hearts, Clubs, Diamonds, and Spades.
     * Each suit contains cards numbered from Ace to King.
     */
    public Deck() {
        this.deck = new ArrayList<>();
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        String[] names = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int [] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        for (int i = 0; i < suits.length; i++) {
            String suit = suits[i];
            for (int j = 0; j < names.length; j++) {
                this.deck.add(new Card(names[j], suit, values[j]));
            }
        }
    }
    /**
     * Get the number of cards in the deck.
     *
     * @return The number of cards in the deck.
     */
    public int size() {
        return this.deck.size();
    }
    /**
     * Get the card at the top of the deck.
     *
     * @return The Card object at the specified index, or null if the index is out of bounds.
     */
    public Card draw() {
        if (this.deck.size() == 0) {
            return null;
        }
        return this.deck.remove(0); // Removes and returns the first card (For top of the deck)
    }
    /**
     * Used Google, shuffling the cards use the "Fisher-Yates Algorithm"
     * Source: https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/ 
     * Code is different as source stated above used Arrays, I am using ArrayList
     */
    public void shuffle() {

        Random random = new Random();
        for (int i = this.deck.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // generates a random index between 0 and i (inclusive)
            // swap
            Card temp = this.deck.get(i);
            this.deck.set(i, this.deck.get(j));
            this.deck.set(j, temp);
        }

    }
    /**
     * Adds a card to the deck (cards)
     * @param card the card to be added to deck
     */
    public void addCard(Card card) {
        if (card != null) {
            this.deck.add(card);
        }
    }
    /**
     * Reshuffles the deck of cards after a card has been added to the deck
     * @param cards the array of cards to be shuffled which includes the added card
     */
    public void reshuffle(Card[] cards) {
        if (cards != null) {
            for (int i = 0; i < cards.length; i++) {
                this.deck.add(cards[i]);
            }
        }
        shuffle();
    }

}