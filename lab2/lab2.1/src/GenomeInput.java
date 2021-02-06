import java.util.Scanner;
import java.util.stream.*;
import static java.lang.System.out;

interface GenomeInput {
   static void main(String[] __) {
      Stream
         .generate(GenomeInput::input)
         .limit(3)
         .collect(Collectors.toUnmodifiableList())
         .stream()
         .forEach(HumanGenome::print);
   }

   Scanner sc = new Scanner(System.in);

   static HumanGenome input() {
      out.print("name\n> ");
      var name = sc.nextLine();

      int genes;
      while (true) {
         out.print("genes\n> ");
         final String temp = sc.nextLine();
         try {
            genes = Integer.parseInt(temp);
            break;
         } catch (Throwable e) {}
         out.println("Try again.");
      }

      int chromosomes;
      while (true) {
         out.print("chromosomes\n> ");
         final String temp = sc.nextLine();
         try {
            chromosomes = Integer.parseInt(temp);
            break;
         } catch (Throwable e) {}
         out.println("Try again.");
      }

      long cells;
      while (true) {
         out.print("cells\n> ");
         final String temp = sc.nextLine();
         try {
            cells = Long.parseLong(temp);
            break;
         } catch (Throwable e) {}
         out.println("Try again.");
      }

      out.write('\n');
      return new HumanGenome(name, genes, chromosomes, cells);
   }
}
