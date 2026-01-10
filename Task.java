package Project;
import java.util.*;

public class Task {

    protected int id;
    protected int priority;
    protected int primary_indentifier;
    protected int second_indentifier;
    protected Time taskStartTime;
    protected Time taskEndTime;

    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLACK = "\u001B[30m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String ANSI_YELLOW = "\u001B[33m";
    protected static final String ANSI_BLUE = "\u001B[34m";
    protected static final String ANSI_PURPLE = "\u001B[35m";
    protected static final String ANSI_CYAN = "\u001B[36m";
    protected static final String ANSI_WHITE = "\u001B[37m";

    public Task(int ID, String T1, String T2){
        id=ID;
        taskStartTime = new Time();
        taskEndTime = new Time();
        taskStartTime.setTime(T1);
        taskEndTime.setTime(T2);
    }

    public Task(int id, String T1, String T2,int primary_indentifier,int second_indentifier){
        this.id = id;
        taskStartTime = new Time();
        taskEndTime = new Time();

        taskStartTime.setTime(T1);
        taskEndTime.setTime(T2);

        this.primary_indentifier = primary_indentifier;
        this.second_indentifier = second_indentifier;
        this.setPriority();
    }
    
    public Task(int id, Time T1, Time T2,int primary_indentifier,int second_indentifier){
        this.id = id;
        taskStartTime = new Time();
        taskEndTime = new Time();

        taskStartTime.setTime(T1);
        taskEndTime.setTime(T2);

        this.primary_indentifier = primary_indentifier;
        this.second_indentifier = second_indentifier;
        this.setPriority();
    }
    public Task(){
        taskStartTime = new Time();
        taskEndTime = new Time();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrimary_indentifier() {
        return primary_indentifier;
    }

    public void setPrimary_indentifier(int primary_indentifier) {
        this.primary_indentifier = primary_indentifier;
    }

    public int getSecond_indentifier() {
        return second_indentifier;
    }

    public void setSecond_indentifier(int second_indentifier) {
        this.second_indentifier = second_indentifier;
    }

    public Time getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Time taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Time getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Time taskEndTime) {
        this.taskEndTime = taskEndTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setRandomId(){
        Random random = new Random();
        int min = 1000;
        int max = 9999;

        int randomNum = random.nextInt(max - min + 1) + min;
        this.id = randomNum;
        System.out.printf("\nTask is Assigned ID: %d\n\n",this.id);

    }

    public void setPriority(){

        if(primary_indentifier==1){
            if(second_indentifier==1)
                priority = 7;
            else if(second_indentifier==2)
                priority = 5;
            else if(second_indentifier==3)
                priority = 4;
            else if(second_indentifier==4)
                priority = 3;
            else if(second_indentifier==5)
                priority = 8;
            else if(second_indentifier==6)
                priority = 9;
        }

        else if(primary_indentifier==2){
            if(second_indentifier==1)
                priority = 15;

            else if(second_indentifier==2)
                priority = 14;

            else if(second_indentifier==3)
                priority = 13;

            else if(second_indentifier==4)
                priority = 10;

            else if(second_indentifier==5)
                priority = 11;

            else if(second_indentifier==6)
                priority = 12;

        }

        else if(primary_indentifier==3){

            if(second_indentifier==1)
                priority = 2;

            else if(second_indentifier==2)
                priority = 1;

            else if(second_indentifier==3)
                priority = 6;

        }

        else if (primary_indentifier==0)
            priority = 16;
    }

    protected void execute_task(Airplane A1,int R1){
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if(primary_indentifier==1){
                    AirplaneRelatedTasks T1 = new AirplaneRelatedTasks();
                    if(second_indentifier==1){

                        System.out.println(ANSI_GREEN+"--------------------------------------------"+ANSI_RESET);
                        System.out.println(ANSI_GREEN+"| This is a Moving Task!                   |"+ANSI_RESET);
                        System.out.println(ANSI_GREEN+"| Getting Permission to Land Airplane "+A1.getId()+" |"+ANSI_RESET);
                        System.out.println(ANSI_GREEN+"--------------------------------------------"+ANSI_RESET);
                        
                        T1.land_runway(A1);

                    }

                    else if(second_indentifier==2)
                        T1.exit_runway(A1);

                    else if(second_indentifier==3)
                        T1.exit_taxiway(A1);

                    else if(second_indentifier==4){
                            System.out.println(ANSI_GREEN+"--------------------------------------------"+ANSI_RESET);
                            System.out.println(ANSI_GREEN+"| This is Departure Task                   |"+ANSI_RESET);
                            System.out.println(ANSI_GREEN+"| Getting Permission to Move Airplane "+A1.getId()+" |"+ANSI_RESET);
                            System.out.println(ANSI_GREEN+"--------------------------------------------"+ANSI_RESET);
                            T1.exit_gate(A1);
                        }

                    else if(second_indentifier==5)
                        T1.enter_taxiway(A1);

                    else if(second_indentifier==6)
                        T1.enter_gate(A1);

                }

                else if(primary_indentifier==2){
                    TrafficNetworkRelatedTasks T2 = new TrafficNetworkRelatedTasks();

                    if(second_indentifier==1)
                        T2.closeRunway(R1);
                    else if(second_indentifier==2)
                        T2.closeTaxiway(R1);

                    else if(second_indentifier==3)
                        T2.closeGate(R1);

                    else if(second_indentifier==4)
                        T2.openRunway(R1);

                    else if(second_indentifier==5)
                        T2.openTaxiway(R1);

                    else if(second_indentifier==6)
                        T2.openGate(R1);

                }

                else if(primary_indentifier==3){
                    TrafficControlRelatedTask T3 = new TrafficControlRelatedTask();
                    if(second_indentifier==1)
                        T3.move_airplane(A1);

                    else if(second_indentifier==2)
                        T3.hold_airplane(A1);

                    else if(second_indentifier==3)
                        T3.park_airplane(A1);

                }

                timer.cancel();

            }
        };

        Calendar date = Calendar.getInstance();
        date.set(Calendar.HOUR_OF_DAY,taskStartTime.getHrs());
        date.set(Calendar.MINUTE,taskStartTime.getMin());
        date.set(Calendar.SECOND,taskStartTime.getSec());
        date.set(Calendar.MILLISECOND,0);

        //timer.schedule(task, 0);
        //timer.schedule(task, date.getTime());
        //timer.scheduleAtFixedRate(task, 0, 1000);
        timer.scheduleAtFixedRate(task, date.getTime(), 1000);
    }

