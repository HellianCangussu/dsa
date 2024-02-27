class Node {
    public int _value;
    public Node _next;

    public Node(int value) {
        _value = value;
    }
}

class SinglyLinkedList {
    public Node _head;
    public Node _tail;
    public int _count;

    public SinglyLinkedList() {
        _head = null;
        _tail = null;
        _count = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (_head == null) {
            _head = _tail = newNode;
        } else {
            var cursor = _head;
            newNode._next = cursor;
            _head = newNode;
        }
        _count++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (_head == null) {
            _head = _tail = newNode;
        } else {
            var cursor = _tail;
            cursor._next = newNode;
            _tail = newNode;
        }
        _count++;
    }

    public void insertAt(int value, int index) {
        if (index == 0) {
            append(value);
        } else if (index == (_count - 1)) {
            prepend(value);
        } else if (index > 0 && index < (_count - 1)) {
            var cursor = _head;
            var newNode = new Node(value);
            for (int i = 1; i < index; i++) {
                cursor = cursor._next;
            }
            newNode._next = cursor._next;
            cursor._next = newNode;
            _count++;
        }
    }

    public void removeAt(int index) {
        if (_count == 0 || index < 0 || index >= _count) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            _head = _head._next;
        } else if (index == (_count - 1)) {
            var cursor = _head;
            while (cursor._next != null && cursor._next != _tail) {
                cursor = cursor._next;
            }
            cursor._next = null;
            _count--;
        } else {
            int i = 0;
            Node cursor = _head;
            while (cursor._next != null) {
                if (i + 1 == index) {
                    cursor = cursor._next._next;
                    _count--;
                    break;
                }
                i++;
                cursor = cursor._next;
            }
        }
    }

    public int getAt(int index) {
        if (index == 0) {
            return _head._value;
        }

        if (index == (_count - 1)) {
            return _tail._value;
        }

        if (index > 0 && index < (_count - 1)) {
            Node cursor = _head;
            for (int i = 1; i < index; i++) {
                cursor = cursor._next;
            }
            return cursor._value;
        }

        throw new IndexOutOfBoundsException();
    }

    public void reverse() {
        Node prev = null;
        Node curr = _head;
        Node next = null;
        while (curr != null) {
            next = curr._next;
            curr._next = prev;
            prev = curr;
            curr = next;
        }
        _head = prev;
    }

    public void print() {
        var cursor = _head;
        while (cursor != null) {
            System.out.print(cursor._value+" - ");
            cursor = cursor._next;
        }
        System.out.print("\n");
    }
}