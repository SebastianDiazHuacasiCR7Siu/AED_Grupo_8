public class Principal { 
    public static void main(String[] args) { 
        Bolsa < Chocolatina > bolsaCho = new Bolsa <> (3);
        Chocolatina c = new Chocolatina("milka"); 
        Chocolatina c1 = new Chocolatina("milka"); 
        Chocolatina c2 = new Chocolatina("ferrero");
        bolsaCho.add(c); 
        bolsaCho.add(c1); 
        bolsaCho.add(c2); 

        for (Chocolatina chocolatina: bolsaCho) { 
            System.out.println(chocolatina.getMarca()); 
        }
    }
}


//Utilizar la clase la clase Bolsa de manera generica //
//Crea otra bolsa para las Golosinas//
