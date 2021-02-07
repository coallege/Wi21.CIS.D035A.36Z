class NucleicAcid {
   static final NucleicAcid cytosine = new NucleicAcid(
      "Cytosine", "C4H5N3O", 111.10, 1.155
   );

   static final NucleicAcid adenine = new NucleicAcid(
      "Adenine", "C5H5N5", 135.13, 1.6
   );

   static final NucleicAcid guanine = new NucleicAcid(
      "Guanine", "C5H5N5", 135.13, 1.6
   );

   static final NucleicAcid thymine = new NucleicAcid(
      "Thymine", "C5H6N2O2", 126.115, 1.223
   );

   static final NucleicAcid uracil = new NucleicAcid(
      "Uracil", "C4H4N2O2", 112.08676, 1.32
   );

   private String name;
   private String chemicalFormula;
   private double molarMass;
   private double density;

   String getName() { return this.name; }
   String getChemicalFormula() { return this.chemicalFormula; }
   double getMolarMass() { return this.molarMass; }
   double getDensity() { return this.density; }

   void setName(String name) { this.name = name; }
   void setChemicalFormula(String chemF) { this.chemicalFormula = chemF; }
   void setMolarMass(double mass) { this.molarMass = mass; }
   void setDensity(double density) { this.density = density; }

   NucleicAcid(String name, String chemF, double mass, double density) {
      this.name = name;
      this.chemicalFormula = chemF;
      this.molarMass = mass;
      this.density = density;
   }

   void print() {
      System.out.printf("%s"
         + "\n   Chemical formula - %s"
         + "\n   Molar mass - %f g/mol"
         + "\n   Density - %f g/cm3 (calculated)"
         + "\n"
         , this.name
         , this.chemicalFormula
         , this.molarMass
         , this.density
      );
   }
}
