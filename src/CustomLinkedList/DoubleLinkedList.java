package CustomLinkedList;

import java.util.function.Consumer;

public class DoubleLinkedList {
    public class Note {
        private int element;
        private Note previous;
        private Note next;

        public Note(int element) {
            this.element = element;
            this.previous = null;
            this.next = null;
        }

    }

    private Note head;
    private Note tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int element) {
        Note note = new Note(element);
        if (this.size == 0) {
            this.head = note;
            this.tail = note;
        } else {
            note.next = this.head;
            this.head.previous = note;
            this.head = note;
        }
        this.size++;
    }

    public void addLast(int element) {
        Note note = new Note(element);
        if (this.size == 0) {
            this.head = note;
            this.tail = note;
        } else {
            note.previous = this.tail;
            this.tail.next = note;
            this.tail = note;
        }
        this.size++;
    }

    public int removeFirst() {
        checkList();
        int element = this.head.element;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head.next.previous = null;
            this.head = this.head.next;
        }
        size--;
        return element;
    }

    public int removeLast() {
        checkList();
        int element = this.tail.element;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail.previous.next = null;
            this.tail = this.tail.previous;
        }
        size--;
        return element;
    }

    public Integer removeAt(int count) {
        checkList();
        checkIndex(count);
        int removedElement;
        Note current = this.head;

        if (this.size == 1) {
            this.head = this.tail = null;
            removedElement = current.element;
            return removedElement;
        }

        current = null;

        int middle = this.size / 2;

        int begin = 0;

        if (middle <= count) {
            current = this.tail;
            begin = this.size - 1;
            while (begin != count) {
                current = current.previous;
                begin--;
            }

        } else {
            current = this.head;
            while (begin < count) {
                current = current.next;
                begin++;
            }
        }


        removedElement = current.element;
        if (count == 0) {
            this.head = this.head.next;
            this.head.previous = null;
        } else if (count == this.size - 1) {
            this.tail = this.tail.previous;
            this.tail.next = null;
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }


        this.size--;

        return removedElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        checkList();
        Note current = this.head;

        while (current != null) {

            consumer.accept(current.element);

            current = current.next;
        }

    }

    public int[] toArray() {
        checkList();
        int[] array = new int[this.size];
        Note note = this.head;
        int counter = -1;

        while (note != null) {
            array[++counter] = note.element;
            note = note.next;
        }
        return array;
    }


    public int get(int index) {
        checkIndex(index);
        Note current;

        if (index < this.size / 2) {
            current = this.head;
            while (index-- > 0) {
                current = current.next;
            }
        } else {
            current = this.tail;
            while (index != this.size - 1) {
                current = current.previous;
            }
        }


        return current.element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d is out of bounds from size %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    private void checkList() {
        if (this.size == 0) {
            String message = "List is empty!";
            throw new NullPointerException(message);
        }
    }

}
