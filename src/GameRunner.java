import java.util.Scanner;

public class GameRunner {


    public static void main(String[] args) {

       //initiate game
        Scanner scan = new Scanner(System.in);
        Deck theDeck = new Deck(1,true);

        //initiate players
        Player1 me = new Player1("ME: ");
        Player1 dealer = new Player1("Dealer: ");

        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());
        me.addCard(theDeck.dealNextCard());
        dealer.addCard(theDeck.dealNextCard());

        //printing initial hands
        System.out.println("Cards are now dealt\n");
        me.printHand(true);
        dealer.printHand(false);
        System.out.println("\n");

        //flags for when each player is finished hitting
        boolean meDone = false;
        boolean dealerDone = false;
        String ans;

        while (!meDone || !dealerDone) {

            //players turn
            if (!meDone) {
                System.out.println("Hit or Stay (Enter H or S): ");
                ans = scan.next();
                System.out.println();

                //if the player hits
                if (ans.compareToIgnoreCase("H") == 0) {

                    //if player wants to hit and store whether player is busted
                    meDone = !me.addCard(theDeck.dealNextCard());
                    //prints dealers hand
                    dealer.printHand(true);
                } else {
                    //if player wants to stay is also busted
                    meDone = true;
                }
            }

            //dealers turn
            if (!dealerDone) {
                if (dealer.getHandSum() < 17) {
                    System.out.println("Dealer hits\n");
                    dealerDone = !dealer.addCard(theDeck.dealNextCard());
                    //prints hand of dealer
                    dealer.printHand(false);
                }else {
                    System.out.println("Dealer stays \n");
                    dealerDone = true;
                }
            }
            //formatting
            System.out.println();
        }
        // closing the scanner
        scan.close();

        //print final hands of player and dealer
        me.printHand(true);
        dealer.printHand(true);

        int mySum = me.getHandSum();
        int dealerSum = dealer.getHandSum();

        //player wins
        if (mySum > dealerSum && mySum <= 21 || dealerSum > 21) {
            System.out.println("your win!");
        }else {
            System.out.println("Dealer wins! Unlucky :(");
        }

    }
}
