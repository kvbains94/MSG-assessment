package Interfaces;

public interface IMissileLauncher {
    /**
     * Launch the missile if foe is detected,
     * returns whether foe is hit.
     * @param isFoe
     */
    boolean LaunchMissile(boolean isFoe);
}
