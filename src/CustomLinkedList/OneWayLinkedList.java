package CustomLinkedList;

import java.util.function.Consumer;

public class OneWayLinkedList {

    private class Note {

        private int element;
        private Note next;


        public Note(int element) {
            this.element = element;
            this.next = null;
        }
    }

    private Note head;
    private Note tail;
    private int size;

    public OneWayLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int element) {
        Note note = new Note(element);
        if (size == 0) {
            this.head = note;
            this.tail = note;
        } else {
            note.next = this.head;
            this.head = note;
        }
        size++;
    }

    public void addLast(int element) {
        Note newNote = new Note(element);
        if (size == 0) {
            this.head = newNote;
            this.tail = newNote;
        } else {
            this.tail.next = newNote;
            this.tail = newNote;
        }
        size++;
    }

    public int size() {
        return this.size;
    }

    public void forEach(Consumer<Integer> consumer) {
        if (this.size == 0){
            String message = "List is empty, you can not operate it!";
            throw new NullPointerException(message);
        }
        Note currentNote = this.head;

        while (currentNote != null) {
            consumer.accept(currentNote.element);
            currentNote = currentNote.next;
        }
    }

    public int get(int index) {
        checkIndex(index);
        Note current = this.head;

        while (index-- > 0) {

            current = current.next;
        }
        return current.element;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d, out of bounds %d", index, this.size);
            throw new NullPointerException(message);
        }
    }

    public int removeFirst() {
        if (this.size == 0) {
            String message = "List is empty!";
            throw new NullPointerException(message);
        }
        int element = this.head.element;

        this.head = this.head.next;


        this.size--;

        if (this.size == 0){
            this.head = this.tail = null;
        }
        return element;
    }

    public int removeLast() {
        if (this.size == 0) {
            String message = "List is empty!";
            throw new NullPointerException(message);
        }
        int element = this.tail.element;

        Note current = this.head;
        Note prev = current;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        this.tail = prev;
        this.tail.next = null;

        this.size--;
        if (this.size == 0){
            this.head = null;
            this.tail = null;
        }
        return element;
    }
    public int [] toArray(){
        if (this.size==0){
            return null;
        }
        int [] array  = new int[this.size];
        int counter = 0;
        Note current = this.head;
        while (current != null){
            array[counter] = current.element;


            counter++;
            current = current.next;
        }

        return array;
    }
}
