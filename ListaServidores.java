import java.util.*;

public class ListaServidores {
    public int tamanho = 0;


    Scanner scan = new Scanner(System.in);
    List<ServidorPublico> ListaServidor = new LinkedList<ServidorPublico>();
  
    public void cadastrarServidor(){
        

        ServidorPublico novo = new ServidorPublico();
        System.out.print("NOME:");
        String nome = scan.nextLine().trim();
        novo.nome = nome;
        System.out.print("MATRICULA:");
        int matricula = scan.nextInt();
        novo.matricula = matricula;
        scan.nextLine().trim();
        System.out.print("SEXO:");
        String sexo = scan.nextLine().trim();
        novo.sexo = sexo;
        System.out.print("DEPARTAMENTO:");
        String departamento = scan.nextLine().trim();
        novo.departamento = departamento;
        System.out.print("DATA DE NASCIMENTO(dd/mm/aa):");
        String dataNascimento = scan.nextLine().trim();
        novo.dataNascimento = dataNascimento;
        ListaServidor.add(novo);
        tamanho++;
    }

    public ServidorPublico findServidor(int matricula){
        int index = 0;
        while(ListaServidor.get(index).matricula != matricula){
            index++;
        }
        if(index<ListaServidor.size()){
            return ListaServidor.get(index);
        }
        return null;
    }

    public void descadastrarServidor(int matricula){
        ListaServidor.remove(findServidor(matricula));
        tamanho--;
    }
}
