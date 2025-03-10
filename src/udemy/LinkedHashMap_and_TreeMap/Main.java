package udemy.LinkedHashMap_and_TreeMap;

import java.time.LocalDate;
import java.util.*;

public class Main {
    private static Map<String , Purchase> purchases = new LinkedHashMap<>();
    private static NavigableMap<String , Student> students = new TreeMap<>();
    public static void main(String[] args) {

        Course jmc = new Course("jmc101" , "Java Master Class" , "Java");
        Course python = new Course("pyt101" , "Python Master Class","Python");
        addPurchase("Mary Martin" , jmc,129.99);
        addPurchase("Andy Martin" , jmc, 139.99);
        addPurchase("Marty Martin" , python , 149.99);
        addPurchase("Joe Jones" , jmc , 149.99);
        addPurchase("Bill Brown" , python,119.99);

        purchases.forEach((key,value) -> System.out.println(key + ": " + value));
        System.out.println("--------------------------------");
        students.forEach((key,value) -> System.out.println(key + ": " + value));


        NavigableMap<LocalDate, List<Purchase>> datedPurchases = new TreeMap<>();
        for(Purchase p : purchases.values()){
             datedPurchases.compute(p.purchaseDate(),(pdate,plist) -> {
                 List<Purchase> list = (plist == null) ? new ArrayList<>() : plist;
                 list.add(p);
                 return list;
             });
        }
        datedPurchases.forEach((key , value) -> System.out.println(key +": " + value));


        int currentYear = LocalDate.now().getYear();
        LocalDate firstDay = LocalDate.ofYearDay(currentYear,1);
        LocalDate week1 = firstDay.plusDays(7);
        Map<LocalDate,List<Purchase>> week1Purchases = datedPurchases.headMap(week1);
        Map<LocalDate,List<Purchase>> week2Purchases = datedPurchases.tailMap(week1);

//        System.out.println("--------------------------------");
//        week1Purchases.forEach((k,v) -> System.out.println(k + ": " + v));
//        System.out.println("--------------------------------");
//        week2Purchases.forEach((k,v) -> System.out.println(k + ": " + v));

        displayStats(1,week1Purchases);
        displayStats(2,week2Purchases);
        System.out.println("_________________________");
        LocalDate lastDate = datedPurchases.lastKey();
        var previousEntry = datedPurchases.lastEntry();

        while(previousEntry !=null) {
            List<Purchase> lastDaysData = previousEntry.getValue();
            System.out.println(lastDate + " purchases : " + lastDaysData.size());

            LocalDate prevDate = datedPurchases.lowerKey(lastDate);
            previousEntry = datedPurchases.lowerEntry(lastDate);
            lastDate = prevDate;

        }
        System.out.println("________________________________");
        var reversed = datedPurchases.descendingMap();

        LocalDate firstDate =  reversed.firstKey();
        var nextEntry = reversed.firstEntry();
         while( nextEntry != null ){
             List<Purchase> lastDaysData = nextEntry.getValue();
             System.out.println(firstDate + " purchases : " + lastDaysData.size() );

             LocalDate nextDate = reversed.higherKey(firstDate);
             nextEntry = reversed.higherEntry(firstDate);
             firstDate = nextDate;
         }
        System.out.println("___________________________");
         datedPurchases.forEach((k,v) ->System.out.println( k + ": " + v));


    }
    private static void addPurchase( String name , Course course , double price){
        Student existingStudent = students.get(name);
        if( existingStudent == null){
            existingStudent = new Student(name, course);
            students.put(name,existingStudent);
        } else {
            existingStudent.addCourse(course);
        }
       // int day = purchases.size() + 1;
        int day = new Random().nextInt(1,5);
        String key = course.courseId() + "_" + existingStudent.getId();
        int year = LocalDate.now().getYear();
        Purchase purchase = new Purchase(course.courseId(), existingStudent.getId(), price,year,day);
        purchases.put(key,purchase);
    }
    private static void displayStats( int period , Map<LocalDate , List<Purchase>> periodData ){
        System.out.println("-----------------------------");
        Map<String , Integer> weeklyCount = new TreeMap<>();
        periodData.forEach((key,value) -> {
            System.out.println(key + ": " +  value);
            for( Purchase p : value){
                weeklyCount.merge(p.courseId(),1,(prev,current) -> {
                    return prev + current;
                });
            }
        });
        System.out.printf("Week %d Purchases = %s%n" , period , weeklyCount);
    }
}

