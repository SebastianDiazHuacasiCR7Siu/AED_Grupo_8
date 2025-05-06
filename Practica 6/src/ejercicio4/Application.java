package ejercicio4;

public class Application {

    public static boolean symbolBalancing(String s) {
        StackLink<Character> stack = new StackLink<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(': case '[': case '{':
                    stack.push(ch);
                    break;
                case ')': case ']': case '}':
                    if (stack.isEmpty()) return false;
                    try {
                        char top = stack.pop();
                        if (!isMatching(top, ch)) return false;
                    } catch (Exception e) {
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    // Método main de prueba
    public static void main(String[] args) {
        String[] tests = {
            "()()()[()]()",
            "((()))[]",
            "([])[](",
            "([{)]}",
            "[",
            "[][][]{{{}}}"
        };

        for (String test : tests) {
            System.out.println(test + " --> " + symbolBalancing(test));
        }
    }
}
