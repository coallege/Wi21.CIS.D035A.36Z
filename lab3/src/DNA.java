import java.util.Arrays;

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

   enum Base {cytosine, guanine, adenine, thymine};

   static Base charToBase(char c) {
      return switch (c) {
         case 'C' -> Base.guanine;
         case 'G' -> Base.cytosine;
         case 'A' -> Base.thymine;
         case 'T' -> Base.adenine;
         default  -> throw new Error("Unexpected char " + c);
      };
   }

   static Base nucleicAcidToBase(NucleicAcid acid) {
      if (acid == cytosine) {
         return Base.cytosine;
      }
      if (acid == guanine) {
         return Base.guanine;
      }
      if (acid == adenine) {
         return Base.adenine;
      }
      if (acid == thymine) {
         return Base.thymine;
      }
      throw new Error("Nucleic Acid is not a DNA!");
   }

   static NucleicAcid baseToNucleicAcid(Base acid) {
      return switch (acid) {
         case cytosine -> cytosine;
         case guanine  -> guanine;
         case adenine  -> adenine;
         case thymine  -> thymine;
      };
   }

   static Base complimentary(Base acid) {
      return switch (acid) {
         case cytosine -> Base.guanine;
         case guanine  -> Base.cytosine;
         case adenine  -> Base.thymine;
         case thymine  -> Base.adenine;
      };
   }

   Base[] LStrand;
   Base[] RStrand;

   DNA() {}
   DNA(String LStrandString) {
      populateUsingLStrand(LStrandString);
   }

   void populateUsingLStrand(final String LStrandString) {
      this.LStrand = LStrandString
         .chars()
         .mapToObj(i -> (char) i)
         .map(DNA::charToBase)
         .toArray(Base[]::new);

      this.RStrand = Arrays
         .stream(this.LStrand)
         .map(DNA::complimentary)
         .toArray(Base[]::new);
   }

   // Yes, this is basically the exact same function
   void populateUsingRStrand(final String RStrandString) {
      this.RStrand = RStrandString
         .chars()
         .mapToObj(i -> (char) i)
         .map(DNA::charToBase)
         .toArray(Base[]::new);

      this.LStrand = Arrays
         .stream(this.RStrand)
         .map(DNA::complimentary)
         .toArray(Base[]::new);
   }

   
}
