package Project;
import java.util.Scanner;

public class AirplaneScheduler {
    private int option;

AirplaneScheduler(){}

    public void schedule(AirplaneList Alist,TaskEngine e){

        Task newtask = new Task();

       Airplane A1 =  Alist.createAirplane();

        if(A1.getId()==0) 
            A1.setRandomId();

        Scanner S1 = new Scanner(System.in);
        int currentLocation;
        int destination;
        while(true) {
            System.out.println("Enter Current Location(0-5): ");
            currentLocation = S1.nextInt();

            if (currentLocation >= 0 && currentLocation <= 5) {
                A1.setFrom(currentLocation);
                break;
            }
            else{
                System.out.println("Invalid Location. Please Enter Again.");
            }
        }
        
        while(true) {
            System.out.println("Enter Destination(0-5): ");
            destination = S1.nextInt();

            if (destination >= 0 && destination <= 5) {
                if(destination!=currentLocation) {
                    A1.setDestination(destination);
                    A1.setTo(destination);
                    break;
                }
                else 
                    System.out.println("Destination cannot be same as Current Location!");
            }
            else
                System.out.println("Invalid Destination. Please Enter Again.");
        }

        Time departTime = new Time();
        int hrs,mins,secs;
        while (true)
        {
            try
            {
                do{
                    System.out.println("Enter Departure Time in Hours: ");
                    hrs = S1.nextInt();
                    departTime.setHrs(hrs);
                }while(hrs<0 || hrs>24);

                do {
                    System.out.println("Enter Departure Time in Mins: ");
                    mins = S1.nextInt();
                    departTime.setMin(mins);
                }while(mins<0 || mins>60);

                do {
                    System.out.println("Enter Departure Time in Seconds: ");
                    secs = S1.nextInt();
                    departTime.setSec(secs);
                }while(secs<0 || secs>60);
                break;
            }
            catch (Exception e1)
            {
                System.out.println("Invalid Entry. Try Again");
            }
        }
        newtask.setTaskStartTime(departTime);

        int newsec = secs;
        int newmin = mins;
        int newhrs = hrs;



        newmin = newmin + ShortestPath.dijkstra(currentLocation,destination);
        if(newmin>59){
            newmin = newmin-60;
            newhrs +=1;
        }
        newtask.getTaskEndTime().setHrs(newhrs);
        newtask.getTaskEndTime().setMin(newmin);
        newtask.getTaskEndTime().setSec(newsec);
        A1.costCalculator();

        
        newtask.setPriority();
        Alist.addAirplane(A1);
        newtask.Landing_Task(A1 ,e);
        newtask.Departure_Task(A1,e);


    }
}
