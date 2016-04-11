package src;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
/**
 * 
 * @author Kristin
 *
 */
public class Testing
{

	public static void main(String[] args)
	{
		Scanner console = new Scanner(System.in);
		int option = 0;
		HashMap<String, MaroonedKeyword> morseCodeMap = getCommandKeywordMap('x', 'o');
		HashMap<MaroonedKeyword, String> keywordMorseCodeMap = 
				getKeywordMorseCodeMap(morseCodeMap);

		do
		{
			System.out.println("choose option");
			System.out.println(" 1. test keyword translation");
			System.out.println(" 2. test morse code translation");			
			System.out.println(" 3. test morse code map reversal");
			System.out.println("-1. exit");

			option = console.nextInt();
			console.nextLine();
			switch(option)
			{
				case 1:
					//HashMap<String, MaroonedKeyword> commandKeywordMap = 
					//getCommandMap();
					//System.out.println(commandKeywordMap.keySet());
					//System.out.println();
					break;

				case 2:
					//System.out.println("enter <dot> <space> <dash>");
					//String[] input = console.nextLine().split(" ");
					//char dot = input[0].charAt(0);
					//char dash = input[1].charAt(0);
					//System.out.println("dot = '" + dot + "'");
					//System.out.println("dash = '" + dash + "'");
					
					//HashMap<String, MaroonedKeyword> morseCodeMap = 
					//		getCommandKeywordMap(dot, dash);
					System.out.println("*** case2 ***");
					MaroonedKeyword value2;
					String key2 = "";
					Iterator itr2 = morseCodeMap.keySet().iterator();
					while(itr2.hasNext())
					{
						key2 = (String) itr2.next();
						value2 = morseCodeMap.get(key2);
						System.out.println("key = " + key2 + " value = " + value2);
					}
					System.out.println();
					//break;

				case 3:
					System.out.println("*** case3 ***");
					MaroonedKeyword key3;
					String value3 = "";
					Iterator itr3 = keywordMorseCodeMap.keySet().iterator();
					while(itr3.hasNext())
					{
						key3 = (MaroonedKeyword) itr3.next();
						value3 = keywordMorseCodeMap.get(key3);
						System.out.println("key = " + key3 + " value = " + value3);
					}
					System.out.println();
					break;

				case -1:
					System.out.println("Exiting program.");
					return;

				default:
					System.out.println("invalid option entered");
					break;
			}
		}
		while(option != -1);

		System.out.println("exiting program");
		return;
	}

	/* ------ */

	public static HashMap<String, MaroonedKeyword> getCommandMap()
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

	public static HashMap<String, MaroonedKeyword> getCommandKeywordMap(char dot, 
			char dash)
	{
		System.out.println("in getCommandKeywordMap()!");
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
		
		Iterator itr1 = (Iterator) patternMap.keySet().iterator();
		System.out.println("\nloop through patternMap...");
		
		while(itr1.hasNext())
		{
			MaroonedKeyword currentKey = (MaroonedKeyword) itr1.next();
			System.out.println("currentKey = " + currentKey + " currentValue = " + 
			patternMap.get(currentKey));
		}
		
		Iterator itr2 = (Iterator) morseCodeMap.keySet().iterator();
		System.out.println("\nloop through morseCodeMap...");
		String currentKeyString = "";
		
		while(itr2.hasNext())
		{
			currentKeyString = (String) itr2.next();
			System.out.println("currentKey = " + currentKeyString + " currentValue = " + 
					morseCodeMap.get(currentKeyString));
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
		MaroonedKeyword currentValue;
		
		while(itr.hasNext())
		{
			currentKey = (String) itr.next();
			currentValue = morseCodeKeywordMap.get(currentKey);
			keywordMorseCodeMap.put(currentValue, currentKey);			
		}		
		
		return keywordMorseCodeMap;
	}
	
	/**
	 * 
	 */
	public static HashMap<MaroonedKeyword, String> getMorseCodePatternMap()
	{
		System.out.println("in getMorseCodePatternMap()!");
		HashMap<MaroonedKeyword, String> patternMap = new HashMap<MaroonedKeyword, String>();	
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
	
	public static void printTranslationResults(
			HashMap<String, MaroonedKeyword> morseCodeMap)
	{
		System.out.println("in printTranslationResults()!");
		//MaroonedKeyword[] keywordValues = MaroonedKeyword.values();
		Iterator itr = (Iterator) morseCodeMap.keySet().iterator();
		System.out.println("approachingloop...");
		MaroonedKeyword currentKeyword;
		String currentKey = "";
		System.out.println("morseCodeMap.size() = " + morseCodeMap.size());

		while(itr.hasNext())
		{
			currentKey = (String) itr.next();
			currentKeyword = morseCodeMap.get(currentKey);
			System.out.println("Key: " + currentKey + " Value: " + currentKeyword);
			return;
		}
		
		
		
	}


}
