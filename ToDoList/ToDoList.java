package Assignments.ToDoList;

class Task {
    int id;
    String title;
    String description;
    boolean completed;

    public Task(int id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "\nTask ID: " + id +
                "\nTitle: " + title +
                "\nDescription: " + description +
                "\nStatus: " + (completed ? "Completed" : "Pending");
    }
}

