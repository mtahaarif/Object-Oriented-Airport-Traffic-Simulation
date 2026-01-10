package Project;
import java.util.ArrayList;
public class AirplaneList {
    public ArrayList<Airplane> airplaneList;

    public AirplaneList()
    {
        airplaneList = new ArrayList<>();
    }

    public Airplane createAirplane()
    {
        Airplane airplane = new Airplane();
        assignRandomId(airplane);
        airplaneList.add(airplane);
        return airplane;
    }
    public void assignID(Airplane a,int id)
    {
        a.setId(id);
    }
    public void assignRandomId(Airplane a)
    {
        a.setRandomId();
    }

    public void addAirplane(Airplane a)
    {
        airplaneList.add(a);
    }

    public void removeAirplane(Airplane a)
    {
        airplaneList.remove(a);
    }

    public void sendTask(int id,String task)
    {
        for(Airplane a : airplaneList)
        {
            if(a.getId()==id)
            {
                a.task(task);
                break;
            }
        }
    }

    public Airplane getAirplane(int id)
    {
        for(Airplane a : airplaneList)
        {
            if(a.getId()==id)
            {
                return a;
            }
        }
        return null;
    }
    public int size(){
        return airplaneList.size();
    }
    public void displayallAirplanes()
    {
        for(Airplane airplane:airplaneList)
        {
            airplane.display();
            System.out.println();
        }
    }
    public int getIdbyIndex(int index)
    {
        int c =0;
        for(Airplane a : airplaneList)
        {
            if(index == c)
            {
                return a.getId();
            }
        }
     return 0; 
    }
}