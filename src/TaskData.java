import java.util.*;

public class TaskData {
    private static final String ALl_Task = """
            Infrastructure, Logging, High
            Infrastructure, DB Access, Medium
            Infrastructure, Security, High
            Infrastructure, Password Policy, Medium
            Data Design, Task Table, Medium
            Data Design, Employee Table, Medium
            Data Design, Cross Reference Tables, High
            Data Design, Encryption Policy, High
            Data Access, Write Views, Low
            Data Access, Set Up Users, Low
            Data Access, Set Up Access Policy, Low 
           """;

   private static final String Ann_Tasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy,Medium, In Progress
            Research, Cloud solutions, Medium, In Progress
            Data Design, Encryption Policy, High
            Data Design, Project Table, Medium
            Data Access, Write Views,Low, In Progress
           """;
  private static  final String Bob_Tasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress
           """;
  private static final String Carols_Tasks = """
            Infrastructure, Security, High, In Progress
            Infrastructure, Password Policy, Medium
            Data Design,Encryption Policy,High
            Data Access,Write Views, Low, In Progress 
           """;

    public static Set<Task> getTasks(String owner){
        Set<Task> taskList = new HashSet<>();
        String user = ("ann , bob , carol".contains(owner.toLowerCase()))?owner: null;
        String selectedList = switch(owner.toLowerCase()){
            case "ann" -> Ann_Tasks;
            case "bob" -> Bob_Tasks;
            case "carol" -> Carols_Tasks;
            default -> ALl_Task;
        };
        for(String taskData : selectedList.split("\n")){
            String[] data = taskData.split(",");
            Arrays.asList(data).replaceAll(String::trim);

            Status status = (data.length <=3)? Status.IN_QUEUE:
                    Status.valueOf(data[3].toUpperCase().replace(' ','_'));

            Priority priority = Priority.valueOf(data[2].toUpperCase());
            taskList.add(new Task(data[0],data[1],user,priority,status));
        }
        return  taskList;

    }
}
