import java.util.Random;

public class Deck {

    //An array of cards in deck, making top card first index
    private Card [] myCards;

    //number of cards currently in the deck
    private int numCards;

    //overloaded the deck method, with a default of one deck (i.e 52 cards) and no shuffling.
    public Deck() {
        this(1, false);
    }


    //multiple deck constructor.
    public Deck(int numCardsDeck, boolean shuffle) {

        this.numCards = numCardsDeck * 52;
        this.myCards = new Card[this.numCards];

        //initiates card deck (nested loops)
        int c = 0;
        //for each deck
        for (int d = 0; d  < numCardsDeck; d++) {
            // for each suit
            for (int s = 0; s < 4; s++) {
                //for each number
                for (int n = 0; n <= 13; n++) {
                    //adds new card to deck
                    this.myCards[c] = new Card(Suit.values()[s], n);
                    c++;
                }
            }
        }
        if (shuffle) {
            this.shuffle();
        }
    }


    public void shuffle () {

        //random number generator.
        Random deck = new Random();

        //temporay card
        Card temp;

        int j;

        for (int i = 0; i < this.numCards; i++) {

            // get random card j to swap the value of i with j
            j = deck.nextInt(this.numCards);

            //do swapping of values, storing the value of i using temp
            temp = this.myCards[i];
            this.myCards[i] = this.myCards[j];
            this.myCards[j] = temp;
        }

    }

    //dealing a card from the top if the deck
    public Card dealNextCard() {

        //get the top card
        Card top = this.myCards[0];

        //shift all the sub cards to the left by one index
        for (int c = 1; c < this.myCards.length; c++)  {
            this.myCards[c-1] = this.myCards[c];
        }
        this.myCards[this.numCards-1] = null;

        //decrement cards in the deck
        this.numCards--;

        return top;

    }

    //print top cards in the deck
    public void printDeck(int numToPrint) {

        for (int c = 0; c < numToPrint; c++) {
            System.out.printf("% 3d/%d %s\n", c+1, this.numCards,
                    this.myCards[c].toString());
        }
        System.out.printf("\t\t[%d other]\n", this.numCards-numToPrint);
    }
}