    public void Landing_Task(Airplane A1 ,TaskEngine E1){

        Task T1 = new Task(A1.getId(),getTaskEndTime(),getTaskEndTime(),1,1); // land.runway
        Task T2 = new Task(A1.getId(),getTaskEndTime(),getTaskEndTime(),1,5); // enter.taxway
        Task T3 = new Task(A1.getId(),getTaskEndTime(),getTaskEndTime(),1,6); // enter.gate
        Task T4 = new Task(A1.getId(),getTaskEndTime(),getTaskEndTime(),3,3); //park

        T2.taskStartTime.addSec(10);
        T3.taskStartTime.addSec(20);
        T4.taskStartTime.addSec(30);

        T2.taskStartTime.corrector();
        T3.taskStartTime.corrector();
        T4.taskStartTime.corrector();

        T2.taskEndTime.addSec(70);
        T3.taskEndTime.addSec(80);
        T4.taskEndTime.addSec(90);

        T2.taskEndTime.corrector();
        T3.taskEndTime.corrector();
        T4.taskEndTime.corrector();

        E1.collectTask(T1, A1);
        E1.collectTask(T2, A1);
        E1.collectTask(T3, A1);
        E1.collectTask(T4, A1);

    }

    public void Departure_Task(Airplane A1 ,TaskEngine E1){

        Task T2 = new Task(A1.getId(),getTaskStartTime(),getTaskEndTime(),1,4);
        Task T3 = new Task(A1.getId(),getTaskStartTime(),getTaskEndTime(),1,3);
        Task T4 = new Task(A1.getId(),getTaskStartTime(),getTaskEndTime(),1,2);

        T2.taskStartTime.addSec(10);
        T3.taskStartTime.addSec(20);
        T4.taskStartTime.addSec(30);

        T2.taskEndTime.addSec(10);
        T3.taskEndTime.addSec(20);
        T4.taskEndTime.addSec(30);

        T2.taskStartTime.corrector();
        T3.taskStartTime.corrector();
        T4.taskStartTime.corrector();

        T2.taskEndTime.corrector();
        T3.taskEndTime.corrector();
        T4.taskEndTime.corrector();

        E1.collectTask(T2, A1);
        E1.collectTask(T3, A1);
        E1.collectTask(T4, A1);
    }

    protected void send_to_Dispatch(){

    }


}
