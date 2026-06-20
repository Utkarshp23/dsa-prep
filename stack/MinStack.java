import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    int min;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        int currentMin = minStack.isEmpty() ? val : Math.min(val, minStack.peek());
        minStack.push(currentMin);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }

    // Resume this session with:
    // claude --resume b81ec431-295b-42a4-ba81-e82c1d7ab4f7
}
