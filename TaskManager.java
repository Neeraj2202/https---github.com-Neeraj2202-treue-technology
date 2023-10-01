import java.util.Scanner;

public class TaskManager {
    private Scanner scanner;
    private TaskList taskList;

    public TaskManager() {
        scanner = new Scanner(System.in);
        taskList = new TaskList();
    }

    public void start() {
        int option;

        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addTask();
                    break;

                case 2:
                    removeTask();
                    break;

                case 3:
                    displayTasks();
                    break;

                case 4:
                    markTaskAsComplete();
                    break;

                case 5:
                    markTaskAsIncomplete();
                    break;

                case 6:
                    System.out.println("Exiting the application...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 6);
    }

    private void displayMenu() {
        System.out.println("\nTask Manager");
        System.out.println("1. Add task");
        System.out.println("2. Remove task");
        System.out.println("3. Display tasks");
        System.out.println("4. Mark task as complete");
        System.out.println("5. Mark task as incomplete");
        System.out.println("6. Exit");
        System.out.print("Enter your option: ");
    }

    private void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        Task newTask = new Task(title, description);
        taskList.addTask(newTask);

        System.out.println("Task added successfully.");
    }

    private void removeTask() {
        System.out.print("Enter task title to remove: ");
        String title = scanner.nextLine();

        if (taskList.removeTask(title)) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("No task found with the given title.");
        }
    }

    private void displayTasks() {
        List<Task> tasks = taskList.getTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    private void markTaskAsComplete() {
        System.out.print("Enter task title to mark as complete: ");
        String title = scanner.nextLine();

        if (taskList.markTaskAsComplete(title)) {
            System.out.println("Task marked as complete successfully.");
        } else {
            System.out.println("No task found with the given title.");
        }
    }

    private void markTaskAsIncomplete() {
        System.out.print("Enter task title to mark as incomplete: ");
        String title = scanner.nextLine();

        if (taskList.markTaskAsIncomplete(title)) {
            System.out.println("Task marked as incomplete successfully.");
        } else {
            System.out.println("No task found with the given title.");
        }
    }
}