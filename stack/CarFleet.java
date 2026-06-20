import java.util.ArrayDeque;
import java.util.Deque;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int remDist = target - position[i];

            int timeRem = remDist / speed[i];

            while (!stack.isEmpty() && stack.peek() <= timeRem) {

            }
        }
    }
}
