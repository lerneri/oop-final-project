import java.util.*;

public class Cardapio{
  public ArrayList<ItemCardapio> cardapio;

  public Cardapio(){
    cardapio = new ArrayList<ItemCardapio>();
  }

  public void inserir(ItemCardapio item){
    cardapio.add(item);
  }
  
}