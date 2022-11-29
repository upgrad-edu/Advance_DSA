class ArrayList {

    private Object[] arrayList;

    
    private int elementsInArray;

    public ArrayList() {
        this(10);
    }

    
    public ArrayList(int n) {
        if (n <= 0) {
            System.out.println("The size must be greater than 0. Try again.");
            return;
        }

        this.arrayList = new Object[n];
        this.elementsInArray = 0;
    }

    public void add(Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        this.arrayList[this.elementsInArray] = x;
        this.elementsInArray++;
    }

    
    public void add(int index, Object x) {
        if (checkIfArrayFull()) {
            copyArray(0, "double");
        }

        if (index >= this.arrayList.length) {
            System.out.println("The index is out of bounds");
            System.exit(-1);
        }

        Object temp = this.arrayList[index];
        arrayList[index] = x;

        Object temp2;

        for (int i = index; i < this.arrayList.length - 1; i++) {
            temp2 = arrayList[i + 1];
            arrayList[i + 1] = temp;
            temp = temp2;
        }

        copyArray(0, "");
        this.elementsInArray++;
    }


    public Object get(int index) {
        Object element = null;

        try {
            element = this.arrayList[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index that you specified is not within bounds.");
            System.exit(-1);
        }

        return element;
    }

    public int size() {
        return this.elementsInArray;
    }

    public boolean isEmpty() {
        return this.elementsInArray == 0;
    }

    
    public boolean isIn(Object ob) {
        return find(ob) >= 0;
    }

    
    public int find (Object n) {
        for (int i = 0; i < this.arrayList.length; i++) {
            if (n.equals(this.arrayList[i])) {
                return i;
            }
        }

        return -1;
    }

    
    public void remove (Object n) {
        for (int i = 0; i < this.elementsInArray; i++) {
            if (n.equals(this.arrayList[i])) {
                this.arrayList[i] = null;
                this.elementsInArray--;
                copyArray(0, "");
                return;
            }
        }
    }

    
    private boolean checkIfArrayFull() {
        return this.arrayList.length == this.elementsInArray;
    }

    
    private void copyArray(int size, String action) {
        size = increaseArraySize(size, action);

        Object[] tempArray = new Object[size];

        int tempElement = 0;

        for (int i = 0; i < this.arrayList.length; i++, tempElement++) {
            if (this.arrayList[i] == null) {
                tempElement--;
                continue;
            }

            tempArray[tempElement] = this.arrayList[i];
        }

        this.arrayList = null;
        this.arrayList = new Object[tempArray.length];
        this.arrayList = tempArray;
    }

    
    private int increaseArraySize(int size, String action) {
        if (action.equals("double")) {
            size = this.arrayList.length * 2;
        } else {
            size = this.arrayList.length + size;
        }

        return size;
    }
}

public class Custom_arraylist {

    public static void main(String[] args) {

        System.out.println("Create Constructor setting ArrayList to capacity 50");
        ArrayList numeric = new ArrayList(50);

        System.out.println("The ArrayList is empty: " + numeric.isEmpty());
        System.out.println("The numer of elements in array is: " + numeric.size());

        System.out.println("Populate the ArrayList with values from 1 to 20");
        for (int i = 0; i < 50; i++) {
            numeric.add((int)(Math.random() * 20) + 1);
        }

        System.out.println("The ArrayList is empty: " + numeric.isEmpty());
        System.out.println("The number of elements in array is: " + numeric.size());

        System.out.println("Add an element to the end of the ArrayList: i.e. 12345");
        numeric.add(12345);
        System.out.println("The index of 12345 is " + numeric.find(12345));

        System.out.println("The number of elements in array is: " + numeric.size());
        System.out.println("The value of element 50 is: " + numeric.get(50));

        System.out.println("Element at index 5 before removal: " + numeric.get(5));
        System.out.println("The number of elements in array is: " + numeric.size());
        System.out.println("Remove element at index 5");
        numeric.remove(numeric.get(5));
        System.out.println("Element at index 5 after removal: " + numeric.get(5));
        System.out.println("The number of elements in array is: " + numeric.size());

        System.out.println("Add an element at specific position");
        System.out.println("Element at index 10 before insertion: " + numeric.get(10));
        numeric.add(10, 200);
        System.out.println("Element at index 10 after insertion: " + numeric.get(10));
        System.out.println("Element at index 11 after insertion: " + numeric.get(11));

        System.out.println("Check to see if particular element is in array?");
        System.out.println("Is 12345 in array? " + numeric.isIn(12345));
        System.out.println("Is 123456 in array? " + numeric.isIn(123456));

        for (int i = 0; i < numeric.size(); i++) {
            System.out.println("ArrayList[" + i + "]: " + numeric.get(i));
        }

        System.out.println("************************************************");

        System.out.println("Tests the default constructor");

        ArrayList array = new ArrayList();
        System.out.println("Current size: " + array.size());
        System.out.println("Is the Array List empty? : " + array.isEmpty());
        array.add("x");
        array.add("b");
        array.add("aa");
        array.add("bh");
        array.add("G");
        array.add("d");
        array.add("a");
        array.add("e");
        array.add("bd");
        array.add("c");
        array.add(2, "DINO");
        array.add(2, "CAJIC");
        array.add(10, "DINO");
        array.add(19, "DINO");
        array.remove("DINO");
        array.remove("x");
        System.out.println("Current size: " + array.size());
        System.out.println("Is the Array List empty? : " + array.isEmpty());
        System.out.println("Object at index 1: " + array.get(1));
        System.out.println("Object at index 3: " + array.get(3));
        System.out.println("Position of G: " + array.find("G"));
        System.out.println("Position of na: " + array.find("na"));
        System.out.println("Is bd in array list? : " + array.isIn("bd"));
        System.out.println("Is bda in array list? : " + array.isIn("bda"));

        for(int i = 0; i < array.size(); i++) {
            System.out.println("ArrayList[" + i + "] : " + array.get(i));
        }

        System.out.println("Out of bounds array: " + array.get(22));
    }
}
