package Project;
public class AirplaneRelatedTasks extends Task{

    public void land_runway(Airplane A1) {
        boolean check = false;
        for(int i = 0; i< AirportGroundNetwork.runways.size(); i++){
            if(!AirportGroundNetwork.runways.get(i) && A1.getTo()==0){

                if(A1.getTo()==0) {
                    AirportGroundNetwork.runways.set(i, true);
                    AirportGroundNetwork.airplaneid_runway.set(i, A1.getId());
                }
                A1.setLand(true);
                System.out.println(ANSI_YELLOW+"Permission to Land Airplane no. "+A1.getId()+"  Granted!"+ANSI_RESET);

                if(A1.getTo()==0) {
                    System.out.println(ANSI_YELLOW+"Now landing on "+ "Runway no. "+ (i+1)+" !"+ANSI_RESET);
                } else {
                    System.out.println(ANSI_YELLOW+"Now landing on Runway. "+ANSI_RESET);
                }
                check = true;
                break;
            }
        }
        if(A1.getTo()!=0)
        {
            System.out.println(ANSI_YELLOW+"Permission to Land Airplane no. "+A1.getId()+"  Granted!"+ANSI_RESET);
            System.out.println(ANSI_YELLOW+"Now landing on Runway. "+ANSI_RESET);
        }
        else if(!check){
            System.out.println(ANSI_RED+"------------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Permission to Land Denied! |"+ANSI_RESET);
            System.out.println(ANSI_RED+"| No Free Runway Found       |"+ANSI_RESET);
            System.out.println(ANSI_RED+"------------------------------"+ANSI_RESET);

        }
    }

    public void enter_taxiway(Airplane A1){
        boolean check = false;

        for(int i=0;i<AirportGroundNetwork.runways.size();i++){
            if(AirportGroundNetwork.airplaneid_runway.get(i) == A1.getId() && A1.getTo()==0){

                for(int j = 0; j< AirportGroundNetwork.taxiways.size(); j++){
                    if(!AirportGroundNetwork.taxiways.get(i)){

                        AirportGroundNetwork.runways.set(i,false);
                        AirportGroundNetwork.taxiways.set(j,true);
                        AirportGroundNetwork.airplaneid_runway.set(i,0);
                        AirportGroundNetwork.airplaneid_taxiway.set(j,A1.getId());

                        check = true;
                        System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Entering "+ " from Runway no. "+(i+1)+" to Taxiway no. "+(j+1)+ANSI_RESET);
                        break;
                    }
                }
                if(check) break;
            }
        }
        if(A1.getTo() != 0)
        {
            System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Entering "+ " from Runway to Taxiway"+ANSI_RESET);

        }
        else if(!check){
            System.out.println(ANSI_RED+"----------------------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Error! Task failed to Complete!      |"+ANSI_RESET);
            System.out.println(ANSI_RED+"| All Taxiways are currently occupied! |"+ANSI_RESET);
            System.out.println(ANSI_RED+"----------------------------------------"+ANSI_RESET);

        }
    }
    public void enter_gate(Airplane A1){
        boolean check = false;

        for(int i = 0; i< AirportGroundNetwork.taxiways.size(); i++){
            if(AirportGroundNetwork.airplaneid_taxiway.get(i) == A1.getId() && A1.getTo()==0){

                for(int j = 0; j< AirportGroundNetwork.gates.size(); i++){
                    if(!AirportGroundNetwork.gates.get(i)){

                        AirportGroundNetwork.taxiways.set(i,false);
                        AirportGroundNetwork.gates.set(j,true);
                        AirportGroundNetwork.airplaneid_taxiway.set(i,0);
                        AirportGroundNetwork.airplaneid_gate.set(j,A1.getId());

                        check = true;
                        System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Entering "+ " from Taxiway no. "+(i+1)+" to Gate no. "+(j+1)+ANSI_RESET);
                        break;
                    }
                }
                if(check) break;
            }

        }
        if(A1.getTo() != 0)
        {
            System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Entering from Taxiway to Gate."+ANSI_RESET);

        }
        else if(!check){
            System.out.println(ANSI_RED+"-------------------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Error! Task failed to Complete!   |"+ANSI_RESET);
            System.out.println(ANSI_RED+"| All Gates are currently occupied! |"+ANSI_RESET);
            System.out.println(ANSI_RED+"-------------------------------------"+ANSI_RESET);

        }
    }

