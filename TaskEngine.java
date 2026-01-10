package Project;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;



public class TaskEngine {

    protected ArrayList<Task> tasks;
    protected ArrayList<Task> orderedTasks;

    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLACK = "\u001B[30m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String ANSI_YELLOW = "\u001B[33m";
    protected static final String ANSI_BLUE = "\u001B[34m";
    protected static final String ANSI_PURPLE = "\u001B[35m";
    protected static final String ANSI_CYAN = "\u001B[36m";
    protected static final String ANSI_WHITE = "\u001B[37m";

    TaskEngine() {
        // constructor
        tasks = new ArrayList<>();
        orderedTasks = new ArrayList<>();
    }

    public void collectTask(Task t, Airplane airplane) {
        // collect task

        Time time = new Time();
        System.out.println(ANSI_YELLOW+"the task for the airplane ID is collected: " + airplane.getId());
        System.out.println("the task for the Airplane ID is collected at the time: "+ANSI_RESET);
        time.getCurrentTime();

        //before adding the tasks to the list, we need to sort the tasks

        orderedTasks.add(t);
        taskInOrder(t);

        //adding sorted task
        tasks.add(t);
    }

    /*public void taskInOrder(Task t, Time time) {

        orderedTasks.sort(Comparator
                .comparingInt(Task -> time.hrs * 60 + time.min)
                .thenComparingInt(Task -> t.getPriority()));
        System.out.println(orderedTasks);
    }*/

    public void taskInOrder(Task t) {
        orderedTasks.add(t);

        // Sort the orderedTasks using the custom comparator
        Collections.sort(orderedTasks, new TaskComparator());
    }


public void displayOrderedTaskList() {
    for (Task t : orderedTasks) {
        System.out.println();
        System.out.println(ANSI_GREEN+"Task ID: " + t.getId());
        System.out.println("Primary Identifier: " + t.getPrimary_indentifier());
        System.out.println("Secondary Identifier: " + t.getSecond_indentifier());
        System.out.println("Priority: " + t.getPriority());
        System.out.printf("Task Start Time: ");
        t.getTaskStartTime().displayTime();
        System.out.println();

        System.out.printf("Task End Time: "+ANSI_RESET);
        t.getTaskEndTime().displayTime();
        System.out.println();
    }
}


public void dispatchTask (AirplaneList A2){
    
    Airplane A1 = new Airplane();
    int newid;
    boolean check = false;

    while(tasks.size()!=0){
        try{
        newid = A2.getIdbyIndex(0);
        A1= A2.getAirplane(newid);
        tasks.get(0).execute_task(A1,0);
        tasks.remove(0);
        A2.removeAirplane(A2.getAirplane(0));

    }catch(Exception e){
        
    }
}
}




public void pendingTask(Task t, Airplane airplane, Time time)
{
    // if the runway is not empty then the task will be sent to the end of the list.
        //true for occupied
        //false for free
        // remove the if else and added input function from time class

        tasks.remove(t);

        System.out.println("the new time of the task with flight no: "  + airplane.getId() + " is: ");

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            time.inputPendingTime();
            break;
        }

        scanner.close();

        time.setTime(time.getHrs(), time.getMin(), time.getSec());

        System.out.println("the new time of the task with flight: ");

        time.displayTime();

        //add to the end of the list
        tasks.add(t);

}

    public void deleteTask(Task t, Airplane airplane) {
        // when the time will be sent to the TaskProcess class and stored in the new ArrayList,
        // then the current task from this ArrayList will be deleted.
        System.out.println("The task with flight number " + airplane.getId() + " is deleted");
        tasks.remove(t);
    }
}
