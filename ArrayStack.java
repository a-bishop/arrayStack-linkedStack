/*
 Array implementation of stacks.

      push
     set array[nextIndex] = data
     increment nextIndex

     expandCapacity
     make a new array twice as long
     copy elements from old to new Array
     set data member to the new array

     general case
     decrement nextIndex
     return array[nextIndex]

     special case
     empty stack
*/

public class ArrayStack implements Stack {
   /* Declare a class constant called DEFAULT_STACK_SIZE with the value 10.
   */

   public static final int DEFAULT_STACK_SIZE = 10;

   /* Declare two instance variables:
    1. an integer called nextIndex
    2. a reference variable of type array of objects.
   */

   private int nextIndex;
   private Object[] array;

   /* Complete the one parameter constructor.
    The parameter indicates the size of the stack
    (i.e. the size of the array that represents that stack.)
    Be sure to create the array!
   */
   public ArrayStack(int size) {
	   array = new Object[size];
     nextIndex = 0;
   }

   /* Write the default (no parameter) constructor.
    Initialize the instance variables by invoking the one parameter constructor
    you just completed. Set the size of the stack to DEFAULT_STACK_SIZE.

   */
   public ArrayStack() {
     this(DEFAULT_STACK_SIZE);
   }

   /* Complete the push operation.
    Be sure to first check to see if the stack is full.
    If the stack is full invoke the method expandCapacity to 'grow' the stack.

   */
   public void push(Object element) {
     if (nextIndex > array.length-1) {
       expandCapacity();
     } else {
       array[nextIndex] = element;
       nextIndex++;
     }
   }

   /* Complete the peek operation.
    It should throw an EmptyCollectionException if the stack is empty.
   */
   public Object peek() throws EmptyCollectionException {
     if (nextIndex == 0) {
       throw new EmptyCollectionException("array");
     } else {
       return array[nextIndex-1];
     }
   }

   /* Complete the pop operation.
    Like the peek operation, pop should throw an EmptyCollectionException if the stack is empty.
    Be sure to set the position from where the element was removed to null.
   */
   public Object pop() throws EmptyCollectionException {
     if (nextIndex == 0) {
       throw new EmptyCollectionException("array");
     } else {
       nextIndex--;
       return array[nextIndex];
     }
   }

   /* Write the method isEmpty.
    It returns true if the stack is empty and false otherwise.
   */
   public boolean isEmpty() {
      return size() == 0;
   }

   /* Write the method size.
    It returns an integer representing the number of items on the stack.
   */
   public int size() {
     return nextIndex;
   }

   /* This method has been completed for you.
   */
   public String toString() {
      return super.toString();
   }

   /* This method is called from the push method when the stack is full.
    It should keep the current stack contents and double the size of the stack.
    Hint: look at the methods in the Arrays class to help you here.
   */
   private void expandCapacity() {
     Object[] arrayNew = new Object[array.length*2];
     for (int i=0; i<array.length; i++) {
       arrayNew[i] = array[i];
     }
     array = arrayNew;
   }
}
