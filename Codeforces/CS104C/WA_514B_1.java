import java.util.*;

/**
 * Created by Alex on 4/10/17.
 * http://codeforces.com/problemset/problem/514/B
 */
public class WA_514B_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int ox = in.nextInt();
        int oy = in.nextInt();

        Trooper[] troopers = new Trooper[n];
        for (int i = 0; i < n; i++) {
            troopers[i] = new Trooper(in.nextInt(), in.nextInt());
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            Trooper t1 = troopers[i];
            if (t1.isDead) {
                continue;
            }

            t1.isDead = true;
            count++;

            for (int j = 0; j < n; j++) {
                Trooper t2 = troopers[j];
                if (t2.isDead) {
                    continue;
                }

                if ((t1.x - ox) * (t2.y - oy) == (t2.x - ox) * (t1.y - oy)) {
                    t2.isDead = true;
                }
            }
        }

        System.out.println(count);
    }

    private static class Trooper {
        int x, y;
        boolean isDead;

        Trooper(int x, int y) {
            this.x = x;
            this.y = y;
            isDead = false;
        }
    }
}
