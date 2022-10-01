public class Element {
    private Element prev;
    private Element next;
    private int key; 

    public Element(int k) {
        key = k;
    }

    public int getKey() {
        return key;
    }

    public Element getPrev() {
        return prev;
    }

    public Element getNext() {
        return next;
    }

    public void setPrev(Element _prev) {
        prev = _prev;
    }

    public void setNext(Element _next) {
        next = _next;
    }

    
}
