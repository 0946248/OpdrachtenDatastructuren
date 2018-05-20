package Opdracht2;

public class List {
    private Student start;
    private Student end;
    private int size;

    public List() {
        start = new Student();
        end = new Student();
        start.setNext(end);
        end.setPrevious(start);
        size = 0;
    }

    public boolean push(Student s, int index) {
        if (index > size + 1) {
            System.out.println("Geen geldige index opgegeven. Geef alstubleft een nummer tussen 1 & " + size + " in plaats van " + index + ".");
            return false;
        }
        Student temp;
        if (index == 1) {
            temp = start.getNext();
            start.setNext(s);
            s.setNext(temp);
            s.setPrevious(start);
            temp.setPrevious(s);
            size++;
            return true;
        } else if (index == size) {
            temp = end.getPrevious();
            end.setPrevious(s);
            s.setPrevious(temp);
            s.setNext(end);
            temp.setNext(s);
            size++;
            return true;
        } else {
            Student tempNext = start.getNext();
            Student tempPrev = start;
            for (int i = 0; i < index - 1; i++) {
                tempPrev = tempNext;
                tempNext = tempNext.getNext();
            }
            tempPrev.setNext(s);
            s.setPrevious(tempPrev);

            tempNext.setPrevious(s);
            s.setNext(tempNext);
            size++;
        }
        return true;
    }

    public int size() {
        return size;
    }

    public Student head() {
        Student s = start.getNext();
        Student t = s.getNext();
        start.setNext(t);
        t.setPrevious(start);
        return s;
    }

    public Student tail() {
        Student s = end.getPrevious();
        Student t = s.getPrevious();
        end.setPrevious(t);
        t.setNext(end);
        return s;
    }

    public Student pop(int index) {
        Student s = null;
        Student tempPrev = null;
        Student tempNext = start;
        if(index > size){
            System.out.println("Er staat niks in de List");
            return null;
        }
        for (int i = 0; i < index; i++) {
            tempPrev = tempNext;
            tempNext = tempNext.getNext();
        }
        s = tempNext;
        tempNext = tempNext.getNext();
        //System.out.println("Prev ="+tempPrev.toString()+" s ="+s.toString()+" Next ="+tempNext.toString());
        tempNext.setPrevious(tempPrev);
        tempPrev.setNext(tempNext);
        s.setNext(null);
        s.setPrevious(null);
        size--;
        return s;
    }

    public boolean peek(Student s) {
        Student t = start.getNext();
        for (int i = 0; i < size; i++) {
            if (s == t) {
                return true;
            }
            t = t.getNext();
        }
        return false;
    }

    public void printList() {
        Student s = start.getNext();
        System.out.println("=========List Start==========");
        for (int i = 1; i < size + 1; i++) {
            System.out.println("Index:" + i + " bevat " + s.toString());
            s = s.getNext();
        }
        System.out.println("=========List End==========");
    }

    public void printMen() {
        Student s = start.getNext();
        System.out.println("=========Male List Start==========");
        for (int i = 1; i < size + 1; i++) {
            if (s.getGeslacht().equals("m") || s.getGeslacht().equals("M")) {
                System.out.println("Index:" + i + " bevat " + s.toString());
            }
            s = s.getNext();
        }
        System.out.println("=========Male List End==========");
    }

    public void printWomen() {
        Student s = start.getNext();
        System.out.println("=========Female List Start==========");
        for (int i = 1; i < size + 1; i++) {
            if (s.getGeslacht().equals("v") || s.getGeslacht().equals("V")) {
                System.out.println("Index:" + i + " bevat " + s.toString());
            }
            s = s.getNext();
        }
        System.out.println("=========Female List End==========");
    }
}
