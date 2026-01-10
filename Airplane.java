package Project;
import java.util.Random;

public class Airplane {
    private int id;  // Airplane ID
    private int orientation;  //angle

    private boolean land;    // checks if airplane is landed or not

    private int destination;

    private int from;

    private int to;

    private int currentPos;
    private double totalCost;

    private double costper100km = 100;
    private boolean reachedDestination;

    private int[] bestPath= new int[6];

    private boolean hold;

    private boolean park;

       Time startTime;   //time mark at which the airplane stars simulation
       Time endTime;    // plane reaches the destination


    Airplane(AirplaneList list,int id)
    {
        this.setId(id);
        list.addAirplane(this);
    }
    Airplane(AirplaneList list)
    {
        this.setRandomId();
        list.addAirplane(this);
    }

    Airplane(AirplaneList list,int id,char currentPosition,int to,int from,int destination)
    {
        this.setId(id);
        this.currentPos = currentPosition;
        this.to = to;
        this.from = from;
        this.destination = destination;
        list.addAirplane(this);
    }

    Airplane()
    {
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLand() {
        return land;
    }

    public void setLand(boolean land) {
        this.land = land;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int i) {
        this.currentPos = i;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getCostper100km() {
        return costper100km;
    }

    public void setCostper100km(double costper100km) {
        this.costper100km = costper100km;
    }

    public boolean isReachedDestination() {
        return reachedDestination;
    }

    public void setReachedDestination(boolean reachedDestination) {
        this.reachedDestination = reachedDestination;
    }

    public int[] getBestPath() {
        return bestPath;
    }

    public void setBestPath(int[] bestPath) {
        this.bestPath = bestPath;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public void setRandomId()
    {
        Random random = new Random();
        int min = 1000;
        int max = 1000000;

        int randomNum = random.nextInt(max - min + 1) + min;

        this.id = randomNum;

        System.out.printf("\nAirplane is Assigned ID: %d\n\n",this.id);

    }

    public void costCalculator()
    {
        totalCost = costper100km*ShortestPath.dijkstra(from,to);
    }

    public void task(String t)
    {

    }

    //Sohaib's bit

    public void askforpermission(AirplaneRelatedTasks t)
    {
        System.out.println("Asking for permission from air traffic controller for airplane of flight no: " + getId());
        t.land_runway(this);
    }

 //
    public void display(){
        System.out.println("Airplane ID: " +id);
        System.out.println("Orientation: " +orientation);
        System.out.println("Destination: " +destination);
        System.out.println("From: " +from);
        System.out.println("To: " +to);
        System.out.println("Current Position: " + currentPos);
        System.out.println("Destination Status: " +reachedDestination);
        System.out.println("Land Status: " +land);
        System.out.println("Total Cost: " +totalCost);
        System.out.println();
    }


    public void setHold(boolean b) {
        this.hold = b;
    }

    public void setPark(boolean b) {
        this.park = b;
    }
}


/*    public void getpermission(AirtrafficController control)
    {
        System.out.println("The permission has been given to land on the runaway!");
        permission = control.returnpermission();

        if (permission == true) {
            System.out.println("The air traffic controller has given access to land on the assigned runaway!");
        } else {
            System.out.println("The air traffic controller has denied access to land on the assigned runaway!");
        }
    } */
