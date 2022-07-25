package Classes;

import Interfaces.IIdentificationFriendFoe;

public class IdentificationFriendFoe implements IIdentificationFriendFoe {

    /**
     * {@inheritDoc}
     */
    public Boolean IsFoe(String radarOutput)
    {
        String[]  splitValues = radarOutput.split(";");
        int[] splitNumbers = new int[splitValues.length];

        for (int i = 0; i < splitValues.length ; i++) {
            splitNumbers[i] = Integer.parseInt(splitValues[i], 2);
        }

        int oddNumbers = CountOddNumbers(splitNumbers);
        int evenNumbers = splitNumbers.length - oddNumbers;

        return oddNumbers > evenNumbers;
    }

    private int CountOddNumbers(int[] numbers)
    {
        int count = 0;

        for (int i = 0; i < numbers.length; i++)
        {
            if (numbers [i] % 2 != 0)
            {
                count++;
            }
        }

        return count;
    }
}
