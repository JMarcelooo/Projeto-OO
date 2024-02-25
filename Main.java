
import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        ListaServidores ListaServidor = new ListaServidores();
        int opc1;
        
        do{
            System.out.println("=================================================================");
            System.out.println("|1 - Cadastrar Servidor                                         |");
            System.out.println("|2 - Encontrar Servidor                                         |");
            System.out.println("|3 - Descadastrar Servidor                                      |");
            System.out.println("|4 - Sair                                                       |");
            System.out.println("=================================================================");
            opc1 = scan.nextInt();
            scan.nextLine();
            
            switch(opc1){

                case 1:
                    clearScreen();
                    System.out.println("Informe os dados do servidor:");
                    ListaServidor.cadastrarServidor();
                    System.err.println("Servidor sendo cadastrado...\nServidor cadastrado com sucesso!");
                    break;

                case 2:
                    clearScreen();
                    System.out.print("Informe a matrícula:");
                    String matricula = scan.nextLine();
                    int opc2=0;
                    ServidorPublico Servidor = ListaServidor.findServidor(matricula);
                    if(Servidor == null){
                        System.out.println("Servidor não encontrado com a matrícula informada.");
                    }
                    else{
                        do{
                            clearScreen();
                            System.out.println("=========================================================");
                            System.out.println("                      "+ Servidor.nome);
                            System.out.println("1 - Cadastrar exames");
                            System.out.println("2 - Verificar exames");
                            System.out.println("3 - Voltar");
                            System.out.println("=========================================================");
                            opc2= scan.nextInt();

                            switch(opc2){

                                case 1:
                                    int opc3;
                                    clearScreen();
                                    do{
                                        System.out.println("=========================Exames=======================");
                                        System.out.println("1 - Sangue");
                                        System.out.println("2 - Urina");
                                        System.out.println("3 - Fezes");
                                        System.out.println("4 - Exames Básicos");
                                        System.out.println("5 - Voltar");
                                        System.out.println("=======================================================");
                                        opc3 = scan.nextInt();


                                        switch(opc3){
                                            case 1:
                                                Servidor.exames.inserirExame(1);
                                                clearScreen();
                                                System.out.println("Exames adicionados com sucesso!");
                                                break;

                                            case 2:
                                                Servidor.exames.inserirExame(2);
                                                clearScreen();
                                                System.out.println("Exames adicionados com sucesso!");
                                                break;

                                            case 3:
                                                Servidor.exames.inserirExame(3);
                                                clearScreen();
                                                System.out.println("Exames adicionados com sucesso!");
                                                break;
                                            case 4:
                                                Servidor.exames.inserirExame(4);
                                                clearScreen();
                                                System.out.println("Exames adicionados com sucesso!");
                                                break;
                                            case 5:
                                                break; 
                                            default:
                                                System.out.println("Opção Inválida!");
                                                break;
                                            }
                                        }while(opc3!=5);
                                        break;
                                        
                                    case 2:
                                        clearScreen();
                                        int opc4;
                                        do{
                                            System.out.println("=========================================================");
                                            System.out.println("1 - Sangue");
                                            System.out.println("2 - Urina");
                                            System.out.println("3 - Fezes");
                                            System.out.println("4 - Basicos");
                                            System.out.println("5 - Voltar");
                                            System.out.println("=========================================================");
                                            opc4 = scan.nextInt();
                                            switch(opc4){
                                                case 1:
                                                    clearScreen();
                                                    Servidor.exames.mostrarExames(1);
                                                    break;
                                                case 2:
                                                    clearScreen();
                                                    Servidor.exames.mostrarExames(2);
                                                    break;
                                                case 3:
                                                    clearScreen();
                                                    Servidor.exames.mostrarExames(3);
                                                    break;
                                                case 4:
                                                    clearScreen();
                                                    Servidor.exames.mostrarExames(4);
                                                    break;
                                                case 5:
                                                    break;
                                                default:
                                                    clearScreen();
                                                    System.out.println("Opcao inválida");
                                                    break;

                                            }
                                        }while(opc4!=5);
                                        break;
                            }


                        }while(opc2!=3);
                        clearScreen();
                    }
                    break;

                case 3: 
                    clearScreen();
                    if(ListaServidor.tamanho==0){
                        System.out.println("Não há servidores cadastrados...");
                        break;
                    }else{
                        System.out.println("Informe a matricula:");
                        matricula = scan.nextLine();
                        System.out.println("Você tem certeza que quer descadastrar esse servidor?\n(S/N)");
                        String opcString = scan.nextLine().trim();
                        if(opcString.equals("S")){
                            ListaServidor.descadastrarServidor(matricula);
                            System.out.println("Servidor descadastrado com sucesso!");
                            break;
                        }else{
                            break;
                        }
                    }

                case 4:
                    clearScreen();
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    clearScreen();
                    System.out.println("Opcão Inválida!");
            }
    
    
        }while(opc1!=4);
        scan.close();
    }
}
