package Classes;

import Interfaces.IRadar;

import java.io.*;

public class Radar implements IRadar {

    /**
     * {@inheritDoc}
     */
    public String GetData(int time)
    {

        return RadarOutput.GetOutput(time-1);
    }

}
