package src;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
/**
 * [MaroonedNATOPhoneticAlphabet.java]
 * @author Kristin Hamilton
 * created 25-Nov-2014
 * cosc3336 Project
 */
public class MaroonedNATOPhoneticAlphabet
{
    public static void main()
    {
    	Scanner console = new Scanner(System.in);
    	HashMap<String, MaroonedKeyword> commandKeywordMap = getCommandKeywordMap();
        String command = "";
        MaroonedKeyword commandKeyword = MaroonedKeyword.ZERO;
        
        do
        {
        	command = console.next();
        	if(commandKeywordMap.containsKey(command))
        		commandKeyword = commandKeywordMap.get(command);

        	switch(commandKeyword)
        	{
        		case ALPHA:
        			try
        			{
        				int commandArg1 = console.nextInt();
        				int commandArg2 = console.nextInt();
        				console.nextLine();
        				alpha(commandArg1, commandArg2);
        			}
        			catch(InputMismatchException e)
        			{
        				System.out.println("Usage: ALPHA <int1> <int2>");
        			}
        			catch(ArrayIndexOutOfBoundsException e)
        			{
        				System.out.println("Usage: ALPHA <int1> <int2>");
        			}
					catch(NullPointerException e)
					{
        				System.out.println("Usage: ALPHA <int1> <int2>");
					}
        			break;
        			
        		case BRAVO:
        			try
        			{
        				String category = console.next();
        				console.nextLine();
        				bravo(category);
        			}
        			catch(ArrayIndexOutOfBoundsException e)
        			{
        				System.out.println("Usage: BRAVO <category>");
        			}
        			break;

        		case CHARLIE:
        			try
        			{
        				String greeting = console.nextLine();
        				charlie(greeting);
        			}
        			catch(ArrayIndexOutOfBoundsException e)
        			{
        				System.out.println("Usage: CHARLIE <statement>");
        			}
        			break;
        			
        		case DELTA:
        			try
        			{
        				int n1 = 0;
        				int n2 = 0;
        				n1 = console.nextInt();
        				n2 = console.nextInt();
        				console.nextLine();
            			delta(n1, n2);
        			}
        			catch(InputMismatchException e)
        			{
        				System.out.println("Usage: DELTA <int1> <int2>");
        			}
        			catch(ArrayIndexOutOfBoundsException e)
        			{
        				System.out.println("Usage: DELTA <int1> <int2>");
        			}
					catch(NullPointerException e)
					{
        				System.out.println("Usage: DELTA <int1> <int2>");
					}
        			break;
        			
        		case MAYDAY:
        			mayday();            			
        			break;

        		case OVER:
        			try
        			{
        				String overLine = console.nextLine();
        				if(overLine.length() > MaroonedKeyword.OVER.toString().length())
        				{
        					String[] overArgs = overLine.substring(1).split(" ");
        					Marooned.main(overArgs);
        				}
        				else 
        				{
        					Marooned.main(null);
        				}
        			}
        			catch(NullPointerException e)
        			{
        				//System.out.println("Usage: OVER -m mc <dot key> <dash key>");
        				Marooned.main(null);
        			}
        			break;
        			
        		case OUT:
        			System.out.println("Exiting program.");
        			System.exit(0);
        			
        		default:
        			System.out.println("Invalid command.");
        			break;

        	}
        }
        while(commandKeyword != MaroonedKeyword.OUT);
    }
    
    /* ------ */
    
    public static void alpha(int int1, int int2)
    {
    	int sum = int1 + int2;
    	System.out.println(int1 + " + " + int2 + " = " + sum);
    	System.out.println();
    	return;
    }
    
    public static void bravo(String category)
    {
    	String randomItem = getRandomItem(category);
    	if(randomItem.equals("")) System.out.println("Sorry, nothing in that category!");
    	else System.out.println(randomItem + " is a type of " + category + "!");
    	System.out.println();
    	return;
    }
    
    public static void charlie(String statement)
    {
    	String chazReply = getChazReply();
    	System.out.println(chazReply);
    	System.out.println();
    	return;
    }
    
	public static void delta(int n1, int n2)
	{
		int result = n1 - n2;
		System.out.println(n1 + " - " + n2 + " = " + result);
		return;
	}
    
    public static void mayday()
    {
    	System.out.println(getManual());
    	System.out.println();
    	return;
    }
    
    /* ------ */
    
    public static void displayRandomItem(String category)
    {
    	String randomItem = getRandomItem(category);
    	if(randomItem.equals("")) System.out.println("Sorry, nothing in that category!");
    	else System.out.println(randomItem);
    	System.out.println();
    	return;
    }
    
