package Immutable_Class;

public class Main {
    public static void main(String[] args) {
//        Person jane = new Person();
//        jane.setName("Jane");
//        Person jim = new Person();
//        jim.setName("Jim");
//        Person joe = new Person();
//        joe.setName("Joe");
//        Person john = new Person();
//        john.setDob("05/05/1900");
//        john.setKids(new Person[]{jane,jim,joe});
//        System.out.println(john);
//
//        john.setName("Jacob");
//        john.setKids(new Person[]{new Person(),new Person()});
//        System.out.println(john);
         Person jane = new Person("Jane" , "01/01/1930");
         Person jim = new Person("Jim" , "02/02/1932");
         Person joe = new Person("Joe" , "03/03/1934");

         Person[] johnKids = {jane,jim,joe};
         Person john = new Person("John" , "05/05/1900", johnKids);
         System.out.println(john);

         john.setKids(new Person[]{new Person("Ann" , "04/04/1930")});
         System.out.println(john);

         Person [] kids = john.getKids();
         kids[0] = jim;
         System.out.println(john);

         kids = null;
         System.out.println(john);





    }
}
