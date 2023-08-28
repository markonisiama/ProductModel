import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString (Scanner pipe, String prompt)
    {
        String returnString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            returnString = pipe.nextLine();
        }
        while (returnString.length() == 0);
        return returnString;
    }

    public static int getInt (Scanner pipe, String prompt)
    {
        int returnInt = 0;
        String trash = "";
        boolean gotAValue = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt())
            {
                returnInt = pipe.nextInt();
                pipe.nextLine();
                gotAValue = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nInvalid value: " + trash);
            }

        }
        while (!gotAValue);
        return returnInt;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double returnDouble = 0;
        String trash = "";
        boolean gotAValue = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble())
            {
                returnDouble = pipe.nextDouble();
                pipe.nextLine();
                gotAValue = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nInvalid value: " + trash);
            }

        }
        while (!gotAValue);
        return returnDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int returnInt = 0;
        String trash = "";
        boolean gotAValue = false;
        do
        {
            System.out.print("\n" + prompt + " (" + low + "-" + high + "): ");

            if (pipe.hasNextInt())
            {
                returnInt = pipe.nextInt();
                pipe.nextLine();

                if(returnInt >= low && returnInt <= high)
                {
                    gotAValue = true;
                }
                else
                {
                    System.out.println("\nInvalid Value: " + returnInt);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nInvalid value: " + trash);
            }
        }
        while (!gotAValue);
        return returnInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        //Declarations
        double returnDouble = 0;
        String trash = "";
        boolean gotAValue = false;
        do
        {
            System.out.print("\n" + prompt + " (" + low + "-" + high + "): ");

            if (pipe.hasNextDouble())
            {
                returnDouble = pipe.nextDouble();
                pipe.nextLine();

                if(returnDouble >= low && returnDouble <= high)
                {
                    gotAValue = true;
                }
                else
                {
                    System.out.println("\nInvalid Value: " + returnDouble);
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nInvalid value: " + trash);
            }
        }
        while (!gotAValue);
        return returnDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String returnYN = "";
        String trash = "";
        boolean gotAAnswer = false;
        boolean control = false;

        do
        {
            System.out.print("\n" + prompt + "(Y or N): ");
            returnYN = pipe.nextLine();

            if (returnYN.equalsIgnoreCase("Y") || returnYN.equalsIgnoreCase("YES"))
            {
                gotAAnswer = true;
                control= true;
            }
            else if (returnYN.equalsIgnoreCase("N") || returnYN.equalsIgnoreCase("NO"))
            {
                control = true;
            }
            else
            {
                trash = returnYN;
                System.out.println("\nInvalid value: " + trash + ". Please answer Y or N!");
            }
        }
        while(!control);
        return gotAAnswer;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String returnValue = "";
        boolean gotAValue = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            returnValue = pipe.nextLine();
            if(returnValue.matches(regExPattern))
            {
                gotAValue = true;
            }
            else
            {
                System.out.println("\nInvalid input: " + returnValue);
            }
        }
        while (!gotAValue);
        return returnValue;

    }
}


