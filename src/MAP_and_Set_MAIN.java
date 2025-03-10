import java.util.*;
public class MAP_and_Set_MAIN {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if (contacts.containsKey("Linus Van Pelt")) {
            System.out.println("Linus and I go way back , so of course I have info");
        }
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("-----------------------------------");
        List<String> list = new ArrayList<>(keysView);
        System.out.println(list);

        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));
        System.out.println("-----------------------------------");
        keysView.retainAll(List.of("Linus Van Pelt ", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        keysView.clear();
        System.out.println(contacts);

//        keysView.add("Daffy Duck"); this will give exception.
//        System.out.println(contacts);

        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));

        System.out.println(keysView);

        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k,v)-> System.out.println(v));

        System.out.println("--------------------------------");
        List<Contact> list1 = new ArrayList<>(values);
        list1.sort(Comparator.comparing(Contact::getNameLastFirst));
        list1.forEach( c-> System.out.println(c.getNameLastFirst() + ": " + c));

        System.out.println("---------------------------------");
        Contact first = list1.get(0);
        contacts.put(first.getNameLastFirst() , first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if( set.size() < contacts.keySet().size()){
            System.out.println("Duplicate Values are in my Map");
        }

        var nodeSet = contacts.entrySet();
        for( var node : nodeSet){
            System.out.println(nodeSet.getClass().getName());
            if( !node.getKey().equals(node.getValue().getName())){
                System.out.println(node.getClass().getName());
                System.out.println("Key doesn't match name: " + node.getKey() + ": " +
                        node.getValue());
            }
        }
    }
}
