public class Track {
    private int packages = 0;
    public synchronized void AccessTrack(Robot robot, AccessType accessType){
        if(accessType == AccessType.DeliverPackage){
            if(packages < 30){
                System.out.println("Robô Construtor " + robot.getRobotName() + " colocou novo conjunto de peças na esteira");
                packages++;
                notify();
                System.out.printf("%s: Agora há %02d conjuntos na esteira%n", robot.getRobotName(), packages);
            }else{
                try{
                    while (packages == 30){
                        wait();
                    }
                }catch (InterruptedException err){
                    System.out.println("sobrecarga no robô!");
                }
            }

        }else if(accessType == AccessType.GetPackage){
            if(packages > 0){
                System.out.println("Robô Montador " + robot.getRobotName() + " pegou um conjunto de peças da esteira");
                packages--;
                notify();
                System.out.printf("%s:  Agora há %02d conjuntos na esteira%n",robot.getRobotName(), packages);
                robot.work();
            }else{
                try{
                    while (packages == 0){
                        wait();
                    }
                }catch (InterruptedException err){
                    System.out.println("sobrecarga no robô!");
                }
            }

        }
    }

}
