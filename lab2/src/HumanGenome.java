class HumanGenome {
   // for whatever goddamn reason, these are private
   // and we're supposed to use getters and setters
   private String name;
   private int genes;
   private int chromosomes;
   private long cells;

   String getName() { return this.name; }
   int getGeneCount() { return this.genes; }
   int getChromoCount() { return this.chromosomes; }
   long getCellCount() { return this.cells; }

   void setName(final String name) { this.name = name; }
   void setGeneCount(final int count) { this.genes = count; }
   void setChromoCount(final int count) { this.chromosomes = count; }
   void setCellCount(final long count) { this.cells = count; }

   /**
    * Has to use printf. Why? Because we say so.
    */
   void print() {
      System.out.printf(
         "name: %s\ngenes: %d\nchromosomes: %d\ncells: %l\n"
         ,this.name
         ,this.genes
         ,this.chromosomes
         ,this.cells
      );
   }
}
