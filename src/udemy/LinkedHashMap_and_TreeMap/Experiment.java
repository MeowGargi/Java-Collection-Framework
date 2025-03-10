package udemy.LinkedHashMap_and_TreeMap;

public abstract class Experiment {
    public abstract void experiment();
    public static final void wow(){
        System.out.println("using final and then as static method cannot be overriden ");
    }
}
class child extends Experiment {
    @Override
    public  void experiment(){
        System.out.println("child");
    }
//    public static void wow(){
//        System.out.println("this still throws error cuz I declared parent method final even tho it " +
//                "doesn't override that but still strange.  "); // method hiding and not overriding.
//    }
}