import java.util.ArrayList;
import java.util.List;

public class MinStack {

    private final List<int[]> stack;

    public MinStack() {
        this.stack = new ArrayList<>();
    }

    public void push(int val) {
        int[] top = null;
        if (stack.isEmpty()) {
            top = new int[] {val, val};
        } else {
            int min = stack.get(stack.size() - 1)[1];
            top = new int[] {val, Math.min(val, min)};
        }
        stack.add(top);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public int top() {
        return stack.get(stack.size() - 1)[0];
    }

    public int getMin() {
        return stack.get(stack.size() - 1)[1];
    }
}
