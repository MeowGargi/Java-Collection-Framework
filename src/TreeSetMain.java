import com.sun.source.tree.Tree;

import java.util.*;
public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone") ;
        List<Contact> emails = ContactData.getData("email") ;


        // HERE IT THROWS THE EXCEPTION THAT CONTACT CLASS CANNOT BE CAST AS IT SHOULD IMPLEMENT COMPARABLE FOR IT AS ONLY KNOWN ELEMENTS
        // TO THE TREESET IS CLASSES LIKE STRINGS AND NUMBERS ETC WRAPPER CLASSES.
        //NavigableSet<Contact> sorted = new TreeSet<>(phones);
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact>sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);
        System.out.println("------------------------------------");

        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c-> justNames.add(c.getName()));
        System.out.println(justNames);
        System.out.println("------------------------------------");

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        System.out.println("------------------------------------");
        List<Contact> fullList = new ArrayList<>();
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("------------------------------------");
        fullList.forEach(System.out::println);

        System.out.println("------------------------------------");

        Contact min = Collections.min(fullSet , fullSet.comparator());
        Contact max = Collections.max(fullSet,fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("------------------------------------");
        System.out.printf("min = %s, first=%s %n" , min.getName(),first.getName());
        System.out.printf("max = %s, last=%s %n" , max.getName(),last.getName());
        System.out.println("------------------------------------");

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("--------------------------------------");

        Contact daffy =  new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        for (Contact c : List.of(daffy, daisy, last, snoopy)) {
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }
        System.out.println("----------------------------------------");

        for(Contact c : List.of(daffy , daisy , first , archie)){
            System.out.printf("floor(%s)=%s%n" , c.getName(),fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(),fullSet.lower(c));
        }
        System.out.println("----------------------------------------");

        NavigableSet<Contact> descendingSet =  fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("-----------------------------------------");

        Contact lastContact = descendingSet.pollLast(); // WHEN YOU CALL THE LAST ELEMENT FROM IT THE PRINTED LIST WILL NOT HAVE THE LAST NAME
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        fullSet.forEach(System.out::println); //    IT WILL BE REMOVED FROM THE ORIGINAL SET TOO
        System.out.println("-----------------------------------------");

        Contact marion =  new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion , true); // returns elements less than maid marion
        headSet.forEach(System.out::println);                                      // NOW AFTER PASSING THE TRUE AS ANOTHER ARGUMENT IT NOW OVERRIDE EACH OTHERS METHODS
        // true means passed element for example maid marion included.
        System.out.println("-----------------------------------------");

        var tailSet = fullSet.tailSet(marion, false); // returns elements after maid marion and prints maid marion too.
        tailSet.forEach(System.out::println);
        System.out.println("-----------------------------------------");

        Contact linus = new Contact("Linus Van Pelt");
        var subset =fullSet.subSet(linus,false,marion,true);
        subset.forEach(System.out::println);


    }
    }



