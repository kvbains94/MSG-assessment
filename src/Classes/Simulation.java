package Classes;

import Interfaces.IIdentificationFriendFoe;
import Interfaces.IMissileLauncher;
import Interfaces.IRadar;

public class Simulation {

    private final IRadar _radar;
    private final IIdentificationFriendFoe _identificationFriendFoe;
    private final IMissileLauncher _missileLauncher;

    public Simulation(IRadar radar, IIdentificationFriendFoe identificationFriendFoe, IMissileLauncher missileLauncher)
    {
        _radar = radar;
        _identificationFriendFoe = identificationFriendFoe;
        _missileLauncher = missileLauncher;
    }

    public void runSimulation(int time)
    {
        // Rekenstappen van de verschillende classes
        String radarOutput = _radar.GetData(time);
        boolean isFoe = _identificationFriendFoe.IsFoe(radarOutput);
        boolean launch = _missileLauncher.LaunchMissile(isFoe);

        // Output
        if (isFoe)
        {
            System.out.println(String.format("Simalation Time (s): %d", time));
            System.out.println("Foe detected");
            System.out.println("Missile Launched");
            System.out.println(String.format("Target Hit: %s \n", launch));
        }
        else
        {
            System.out.println(String.format("Simalation Time (s): %d", time));
            System.out.println("Friend detected");
            System.out.println("No Missile Launched \n");
        }
    }
}
