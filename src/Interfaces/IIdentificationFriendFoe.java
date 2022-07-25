package Interfaces;

public interface IIdentificationFriendFoe {
    /**
     * Determines if friend or foe is detected based on radar ouput
     *
     * @param radarOutput
     */
    Boolean IsFoe(String radarOutput);
}
