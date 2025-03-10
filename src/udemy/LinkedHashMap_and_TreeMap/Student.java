package udemy.LinkedHashMap_and_TreeMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record Course(String courseId , String name , String subject){}
record Purchase(String courseId , int studentId , double price , int yr , int dayOfYear){
    public LocalDate purchaseDate(){
        return LocalDate.ofYearDay(yr,dayOfYear);
    }
}

public class Student {
    public static int lastId = 1;

    private String name;
    private int studentId;
    private List<Course> courseList;

    public Student( String name , List<Course> courseList){
        this.name = name ;
        this.courseList = courseList;
        studentId = lastId++;
    }
    public Student( String name , Course course){
       this(name , new ArrayList<>(List.of(course)));
    }
    public int getId(){
        return studentId;
    }
    public String getName(){
        return name;
    }
    public void addCourse( Course course){
        courseList.add(course);
    }
    public String toString(){
        String[] courseNames = new String[courseList.size()];
        Arrays.setAll(courseNames , i-> courseList.get(i).name());
        return "[%d] : %s".formatted(studentId,String.join("," , courseNames));
    }

}
