package udemy.EnumSet_and_EnumMap;
import java.util.*;
import javax.swing.plaf.PanelUI;

public class MainEnum {
    enum WeekDay {SUNDAY , MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY}

    public static void main(String[] args){
        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(WeekDay.MONDAY,WeekDay.TUESDAY,WeekDay.THURSDAY,WeekDay.FRIDAY));

        var annsDaysSet = EnumSet.copyOf(annsWorkDays);
        System.out.println(annsDaysSet.getClass().getSimpleName());
        annsDaysSet.forEach(System.out::println); // naturally ordered
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println("--------------------------------");
        allDaysSet.forEach(System.out::println);

        Set<WeekDay> newPersonDays =  EnumSet.complementOf(annsDaysSet);
        System.out.println("______________________________________");
        newPersonDays.forEach(System.out::println);

        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY , WeekDay.FRIDAY);
        System.out.println("--------------------------------------------------");
        businessDays.forEach(System.out::println);


        Map<WeekDay , String[]> employeeMap = new EnumMap<>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Ann" , "Mary","Bob"});
        employeeMap.put(WeekDay.MONDAY,new String[]{"Mary" , "Bob"});
        employeeMap.forEach((k,v)-> System.out.println(k + ": " + Arrays.toString(v)));
    }
}
