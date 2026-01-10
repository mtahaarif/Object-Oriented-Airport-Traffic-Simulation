package Project;
import java.text.SimpleDateFormat;
import java.util.*;
public class Time {
    private int hrs;
    private int min;
    private int sec;

    public  Time(){
        hrs = 0;
        min = 0;
        sec = 0;
    }
    public void setTime(int a, int b, int c){
        hrs = a;
        min = b;
        sec = c;
        corrector();

    }
    public void getCurrentTime(){

        Date D1=new Date();
        SimpleDateFormat sfd = new SimpleDateFormat("hh : mm : ss");

        String dateTime=sfd.format(D1);
        String[] S1 = dateTime.split(":",3);
        hrs=Integer.parseInt(S1[0].trim());
        min=Integer.parseInt(S1[1].trim());
        sec=Integer.parseInt(S1[2].trim());

    }
    public void setTime(String time){


        String dateTime= time;
        String[] S1 = dateTime.split(":",3);
        hrs=Integer.parseInt(S1[0].trim());
        min=Integer.parseInt(S1[1].trim());
        sec=Integer.parseInt(S1[2].trim());

        corrector();
    }
    
    public void setTime(Time time){
        this.hrs=time.hrs;
        this.min=time.min;
        this.sec=time.sec;
    }

    public void corrector(){
        if (sec>59){
            sec-=60;
            min+=1;
        }
        else if (min>59){
            min-=60;
            hrs+=1;
        }

        else if (hrs>23)
            hrs-=24;
    }

    public void displayTime(){
        System.out.println(hrs + ":" + min + ":" + sec);
    } 
    public void setSec(int sec){
        this.sec = sec;
        corrector();

    }      
    public void setHrs(int hrs){
        this.hrs = hrs;
        corrector();
    }
    public void setMin(int min){
        this.min = min;
        corrector();

    }
    public void addSec(int s){
        this.sec += s;
        corrector();

    }  

    public int getHrs(){return hrs;}
    public int getMin(){return min;}
    public int getSec(){return sec;}

     public void inputPendingTime() // created a new function to allow for entering the pending time for the delayed task
     {
         System.out.println("enter hours for new depart time: \n");
         Scanner scanner = new Scanner(System.in);
         hrs = scanner.nextInt();
         System.out.println("and min: \n" );
         min = scanner.nextInt();
         System.out.println("and sec: \n" );
         sec = scanner.nextInt();
     }
    }