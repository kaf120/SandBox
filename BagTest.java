//
//	Name: Yeh, Jason
//	Project: 1
//	Due: 10/16/2017
//	Course:cs-240-01-f17
//	Description: Implementation fo the ArrayBag ADT and a Test class to
//
//

//Class to test the ArrayBagADT. This ArrayBag in particular holds Strings of one letter.
public class BagTest
{
	//Main method will take the user through and showcase all functions of the ArrayBag ADT with an organized printout.
	public static void main(String args[])
	{
		BagInterface<String> testBag = new ArrayBag<String>();

		String[] tempBag = {"A","A","B", "C", "C", "D","E","J"};
		String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

		System.out.println("J. Yeh's Bag ADT");
		System.out.println(" ");
		System.out.println("First we will print the status of the empty Bag");
		printBagStatus(testBag);
		System.out.println("Now we will add these objects into the bag: A,A,B,C,C,D,E,J");
		System.out.println("Printing again gives us:");
		testAdd(testBag,tempBag);
		printBagStatus(testBag);
		System.out.println("Now we will remove the \"E\" Object from the bag");
		testBag.remove("E");
		printBagStatus(testBag);
		System.out.println("And now we remove an unspecified Object from the bag, which will take from the last object");
		testBag.remove();
		printBagStatus(testBag);
		System.out.println("Now let's find the frequency of the letter A");
		printFrequency(testBag, "A");
		System.out.println("Now let's find the frequency of the letter N");
		printFrequency(testBag, "N");
		System.out.println("Let's see whether the Bag contains an instance of G");
		printContains(testBag, "G");
		System.out.println("How about B?");
		printContains(testBag, "B");
		System.out.println("Finally we will remove all things from the bag...");
		testBag.clear();
		printBagStatus(testBag);
		System.out.println("...And fill the Bag all the way up");
	 	testAdd(testBag,alpha);
		printBagStatus(testBag);
        }

	//Method will take an array and will add each element into the ArrayBag's array
	public static void testAdd(BagInterface<String> aBag, String[] input)
	{
		for(int i = 0; i < input.length; i++)
		{
			aBag.add(input[i]);
		}
	}

	//Method will print the status of the bag, using isFull(), isEmpty(), and getCurrentSize()
	//then calls printBagObject to print out the contents of the bag.
	public static void printBagStatus(BagInterface<String> aBag)
	{
		System.out.println(" ");
		System.out.println("     Is Bag Full?........... " + aBag.isFull());
		System.out.println("     Is Bag Empty?.......... " + aBag.isEmpty());
		System.out.println("     # Of Objects In Bag.... " + aBag.getCurrentSize());
		printBagObject(aBag);
		System.out.println(" ");
	}

	//Method will print the objects of the contents by using the toArray() method.
	public static void printBagObject(BagInterface<String> pBag)
	{
		Object[] printArray = pBag.toArray();
		System.out.print("     Objects in Bag: ");
		for(int j = 0; j < pBag.getCurrentSize(); j++)
		{
			System.out.print(printArray[j] + " ");
		}
		System.out.println(" ");
	}

	//Method will print out whether the bag contains the specified String target using the method contains(T anEntry).
	public static void printContains(BagInterface<String> aBag, String target)
	{
		System.out.println(" ");
		printBagObject(aBag);
		System.out.println("     Does the Bag contain " + target + "? " +  aBag.contains(target));
		System.out.println(" ");
	}

	//Method will print out the frequency of the String target using the method getFrequencyOf(T anEntry).
	public static void printFrequency(BagInterface<String> aBag, String target)
	{
		System.out.println(" ");
		printBagObject(aBag);
		System.out.println("     Frequency of " + target + " is: " + aBag.getFrequencyOf(target));
		System.out.println(" ");
	}
}
