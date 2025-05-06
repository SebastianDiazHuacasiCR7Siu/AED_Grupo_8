import ejercicio1.*;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stackInt = new StackLink<>();
        Stack<String> stackStr = new StackLink<>();

        try {
            stackInt.push(10);
            stackInt.push(20);
            System.out.println("Peek (int): " + stackInt.peek());
            System.out.println("Pop (int): " + stackInt.pop());
            System.out.println("Pop (int): " + stackInt.pop());

            stackStr.push("Hola");
            stackStr.push("Mundo");
            System.out.println("Peek (str): " + stackStr.peek());
            System.out.println("Pop (str): " + stackStr.pop());
            System.out.println("Is empty (str): " + stackStr.isEmpty());
            System.out.println("Pop (str): " + stackStr.pop());
            System.out.println("Is empty (str): " + stackStr.isEmpty());

        } catch (ExcepcionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }
    }
}
