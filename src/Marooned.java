package src;
/**
 * [Marooned.java]
 * @author Kristin Hamilton
 * created 25-Nov-2014
 * cosc3336 Project
 */
public class Marooned
{
    public static void main(String[] args)
    {
        String option = "";
        String mode = "";
        char dot = ' ';
        char dash = ' ';

        try
        {
            option = args[0];
            switch(option)
            {
                case "-m":
                    try
                    {
                        mode = args[1];
                        switch(mode)
                        {
                            case "npa":
                                //invoke npa program
                                MaroonedNATOPhoneticAlphabet.main();
                                System.out.println("Exiting program.");
                                return;
                                //break;
                                
                            case "mc":
                                try
                                {
                                    //args[0], args[1], args[2], and args[3] provided.
                                    if((args.length == 4) && 
                                       (args[2].length() == 1) && 
                                       (args[3].length() == 1))
                                    {
                                        dot = args[2].charAt(0);
                                        dash = args[3].charAt(0);                
                                        System.out.println(
                                        		"(1.2) Invoking mc program mode, "+
                                                "where dot = '" + dot + "', " +
                                                "dash = '" + dash + "'.");
                                        //invoke mc program
                                        MaroonedMorseCode.main(dot, dash);
                                        System.out.println("(1.2) Exiting program.");
                                        return;
                                    }

                                }
                                catch(ArrayIndexOutOfBoundsException e)
                                {
                                    System.out.println("(2.4) Usage: -m <mode> " +
                                            "<dot key> <dash key>");
                                    //System.exit(0);
                                }
                                break;
                                
                            default:
                                //args[1] provided, but not a valid option.
                                System.out.println("(2.3) Usage: -m <mode>, "
                                        + "where <mode> = 'mc' or 'npa'.");
                                //System.exit(0);
                                break;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        //args[0] provided, but args[1] not provided
                        System.out.println("(2.2) Usage: java Marooned -m <mode>");
                        //System.exit(0);
                    }
					catch(NullPointerException e)
					{
                        System.out.println("(2.2) Usage: java Marooned -m <mode>");
					}

                default:  //args[0] provided, but not a valid option.
                    System.out.println("(2.1) Usage: java Marooned <options>, " +
                            "where <options> = '-m'.");
                    //System.exit(0);
                    break;
            }
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            dot = '-';
            dash = '=';
            System.out.println("(1.1) Invoking mc program mode, " +
                    "where dot = '" + dot + "', dash = '" + dash + "'.");
            //invoke mc program by default, no args[0] provided.
            MaroonedMorseCode.main(dot, dash);
            //System.out.println("(1.1) Exiting program.");
            //return;
        }
        catch(NullPointerException e)
        {
            dot = '-';
            dash = '=';
            System.out.println("(1.1) Invoking mc program mode, " +
                    "where dot = '" + dot + "', dash = '" + dash + "'.");
            //invoke mc program by default, no args[0] provided.
            MaroonedMorseCode.main(dot, dash);
            //System.out.println("(1.1) Exiting program.");
            //return;
        }
        
        return;
        
    }//end main()

}//end Marooned.java
