import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
       

        Scanner sc = new Scanner(System.in);

        // criando o grafo que representa a malha aérea.
        Grafo<String> grafo = new Grafo<String>();

        String BSB = "Brasilia";
        String GIG = "Rio de Janeiro";
        String CNF = "Belo Horizonte";
        String GRU = "Sao Paulo";
        String SSA = "Salvador";

        // adicionando os aeroportos dentro do grafo
        grafo.adicionarVertice(03, GIG);
        grafo.adicionarVertice(01, BSB);
        grafo.adicionarVertice(02, CNF);
        grafo.adicionarVertice(04, GRU);
        grafo.adicionarVertice(05, SSA);

        grafo.adicionarAresta(01,GRU, SSA); //metodo para adicionar
        grafo.adicionarAresta(02,CNF, SSA);
        grafo.adicionarAresta(03,SSA, GIG);
        grafo.adicionarAresta(04,GIG, GRU);
        grafo.adicionarAresta(05,GIG,CNF);
        grafo.adicionarAresta(06,CNF,GRU);
        grafo.adicionarAresta(07,GRU,BSB);
        grafo.adicionarAresta(015,BSB,GRU);
        grafo.adicionarAresta(12,BSB, GIG);
        grafo.adicionarAresta(15,GIG, CNF);
        grafo.adicionarAresta(10,SSA, CNF);
        grafo.adicionarAresta(23,GRU, CNF);

      try {
        
      
        int escolha = 0;

        while (escolha != 5) {
            MeuMenu.exibirMenu();
            escolha = sc.nextInt();

            
                switch (escolha) {
                    case 1:
                        System.out.println("Digite o código do Aeroporto:");
                        int codigoAeroporto = sc.nextInt();
                        if(grafo.ValidaAeroporto(codigoAeroporto)==false){
                        sc.nextLine();
                        System.out.println("Digite o nome do Aeroporto:");
                        String nome = sc.nextLine();
                        grafo.adicionarVertice(codigoAeroporto, nome);
                        }else{
                          System.out.println("esse codigo ja existe, tente outro");
                        }
                        break;

                    case 2:
                        System.out.println("Digite o código do voo:");
                        int codigodovoo = sc.nextInt();

                        if (grafo.validarAresta(codigodovoo) == false) {
                            sc.nextLine();
                            System.out.println("Digite o aeroporto de origem:");
                            String aeroportoOrigem = sc.nextLine();
                            System.out.println("Digite o aeroporto de destino:");
                            String aeroportoDestino = sc.nextLine();
                            grafo.adicionarAresta(codigodovoo, aeroportoOrigem, aeroportoDestino);
                        } else {
                            System.out.println("Esse código já existe, tente outro.");
                        }
                        break;

                    case 3:
                        System.out.println("Digite o nome do aeroporto que deseja ver os voos:");
                        sc.nextLine(); // Consumir nova linha pendente
                        String name = sc.nextLine();
                        grafo.exibirArestasdoVertice(name);
                        break;

                    case 4:
                        System.out.println("Digite o código do voo para excluí-lo:");
                        int codigoExcluir = sc.nextInt();
                        grafo.excluirAresta(codigoExcluir);
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            
        }
      }catch(Exception e){
        System.out.println("ERRO: PORFAVOR DIGITE OS CODIGOS NO PADRAO DESEJADO");

      }

        sc.close();
    }
}



