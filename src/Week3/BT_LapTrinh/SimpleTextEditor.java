package Week3.BT_LapTrinh;
import java.util.Scanner;
import java.util.Stack;
public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();
        StringBuilder s = new StringBuilder();
        Stack<String> history = new Stack<String>();
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            if (type == 1) {
                String w = scanner.next();
                history.push(s.toString());
                s.append(w);
            }
            else if (type == 2) {
                int k = scanner.nextInt();
                history.push(s.toString());
                s.delete(s.length() - k, s.length());
            }
            else if (type == 3) {
                int k = scanner.nextInt();
                System.out.println(s.charAt(k - 1));
            }
            else if (type == 4) {
                if (!history.isEmpty()) {
                    s = new StringBuilder(history.pop());
                }
            }
        }
        scanner.close();
    }
}