    public void exit_runway(Airplane A1){
        boolean check = false;

        for (int i=0; i<AirportGroundNetwork.runways.size();i++){
            if (AirportGroundNetwork.airplaneid_runway.get(i)==A1.getId() && A1.getFrom()==0){

                System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Existing from "+ " Runway no. "+(i+1)+ANSI_RESET);
                A1.setLand(false);
                AirportGroundNetwork.airplaneid_runway.set(i,0);
                AirportGroundNetwork.runways.set(i, false);
                check = true;
                break;
            }
        }
        if(A1.getFrom()!=0)
        {
           System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Existing from Runway. "+ANSI_RESET);
        }

        else if(!check){
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Error! Task failed to Complete! |"+ANSI_RESET);
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);

        }
    }

    public void exit_taxiway(Airplane A1){
        boolean check = false;

        for (int i = 0; i< AirportGroundNetwork.taxiways.size(); i++){
            if (AirportGroundNetwork.airplaneid_taxiway.get(i)==A1.getId()&& A1.getFrom()==0){

                System.out.println(ANSI_YELLOW+ "Airplane no. "+A1.getId()+" is Exiting from "+ "Taxiway no. "+(i+1)+ANSI_RESET);
                AirportGroundNetwork.airplaneid_taxiway.set(i,0);
                AirportGroundNetwork.taxiways.set(i, false);

                for (int j = 0; j< AirportGroundNetwork.runways.size(); j++){
                    if (AirportGroundNetwork.airplaneid_runway.get(j)==0){
                        AirportGroundNetwork.airplaneid_runway.set(i,A1.getId());
                        AirportGroundNetwork.runways.set(i, true);
                        break;
                    }
                }

                check = true;
                break;
            }
        }
        if(A1.getFrom()!=0)
        {
            System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Existing from Taxiway. "+ANSI_RESET);
        }
        else if(!check){
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Error! Task failed to Complete! |"+ANSI_RESET);
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);

        }
    }

    public void exit_gate(Airplane A1){
        boolean check = false;

        for (int i = 0; i<AirportGroundNetwork.gates.size(); i++){
            if (AirportGroundNetwork.airplaneid_gate.get(i)==A1.getId() && A1.getFrom()==0){

                System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Exiting from "+ " Gate no. "+(i+1)+ANSI_RESET);
                AirportGroundNetwork.airplaneid_gate.set(i,0);
                AirportGroundNetwork.gates.set(i, false);
                A1.setPark(false);

                for (int j = 0; j< AirportGroundNetwork.taxiways.size(); j++){

                    if (AirportGroundNetwork.airplaneid_taxiway.get(j)==0){

                        AirportGroundNetwork.airplaneid_taxiway.set(i,A1.getId());
                        AirportGroundNetwork.taxiways.set(i, true);
                        break;
                    }
                }

                check = true;
                break;
            }
        }

        if(A1.getFrom()!=0){

            System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Existing from Gate. "+ANSI_RESET);
        }

        else if(A1.getFrom()==0){
            for(int i=0;i<AirportGroundNetwork.gates.size();i++){
                AirportGroundNetwork.gates.set(i, true);
                AirportGroundNetwork.airplaneid_gate.set(i,A1.getId());
            }

            for (int i = 0; i<AirportGroundNetwork.gates.size(); i++){
                if (AirportGroundNetwork.airplaneid_gate.get(i)==A1.getId() && A1.getFrom()==0){
    
                    System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is Exiting from "+ " Gate no. "+(i+1)+ANSI_RESET);
                    AirportGroundNetwork.airplaneid_gate.set(i,0);
                    AirportGroundNetwork.gates.set(i, false);
                    A1.setPark(false);
    
                    for (int j = 0; j< AirportGroundNetwork.taxiways.size(); j++){
                        if (AirportGroundNetwork.airplaneid_taxiway.get(j)==0){
                            AirportGroundNetwork.airplaneid_taxiway.set(i,A1.getId());
                            AirportGroundNetwork.taxiways.set(i, true);
                            break;
                        }
                    }
    
                    check = true;
                    break;
                }
            }
        }
        
        else if(!check){
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Error! Task failed to Complete! |"+ANSI_RESET);
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);

        }
    }

}
