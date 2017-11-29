import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class Anagram 
{
	static int tableSize=1000000;
	static int minWordLen=3;
	static LinkedList<String>[] hashmapLinkedList = new LinkedList[tableSize];
	static HashMap< Character,Integer> hm = new HashMap< Character,Integer>();
	static ArrayList<String> lsPerm= new ArrayList<String>();
	static int hashString(String str)
	{
		//System.out.println(str);
		int code=0;
		for(int i=0;i<str.length();i++)
		{
			code=code*38+hm.get(str.charAt(i));
			code%=tableSize;
		}
		return code;
	}
	
	public static void permutation(String str) 
	{ 
		lsPerm.clear();
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) 
	    {
	    	lsPerm.add(prefix);
	    }
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		String vocabFileName = String.valueOf(args[0]);
		String inputFileName = String.valueOf(args[1]);
		//System.out.println("vocabFileName="+vocabFileName);
		//System.out.println("inputFileName="+inputFileName);
		// String vocabFileName = "vocabulary1.txt";
		// String inputFileName = "input1.txt";
		// TODO Auto-generated method stub
		int hashCount=1;
		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) 
		{
			//System.out.print(alphabet);
		    hm.put(alphabet,hashCount);
		    hashCount+=1;
		}
		for (char alphabet = '0'; alphabet <= '9'; alphabet++) 
		{
			//System.out.print(alphabet);
		    hm.put(alphabet,hashCount);
		    hashCount+=1;
		}
		char alphabet='\'';
		//System.out.print(alphabet);
		hm.put(alphabet, hashCount);
		hashCount+=1;
		alphabet='&';
		//System.out.print(alphabet);
		hm.put(alphabet, hashCount);
		for (int i=0;i<tableSize;i++)
		{
			hashmapLinkedList[i] = new LinkedList<String>();
		}
		String vocabLine = null;
		try {
			FileReader fileReader=new FileReader(vocabFileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String numWordLine=bufferedReader.readLine();
			int numWordsInVocab=Integer.parseInt(numWordLine);
			for(int z=0;z<numWordsInVocab;z++)
			{
				vocabLine = bufferedReader.readLine();
				//if(z==24976)
				//{
					//System.out.println(vocabLine);
				//}
				hashmapLinkedList[hashString(vocabLine)].add(vocabLine);
			}
	        bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		int maxLen=0;
//		for(int i=0;i<tableSize;i++)
//		{
//			if(hashmapLinkedList[i].size()>maxLen)
//			{
//				maxLen=hashmapLinkedList[i].size();
//			}
//		}
//		System.out.println(maxLen);
		
		
		
		String inputLine = null;
		try {
			FileReader fileReader=new FileReader(inputFileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String numWordLine=bufferedReader.readLine();
			int numWordsInInput=Integer.parseInt(numWordLine);
			for(int z=0;z<numWordsInInput;z++)
			{
				inputLine = bufferedReader.readLine();
				//System.out.println("For "+inputLine);
				permutation(inputLine);
				List<String> ansPerm= new ArrayList<String>();
				for(int k=0;k<lsPerm.size();k++)
				{
					String currStr=lsPerm.get(k);
					//Checking Full String
					if(hashmapLinkedList[hashString(currStr)].contains(currStr))
					{
						ansPerm.add(currStr);
					}
					for(int p=3;p<=currStr.length()-minWordLen;p++)
					{
						String substr1=currStr.substring(0, p);
						String substr2=currStr.substring(p,currStr.length());
						if(hashmapLinkedList[hashString(substr1)].contains(substr1))
						{
							//1 space
							if(hashmapLinkedList[hashString(substr2)].contains(substr2))
							{
								ansPerm.add(substr1+" "+substr2);
							}
							//2 space
							for(int q=3;q<=substr2.length()-minWordLen;q++)
							{
								String subsub1=substr2.substring(0,q);
								String subsub2=substr2.substring(q,substr2.length());
								if(hashmapLinkedList[hashString(subsub1)].contains(subsub1)
								&& hashmapLinkedList[hashString(subsub2)].contains(subsub2))
								{
									ansPerm.add(substr1+" "+subsub1+" "+subsub2);
								}
							}
						}
					}
					
				}
				//Collections.sort(ansPerm);
				HashSet<String> uniqueValues = new HashSet<String>(ansPerm);
				List sortedList = new ArrayList(uniqueValues);
				Collections.sort(sortedList);
				for(int e=0;e<sortedList.size();e++)
				{
					System.out.println(sortedList.get(e));
				}
				System.out.println("-1");
			}
	        bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
