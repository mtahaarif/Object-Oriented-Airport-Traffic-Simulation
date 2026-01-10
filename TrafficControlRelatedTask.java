package Project;
class TrafficControlRelatedTask extends Task {


    public void move_airplane(Airplane  A1){
        System.out.println(ANSI_GREEN+"--------------------------"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"| This is a Moving Task! |"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"--------------------------"+ANSI_RESET);

        System.out.println();
        A1.setHold(false);
        for (int i=0; i<3;i++){
            A1.setCurrentPos(A1.getBestPath()[i]);
            A1.setTo(A1.getBestPath()[i+1]);
            A1.display();
        }
        A1.setCurrentPos(A1.getBestPath()[3]);
        A1.setReachedDestination(true);
        A1.display();
    }

    public void hold_airplane(Airplane A1){
        for (int i = 0; i< AirportGroundNetwork.gates.size(); i++){
            if (AirportGroundNetwork.airplaneid_gate.get(i)==A1.getId()){

                System.out.println(ANSI_YELLOW+"Airplane no. "+A1.getId()+" is holding its position at "+ A1.getCurrentPos()+ANSI_RESET);
                A1.setHold(true);
            }
        }
    }

    public void park_airplane(Airplane A1){
        if (A1.isLand()){        
        boolean check = false;
        for (int i = 0; i< AirportGroundNetwork.gates.size(); i++){
            if (AirportGroundNetwork.airplaneid_gate.get(i)==A1.getId()){

                System.out.println(ANSI_GREEN+"--------------------------------------------------"+ANSI_RESET);
                System.out.println(ANSI_GREEN+"| Airplane no. "+A1.getId()+" is been Parked at "+ "Gate no. "+(i+1)+" |"+ANSI_RESET);
                System.out.println(ANSI_GREEN+"--------------------------------------------------"+ANSI_RESET);
                A1.setPark(true);
                check = true;
                    break;
            }
        }

        if(!check){
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);
            System.out.println(ANSI_RED+"| Error! Task failed to Complete! |"+ANSI_RESET);
            System.out.println(ANSI_RED+"-----------------------------------"+ANSI_RESET);
        }
    }
    
    else{
        System.out.println(ANSI_GREEN+"--------------------------------------"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"| Airplane no. "+A1.getId()+" has been Parked |"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"--------------------------------------"+ANSI_RESET);

    }


    }
    
}