package Project;

import java.util.ArrayList;

public class AirportGroundNetwork {

    protected static ArrayList<Boolean> runways = new ArrayList<Boolean>(4);
    protected static ArrayList<Integer> airplaneid_runway = new ArrayList<Integer>(4);

    protected static ArrayList<Boolean> taxiways = new ArrayList<Boolean>(12);         // FOR TELLING IF TAXIWAY IS OPEN OR NOT
    protected static ArrayList<Integer> airplaneid_taxiway = new ArrayList<Integer>(12); // FOR PUTTING AIRPLANE ID IN ITS OCCUPIED TAXIWAY NUM
    protected static ArrayList<Boolean> gates = new ArrayList<Boolean>(24);            // FOR TELLING IF GATE IS OPEN OR NOT
    protected static ArrayList<Integer> airplaneid_gate = new ArrayList<Integer>(24);   // FOR PUTTING AIRPLANE ID IN ITS OCCUPIED GATE NUM

    public AirportGroundNetwork(){
        for (int i=0; i<4; i++){
            runways.add(false);
            airplaneid_runway.add(0);
        }

        for (int i=0; i<12; i++){
            taxiways.add(false);
            airplaneid_taxiway.add(0);
        }

        for (int i=0; i<24; i++){
            gates.add(false);
            airplaneid_gate.add(0);
        }

}

public void closeRunway(int runwaynum)
    {
        if(runwaynum<runways.size() && runwaynum>=0) {
            runways.set(runwaynum, true);
        }
        else{
            System.out.println("Invalid Runway Index.");
        }
    }
public void openRunway(int runwaynum)
    {
        if(runwaynum<runways.size() && runwaynum>=0)
        {
            if(airplaneid_runway.get(runwaynum)==0)
            {
                runways.set(runwaynum,false);
            }
            else {
                System.out.println("Runway is still occupied by an Airplane. Cannot perform Operation");
            }
        }
        else{
            System.out.println("Invalid Runway Index.");
        }
    }


    public void closeTaxiway(int taxiwaynum)
    {
        if(taxiwaynum<taxiways.size() && taxiwaynum>=0) {
            taxiways.set(taxiwaynum, true);
        }
        else
        {
            System.out.println("Invalid Taxiway Index.");
        }
    }
    public void openTaxiway(int taxiwaynum)
    {
        if(taxiwaynum<taxiways.size() && taxiwaynum>=0)
        {
            if(airplaneid_taxiway.get(taxiwaynum)==0)
            {
                taxiways.set(taxiwaynum,false);
            }
            else {
                System.out.println("Taxiway is still occupied by an Airplane. Cannot perform Operation");
            }
        }
        else{
            System.out.println("Invalid Taxiway Index.");
        }
    }

    public void closeGate(int gatenum)
    {
        if(gatenum<gates.size() && gatenum>=0) {
            gates.set(gatenum, true);
        }
        else
        {
            System.out.println("Invalid Gate Index.");
        }
    }
    public void openGate(int gatenum)
    {
        if(gatenum<gates.size() && gatenum>=0)
        {
            if(airplaneid_gate.get(gatenum)==0)
            {
                gates.set(gatenum,false);
            }
            else {
                System.out.println("Gate is still occupied by an Airplane. Cannot perform Operation");
            }
        }
        else{
            System.out.println("Invalid Gate Index.");
        }
    }

    public boolean land_on_runway(Airplane a)
    {
        boolean check = false;
        for(int i=0;i<runways.size();i++)
        {
            if(runways.get(i)==false)
            {
                runways.set(i,true);
                airplaneid_runway.set(i,a.getId());
                a.setLand(true);
                System.out.println("Permission Granted!");
                System.out.printf("\nAirplane %d Landed on Runway Number %d\n",a.getId(),i);
                check = true;
                return true;
            }
        }
        if(check==false)
        {
            System.out.println("No Free Runway Found.");
            return false;
        }
        return false;
    }

    public void movetoTaxiway(Airplane airplane)
    {
        boolean check = false;
        for(int i=0;i<runways.size();i++)
        {
            if(airplaneid_runway.get(i) == airplane.getId())
            {
                for(int j=0;j<taxiways.size();i++)
                {
                    if(taxiways.get(i)==false)
                    {
                        runways.set(i,false);
                        airplaneid_runway.set(i,0);
                        taxiways.set(j,true);
                        airplaneid_taxiway.set(j,airplane.getId());
                        check = true;
                        break;
                    }
                }
                if(check==true)
                {
                    break;
                }
            }
            if(check==true)
            {
                break;
            }
        }
        if(check==false)
        {
            System.out.println("All Taxiways are currently occupied.");
        }
    }


    public void movetoGate(Airplane airplane)
    {
        boolean check = false;
        for(int i=0;i<taxiways.size();i++)
        {
            if(airplaneid_taxiway.get(i) == airplane.getId())
            {
                for(int j=0;j<gates.size();i++)
                {
                    if(gates.get(i)==false)
                    {
                        taxiways.set(i,false);
                        airplaneid_taxiway.set(i,0);
                        gates.set(j,true);
                        airplaneid_gate.set(j,airplane.getId());
                        check = true;
                        break;
                    }
                }
                if(check==true)
                {
                    break;
                }
            }
            if(check==true)
            {
                break;
            }
        }
        if(check==false)
        {
            System.out.println("All Gates are currently occupied.");
        }
    }

    public static void getrunwayInfo(){

        for(int i=0;i<runways.size();i++){
            if(runways.get(i))
                System.out.printf("Runway Number %d: Airplane #%d\n",i+1,airplaneid_runway.get(i));
            else 
                System.out.printf("Runway Number %d: Free\n",i+1);
            
        }
        System.out.println();
    }

    public void gettaxiwayInfo(){

        for(int i=0;i<taxiways.size();i++){
            if(taxiways.get(i))
                System.out.printf("Taxiway Number %d: Airplane #%d\n",i+1,airplaneid_taxiway.get(i));
            
            else 
                System.out.printf("Taxiway Number %d: Free\n",i+1);
            
        }
            System.out.println();
    }

    public void getgateInfo(){

        for(int i=0;i<gates.size();i++){
            if(gates.get(i))
                System.out.printf("Gate Number %d: Airplane #%d\n",i+1,airplaneid_gate.get(i));
            
            else 
                System.out.printf("Gate Number %d: Free\n",i+1);
            
        }
            System.out.println();

    }

}
