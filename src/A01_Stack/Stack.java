package A01_Stack;


public class Stack<T>
{
	 private Node<T> first;
     private int counter = 0;
    /**
     * Oberstes Element entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {
        if(first == null)
            throw new StackEmptyException();
/*
        T result = first.getData();
        first = first.getNext();
    	return result;
 */

        // So wird der Speicher auch wieder mittels Garbage Collector freigegeben:
        Node<T> result = first;
        first = first.getNext();
        result.setNext(null);
        counter--;
        return result.getData();

    }
    
    /**
     * Übergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {
        Node<T> pushed = new Node<>(i);
        pushed.setNext(first);
        first = pushed;
        counter++;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return counter;
    }


    // Falls ich keine 4 Byte für den counter verwenden will (z.B. hardwarenahe Programmierung):
    public int getCountAlternative(){
        int counter = 0;
        Node<T> iterator = first;

        while(iterator != null){
            counter++;
            iterator = iterator.getNext();
        }
        return counter;
    }
}
