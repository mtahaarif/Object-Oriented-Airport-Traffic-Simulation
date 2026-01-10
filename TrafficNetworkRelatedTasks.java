package Project;
class TrafficNetworkRelatedTasks extends Task{
    
    public void closeRunway(int R1){
        if(R1>AirportGroundNetwork.runways.size())
            AirportGroundNetwork.runways.set(R1, true);
        else{
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Invalid Runway Index | "+ANSI_RESET);
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);


        }
    }
    
    public void openRunway(int R1){
        if(R1>AirportGroundNetwork.runways.size()){
    
            if(AirportGroundNetwork.airplaneid_runway.get(R1)==0)
                AirportGroundNetwork.runways.set(R1,false);
            else {
                System.out.println(ANSI_YELLOW+ "---------------------------------------------------------------------"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW+ "| Runway is still occupied by an Airplane. Cannot perform Operation |"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW+ "---------------------------------------------------------------------"+ ANSI_RESET);


            }
        }
        else{
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Invalid Runway Index | "+ANSI_RESET);
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);

        }
    }
    
    public void closeTaxiway(int T1){
        if(T1>AirportGroundNetwork.taxiways.size())
            AirportGroundNetwork.taxiways.set(T1, true);
            else{
                System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
                System.out.println(ANSI_RED+"| Invalid Runway Index | "+ANSI_RESET);
                System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
    
            }
    }
    
    public void openTaxiway(int T1){
        if(T1>AirportGroundNetwork.taxiways.size()){
    
            if(AirportGroundNetwork.airplaneid_taxiway.get(T1)==0)
                AirportGroundNetwork.taxiways.set(T1,false);
            else {
                System.out.println(ANSI_YELLOW+ "----------------------------------------------------------------------"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW+ "| Taxiway is still occupied by an Airplane. Cannot perform Operation |"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW+ "----------------------------------------------------------------------"+ ANSI_RESET);
            }
        }
        else{
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Invalid Runway Index | "+ANSI_RESET);
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
        }
    }
    
    public void closeGate(int G1){
        if(G1>AirportGroundNetwork.gates.size())
            AirportGroundNetwork.gates.set(G1, true);
        else{
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Invalid Runway Index | "+ANSI_RESET);
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);

        }
    }
    
    public void openGate(int G1){
        if(G1>AirportGroundNetwork.gates.size()){
    
            if(AirportGroundNetwork.airplaneid_gate.get(G1)==0)
                AirportGroundNetwork.gates.set(G1,false);
            else {
                System.out.println(ANSI_YELLOW+ "-------------------------------------------------------------------"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW+ "| Gate is still occupied by an Airplane. Cannot perform Operation |"+ ANSI_RESET);
                System.out.println(ANSI_YELLOW+ "-------------------------------------------------------------------"+ ANSI_RESET);
            }
        }
        else{                   
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Invalid Runway Index | "+ANSI_RESET);
            System.out.println(ANSI_RED+"------------------------"+ANSI_RESET);
}
    }
    
}
