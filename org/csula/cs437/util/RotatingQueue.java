package org.csula.cs437.util;

import java.util.Collection;
import java.util.LinkedList;

public class RotatingQueue<E> extends LinkedList<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7689053011843105686L;
	
	public RotatingQueue(Collection<? extends E> c)
	{
		super(c);
	}
	
	public void rotateForward()
	{
		super.addLast(super.removeFirst());
	}
	
	public void rotateBackward()
	{
		super.addFirst(super.removeLast());
	}
}
