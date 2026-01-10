package Project;
import java.util.*;

public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        int startTime1 = task1.getTaskStartTime().getHrs() * 60 + task1.getTaskStartTime().getMin();
        int startTime2 = task2.getTaskStartTime().getHrs() * 60 + task2.getTaskStartTime().getMin();

        if (startTime1 != startTime2) {
            return Integer.compare(startTime1, startTime2);
        } else {
            return Integer.compare(task1.getPriority(), task2.getPriority());
        }
    }
}