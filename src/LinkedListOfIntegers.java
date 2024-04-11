public class LinkedListOfIntegers {

    private class Node {
        public int element;
        public Node next;

        public Node(int element) {
            this(element, null);
        }

        public Node(int element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public LinkedListOfIntegers(int size) {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(int element)  {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }
    public void add(int index, int element) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException();
        }

        Node n = new Node(element);

        if (index == 0) {
            n.next = head;
            head = n;
            if (count == 0) {
                tail = n;
            }
        } else if (index == count) {
            tail.next = n;
            tail = n;
        } else {
            Node c = head;
            for (int i = 0; i < index - 1; i++) {
                c = c.next;
            }
            n.next = c.next;
            c.next = n;
        }
        count++;
    }

    public int get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        Node c = head;
        for (int i = 0; i < index; i++) {
            c = c.next;
        }

        return c.element;
    }
    public int set(int index, int element) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        Node c = head;
        for (int i = 0; i < index; i++) {
            c = c.next;
        }

        int antigo = c.element;
        c.element = element;

        return antigo;
    }

    public boolean remove(int element) {
        if (count == 0)
            return false;
        if (element == head.element) {
            if (count == 1) {
                tail = null;
            }
            head = head.next;
            count--;
            return true;
        }
        Node ant = head;
        Node aux = head.next;
        while (aux != null) {
            if (element == aux.element) {
                if (aux == tail) {
                    tail = ant;
                    tail.next = null;
                } else {
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            aux = aux.next;
            ant = ant.next;
        }
        return false;
    }

    public boolean removeAll(int element) {
        int removedCount = 0;
        while (count > 0 && head.element == element) {
            if (count == 1) {
                tail = null;
            }
            head = head.next;
            count--;
            removedCount++;
        }
        Node ant = head;
        Node aux = head.next;
        while (aux != null) {
            if (aux.element == element) {
                if (aux == tail) {
                    tail = ant;
                    tail.next = null;
                } else {
                    ant.next = aux.next;
                }
                count--;
                removedCount++;
            } else {
                ant = aux;
            }
            aux = aux.next;
        }
        return removedCount > 0;
    }

    public int removeByIndex(int index) {
        if (index < 0 || index >= getSize())
            throw new IndexOutOfBoundsException();

        int remo;

        if (index == 0) {
            remo = head.element;
            head = head.next;
            if (count == 1) {
                tail = null;
            }
        } else {
            Node ant = head;
            for (int i = 0; i < index - 1; i++) {
                ant = ant.next;
            }
            remo = ant.next.element;
            if (index == count - 1) {
                tail = ant;
                tail.next = null;
            } else {
                ant.next = ant.next.next;
            }
        }

        count--;
        return remo;
    }


    public boolean isEmpty() {
        return (head == null);
    }

    public int getSize() {
        return count;
    }

    public boolean contains(Integer element) {
        Node aux = head;
        for(int i=0; i<count; i++) {
            if (aux.element==element) {
                return true;
            }
            aux=aux.next;
        }
        return false;
    }

    public int indexOf(Integer element) {

        Node aux = head;
        for(int i=0; i<count; i++) {
            if (aux.element==element) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public void sort() {
        if (count <= 1) {
            return;
        }

        Node c = head;
        Node index = null;
        int temp;

        while (c != null) {
            index = c.next;
            while (index != null) {
                if (c.element < index.element) {
                    temp = c.element;
                    c.element = index.element;
                    index.element = temp;
                }
                index = index.next;
            }
            c = c.next;
        }
    }

    public void reverse() {
        if (count <= 1) {
            return;
        }

        Node previous = null;
        Node c = head;
        Node next = null;

        tail = head;

        while (c != null) {
            next = c.next;
            c.next = previous;

            previous = c;
            c = next;
        }

        head = previous;
    }

    public LinkedListOfIntegers getSubset(int start, int end) {
        if (start < 0 || start >= count || end <= start || end > count) {
            throw new IllegalArgumentException("Índices inválidos");
        }

        LinkedListOfIntegers subsetList = new LinkedListOfIntegers(count);
        Node c = head;
        int currentIndex = 0;

        while (c != null && currentIndex < end-1) {
            if (currentIndex >= start-1) {
                subsetList.add(c.element);
            }
            c = c.next;
            currentIndex++;
        }

        return subsetList;
    }
}
