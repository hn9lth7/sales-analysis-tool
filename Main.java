import java.util.*;

class SalesAnalysis {
    public static void main(String[] args) {

        Random r = new Random();
        int[] s = new int[21], w = new int[3];
        int sum = 0, max = 0, maxI = 0, below = 0;

        for (int i = 0; i < 21; i++) {
            s[i] = r.nextInt(151) + 100;
            sum += s[i];
            w[i/7] += s[i];
            if (s[i] > max) { max = s[i]; maxI = i; }
        }

        double avg = sum / 21.0;
        for (int x : s) if (x < avg) below++;

        int bestWeek = 0;
        for (int i = 1; i < 3; i++)
            if (w[i] > w[bestWeek]) bestWeek = i;

        System.out.println("Загалом: " + sum);
        System.out.println("Середнє: " + avg);
        System.out.println("Нижче середнього: " + below);
        System.out.println("Максимум: " + max + " (тиждень " + (maxI/7+1) + ")");
        System.out.println("Кращий тиждень: " + (bestWeek+1));

        System.out.println("Рекомендація: " +
                (w[bestWeek] > avg*7 ?
                        "Зберігати поточну стратегію." :
                        "Потрібно посилити маркетинг."));
    }
}
