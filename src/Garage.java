


public class Garage {
    private int cars = 0;
    private int carsFinished = 0;
    public synchronized void AccessGarage(Robot robot, AccessType accessType){
        if(accessType == AccessType.DeliverCar){
            if(cars < 30){
                System.out.println("Robô Montador " + robot.getRobotName() +  " entregou carro na garagem");
                cars++;
                notify();
                System.out.printf("%s: Agora há %02d carros na garagem%n", robot.getRobotName(), cars);
            }else{
                try{
                    while (cars == 30){
                        wait();
                    }
                }catch (InterruptedException err){
                    System.out.println("sobrecarga no robô!");
                }
            }

        }else if(accessType == AccessType.TestCar){
            if(cars > 0){
                System.out.println("Piloto de Testes " + robot.getRobotName() + " está testando um carro");
                robot.work();
                cars--;
                System.out.println("Piloto de Testes " + robot.getRobotName() + " testou o carro com sucesso");
                carsFinished++;
                System.out.printf("%s: Agora há %02d carros na garagem%n", robot.getRobotName(), cars);
                System.out.printf("%s: Agora há %02d carros finalizados%n", robot.getRobotName(), carsFinished);
                notify();
            }else{
                try{
                    while (cars == 0){
                        wait();
                    }
                }catch (InterruptedException err){
                    System.out.println("sobrecarga no robô!");
                }
            }
        }
    }

}
