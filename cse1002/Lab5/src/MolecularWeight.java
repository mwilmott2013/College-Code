import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Paths;

/*
 * Author: Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Spring 2015
 * Project: MolecularWeight
 */

public final class MolecularWeight {
    private static final int THREE = 3;
    static class Entry {
        String name;
        int anum;
        String symbol;
        double aweight;
    }
    public static void main (final String[] args) throws IOException {

        final ArrayList<Entry> list = new ArrayList<Entry>();

          final Scanner fileInput = new Scanner(Paths.get(args[0]));
          final Scanner stdInput = new Scanner(System.in);
          fileInput.nextLine();
          while (fileInput.hasNextLine()) {
              final String current = fileInput.nextLine();
              final String[] storage = current.split(",");
              final Entry alom = new Entry();
              alom.name = storage[0];
              alom.anum = Integer.parseInt(storage[1]);
              alom.symbol = storage[2];
              alom.aweight = Double.parseDouble(storage[THREE]);
              list.add(alom);
          }

          StringBuilder builder = new StringBuilder();
          double cwe = 0.0;

          while (stdInput.hasNext()) {
              final String bravo = stdInput.next();
              double awe = 0.0;
              int bwe = 1;
              for (int i = 0; i < list.size(); i++) {
                  if (bravo.equals(list.get(i).symbol)) {
                      awe = list.get(i).aweight;
                  }
              }

              if (bravo.equals(".")) {
                  System.out.println("Molecular Weight of "
                          + builder.toString() + "= " + cwe);
                  builder = new StringBuilder();
                  cwe = 0.0;
                  continue;
              } else if (awe == 0.0) {
              System.out.println("Unknown Molecular equation");
              stdInput.nextLine();
              continue;
              }
              builder.append(bravo + " ");
              if (stdInput.hasNextInt()) {
                  bwe = stdInput.nextInt();
                  builder.append(bwe + " ");
              }
              cwe += awe * bwe;
          }
          stdInput.close();
          fileInput.close();
}
}