    public static String getRandomItem(String category)
    {
    	String randomItem = "";
    	final int LIST_LENGTH = 5;
    	HashMap<String, String[]> itemMap = new HashMap<String, String[]>();
    	Random rNum = new Random();
    	int rIndex = rNum.nextInt(LIST_LENGTH);
    	
    	String[] dinosaurs = new String[]{"Velociraptor", "Brontosaurus", "Triceratops", 
    			"Tyrannosaurus Rex", "Stegasaurus"};
    	String[] beans = new String[]{"Black bean", "Lentil", "Sweet pea", 
    			"Pinto bean", "Black eyed pea"};
    	String[] states = new String[]{"Montana", "Texas", "Virginia", "Colorado", 
    			"New Hampshire"};
    	String[] weather = new String[]{"Humidity", "Wind", "Rain", "Sleet", "Tornado"};
    	String[] dogs = new String[]{"American Bulldog", "Labrador Retriever", 
    			"Black and Tan Coonhound", "Border Collie", "Beagle"};
    	
    	itemMap.put("dinosaurs", dinosaurs);
    	itemMap.put("beans", beans);
    	itemMap.put("states", states);
    	itemMap.put("weather", weather);
    	itemMap.put("dogs", dogs);
    	
    	if(itemMap.containsKey(category)) randomItem = itemMap.get(category)[rIndex];
    	return randomItem;
    }
    
    public static String getChazReply()
    {
    	String[] repliesList = new String[]{
    			"Get it together.", 
    			"You're the best at making a campfire! I feel warm", 
    			"You are my favorite friend ever! Let's go fishing", 
    			"Absolutely you should!", 
    			"That's the worst possible thing you could say right now!"
    	};
    	
    	final int LIST_LENGTH = repliesList.length;
    	Random rNum = new Random();
    	int rIndex = rNum.nextInt(LIST_LENGTH);
    	return repliesList[rIndex];
    }
    
	public static String getManual()
	{
		final int TOTAL_WIDTH = 96;
		final int COL_WIDTH = (TOTAL_WIDTH / 4);
		final int CELL_TEXT_WIDTH = COL_WIDTH - 1;
		
		String rowChars = "";
		String rowDivider = "";
		StringBuilder manual = new StringBuilder();

		for(int i = 0; i < TOTAL_WIDTH; i++)
		{
			if(i % (CELL_TEXT_WIDTH + 1) == 0) rowChars += "+";
			else rowChars += "-";
		}
		rowChars += "+\n";
		rowDivider = String.format("%" + TOTAL_WIDTH + "s", rowChars);

		manual.append(rowDivider);


		/* column headings */
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "COMMAND") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "DESCRIPTION") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "EXAMPLE USAGE") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "EXAMPLE OUTPUT") + "|\n");
		manual.append(rowDivider);

		/* ALPHA */
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "ALPHA") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "add") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", "ALPHA 3 12") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "3 + 12 = 15") + "|\n");
		manual.append(rowDivider);

		/* BRAVO */
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "BRAVO") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "category item") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", "BRAVO weather") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "Tornado") + "|\n");
		manual.append(rowDivider);

		/* CHARLIE */
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "CHARLIE") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "companion") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", "CHARLIE Howdy Chaz!") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "Get it together.") + "|\n");
		manual.append(rowDivider);

		/* DELTA */
		manual.append("|");
    	manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "DELTA") + "|" + 
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "subtract") + "|" +  
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "DELTA 10 4") + "|" +
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "10 - 4 = 6") + "|\n");
    	manual.append(rowDivider);

		
		/* MAYDAY */
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "MAYDAY") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "display manual") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", "MAYDAY") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "(n/a)") + "|\n");
		manual.append(rowDivider);

		/* OVER */
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "OVER") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "change mode") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", "OVER -m mc l o") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "(n/a)") + "|\n");
		manual.append(rowDivider);

		/* OUT */
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "OUT") + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "quit program") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", "OUT") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "(n/a)") + "|\n");
		manual.append(rowDivider);

		/*
		manual.append("|");
    	manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|" + 
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|" +  
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|" +
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|\n");
    	manual.append(rowDivider);
		 */

		return manual.toString();
	}
	
	public static HashMap<String, MaroonedKeyword> getCommandKeywordMap()
	{
    	HashMap<String, MaroonedKeyword> commandKeywordMap = 
    			new HashMap<String, MaroonedKeyword>();
    	MaroonedKeyword[] commandKeywordArray = MaroonedKeyword.values();
    	String command = "";
    	
    	for(MaroonedKeyword commandKeyword: commandKeywordArray)
    	{
    		command = commandKeyword.toString();
    		commandKeywordMap.put(command, commandKeyword);
    	}
    	
    	return commandKeywordMap;    	
	}
}

