public class EvaluateReversePolishNotationMain {
    public static void main(String[] args) {
        EvaluateReversePolishNotation solution = new EvaluateReversePolishNotation();
//        int result = solution.evalRPN(new String[] {"2","1","+","3","*"});
//        System.out.println(result);

        int result2 = solution.evalRPN(new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"});
        System.out.println(result2);
    }
}
