package Classes;

import Interfaces.IRadar;

import java.io.*;

public class Radar implements IRadar {

    /**
     * {@inheritDoc}
     */
    public String GetData(int time)
    {

        // File reader kreeg ik niet op tijd werkend, vandaar dat ik het op deze manier heb gedaan.

        return RadarOutput.GetOutput(time-1); // -1 is nodig omdat array index begint bij 0
    }

}
