

public class Player1 {

    private String name;

    //possibly add in a card max length?
    private Card[] hand = new Card[10];

    private int numCards;

    public Player1(String aName) {

        this.name = aName;

        //set a players hand empty
        this.emptyHand();

    }

    //reset the players hand to have no cards
    public void emptyHand() {

        for (int c = 0; c < 10; c++) {
            this.hand[c] = null;
        }
        this.numCards = 0;

    }
    //adds a card to players hand
    public boolean addCard(Card aCard) {

        //prints error if card already exists
        if (this.numCards == 10) {
            System.err.printf("% hand already has 10 cards: " + "cannot add another\n", this.name);
            System.exit(1);
        }
        this.hand[this.numCards] = aCard;
        this.numCards++;

        return (this.getHandSum() <= 21);

    }
    public int getHandSum() {
        int handSum = 0;
        int cardNumber;
        int numAces = 0;

        //calculates each card contribution to the hand sum
        for (int c = 0;  c < this.numCards; c++) {

            //gets number of current card
            cardNumber = this.hand[c].getMyNumber();

            if (cardNumber == 1) { // ace card
                numAces++;
                handSum += 11;
            } else if (cardNumber > 10) { // face card

                handSum += 10;
            } else {
                handSum += cardNumber;
            }

            //if aces and sum is greater than 21 set all or some to the value of 1
            while (handSum > 21 && numAces > 0) {
                handSum -= 10;
                numAces--;
            }

        }
        return handSum;
    }

    //print out the card in the players hand
    public void printHand (boolean showFirstCard) {

        System.out.printf("%'s cards:\n", this.name);

        for(int c = 0; c < this.numCards; c++) {
            if (c == 0 && !showFirstCard) {

                System.out.println(" [hidden]");
            } else {
                System.out.printf(" %s\n", this.hand[c].toString());
            }
        }

    }
}
