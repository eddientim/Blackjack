public class Card {

    //validates on of four suits
    private Suit mySuit;

    //number of cards before game starts
    private int myNumber;

    //constructing a new instance of the card class.
    public Card(Suit aSuit, int aNumber) {

        this.mySuit = aSuit;

        //values outside the values of the deck
        if (aNumber >= 1 && aNumber <= 13) {
            this.myNumber = aNumber;
        } else {
            System.err.println(aNumber+ "invalid entry");
            System.exit(1);
        }
    }
    //gets number of the card. Accessible only to the 'mynumber' method.
    public int getMyNumber() {
        return myNumber;

    }
    //overriding the object class
    public String toString() {

        String numStr = "error";

        //switch statement for myNumber object.
        switch (this.myNumber){
            case 1:
                numStr = "ACE";
                break;
            case 2:
                numStr = "TWO";
                break;
            case 3:
                numStr = "THREE";
                break;
            case 4:
                numStr = "FOUR";
                break;
            case 5:
                numStr = "FIVE";
                break;
            case 6:
                numStr = "SIX";
                break;
            case 7:
                numStr = "SEVEN";
                break;
            case 8:
                numStr = "EIGHT";
                break;
            case 9:
                numStr = "NINE";
                break;
            case 10:
                numStr = "TEN";
                break;
            case 12:
                numStr = "QUEEN";
                break;
            case 13:
                numStr = "KING";
                break;
            case 14:
                numStr = "JACK";
                break;
        }

       return numStr + " of " + mySuit.toString();
    }
}

