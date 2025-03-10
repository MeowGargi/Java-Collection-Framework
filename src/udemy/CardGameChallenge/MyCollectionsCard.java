package udemy.CardGameChallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record MyCollectionsCard(Suit suit , String face, int rank) {
    public static enum Suit{
        CLUB,DIAMOND,HEART,SPADE;

        public char getImage(){
            return ( new char[] {9827 , 9830 , 9829, 9824}) [this.ordinal()];
        }
    }

    public static Comparator<MyCollectionsCard> sortedRankReversedSuit(){
        return Comparator.comparing(MyCollectionsCard:: rank).reversed().thenComparing(MyCollectionsCard:: suit);
    }

    @Override
    public String toString(){
        int index = face.equals("10")?2:1;
        return "%s%c(%d)".formatted(face,suit.getImage(),rank);
    }

    public static MyCollectionsCard NumericCard(Suit suit , int cardNumber){
        if( cardNumber > 1 && cardNumber < 11) {
            return new MyCollectionsCard(suit, String.valueOf(cardNumber), cardNumber - 2);
        }
        else {
            System.out.println("Invalid Number Selected!");
            return null;
        }
        }
    public static MyCollectionsCard faceCard(Suit suit , char abbrev){
        int index = "JQKA".indexOf(abbrev);
        if( index > -1){
            return new MyCollectionsCard(suit," "+ abbrev,index+9);
        }
        System.out.println("Invalid Face udemy.CardGameChallenge.Card detected!\234");
        return null;
    }

    public static List<MyCollectionsCard> StandardDeck(){
        List<MyCollectionsCard> deck = new ArrayList<>(52);
        for(Suit suit : Suit.values()){
            for( int i = 2 ; i < 11 ; i++) {
                deck.add(NumericCard(suit, i));
            }
            for( char c : new char[]{'J','Q','K','A'}){
                deck.add(faceCard(suit,c));
            }
        }

      return deck;
    }

    public void dealer(MyCollectionsCard card){
        List<MyCollectionsCard> shuffle = new ArrayList<>(StandardDeck());
        System.out.println(shuffle);

    }
    public static void printDeck(List<MyCollectionsCard> deck){
        printDeck(deck, "Current Deck" ,  4);
    }


    public static void printDeck(List<MyCollectionsCard>deck , String description , int rows){
        System.out.println( "_______________________________________"
        );
        if( description != null){
            System.out.println(description);
        }
        int cardsInRow = deck.size() / rows;
        for( int i = 0 ; i <  rows ; i++){
            int startIndex = i * cardsInRow;
            int endIndex = startIndex + cardsInRow;
            deck.subList(startIndex, endIndex).forEach(c-> System.out.print(c + " "));
            System.out.println();
        }
    }
}

