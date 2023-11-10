import java.util.ArrayList;

public class Vertice<T> {
    //aqui as coisas ficam mais interessantes. os vertices no meu codigo referencia os aeropotos da malha aerea
    
    
    private ListaSimplesDesordenada<Aresta<T>> arestasEntrada;  //nota uma aeroporto tem varios voos de chegada logo um vertice tem uma lista de arestas de entrada
    private ListaSimplesDesordenada<Aresta<T>> arestasSaida;  //arestas de saida. um aeroporto tem varios voos de saida. logo uma 
    private T nomedoAeroporto;
    private int codigodovertice;

    public Vertice(int codigodovertice,T nomedoAeroporto) {
        this.codigodovertice=codigodovertice;
        this.nomedoAeroporto = nomedoAeroporto;
        this.arestasEntrada = new ListaSimplesDesordenada<>();
        this.arestasSaida = new ListaSimplesDesordenada<>();
    }

    public T getNomedoAeroporto() {
        return nomedoAeroporto;
    }

    public void setNomedoAeroporto(T nomedoAeroporto) {
        this.nomedoAeroporto = nomedoAeroporto;
    }


    public ListaSimplesDesordenada<Aresta<T>> getArestasEntrada() {
        return arestasEntrada;
    }



    public ListaSimplesDesordenada<Aresta<T>> getArestasSaida() {
        return arestasSaida;
    }

    public int getCodigodovertice() {
        return codigodovertice;
    }

    public void setCodigodovertice(int codigodovertice) {
        this.codigodovertice = codigodovertice;
    }


    public void adicionarArestaEntrada(Aresta<T> aresta){

        try {
            this.arestasEntrada.guardeUmItemNoInicio(aresta);
            aresta.setDestino(this);
            
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR UM ITEM");
            
        }
        
    }

    public void adicionarArestaSaida(Aresta<T> aresta){
        try {
            this.arestasSaida.guardeUmItemNoInicio(aresta);
            aresta.setOrigem(this);
            
        } catch (Exception e) {
            System.out.println("ERRO AO ADICIONAR UM ITEM");
        }

    }

     public String toString() {
        return "aeroporto: " + nomedoAeroporto;
    }



   
    
}


