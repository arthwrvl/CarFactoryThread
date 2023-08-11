import java.util.Scanner;

public class Factory {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int builderRobotsAmount = 0;
        int assemblerRobotsAmount = 0;
        int testerRobotsAmount = 0;
        int carAmount = 0;
        Track track = new Track();
        Garage garage = new Garage();
        System.out.println("Quantos robôs construtores a fábrica possui?");
        builderRobotsAmount = input.nextInt();
        System.out.println("Quantos robôs montadores a fábrica possui?");
        assemblerRobotsAmount = input.nextInt();
        System.out.println("Quantos robôs testadores a fábrica possui?");
        testerRobotsAmount = input.nextInt();
        System.out.println("Quantos carros deseja construir?");
        carAmount = input.nextInt();

        for(int i = 0; i < builderRobotsAmount; i++){
            if(i == 0){
                if(carAmount%builderRobotsAmount != 0){
                    new BuilderRobot(String.format("B%02d", i + 1), carAmount/builderRobotsAmount + carAmount%builderRobotsAmount, track).start();
                }else{
                    new BuilderRobot(String.format("B%02d", i + 1), carAmount/builderRobotsAmount, track).start();
                }
            }else{
                new BuilderRobot(String.format("B%02d", i + 1), carAmount/builderRobotsAmount, track).start();
            }
        }
        for(int i = 0; i < assemblerRobotsAmount; i++){
            if(i == 0){
                if(carAmount%assemblerRobotsAmount != 0){
                    new AssemblerRobot(String.format("A%02d", i+1), carAmount/assemblerRobotsAmount + carAmount%assemblerRobotsAmount, track, garage).start();
                }else{
                    new AssemblerRobot(String.format("A%02d", i+1), carAmount/assemblerRobotsAmount, track, garage).start();
                }
            }else{
                new AssemblerRobot(String.format("A%02d", i+1), carAmount/assemblerRobotsAmount, track, garage).start();
            }
        }
        for(int i = 0; i < testerRobotsAmount; i++){
            if(i == 0){
                if(carAmount%testerRobotsAmount != 0){
                    new TesterRobot(String.format("T%02d", i+1), carAmount/testerRobotsAmount + carAmount%testerRobotsAmount, garage).start();
                }else{
                    new TesterRobot(String.format("T%02d", i+1), carAmount/testerRobotsAmount, garage).start();
                }
            }else{
                new TesterRobot(String.format("T%02d", i+1), carAmount/testerRobotsAmount, garage).start();
            }
        }
    }
}