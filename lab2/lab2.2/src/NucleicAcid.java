class NucleicAcid {
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
