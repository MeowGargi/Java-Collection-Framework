package udemy.CardGameChallenge;

import java.util.Objects;

public class PlayingCard {
    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit , String face) {
        this.suit = suit;
        this.face = face;
        this.internalHash = suit.equals("Hearts") ? 11 : suit.equals("Clubs") ? 12 : 13;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

//    @Override
//    public int hashCode() {
//        return internalHash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        System.out.println("Checking Playing udemy.CardGameChallenge.Card equality");
//        return true;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;

        if(!Objects.equals(suit, that.suit))return false;
        return Objects.equals(face, that.suit) ;
    }

    @Override
    public int hashCode() {
        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + ( face != null ? face.hashCode() : 0) ;
        return result;
    }
}
