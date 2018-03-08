/*
    A linked list implementation of a stack which uses the structures
    of LinkedList.java. (Therefore, Is a child of LinkedList.)

    Complete the code as indicated by the comments
*/

public class LinkedStack extends LinkedList implements Stack {

   /* Write the default (no parameter) constructor.
    Have it call the constructor of the super class.
   */

	public LinkedStack() {
		super();
	}

   /*
     Complete the method for the push operation.
     1. Create a new node containing the data given by the formal parameter.
     2. If the linked list is empty make the head and the tail refer to the new node.
        Otherwise, add the new node to the head of the linked list.
   */
   public void push(Object data) {
		Node newNode = createNode(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
   }

   /*
     Complete the method for the peek operation.
     This method returns the data from the top of the stack.
     The stack must remain unchanged.
     1. If the stack is empty peek throws an EmptyCollectionException.
        See EmptyCollectionException.java that is written for you.
     2. Otherwise, return the data from the top of the stack.
        (Hint: return the data from the head of the list.)
   */
   public Object peek() throws EmptyCollectionException {
		if (head == null) {
			throw new EmptyCollectionException("stack peek");
		} else {
			return head.data;
		}
   }

   /*
     Complete the method for the pop operation.
     This method does the same as peek and, in addition,
     it removes the item that is on top of the stack.
     1. Call peek to get the data from the top of the stack.
     2. If peek returned null throw an EmptyCollectionException as
        there is nothing to pop off the stack.
        Otherwise remove the top of the stack. (Hint: make the top
        of the stack the next item on the stack.)
     3. return the data that was returned by peek in 1.

   */
   public Object pop() throws EmptyCollectionException {
      Object data = peek();
		  if (data == null) {
			  throw new EmptyCollectionException("stack pop");
		  } else {
			  head = head.next;
			  return data;
		  }
   }

}
