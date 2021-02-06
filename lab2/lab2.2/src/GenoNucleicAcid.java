import java.util.Arrays;

interface GenoNucleicAcid {
   final NucleicAcid cytosine = new NucleicAcid(
      "Cytosine", "C4H5N3O", 111.10, 1.155
   );

   final NucleicAcid adenine = new NucleicAcid(
      "Adenine", "C5H5N5", 135.13, 1.6
   );

   final NucleicAcid guanine = new NucleicAcid(
      "Guanine", "C5H5N5", 135.13, 1.6
   );

   final NucleicAcid thymine = new NucleicAcid(
      "Thymine", "C5H6N2O2", 126.115, 1.223
   );

   final NucleicAcid uracil = new NucleicAcid(
      "Uracil", "C4H4N2O2", 112.08676, 1.32
   );

   static void main(String[] __) {
      Arrays
         .asList(cytosine, adenine, guanine, thymine, uracil)
         .forEach(NucleicAcid::print);
   }
}
