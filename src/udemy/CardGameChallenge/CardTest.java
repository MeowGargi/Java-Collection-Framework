package udemy.CardGameChallenge;

import java.util.*;

public class CardTest {
    public static void main(String[] args) {


        Card[] cardArray =  new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card .printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card>acesOfHearts = Collections.nCopies(13,aceOfHearts);
        Card.printDeck(acesOfHearts , "Aces of Hearts" ,  1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB,'K');
        List<Card>kingsOfClubs = Collections.nCopies(13,kingOfClubs);
        Card.printDeck(kingsOfClubs , "Kings of Clubs" ,  1);

        Collections.addAll(cards,cardArray);
        Collections.addAll(cards,cardArray);
        Card.printDeck(cards,"udemy.CardGameChallenge.Card Collection with Aces added", 2);
        Collections.copy(cards,kingsOfClubs); // if it is empty list that is past it will throw an exception.
        Card.printDeck(cards, "udemy.CardGameChallenge.Card Collection with Kings copied" , 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards,"List Copy of Kings" , 1);

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck,"Shuffled Deck" , 4);

        Collections.reverse(deck);
        Card.printDeck(deck,"Reversed Deck of CARDS" , 4);

       var sortingAlgorithm = Comparator.comparing(Card :: rank).thenComparing(Card ::suit);
       Collections.sort(deck,sortingAlgorithm);
       Card.printDeck(deck , "Standard Deck sorted by rank , suit" , 13);
       Collections.reverse(deck);
       Card.printDeck(deck , "Sorted by rank , suit reversed:" , 13);

       List<Card> kings = new ArrayList<>(deck.subList(4,8));
       Card.printDeck(kings , "Kings in deck " , 1);

       List<Card> tens = new ArrayList<>(deck.subList(16 , 20));
       Card.printDeck(tens, "Tens in deck" ,1);

      // Collections.shuffle(deck);
       int subListIndex = Collections.indexOfSubList(deck , tens);
       System.out.println("sublist index for tens = " + subListIndex);
       System.out.println("Contains = " + deck.containsAll(tens));

       boolean disjoint = Collections.disjoint(deck,tens);
       System.out.println("disjoint = " + disjoint);

       boolean disjoint2 = Collections.disjoint(kings,tens);
       System.out.println("disjoint = " + disjoint2);

       deck.sort(sortingAlgorithm);
       Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART , 10);
       int foundIndex =  Collections.binarySearch(deck,tenOfHearts,sortingAlgorithm);
       System.out.println("Found Index = " + foundIndex);
       System.out.println("Found Index = " + deck.indexOf(tenOfHearts));
       System.out.println(deck.get(foundIndex));





    }
    }

