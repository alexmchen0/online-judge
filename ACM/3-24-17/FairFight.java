import java.util.*;

public class FairFight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int sum = 0;
        for(int x_i=0; x_i < n; x_i++){
            sum += m - in.nextInt();
        }
        System.out.println(sum);
    }
}