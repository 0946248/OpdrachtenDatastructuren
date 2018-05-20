package Opdracht2;
public class App {

    public static void main(String[] args) {
        //Stap 1 - Maak de studenten aan
        Student Janice = new Student(01, "Janice", 25, "v");
        Student Kermit = new Student(02, "Kermit", 18, "m");
        Student Gonzo = new Student(03, "Gonzo", 8, "m");
        Student Chef = new Student(04, "Swedish Chef", 35, "m");
        Student Piggy = new Student(05, "Miss Piggy", 28, "v");
        //Stap 2 - Maak een Queue, List en SortedList
        Queue q = new Queue();
        List l = new List();
        SortedList slM = new SortedList();
        SortedList slV = new SortedList();
        //Stap 3 - pop() alle datastructuren
        q.pop();
        l.pop(1);
        slM.pop(1);
        slV.pop(1);
        //Stap 4 - Vul de Queue met Studenten
        q.push(Kermit);
        q.push(Janice);
        q.push(Gonzo);
        q.push(Piggy);
        q.push(Chef);
        //Stap 5 - Print de Queue
        q.printQueue();
        //Stap 6 - Laat de Queue leeg lopen -> Push naar de List & Push naar geslachts specifieke SortedList
        for(int i = 0;i < q.size();i++){
            Student s = q.pop();
            String g = s.getGeslacht();
            l.push(s,i);
            if (g.equals("m") || g.equals("M")){
                slM.push(s);
            }else{
                slV.push(s);
            }
        }
        //Stap 7 - Print Queue, List en beide Sorted Lists
        q.printQueue();
        l.printList();
        slM.printSortedList();
        slV.printSortedList();




    }

}
