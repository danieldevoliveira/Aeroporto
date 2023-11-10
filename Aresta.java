public class Aresta <T> {
    //no meu programas as arestas equivalem as linhas de voo da malha aerea

    private Vertice origem; //de onde sai o aeroporto
    private Vertice destino; //onde chega o aviao
    private int codigoaresta;


    //controtor do programa quando se cria um novo voo no caso aresta devese passar como dado seu codido, sua origem e seu destino. claro na vida real teria tb horario e outras coisas mas nao é necessario neste programa.
    public Aresta(int codigoaresta, Vertice<T> origem, Vertice<T> destino) {
        this.codigoaresta = codigoaresta;
        this.origem = origem;
        this.destino = destino;
    }


  
    //metodos obrigatorios de acesso padrao. basico do basico.
    public int getCodigoaresta() {
        return codigoaresta;
    }

    public void setCodigoaresta(int codigoaresta) {
        this.codigoaresta = codigoaresta;
    }


    public Vertice<T> getDestino() {
        return destino;
    }

    public Vertice<T> getOrigem() {
        return origem;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    @Override
    public String toString() {
    return "Aresta [codigoaresta=" + codigoaresta + ", origem=" + origem + ", destino=" + destino + "]";
    }

 


}
