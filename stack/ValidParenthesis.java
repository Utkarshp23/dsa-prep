import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ValidParenthesis {
    public boolean isValid(String s) {
        int n = s.length();

        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                q.push(c);
            } else {
                if (q.isEmpty()) {
                    return false;
                }
                char top = q.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
            }
        }
        return q.isEmpty();
    }

    public static void main(String[] args) {
        // Drill 1:
        List<String> names = List.of("Alice", "Bob", "Charlie", "Anna", "David");
        List<String> ans = names.stream().filter((s) -> s.length() > 3).map(String::toUpperCase).sorted()
                .collect(Collectors.toList());

        System.out.println(ans);

        // Drill 2:
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer ans1 = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n).reduce((a, b) -> a + b).get();
        System.out.println(ans1);

        // Drill 3:
        List<String> words = List.of("hello world", "java streams", "flat map");
        List<String> flatten = words.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList());
        System.out.println(flatten);

        // Drill 4:
        Map<Integer, List<String>> grouped = names.stream().collect(Collectors.groupingBy(String::length));

        Map<String, List<String>> deptEmployees = Map.of(
                "Engineering", List.of("Alice", "Bob"),
                "Design", List.of("Charlie", "Anna"),
                "Product", List.of("David"));

    }
}
