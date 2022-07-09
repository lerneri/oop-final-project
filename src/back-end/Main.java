public class Main {  
  public static void main(String[] args){
    // try{
    //   Bebida b = new Bebida("4000", "N", "cuida", 10);
    //   System.out.println("try na bebida");
    // }catch(CodigoInvalidoException e){
    //   System.out.println("catch na bebida");  
    // }

    // try{
    //   Principal p = new Principal("3000", "N", "cuida", 10);
    //   System.out.println("try no principal");
    // }catch(CodigoInvalidoException e){
    //   System.out.println("catch no principal");  
    // }

    // try{
    //   Entrada e = new Entrada("1000", "N", "cuida", 10);
    //   System.out.println("try na entrada");
    // }catch(CodigoInvalidoException e){
    //   System.out.println("catch na entrada");  
    // }
    // try{
    //   Sobremesa s = new Sobremesa("2000", "N", "cuida", 10);
    //   System.out.println("try na sobremesa");
    // }catch(CodigoInvalidoException e){
    //   System.out.println("catch na sobremesa");  
    // }

    
    
    // Gerente g = new Gerente("Rodrigo");
    // Garcom g1 = new Garcom("Vv");
    // Garcom g2 = new Garcom("Jao vitu");
    // Garcom g3 = new Garcom("Aiku");
    // Garcom g4 = new Garcom("Let");

    // g.inserirGarcom(g1);
    // g.inserirGarcom(g2);
    // g.inserirGarcom(g3);
    // g.inserirGarcom(g4);
    // System.out.println(g1.getCodigo());
    // System.out.println(g2.getCodigo());
    // System.out.println(g3.getCodigo());
    // System.out.println(g4.getCodigo());
    // System.out.println(g.getGarcom("0").getNome());

    // Mesa m1 = new Mesa(1);
    // Garcom g = new Garcom("VV");
    // Gerente ger = new Gerente("Rodrigo");
 
	Cardapio c = new Cardapio();
    try{
     ItemCardapio redLabel= new ItemCardapio("4000", "Red Label bruto", "Whisky", 12);
     c.inserir(redLabel);
    }catch(CodigoInvalidoException e){
    	e.printStackTrace();
    }
    
    
    System.out.println(c.cardapio.get(0).getNome());
  }
}
