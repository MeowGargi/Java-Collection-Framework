package udemy.CardGameChallenge;

import java.util.*;
import java.util.function.Consumer;

public class PokerGame {

    private final List<MyCollectionsCard> deck = MyCollectionsCard.StandardDeck();
    private int playerCount;
    private int cardsInHand;
    private List<PokerHand> pokerHands;
    private List<MyCollectionsCard> remainingCards;

    public PokerGame( int playerCount , int cardsInHand){
        this.playerCount = playerCount;
        this.cardsInHand = cardsInHand;
        this.pokerHands = new ArrayList<>(cardsInHand);
    }

    public void startPlay(){
        Collections.shuffle(deck);
        MyCollectionsCard.printDeck(deck);
        int randomMiddle = new Random().nextInt(15,35);
        Collections.rotate(deck,26);
        MyCollectionsCard.printDeck(deck);

        deal();
        System.out.println("------------------------------------------");
        Consumer<PokerHand> checkHand = PokerHand::evalHand;
        pokerHands.forEach(checkHand.andThen(System.out::println));
        int cardsDealt = playerCount * cardsInHand;
        int cardsRemaining = deck.size() - cardsDealt;

       // remainingCards = new ArrayList<>(cardsRemaining);
        remainingCards = new ArrayList<>(Collections.nCopies(cardsRemaining,null));
        remainingCards.replaceAll(c->deck.get(cardsDealt + remainingCards.indexOf(c)));
        MyCollectionsCard.printDeck(remainingCards,"Remaining Cards" , 2);

    }
    private void deal(){
        MyCollectionsCard[][] hands = new MyCollectionsCard[playerCount][cardsInHand];
        for( int deckIndex = 0 , i = 0 ; i < cardsInHand ; i++ ){
            for( int j = 0 ; j < playerCount ; j++){
                hands[j][i] = deck.get(deckIndex++);
            }
        }
        int playerNo = 1;
        for( MyCollectionsCard[] hand : hands){
            pokerHands.add(new PokerHand(playerNo++, Arrays.asList(hand)));
        }
    }
}
