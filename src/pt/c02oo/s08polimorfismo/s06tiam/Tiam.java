package pt.c02oo.s08polimorfismo.s06tiam;

public abstract class Tiam {
   
   public abstract String first();
   
   public abstract String next();
   
//   public String next() {
//      return null;
//   }
//   
   public void list() {
      String element = first();
      
      while (element != null) {
         System.out.println(element);
         element = next();
      }
   }
}
