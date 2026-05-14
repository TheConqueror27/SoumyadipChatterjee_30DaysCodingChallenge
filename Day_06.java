import java.util.*;
public class Day_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine(); 
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        if (!sc.hasNextInt()) return;
        int q = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < q; i++) {
            String query = sc.nextLine();
            System.out.println(counts.getOrDefault(query, 0));
        }
        
        sc.close();
    }
}