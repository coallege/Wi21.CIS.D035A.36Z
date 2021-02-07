import java.util.Arrays;
import java.util.stream.Stream;
import static java.lang.System.out;

class DNA {
   static final NucleicAcid cytosine = new NucleicAcid(
      "Cytosine", "C4H5N3O", 111.10, 1.155
   );
   static final NucleicAcid guanine = new NucleicAcid(
      "Guanine", "C5H5N5", 135.13, 1.6
   );
   static final NucleicAcid adenine = new NucleicAcid(
      "Adenine", "C5H5N5", 135.13, 1.6
   );
   static final NucleicAcid thymine = new NucleicAcid(
      "Thymine", "C5H6N2O2", 126.115, 1.223
   );

   static NucleicAcid charToNucleicAcid(char c) {
      return switch (c) {
         case 'C' -> guanine;
         case 'G' -> cytosine;
         case 'A' -> thymine;
         case 'T' -> adenine;
         default  -> throw new Error("Unexpected char " + c);
      };
   }

   static NucleicAcid complimentary(NucleicAcid acid) {
      if (acid == cytosine) {
         return guanine;
      }
      if (acid == guanine) {
         return cytosine;
      }
      if (acid == adenine) {
         return thymine;
      }
      if (acid == thymine) {
         return adenine;
      }
      throw new Error("Nucleic Acid is not a DNA!");
   }

   NucleicAcid[] LStrand;
   NucleicAcid[] RStrand;

   DNA() {}
   DNA(String LStrandString) {
      populateUsingLStrand(LStrandString);
   }

   void populateUsingLStrand(final String LStrandString) {
      this.LStrand = LStrandString
         .chars()
         .mapToObj(i -> (char) i)
         .map(DNA::charToNucleicAcid)
         .toArray(NucleicAcid[]::new);

      this.RStrand = Arrays
         .stream(this.LStrand)
         .map(DNA::complimentary)
         .toArray(NucleicAcid[]::new);
   }

   // Yes, this is basically the exact same function
   void populateUsingRStrand(final String RStrandString) {
      this.RStrand = RStrandString
         .chars()
         .mapToObj(i -> (char) i)
         .map(DNA::charToNucleicAcid)
         .toArray(NucleicAcid[]::new);

      this.LStrand = Arrays
         .stream(this.RStrand)
         .map(DNA::complimentary)
         .toArray(NucleicAcid[]::new);
   }

   void print() {
      out.println("--- L Strand ---");
      Arrays
         .stream(this.LStrand)
         .forEach(NucleicAcid::print);

      out.println("--- R Strand ---");
      Arrays
         .stream(this.RStrand)
         .forEach(NucleicAcid::print);
   }

   void highestMolarMass() {
      final var heaviestLeft = Arrays
         .stream(this.LStrand)
         .mapToDouble(NucleicAcid::getMolarMass)
         .max()
         .orElse(0);

      out.println("The heaviest molar mass on the left strand is " + heaviestLeft);
      out.println("Here are the heaviest indices:");
      for (int i = 0; i < this.LStrand.length; ++i) {
         if (this.LStrand[i].getMolarMass() == heaviestLeft) {
            out.print(i + " ");
         }
      }
      out.println();

      final var heaviestRight = Arrays
         .stream(this.RStrand)
         .mapToDouble(NucleicAcid::getMolarMass)
         .max()
         .orElse(0);

      out.println("The heaviest molar mass on the right strand is " + heaviestRight);
      out.println("Here are the heaviest indices:");
      for (int i = 0; i < this.RStrand.length; ++i) {
         if (this.RStrand[i].getMolarMass() == heaviestRight) {
            out.print(i + " ");
         }
      }
      out.println();

      final var heaviest = heaviestLeft > heaviestRight ? heaviestLeft : heaviestRight;
      out.println("The heaviest molar mass on both strands is " + heaviest);
   }

   void totalDensity() {
      final var dualStream = Stream.concat(
         Arrays.stream(this.LStrand),
         Arrays.stream(this.RStrand)
      );

      final var totalDensity = dualStream
         .mapToDouble(NucleicAcid::getDensity)
         .sum();

         out.println("The total density of both strands is " + totalDensity);
   }
}
