package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		//Create a new Linked List
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		size ++;
		LLNode<E> node = new LLNode(element);
		LLNode<E> lastNode = tail.prev;
		lastNode.next = node;
		node.prev = lastNode;
		tail = node;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		E e= null;
		if(index + 1 > size){
			throw new IndexOutOfBoundsException("Specififed index greater than Linked list size");
		}else{
			LLNode nextNode = head;
			int i = 0;
			do{
				nextNode = head.next;
				i++;
			}while(i < index);
			
			e = (E) nextNode.data;
		}
		return e;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		LLNode<E> node = new LLNode(element);
		if(index > size){
			throw new IndexOutOfBoundsException("Specififed index greater than Linked list size");
		}else{
			LLNode nextNode = head;
			int i = 0;
			do{
				nextNode = head.next;
				i++;
			}while(i < index -1);
			
			if(nextNode.next != null){
				nextNode.next.prev = node;
				node = nextNode.next;
			}
			
			nextNode.next = node;
			size ++;
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		E e = null;
		if(index + 1 > size){
			throw new IndexOutOfBoundsException("Specififed index greater than Linked list size");
		}else{
			LLNode nextNode = head;
			int i = 0;
			do{
				nextNode = head.next;
				i++;
			}while(i < index);
			
			if(nextNode.next != null )
				nextNode.next.prev = nextNode.prev;
			
			e = (E) nextNode.data;
			nextNode.prev.next = nextNode.next;
			size --;
		}
		return e;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
