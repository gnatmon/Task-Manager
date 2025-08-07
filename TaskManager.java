import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public List<Task> displayTasks(){
        return tasks;
    }

    public void editTask(int index, String newTitle, String newDescription) {
        if (index < 0 || index >= tasks.size()) {
            System.out.println("Invalid index.");
            return;
        }
        Task taskToEdit = tasks.get(index);
        if(!newTitle.trim().isEmpty()){
            taskToEdit.setTitle(newTitle);
        }
        if(!newDescription.trim().isEmpty()){
            taskToEdit.setDescription(newDescription);
        }

    }

    public void toggleCompletion(int index){
        if(index < 0 || index >= tasks.size()){
            System.out.println("Invalid input, please try again.");
            return;
        }

        Task taskToComplete = tasks.get(index);
        taskToComplete.toggleComplete();
        System.out.println("Task is now " + (taskToComplete.isComplete() ? "complete" : "incomplete") );
    }

    public boolean deleteTask(int index){
        if(index < 0 || index >= tasks.size()){
            return false;
        }
        tasks.remove(index);
        return true;
        }

    public void saveTasksToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Task task : tasks) {
                writer.write(task.toFileString());
                writer.newLine();
            }
        }   
    }

    public void loadTasksFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = new Task(line);
                tasks.add(task);
            }
        }
    }

        
}
