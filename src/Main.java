import Classes.IdentificationFriendFoe;
import Classes.MissileLauncher;
import Classes.Radar;
import Interfaces.IIdentificationFriendFoe;
import Interfaces.IMissileLauncher;
import Interfaces.IRadar;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private IRadar _radar;
    private IIdentificationFriendFoe _identificationFriendFoe;
    private IMissileLauncher _missileLauncher;

    // constructor geschreven voor dependency injection met interfaces
    public Main(IRadar radar, IIdentificationFriendFoe identificationFriendFoe, IMissileLauncher missileLauncher)
    {
        _radar = radar;
        _identificationFriendFoe = identificationFriendFoe;
        _missileLauncher = missileLauncher;
    }

    public static void main(String[] args) throws InterruptedException {

        // voorbeeld voor het gebruik van dependency injection, beetje overbodig omdat je hier in Main zit.
        Main obj = new Main(new Radar(), new IdentificationFriendFoe(), new MissileLauncher());

        Timer timer = new Timer();
        long start = System.currentTimeMillis();
        int maxSimulationTime = 20;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                // Bepalen van de simulation time
                long elapsedTime = System.currentTimeMillis() - start;
                elapsedTime = elapsedTime / 1000;

                // Rekenstappen van de verschillende classes
                String radarOutput = obj._radar.GetData((int)elapsedTime);
                boolean isFoe = obj._identificationFriendFoe.IsFoe(radarOutput);
                boolean launch = obj._missileLauncher.LaunchMissile(isFoe);

                // Output
                if (isFoe)
                {
                    System.out.println(String.format("Simalation Time (s): %d", elapsedTime));
                    System.out.println(String.format("Foe detected: %s", isFoe));
                    System.out.println("Missile Launched");
                    System.out.println(String.format("Target Hit: %s \n", launch));
                }
                else
                {
                    System.out.println(String.format("Simalation Time (s): %d", elapsedTime));
                    System.out.println(String.format("Foe detected: %s", isFoe));
                    System.out.println("No Missile Launched \n");
                }

                // simulatie stopzetten
                if (elapsedTime >= maxSimulationTime)
                {
                    timer.cancel();
                }
            }
        }, 1000, 1000);//wait 0 ms before doing the action and do it every 1000ms (1second)

    }
}