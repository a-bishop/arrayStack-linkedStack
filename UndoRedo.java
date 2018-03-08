import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Application to demonstrate the use of a stack by simulating an editor's un/redo operations.
 *
 * @author lynda, rt
 */
public class UndoRedo {


    private static Stack doneStack;
    private static Stack undoneStack;


    public static void initLinkedStacks() {
        doneStack = new LinkedStack();
        undoneStack = new LinkedStack();
    }

    /*public static void initArrayStacks() {
        doneStack = new ArrayStack();
        undoneStack = new ArrayStack();
    }*/

    public static Scanner openFile(String fileName) throws IOException{
        FileInputStream fileByteStream = new FileInputStream(fileName);
        return(new Scanner(fileByteStream));
    }

    public static void performOperation(String operation) {
        System.out.println("Operation: " + operation + " started.");
        switch (operation) {
            case "typing" :
            case "auto format" :
            case "bold" :
            case "italic" :
            case "copy text" :
                doneStack.push(operation);
                break;

            case "UNDO" :
                if (doneStack.isEmpty())
                    System.out.println("x Cannot undo. Nothing to undo.");
                else {
                    System.out.println("About to pop: " + doneStack.peek());
                    operation = (String) doneStack.pop();
                    undoneStack.push(operation);
                }
                break;

            case "REDO" :
                if (undoneStack.isEmpty())
                    System.out.println("x Cannot redo. Nothing to redo.");
                else {
                    operation = (String) undoneStack.pop();
                    doneStack.push(operation);
                }
                break;
        }
        System.out.println("Operation: " + operation + " completed.");
    }


    /* This program performs operations in the order given in a supplied input file.
    * The operations are repeated for both ArrayStack and LinkedStack implementations. Both
    * tests should produce identical output.
    */
    public static void main(String[] args) throws Exception {
        String fileName;
        Scanner inputFileStream;
        String operation;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = keyboard.nextLine();


        // Begin LinkedStack test.
        System.out.println("--- Beginning LinkedStack Test ---");
        initLinkedStacks();
        inputFileStream = openFile(filename);

        while (inputFileStream.hasNextLine()) {
            operation = inputFileStream.nextLine();
            performOperation(operation);
        }
        System.out.println();
        inputFileStream.close();

        Begin ArrayStack test.
        System.out.println("--- Beginning ArrayStack Test ---");
        initArrayStacks();
        inputFileStream = openFile(filename);

        while (inputFileStream.hasNextLine()) {
            operation = inputFileStream.nextLine();
            performOperation(operation);
        }
        System.out.println();
        inputFileStream.close();*/
   }
}
