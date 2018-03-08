public interface Stack {
    public Object pop() throws EmptyCollectionException;
    public Object peek() throws EmptyCollectionException;
    public void push(Object data);
    public boolean isEmpty();
}
