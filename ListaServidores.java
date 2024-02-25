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
        String matricula = scan.nextLine();
        novo.matricula = matricula;
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

    public ServidorPublico findServidor(String matricula) {
        if (ListaServidor.isEmpty()) {
            return null; 
        }
        
        for (ServidorPublico servidor : ListaServidor) {
            if (servidor.matricula.equals(matricula)) {
                return servidor;
            }
        }
        
        return null; 
    }

    public void descadastrarServidor(String matricula){
        ServidorPublico servidor = findServidor(matricula);
        if (servidor != null) {
            ListaServidor.remove(servidor);
            tamanho--;
        } else {
            System.out.println("Servidor com a matrícula " + matricula + " não encontrado.");
        }
    }
}
