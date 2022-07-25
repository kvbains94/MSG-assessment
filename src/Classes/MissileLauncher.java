package Classes;

import Interfaces.IMissileLauncher;
import java.util.Random;

public class MissileLauncher implements IMissileLauncher {

    /**
     * {@inheritDoc}
     */
    public boolean LaunchMissile(boolean isFoe)
    {
        if (isFoe)
        {
            return TargetHit();
        }

        return false;
    }

    private boolean TargetHit()
    {
        double pk = 0.8;
        double enemyValue = GetCompareValue();

        return pk > enemyValue;
    }

    private double GetCompareValue()
    {
        Random random = new Random();
        return random.nextDouble();
    }
}
