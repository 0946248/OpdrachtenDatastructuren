package Opdracht2;

public class SortedList {
    protected Student start;
    protected Student end;
    private int size;
    private boolean debug = false;

    public SortedList() {
        start = new Student();
        start.setNaam("start");
        end = new Student();
        end.setNaam("end");
        start.setNext(end);
        end.setPrevious(start);
        size = 0;
    }

    public boolean push(Student s) {
        Student temp = start.getNext();
        start.setNext(s);
        s.setNext(temp);
        s.setPrevious(start);
        temp.setPrevious(s);
        size++;
        if (size > 1) {
            sortList();
        }
        return true;
    }

    public void sortList() {
        for (int i = 0; i < size; i++) {
            Student checkPrev = start;
            Student check1 = start.getNext();
            Student check2 = start.getNext().getNext();
            Student checkNext = start.getNext().getNext().getNext();
            for (int j = 1; j < size; j++) {
                if (check1.getStudentnummer() > check2.getStudentnummer()) {
                    //switch elements
                    if (debug) System.out.println("Switching " + check1.toString() + " & " + check2.toString());
                    if (debug)
                        System.out.println("Changing prev next from " + checkPrev.getNext().toString() + " to " + check2.toString());
                    checkPrev.setNext(check2);
                    if (debug) System.out.println("Changing temp to " + check2.getNext().toString());
                    Student temp = check2.getNext();
                    if (debug)
                        System.out.println("Changing 2 prev from " + check2.getPrevious().toString() + " to " + check1.getPrevious().toString());
                    check2.setPrevious(check1.getPrevious());
                    if (debug)
                        System.out.println("Changing 2 next from " + check2.getNext().toString() + " to " + check1.toString());
                    check2.setNext(check1);
                    if (debug)
                        System.out.println("Changing 1 prev from " + check1.getPrevious().toString() + " to " + check2.toString());
                    check1.setPrevious(check2);
                    if (debug)
                        System.out.println("Changing 1 next from " + check2.getNext().toString() + " to " + temp.toString());
                    check1.setNext(temp);
                    if (debug)
                        System.out.println("Changing next prev from " + checkNext.getPrevious().toString() + " to " + check1.toString());
                    checkNext.setPrevious(check1);

                    if (debug)
                        System.out.println("Prev:" + checkPrev.toString() + " 1:" + check1.toString() + " 2:" + check2.toString() + " Next:" + checkNext.toString());
                    if (debug) printSortedList();

                    checkPrev = checkPrev.getNext();
                    if (debug) System.out.print("Next Prev:" + checkPrev.toString());
                    check1 = checkPrev.getNext();
                    if (debug) System.out.print(" Next 1:" + check1.toString());
                    check2 = checkPrev.getNext().getNext();
                    if (debug) System.out.print(" Next 2:" + check2.toString());
                    if (check2 == end) break;
                    checkNext = checkPrev.getNext().getNext().getNext();
                    if (debug) System.out.print(" Next Next:" + checkNext.toString());
                    if (debug) printSortedList();

                } else {
                    checkNext = checkNext.getNext();
                    check2 = check2.getNext();
                    check1 = check1.getNext();
                    checkPrev = checkPrev.getNext();
                }
            }
        }
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

    public Student pop(Student s) {
        Student tempPrev = null;
        Student tempNext = start;
        for (int i = 0; i < size; i++) {
            tempPrev = tempNext;
            tempNext = tempNext.getNext();
            if (tempNext == s) {
                tempNext = tempNext.getNext();
                //System.out.println("Prev ="+tempPrev.toString()+" s ="+s.toString()+" Next ="+tempNext.toString());
                tempNext.setPrevious(tempPrev);
                tempPrev.setNext(tempNext);
                s.setNext(null);
                s.setPrevious(null);
                size--;
                return s;
            }
        }
        return null;
    }

    public Student pop(int index) {
        Student s = null;
        Student tempPrev = null;
        Student tempNext = start;
        if (index > size) {
            System.out.println("Index staat niet in de Sorted List");
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

    public void printSortedList() {
        Student s = start.getNext();
        System.out.println("=========Sorted List Start==========");
        for (int i = 1; i < size + 1; i++) {
            System.out.println("Index:" + i + " bevat " + s.toString());
            s = s.getNext();
        }
        System.out.println("=========Sorted List End==========");
    }

    public void printMen() {
        Student s = start.getNext();
        System.out.println("=========Male Sorted List Start==========");
        for (int i = 1; i < size + 1; i++) {
            if (s.getGeslacht().equals("m") || s.getGeslacht().equals("M")) {
                System.out.println("Index:" + i + " bevat " + s.toString());
            }
            s = s.getNext();
        }
        System.out.println("=========Male Sorted List End==========");
    }

    public void printWomen() {
        Student s = start.getNext();
        System.out.println("=========Female Sorted List Start==========");
        for (int i = 1; i < size + 1; i++) {
            if (s.getGeslacht().equals("v") || s.getGeslacht().equals("V")) {
                System.out.println("Index:" + i + " bevat " + s.toString());
            }
            s = s.getNext();
        }
        System.out.println("=========Female Sorted List End==========");
    }


}
