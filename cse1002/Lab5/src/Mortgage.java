import java.util.Scanner;
import java.math.BigDecimal;

public class Mortgage {

    public static void main (final String[] args) {
        BigDecimal loan = new BigDecimal(args[0]);
        final BigDecimal interest = new BigDecimal(args[1]);
        final Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            final String wcn = sc.next();
            if (wcn.toLowerCase().equals("balance")) {
                final StringBuilder theOutput = new StringBuilder();
                theOutput.append("Balance: ");
                loan = loan.setScale(2, BigDecimal.ROUND_HALF_UP);

                if (loan.compareTo(BigDecimal.ZERO) == -1) {
                    theOutput.append(loan.negate().toString());
                    theOutput.append(" over");
                } else if (loan.compareTo(BigDecimal.ZERO) == 1) {
                    theOutput.append(loan.toString());
                    theOutput.append(" left");
                }
                System.out.println(theOutput.toString());
                } else {
                final BigDecimal payment = new BigDecimal(wcn);
                payment.setScale(2);
                loan = loan.add(loan.multiply(interest));
                loan = loan.subtract(payment);
            }
        }
    }

}
