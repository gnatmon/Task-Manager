import java.util.*;

public class TaskManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }
    public void removeTask(Task task){
        tasks.remove(task);
    }
    public void displayTasks(){
        for(Task t : tasks){
            System.out.println(t.toString());
        }
    }

    public void editTask(){
        int index = -1;
        String input = "";

        while(true){
            try {
            System.out.println("Please enter the index position of the task you would like to edit:");
            String indexString = scanner.nextLine();
            index = Integer.parseInt(indexString);

            if(index >= 0 && index < tasks.size()){
                break;
            }
            else{
                System.out.println("Invalid input, please try again.");
            }
            
            } catch (NumberFormatException e) {
                System.err.println("Error: Please enter a valid number.");
            }
        }

        Task taskToEdit = tasks.get(index);

        System.out.println("Current title: " + taskToEdit.getTitle());
        System.out.print("Enter new title (leave blank to keep): ");
        input = scanner.nextLine();
        if(!input.trim().isEmpty()){
            taskToEdit.setTitle(input);
        }
        System.out.println("Current description: " + taskToEdit.getDescription());
        System.out.print("Enter new description (leave blank to keep): ");
        input = scanner.nextLine();
        if(!input.trim().isEmpty()){
            taskToEdit.setDescription(input);
            }
        System.out.println("Task updated!");

    }


    public void toggleCompletion(){
        int index = -1;
        while(true){
            try {
            System.out.println("Please enter the index position of the task you would like to chnage status of:");
            String indexString = scanner.nextLine();
            index = Integer.parseInt(indexString);

            if(index >= 0 && index < tasks.size()){
                break;
            }
            else{
                System.out.println("Invalid input, please try again.");
            }
            
            } catch (NumberFormatException e) {
                System.err.println("Error: Please enter a valid number.");
            }
        }
        Task taskToComplete = tasks.get(index);
        taskToComplete.toggleComplete();
        System.out.println("Task is now" + (taskToComplete.isComplete() ? "complete" : "incomplete") );

    }

    public void deleteTask(){
        int index = -1;
        while(true){
            try {
            System.out.println("Please enter the index position of the task you would like to delete:");
            String indexString = scanner.nextLine();
            index = Integer.parseInt(indexString);

            if(index >= 0 && index < tasks.size()){
                break;
            }
            else{
                System.out.println("Invalid input, please try again.");
            }
            
            } catch (NumberFormatException e) {
                System.err.println("Error: Please enter a valid number.");
            }
        }
        System.out.println("Delete Task: " + tasks.get(index).getTitle() + " ? Type Y for yes, anything else for no.");
        if(scanner.nextLine().equalsIgnoreCase("Y")){
            tasks.remove(index);
            System.out.println("Task deleted.");
        }
        else {
            System.out.println("Task not deleted.");

        }

        
    }
}