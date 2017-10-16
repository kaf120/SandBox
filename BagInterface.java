//
//	Name: Yeh, Jason
//	Project: 1
//	Due: 10/17/2017
//	Course: cs-240-01-f17
//	Description: Implementation of the ArrayBag ADT with a Test class to
//	showcase it's functions.
//

//An interface that contains the operation of the Bag ADT
public interface BagInterface<T>
{
	//Gets the current number of entries in this bag.
	public int getCurrentSize();

	//Sees whether this bag is full.
	public boolean isFull();

	//Sees whether this bag is empty.
	public boolean isEmpty();

	//Adds a new entry to this bag.
	public boolean add(T newEntry);

	//Removes one unspecified entry from this bag, if possible.
	public T remove();

	//Removes one occurrence of a given entry from this bag, if possible.
	public boolean remove(T anEntry);

	//Removes all entries
	public void clear();

	//Counts the number of times a given entry appears in this bag.
	public int getFrequencyOf(T anEntry);

	//Tests whether this bag contains a given entry.
	public boolean contains(T anEntry);

	//Creates an array of all entries taht are in this bag.
	public T[] toArray();
}
