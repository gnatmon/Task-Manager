// <editor-fold desc="Task logic explanation">
/*
    * This class represents a Task with a title, description, and completion status.
    * It provides methods to get and set the title and description, check if the task is complete,
    * toggle the completion status, and convert the task to a string representation.
    * The constructor initializes the title and description to empty strings and sets isComplete to false.
    * The toString method formats the task for display, indicating whether it is complete or not.
        * Overiding of toString method allows for easiest printing of task objects.
        * method checks status of isComplete and returns a string with a checkmark if complete or a space if not.
*/
// </editor-fold>

public class Task{
    private String title;
    private String description;
    private boolean isComplete;

public Task (String title, String description){
    this.title = "";
    this.description = "";
    this.isComplete = false;
}

public String getTitle(){
    return title;
}
public String getDescription(){
    return description;
}
public boolean isComplete(){
    return isComplete;
}
public void setTitle(String title){
    this.title = title;
}
public void setDescription(String description){
    this.description = description;
}
public void setIsComplete(boolean isComplete){
    this.isComplete = isComplete;
}
public void toggleComplete(){
    this.isComplete = !this.isComplete;
}
@Override
public String toString() {
    return "[" + (isComplete ? "✓" : " ") + "] " + title;
}

}