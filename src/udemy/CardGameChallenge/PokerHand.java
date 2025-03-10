package udemy.CardGameChallenge;

import java.util.*;

public class PokerHand {
    private List<MyCollectionsCard> hand;
    private List<MyCollectionsCard> keepers;
    private List<MyCollectionsCard> discards;
    private Ranking score = Ranking.NONE;
    private int playerNo;

    public PokerHand(int playerNo,List<MyCollectionsCard> hand) {
        hand.sort(MyCollectionsCard.sortedRankReversedSuit());
        this.hand = hand;
        this.playerNo = playerNo;
        keepers = new ArrayList<>(hand.size());
        discards = new ArrayList<>(hand.size());
    }

    @Override
    public String toString() {
        return "%d.%-16s Rank:%d %-40s Best:%-7s Worst:%-6s %s".formatted(playerNo,score,score.ordinal(),hand,Collections.max(hand, Comparator.comparing(MyCollectionsCard::rank)),Collections.min(hand,Comparator.comparing(MyCollectionsCard::rank)),(!discards.isEmpty()) ? "Discards : " + discards: " ");
    }

    private void setRank( int faceCount){
        switch(faceCount){
            case 4 -> score = Ranking.FOUR_OF_A_KIND;
            case 3 -> {
                if( score == Ranking.NONE) score = Ranking.THREE_OF_A_KIND;
                else score = Ranking.FULL_HOUSE;
            }
            case 2 ->{
                if( score == Ranking.NONE) score = Ranking.ONE_PAIR;
                else if (score == Ranking.THREE_OF_A_KIND) score = Ranking.FULL_HOUSE;
                else score = Ranking.TWO_PAIR;

            }
        }

    }
    public void evalHand(){
        List<String> faceList = new ArrayList<>(hand.size());
        hand.forEach(card -> faceList.add(card.face()));
        List<String> duplicateFaceCards = new ArrayList<>();
        faceList.forEach(face -> {
            if( !duplicateFaceCards.contains(face) &&
            Collections.frequency(faceList,face) > 1){
                duplicateFaceCards.add(face);
            }
        });
     for( String duplicate : duplicateFaceCards){
         int start = faceList.indexOf(duplicate);
         int last = faceList.lastIndexOf(duplicate);
         setRank(last - start +1);
         List<MyCollectionsCard> sub = hand.subList(start , last+1);
         keepers.addAll(sub);
     }
     pickDiscards();
    }

    private void pickDiscards(){
        List<MyCollectionsCard> temp = new ArrayList<>(hand);
        temp.removeAll(keepers);
        int rankedCards = keepers.size();
        Collections.reverse(temp);
        int index = 0;
        for( MyCollectionsCard c : temp){
            if( index++ < 3 && ( rankedCards > 2 || c.rank() < 9)) discards.add(c);
            else keepers.add(c);
        }


    }
}
