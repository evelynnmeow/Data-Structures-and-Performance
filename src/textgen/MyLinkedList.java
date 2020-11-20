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
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		size = 0;
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		// check if the element is null
		if (element == null) {
			throw new NullPointerException();
		}
		// if the element is not null
		// create a node for the element
		LLNode<E> node  = new LLNode<E>(element);
		node.next = tail;
		node.prev = tail.prev;
		tail.prev.next = node;
		tail.prev = node;
		size++;
		
		
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		// check if the element is null
		if (element == null) {
			throw new NullPointerException();
		}
		// check if index is out of bound
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> new_node = new LLNode<E>(element);
		// get the node at index
		LLNode<E> curr_node = head;
		for (int i = 0; i < index; i++) {
			curr_node = curr_node.next;
		}
		new_node.prev = curr_node;
		new_node.next = curr_node.next;
		new_node.prev.next = new_node;
		curr_node.next = new_node;
		
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
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
		// TODO: Implement this method
		// check if index is out of bound
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bound");
		}
		// locate the node
		LLNode<E> delete_node = head;
		for (int i = 0; i <= index; i++) {
			delete_node = delete_node.next;
		}
		delete_node.prev.next = delete_node.next;
		delete_node.next.prev = delete_node.prev;
		delete_node.prev = null;
		delete_node.next = null;
		size--;
		return delete_node.data;
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
		// check whether the index is out of bound
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index is out of bound");
			
		}
		// check if the element is null
		if (element == null) {
			throw new NullPointerException("Should not set null element");
			
		}
		
		LLNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		node.data = element;
		
		return element;
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
