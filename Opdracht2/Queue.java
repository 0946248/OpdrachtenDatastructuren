package Opdracht2;

public class Queue {
    private Student start;
    private Student end;
    private int size;
    private boolean debug = false;

    public Queue() {
        start = new Student();
        end = new Student();
        start.setNext(end);
        end.setPrevious(start);
        size = 0;
    }

    public boolean push(Student s) {
        if (size == 0) {
            start.setNext(s);
            s.setNext(end);
            s.setPrevious(start);
            end.setPrevious(s);
        }
        Student temp = end.getPrevious();
        temp.setNext(s);
        s.setPrevious(temp);
        end.setPrevious(s);
        s.setNext(end);
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public Student pop() {
        if (size == 0) {
            System.out.println("Er staat niks in de Queue");
            return null;
        }
        Student s = start.getNext();
        if (size == 1) {
            start.setNext(end);
            end.setPrevious(start);
            size--;
            return s;
        }
        Student temp = s.getNext();
        start.setNext(temp);
        temp.setPrevious(start);
        size--;
        s.setNext(null);
        s.setPrevious(null);
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

    public void printQueue() {
        Student s = start.getNext();
        System.out.println("=========Queue Start==========");
        for (int i = 0; i < size; i++) {
            System.out.println(s.toString());
            s = s.getNext();
        }
        System.out.println("=========Queue End==========");
    }

    public void printMen() {
        Student s = start.getNext();
        System.out.println("=========Male Queue Start==========");
        for (int i = 0; i < size; i++) {
            if (s.getGeslacht().equals("m") || s.getGeslacht().equals("M")) {
                System.out.println(s.toString());
            }
            s = s.getNext();
        }
        System.out.println("=========Male Queue End==========");
    }

    public void printWomen() {
        Student s = start.getNext();
        System.out.println("=========Female Queue Start==========");
        for (int i = 0; i < size; i++) {
            if (s.getGeslacht().equals("v") || s.getGeslacht().equals("V")) {
                System.out.println(s.toString());
            }
            s = s.getNext();
        }
        System.out.println("=========Female Queue End==========");
    }


}
