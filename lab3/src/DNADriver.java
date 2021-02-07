interface DNADriver {
   static String[] testStrings =
      { "AGCCTAGGATCAG"
      , "AGCCTAGGATCTAGGATCAG"
      , "AGCCTATAGGATCAG"
      , "AAAGCCTAGGATAGGATCAG"
      , "AAAGCCTCTGAGGATAGGATCAG"
      }
   ;
   static void main(String[] __) {
      for (final var testString : testStrings) {
         System.out.println("\n\nTESTING " + testString);
         final var dna = new DNA(testString);
         dna.print();
         dna.highestMolarMass();
         dna.totalDensity();
      }
   }
}
