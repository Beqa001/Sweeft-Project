public class DataStructure<T> {
    private Node root;
    private Node end;

    private class Node {
        public Node(T value) {
            this.value = value;
        }

        private Node previous;
        private Node next;
        private T value;
    }

    public T add(T element) {
        if (root == null) {
            root = new Node(element);
            end = root;
            return element;
        }

        end.next = new Node(element);
        end.next.previous = end;
        end = end.next;

        return element;
    }

    public T pop() {
        Node temp = end.previous;
        end = end.previous;
        end.next = null;
        return temp.value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node curr = root;
        while (curr!=null){
            stringBuilder.append(curr.value);
            if(curr.next!=null){
                stringBuilder.append(" - ");
            }

            curr=curr.next;
        }
        return stringBuilder.toString();
    }

}