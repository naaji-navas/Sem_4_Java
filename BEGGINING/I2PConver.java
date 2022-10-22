
//Infix expression  to postfix expression converstion program
import java.util.Stack;
import java.util.Scanner;

class I2PConvert {

    public static void main(String args[]) {
        InfixToPost converter = new InfixToPost();
        System.out.println("Enter the String  :");
        Scanner in = new Scanner(System.in);
        String infix = in.nextLine();
        System.out.println("Equivalent Postfix expression  is :" + converter.infixToPost(infix));

    }
}

class InfixToPost {
    public String infixToPost(String infixExp) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();
        // step 1
        stack.push('(');
        infixExp = infixExp.concat(String.valueOf(')'));
        // step2
        //check this
        for (int i = 0; i < infixExp.length(); i++) {
            char character = infixExp.charAt(i);
            // step3
            if (Character.isAlphabetic(character) || Character.isDigit(character)) {

                postfix = postfix.concat(String.valueOf(character));

            }
            // step 4
            else if (character == '(') {

                stack.push(character);

            }
            // step5
            else if (isOperator(character)) {
                while (!stack.empty()) {

                    if (precedence(stack.peek()) >= precedence(character)) {
                        postfix = postfix.concat(String.valueOf(stack.pop()));

                    } else {
                        stack.push(character);
                        break;

                    }

                }

            }
            // step 6
            else if (character == ')') {

                while (!stack.empty()) {
                    if (stack.peek() != '(') {

                        postfix = postfix.concat(String.valueOf(stack.pop()));

                    } else {

                        stack.pop();
                        break;
                    }

                }

            }
        }
        return postfix;
    }

    private boolean isOperator(char character) {
        boolean response = false;
        switch (character) {
            case '^':
            case '/':
            case '*':
            case '+':
            case '-':
                response = true;
        }

        return response;
    }

    private int precedence(char operator) {
        int response = 0;
        switch (operator) {
            case '^':
                response = 3;
                break;
            case '/':
            case '*':
                response = 2;
                break;
            case '+':
            case '-':
                response = 1;

        }

        return response;

    }

}
