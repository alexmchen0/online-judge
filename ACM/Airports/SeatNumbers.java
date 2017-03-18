import java.util.Scanner;

/**
 * Created by Alex on 2/10/17.
 */
public class SeatNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = Integer.parseInt(in.nextLine());
        for (int i = 0; i < numTests; i++) {
            String seat = in.nextLine();
            StringBuilder rowNum = new StringBuilder();
            for (int j = 0; j < seat.length(); j++) {
                char next = seat.charAt(j);
                if (next >= 'A' && next <= 'F') {
                    break;
                }
                rowNum.append(next);
            }
            long row = Long.parseLong(rowNum.toString());
            long ans = row * 6;
            System.out.println(ans);
        }
    }
}
