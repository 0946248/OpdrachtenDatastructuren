package Opdracht1;

public class App {

    public static void main(String[] args) {
        //Stap 1 - Maak de studenten aan
        Student Janice = new Student(01, "Janice", 25, "v");
        Student Kermit = new Student(02, "Kermit", 18, "m");
        Student Gonzo = new Student(03, "Gonzo", 8, "m");
        Student Chef = new Student(04, "Swedish Chef", 35, "m");
        Student Piggy = new Student(05, "Miss Piggy", 28, "v");
        //Stap 2 - Maak Stack aan
        Stack stack = new Stack();
        //Stap 3 - Voer pop() uit
        stack.pop();
        //Stap 4 - Print de stack
        stack.printStack();
        //Stap 5 - Print alle vrouwen in de stack
        stack.printWomen();
        //Stap 6 - Push studenten de stack op
        stack.push(Janice);
        stack.push(Kermit);
        stack.push(Gonzo);
        stack.push(Chef);
        stack.push(Piggy);
        //Stap 7 - Print alle mannelijke studenten
        stack.printMen();
        //Stap 8 - Print alle vrouwelijke studenten
        stack.printWomen();
        //Stap 9 - Push Kermit nogmaals op de stack
        stack.push(Kermit);
        //Stap 10 - Print de stack
        stack.printStack();


    }

}
