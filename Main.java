package Project;
import java.util.*;
public class Main {

    public static void main(String[] args)
    {
        System.out.println("--------------------------------------------------");
        System.out.println("| Enter the number of Airplanes to be scheduled: |");
        System.out.println("--------------------------------------------------");
            
        int count;
        Scanner S1 = new Scanner(System.in);
        count = S1.nextInt();
            
        AirportGroundNetwork G1=new AirportGroundNetwork();
        ShortestPath.dijkstra(0,5);

        TaskEngine e = new TaskEngine();
        AirplaneScheduler a = new AirplaneScheduler();
        AirplaneList alist = new AirplaneList();

        for (int i=0; i<count; i++) 
            a.schedule(alist,e);

        e.displayOrderedTaskList();
        e.dispatchTask(alist);
    }
}