import Classes.IdentificationFriendFoe;
import Classes.MissileLauncher;
import Classes.Radar;
import Classes.Simulation;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Timer timer = new Timer();
        long start = System.currentTimeMillis();
        int maxSimulationTime = 20; // depends on number of lines in RadarOutput
        Simulation sim = new Simulation(new Radar(), new IdentificationFriendFoe(), new MissileLauncher());

        System.out.println("\nStarting Simulation\n");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                // Bepalen van de simulation time
                long elapsedTime = System.currentTimeMillis() - start;
                elapsedTime = elapsedTime / 1000;

                // Daadwerkelijke simulatie
                sim.runSimulation((int)elapsedTime);

                // simulatie stopzetten
                if (elapsedTime >= maxSimulationTime)
                {
                    timer.cancel();
                    System.out.println("\nEnd of simualation\n");
                }
            }
        }, 1000, 1000);//wait 0 ms before doing the action and do it every 1000ms (1second)
    }
}