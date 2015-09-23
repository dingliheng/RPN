import java.util.LinkedList;

public class RPNAddSubMult {
    // @include
    public static int eval(String RPNExpression) {
        LinkedList<Integer> intermediateResults = new LinkedList<>();
        String delimiter = ",";
        String[] symbols = RPNExpression.split(delimiter);
        for (String token : symbols) {
            if (token.length() == 1 && "+-*".contains(token)) {
                int y = intermediateResults.pop();
                int x = intermediateResults.pop();
                switch (token.charAt(0)) {
                    case '+':
                        intermediateResults.push(x + y);
                        break;
                    case '-':
                        intermediateResults.push(x - y);
                        break;
                    case '*':
                        intermediateResults.push(x * y);
                        break;
                }
            } else { // token is a number.
                intermediateResults.push(Integer.parseInt(token));
            }
        }
        return intermediateResults.pop();
    }
    // @exclude

    public static void main(String[] args) {
        assert (-20 == eval("-10,2,*"));
        assert (6 == eval("-10,-16,-"));
        assert (12 == eval("10,2,+"));
        assert (15 == eval("1,2,+,3,4,*,+"));
        assert (42 == eval("1,2,3,4,5,+,*,+,+,3,4,*,+"));
    }
}