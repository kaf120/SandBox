//
//	Name: Yeh, Jason
//	Project #1
//	Due: 10/16/2017
//	Course: cd-240-01-f17
//	Description: Implementation of the ArrayBag ADT and a Test class to
//      showcase it's functions.
//

//A class implementing the BagInterface and storing data in a fixed-size array.
public class ArrayBag<T> implements BagInterface<T>
{
	//Declaration of the bag array.
	private final T[] bag;

	//The default capacity of the bag,when capacity is no specified.
	private static final int DEFAULT_CAPACITY = 26;

	//int that will keep track of the number of entries inside the bag.
   	private int numberOfEntries;

	//Creates an empty Bag whos initial capacity is 25
   	public ArrayBag()
   	{
		this(DEFAULT_CAPACITY);
	}

	//Creates an empty bag with the capacity as a paramter
   	public ArrayBag(int capacity)
	{
		numberOfEntries = 0;

		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[capacity];
		bag = tempBag;
   	}

	//Adds a new entry to this bag. Object newEntry will be added to the bag and
        //will return true if the addition is successful, or false if not
	public boolean add(T newEntry)
	{
		boolean result = true;
		if(isFull())
		{
			result = false;
		}
		else
		{
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		return result;
	}

	//Takes all data and stores inside another array for use outside of the class
	// returns a new array with the data inside.
	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		for(int j = 0; j < numberOfEntries; j++)
		{
			result[j] = bag[j];
		}
		return result;
	}

	//Checks to see if the bag is at maximum capacity
	//returns true if the bag is full, false if not.
	public boolean isFull()
	{
		return numberOfEntries == bag.length;
	}

	//checks to see if the bag is empty
	//returns true if the bag is empty, false if not.
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}

	//returns the number of objects inside the bag
	public int getCurrentSize()
	{
		return numberOfEntries;
	}

	//counts the number of times a given entry appears in this bag.
	//anEntry is the entry to be counted
	//returns the number of times anEntry appears in the bag.
	public int getFrequencyOf(T anEntry)
	{
		int counter = 0; 

		for(int j = 0; j < numberOfEntries; j++)
		{
			if(anEntry.equals(bag[j]))
			{
				counter++;
			}
		}
		return counter;
	}

	//Tests whetehr this bag contains a given entry.
	//anEntry is the entry to be located.
	//returns true if the bag contains the entry, false if not.
	public boolean contains(T anEntry)
	{
		return getIndexOf(anEntry) > -1;
	}

	//clears all entries from the bag.
	public void clear()
	{
		while(!isEmpty())
		{
			remove();
		}
	}

	//Removes one unspecified entry from this bag,if possible.
	//returns the removed entry, if the removal was successsful, or null if
	// not
	public T remove()
	{
		T result = null;
		if(numberOfEntries > 0)
		{
			numberOfEntries--;
			result = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		}
		return result;
	}

	//Removes a specific entry from the bag, if it is inside.
	//anEntry is the object to be removed.
	//returns true if the object is removed, false if not.
	public boolean remove(T anEntry)
	{
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	}

	//Removes the entry at the given index in the array
	//If no such entry exists, return null.
	public T removeEntry(int givenIndex)
	{
		T result = null;
		if(!isEmpty() && (givenIndex >= 0))
		{
			result = bag[givenIndex];
			numberOfEntries--;
			bag[givenIndex] = bag[numberOfEntries];
			bag[numberOfEntries] = null;
		}
		return result;
	}

	//Locates a given entry within the array bag.
	//Returns the index of the entry, or -1 if not.
	public int getIndexOf(T anEntry)
	{
		int where = -1;
		boolean found = false;

		for(int index = 0; !found && (index < numberOfEntries); index++)
		{
			if(anEntry.equals(bag[index]))
			{
				found = true;
				where = index;
			}
		}
		return where;
	}


}

