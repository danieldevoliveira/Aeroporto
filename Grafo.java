public class Grafo<T> {

    private ListaSimplesDesordenada<Vertice<T>> vertices;
    private ListaSimplesDesordenada<Aresta<T>> arestas;

    public Grafo() {
        this.vertices = new ListaSimplesDesordenada<Vertice<T>>();
        this.arestas = new ListaSimplesDesordenada<Aresta<T>>();
    }

    public void adicionarVertice(int codigodovertice, T vertice) {

        try {
            Vertice<T> novoVertice = new Vertice<T>(codigodovertice, vertice);
            this.vertices.guardeUmItemNoInicio(novoVertice);
        } catch (Exception e) {
            System.out.println("vertice nao adicionado");
        }

    }

    // adicionar voo a um aeroporto deve passar o codigo do aeroporto, origem e
    // destino
    public void adicionarAresta(int codigoaresta, T dadoInicio, T dadoFim) {
        try {
            Vertice<T> inicio = procurandoVertice(dadoInicio);
            Vertice<T> fim = procurandoVertice(dadoFim);

            if (inicio != null && fim != null) {
                Aresta<T> aresta = new Aresta<>(codigoaresta, inicio, fim);
                inicio.adicionarArestaSaida(aresta); // Adicionar a aresta à lista de arestas de saída do vértice de
                                                     // origem
                fim.adicionarArestaEntrada(aresta);
                this.arestas.guardeUmItemNoInicio(aresta);
            } else {
                System.out.println("Vértices não foram encontrados.");
            }
        } catch (Exception e) {
            System.out.println("aresta nao adicionada!");
        }

    }




    //exibir as aretas ligas a um vertice (voos de um aeroporto)
    public void exibirArestasdoVertice(T nomeVertice) throws Exception {
    Vertice<T> vertice = procurandoVertice(nomeVertice);

    if (vertice != null) {
        System.out.println("Voos do Aeroporto " + nomeVertice + ":");
        
        System.out.println("Voos de chegada:");

        ListaSimplesDesordenada<Aresta<T>> arestasEntrada = vertice.getArestasEntrada();
        for (int i = 0; i < arestasEntrada.getQuantidade(); i++) {
            Aresta<T> voo = arestasEntrada.recupereItemDoInicio();
            System.out.println("Código do voo: " + voo.getCodigoaresta() + ", " + voo.getOrigem() + " ----> " + voo.getDestino());
            arestasEntrada.removaItemDoInicio();
            arestasEntrada.guardeUmItemNoFinal(voo);
        }

        System.out.println("Voos de saída:");

        ListaSimplesDesordenada<Aresta<T>> arestasSaida = vertice.getArestasSaida();
        for (int i = 0; i < arestasSaida.getQuantidade(); i++) {
            Aresta<T> voo = arestasSaida.recupereItemDoInicio();
            System.out.println("Código do voo: " + voo.getCodigoaresta() + ", " + voo.getOrigem() + " ----> " + voo.getDestino());
            arestasSaida.removaItemDoInicio();
            arestasSaida.guardeUmItemNoFinal(voo);
        }
    }
    }


    //metodo para excluir um voo
    public void excluirAresta(int codigoAresta) throws Exception{

        Aresta<T> arestaRemover = null;

        for(int i =0;i<arestas.getQuantidade();i++){
             Aresta<T> aresta = arestas.recupereItemDoInicio();
            
            if (aresta.getCodigoaresta() == codigoAresta) {
            arestaRemover = aresta;
                break;
            }
                else{
                arestas.removaItemDoInicio();
                arestas.guardeUmItemNoFinal(aresta);
            }
        }

        if(arestaRemover != null){
            Vertice<T> origem = arestaRemover.getOrigem();
            origem.getArestasSaida().removaItemIndicado(arestaRemover);

            Vertice<T> destino = arestaRemover.getDestino();
            destino.getArestasEntrada().removaItemIndicado(arestaRemover);

            arestas.removaItemIndicado(arestaRemover);

            System.out.println("Aresta removida com sucesso.");
        } else {
        System.out.println("Aresta não encontrada.");
        }

        
    }


public boolean validarAresta(int codigoAresta) throws Exception {
    int quantidadeArestas = arestas.getQuantidade();
    
    for (int i = 0; i < quantidadeArestas; i++) {
        Aresta<T> aresta = arestas.recupereItemDoInicio();
        if (aresta.getCodigoaresta() == codigoAresta) {
            return true;
        } else {
            arestas.removaItemDoInicio();
            arestas.guardeUmItemNoFinal(aresta);
        }
    }
    
    return false;
}

//metodo criado para validar aeroporto
public boolean ValidaAeroporto(int Codigo) throws Exception{
    int quantidadedeVertices = vertices.getQuantidade();

    for(int i=0;i<quantidadedeVertices;i++){
        Vertice<T> vertice = vertices.recupereItemDoInicio();
        if(vertice.getCodigodovertice()== Codigo){
            return true;
        }else{
            vertices.removaItemDoInicio();
            vertices.guardeUmItemNoFinal(vertice);
        }
        
    }
    
    return false;

}




    public Vertice<T> procurandoVertice(T nomeAeroporto) {
        try {
            for (int i = 0; i < vertices.getQuantidade(); i++) {
                Vertice<T> vertice = vertices.recupereItemDoInicio();
                if (vertice.getNomedoAeroporto().equals(nomeAeroporto)) {
                    return vertice;
                }
                vertices.removaItemDoInicio();
                vertices.guardeUmItemNoFinal(vertice);
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }


}
