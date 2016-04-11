package src;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**
 * [MaroonedMorseCode.java]
 * @author Kristin Hamilton
 * created 25-Nov-2014
 * cosc3336 Project
 */
public class MaroonedMorseCode
{
	public static void main(char dot, char dash)
	{
		HashMap<String, MaroonedKeyword> morseCodeKeywordMap = 
				getMorseCodeKeywordMap(dot, dash);
		HashMap<MaroonedKeyword, String> keywordMorseCodeMap = 
				getKeywordMorseCodeMap(morseCodeKeywordMap);
		String command = "";
		MaroonedKeyword commandKeyword = MaroonedKeyword.ZERO;		
		Scanner console = new Scanner(System.in);

		do
		{
			command = console.next();
			//console.nextLine();
			if(morseCodeKeywordMap.containsKey(command))
				commandKeyword = morseCodeKeywordMap.get(command);

			switch(commandKeyword)
			{			
				case TANGO:
					try
					{
						String choice1 = console.next();
						String choice2 = console.next();
						console.nextLine();
						tango(choice1, choice2);
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Usage: TANGO <choice1> <choice2>");
					}
					catch(NullPointerException e)
					{
						System.out.println("Usage: TANGO <choice1> <choice2>");
					}
					break;
				
				case UNIFORM:
					try
					{
						double number = console.nextDouble();
						String roundUpOrDown = console.next();
						console.nextLine();
						uniform(number, roundUpOrDown);
					}
					catch(InputMismatchException e)
					{
						System.out.println("Usage: UNIFORM <double> <direction to round>");
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Usage: UNIFORM <double> <direction to round>");
					}
					catch(NullPointerException e)
					{
						System.out.println("Usage: UNIFORM <double> <direction to round>");
					}
					break;
					
				case WHISKEY:
					try
					{
						String comparisonString = console.nextLine();
						whiskey(comparisonString);
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Usage: WHISKEY <string>");
					}
					catch(NullPointerException e)
					{
						System.out.println("Usage: WHISKEY <string>");
					}
					break;
					
				case YANKEE:
					try
					{
						double number = console.nextDouble();
						console.nextLine();
						yankee(number);
					}
					catch(InputMismatchException e)
					{
						System.out.println("Usage: YANKEE <double>");
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						System.out.println("Usage: YANKEE <double>");
					}
					catch(NullPointerException e)
					{
						System.out.println("Usage: YANKEE <double>");
					}
					break;
										
				case MAYDAY:
					mayday(keywordMorseCodeMap);            			
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
        					String[] mainArgs = new String[]{"-m", "npa"};
        					Marooned.main(mainArgs);
        				}
					}
					catch(NullPointerException e)
					{
						System.out.println("Usage: OVER -m npa");
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
	
	public static void tango(String choice1, String choice2)
    {
		String decision = "";
		Random rNum = new Random();
		int rInt = rNum.nextInt() % 2;
		if(rInt == 0) decision = choice2;
		else decision = choice1;
    	System.out.println("100%, " + decision);
    	return;
    }
	
	public static void uniform(double number, String roundUpOrDown)
    {
		double roundedNumber = (roundUpOrDown.equalsIgnoreCase("down")) ? 
												Math.floor(number) : Math.ceil(number); 
		System.out.println("Once rounded " + roundUpOrDown.toLowerCase() + 
				", " + number + " = " + roundedNumber);
    	return;
    }
	
	public static void whiskey(String comparisonString)
    {
		String whiskey = "whiskey";
		comparisonString.toLowerCase();
		int commonCount = 0;
		int notInCommonCount = 0;
		int lettersTotal = comparisonString.length() + "whiskey".length();
		Set<Character> notInCommonCharsSet = new HashSet<Character>();
		
		for(int i = 0; i < whiskey.length(); i++)
		{
			try
			{
				notInCommonCharsSet.add(whiskey.charAt(i));	
			}
			catch(Exception e) { }
		}
		
		for(int i = 0; i < comparisonString.length(); i++)
		{
			try
			{
				notInCommonCharsSet.add(comparisonString.charAt(i));	
			}
			catch(Exception e) { }
		}

		commonCount = lettersTotal - notInCommonCharsSet.size();
		System.out.println(comparisonString + " \"has\" " + commonCount + 
				" letters in common with the word \"whiskey\"");
    	return;
    }
	
    public static void yankee(double number)
    {
    	double sqrtResult = Math.sqrt(number);
		System.out.println("The square root of " + number + " is approximately " + 
				sqrtResult);
    	return;
    }
		
    public static void mayday(HashMap<MaroonedKeyword, String> keywordMorseCodeMap)
    {
    	System.out.println(getManual(keywordMorseCodeMap));
    	System.out.println();
    	return;
    }
	
    /* ------ */
    
	public static HashMap<String, MaroonedKeyword> getMorseCodeKeywordMap(char dot, 
																		char dash)
	{
		HashMap<String, MaroonedKeyword> morseCodeMap = 
				new HashMap<String, MaroonedKeyword>();
		HashMap<MaroonedKeyword, String> patternMap = getMorseCodePatternMap();
		MaroonedKeyword[] keywordArray = MaroonedKeyword.values();
		String currentPattern = "";
		String morseCodeKeywordSub1 = "";
		String morseCodeKeywordSub2 = "";
		String morseCodeKeywordSub3 = "";

		for(int i = 0; i < keywordArray.length; i++)
		{
			currentPattern = patternMap.get(keywordArray[i]);
			morseCodeKeywordSub1 = currentPattern.replace('-', ' ');
			morseCodeKeywordSub2 = morseCodeKeywordSub1.replace('0', dot);
			morseCodeKeywordSub3 = morseCodeKeywordSub2.replace('1', dash);
			morseCodeMap.put(morseCodeKeywordSub3, keywordArray[i]);
		}
		
		return morseCodeMap;
	}
	
	public static HashMap<MaroonedKeyword, String> getKeywordMorseCodeMap(
			HashMap<String, MaroonedKeyword> morseCodeKeywordMap)
	{
		HashMap<MaroonedKeyword, String> keywordMorseCodeMap = 
				new HashMap<MaroonedKeyword, String>();
		Iterator itr = morseCodeKeywordMap.keySet().iterator();
		String currentKey = "";
		MaroonedKeyword currentValue = MaroonedKeyword.ZERO;
		
		while(itr.hasNext())
		{
			currentKey = (String) itr.next();
			currentValue = morseCodeKeywordMap.get(currentKey);
			keywordMorseCodeMap.put(currentValue, currentKey);			
		}		
		
		return keywordMorseCodeMap;
	}
	
	public static HashMap<MaroonedKeyword, String> getMorseCodePatternMap()
	{
		HashMap<MaroonedKeyword, String> patternMap = 
				new HashMap<MaroonedKeyword, String>();
		
		String[] patternArray = new String[]{
				"01", "1000", "1010", "100", "0",  				//A to E
				"0010", "110", "0000", "00", "0111",  			//F to J
				"101", "0100", "11", "10", "111",  				//K to O
				"0110", "1101", "010", "000", "1",  			//P to T
				"001", "0001", "011", "1001", "1011",  			//U to Y
				"1100",  										//Z
				"01111", "0011", "00011", "0001", "00000",  	//1 to 5
				"10000", "11000", "11100", "11110", "11111",	//6 to 0
				"000111000", "11100010010", "1110011"  			//MAYDAY, OVER, OUT
		};

		MaroonedKeyword[] keywordArray = MaroonedKeyword.values();
		int i = 0;
		while(i < keywordArray.length)
		{
			patternMap.put(keywordArray[i], patternArray[i]);
			i++; 
		}
		
		return patternMap;
	}
	
	public static String getManual(HashMap<MaroonedKeyword, String> keywordMorseCodeMap)
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

		/* TANGO */
		String tango = keywordMorseCodeMap.get(MaroonedKeyword.TANGO);
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", tango) + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "decision helper") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", 
						tango + " pants nopants") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "100%, nopants") + "|\n");
		manual.append(rowDivider);

		/* UNIFORM */
		String uniform = keywordMorseCodeMap.get(MaroonedKeyword.UNIFORM);
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", uniform) + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "round up or down") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", uniform + " 2.5 up") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "3") + "|\n");
		manual.append(rowDivider);

		/* WHISKEY */
		String whiskey = keywordMorseCodeMap.get(MaroonedKeyword.WHISKEY);
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", whiskey) + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "# common letters") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", whiskey + " hello") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "3 letters in common") + "|\n");
		manual.append(rowDivider);

		/* YANKEE */
		String yankee = keywordMorseCodeMap.get(MaroonedKeyword.YANKEE);
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", yankee) + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "square root") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", yankee + " 4") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "sqrt(4) = 2") + "|\n");
		manual.append(rowDivider);
		
		/* MAYDAY */
		String mayday = keywordMorseCodeMap.get(MaroonedKeyword.MAYDAY);
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", mayday) + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "display manual") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", mayday) + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "(n/a)") + "|\n");
		manual.append(rowDivider);

		/* OVER */
		String over = keywordMorseCodeMap.get(MaroonedKeyword.OVER);
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", over) + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "change mode") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", over + " -m npa") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "(n/a)") + "|\n");
		manual.append(rowDivider);

		/* OUT */
		String out = keywordMorseCodeMap.get(MaroonedKeyword.OUT);
		manual.append("|");
		manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", out) + "|" + 
				String.format("%-" + CELL_TEXT_WIDTH + "s", "quit program") + "|" +  
				String.format("%-" + CELL_TEXT_WIDTH + "s", "(n/a)") + "|" +
				String.format("%-" + CELL_TEXT_WIDTH + "s", "(n/a)") + "|\n");
		manual.append(rowDivider);

		/*
		String ___ = keywordMorseCodeMap.get(MaroonedKeyword.___);
		manual.append("|");
    	manual.append(String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|" + 
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|" +  
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|" +
  			  		  String.format("%-" + CELL_TEXT_WIDTH + "s", "") + "|\n");
    	manual.append(rowDivider);
		 */

		return manual.toString();
	}
	
}//end MaroonedMorseCode.java

