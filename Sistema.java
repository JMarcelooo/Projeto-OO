import java.util.*;

public class Sistema {
    
    ArrayList <ServidorPublico> ListaServidor = new ArrayList<ServidorPublico>();
    Scanner scan = new Scanner(System.in);


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
        } else {
            System.out.println("Servidor com a matrícula " + matricula + " não encontrado.");
        }
    }


    ArrayList <Exame> ListaExames = new ArrayList<Exame>();

    public void inserirExame(int tipo){
        Scanner sc2 = new Scanner(System.in);
        Exame novo = null;
        String data;
        String Laboratorio;

        System.out.println("Informe qual a data do exame:");
        data = sc2.nextLine().trim();
        System.out.println("Informe o Laboratório onde o exame foi realizado:");
        Laboratorio = sc2.nextLine().trim();

        switch (tipo) {
            case 1:
                double h, p, l;

                System.out.println("Informe o nível das Hemácias:");    
                h = sc2.nextDouble();
                System.out.println("Informe o nível das Plaquetas:");
                p = sc2.nextDouble();
                System.out.println("Informe o nível dos Leucócitos:");
                l = sc2.nextDouble();
                novo = new Sangue(h,l,p);
                novo.setData(data);
                novo.setLaboratorio(Laboratorio);
                break;

            case 2:
            
                boolean para = false; 
                boolean s= false;
                String t = null;
                float phUrina;

        
                System.out.println("Informe se foram detectados parasitas[S/N]");
                String op = sc2.nextLine().trim();
                switch(op){
                    case "S":
                    case "s":
                        para = true;
                        System.out.println("Informe o tipo do parasita:");
                        t = sc2.nextLine().trim();
                        break;

                    case "N":
                    case "n":
                        para = false;
                        t = null;
                        break;

                    default:
                        System.out.println("opcao inválida!");    
                        break;
                }
                System.out.println("Informe se foi encontrado sangue[S/N]");
                op = sc2.nextLine().trim();
                switch(op){
                    case "S":
                    case "s":
                        s = true;
                        break;
                    case "N":
                    case "n":
                        s = false;
                        break;
                    default:
                        System.out.println("opcao invalida");
                        break;
                }
                System.out.println("Informe o PH:");
                phUrina = sc2.nextFloat();
                novo = new Urina(para, t, s, phUrina);
                novo.setData(data);
                novo.setLaboratorio(Laboratorio);
                break;

            case 3:
                
                boolean parasita = false;
                String tipoParasita = null;
                boolean ovoParasita = false;
                String cor = null;
                boolean sangue = false;
                boolean gordura = false;
                double ph;
                
                System.out.println("Informe se foram detectados parasitas[S/N]:");
                op = sc2.nextLine().trim();
                if(op.equals("S") || op.equals("s")){
                    parasita = true;
                }
                if(parasita){
                    System.out.println("Informe o tipo do parasita:");
                    tipoParasita = sc2.nextLine().trim();
                    System.out.println("Foram encontrados ovos do parasita[S/N]:");
                    op = sc2.nextLine().trim();
                    if(op.equals("S") || op.equals("s")){
                        ovoParasita = true;
                    }
                }
                System.out.println("Informe a cor:");
                cor = sc2.nextLine().trim();
                System.out.println("Informe se houve sangue[S/N]:");
                op = sc2.nextLine().trim();
                if(op.equals("S") || op.equals("s")){
                    sangue = true;
                }
                System.out.println("Informe se houve gordura[S/N]:");
                op = sc2.nextLine().trim();
                if(op.equals("S") || op.equals("s")){
                    gordura = true;
                }
                System.out.println("Informe o nível de PH:");
                ph = sc2.nextDouble();
                novo = new Fezes(parasita, ovoParasita, tipoParasita, cor, sangue, gordura, ph);
                novo.setData(data);
                novo.setLaboratorio(Laboratorio);
                break;

            case 4:
                float altura, peso, pressaoArterial;
                System.out.println("Informe a sua altura:");
                altura = sc2.nextFloat();
                System.out.println("Informe o seu peso:");
                peso = sc2.nextFloat();
                System.out.println("Informe a presão arterial:");
                pressaoArterial = sc2.nextFloat();
                novo = new Basico(altura, peso, pressaoArterial);
                novo.setData(data);
                novo.setLaboratorio(Laboratorio);
                break; 
        }
        ListaExames.add(novo);
    }

    public void mostrarExames(int tipo){
        if(ListaExames.isEmpty())
            System.out.println("Não foram encontrados exames!");
        else{
            Exame aux = ListaExames.getFirst();
            int cont = 1;
            switch (tipo){
                case 1:
                    System.out.println("=================Exames de Sangue=============");
                    for (Exame exame : ListaExames) {
                        if (exame instanceof Sangue) {
                            Sangue sangue = (Sangue) exame;
                            System.out.println("\t\t" + "Exame " + cont + "\t\n");
                            System.out.println("\t" + "Data do Exame:" + sangue.getData());
                            System.out.println("\t" + "Laboratório:" + sangue.getLaboratorio());
                            System.out.println("Nível de Hemácias:" + sangue.getHemacias() + "\t" + sangue.hemacias());
                            System.out.println("Nível de Leucócitos:" + sangue.getLeucocitos() + "\t" + sangue.leucocitos());
                            System.out.println("Nível de Plaquetas:" + sangue.getPlaquetas() + "\t" + sangue.plaquetas());
                            System.out.println("============================================");
                            cont++;
                        }
                    }
                    break;

                case 2:
                    System.out.println("=================Exames de Urina=============");
                    for (Exame exame : ListaExames) {
                        if (exame instanceof Urina) {
                            Urina urina = (Urina) exame;
                            System.out.println("\t\t" + "Exame " + cont + "\t\n");
                            System.out.println("\t" + "Data do Exame:" + urina.getData());
                            System.out.println("\t" + "Laboratório:" + urina.getLaboratorio());
                            System.out.println("Concentração do PH:" + urina.getPh() + "\t" + urina.ph());
                            System.out.println("Presença de Parasita:" + urina.parasita());
                            if (urina.getParasita()) {
                                System.out.println("Tipo do parasita:" + urina.getTipoParasita());
                            }
                            System.out.println("Presença de Sangue:" + urina.sangue());
                            System.out.println("============================================");
                            cont++;
                        }
                    }
                    break;
                
                case 3:
                    System.out.println("=================Exames de Fezes=============");
                    for (Exame exame : ListaExames) {
                        if (exame instanceof Fezes) {
                            Fezes fezes = (Fezes) exame;
                            System.out.println("\t\t" + "Exame " + cont + "\t\n");
                            System.out.println("\t" + "Data do Exame:" + fezes.getData());
                            System.out.println("\t" + "Laboratório:" + fezes.getLaboratorio());
                            System.out.println("Concentração do PH:" + fezes.getPH() + "\t" + fezes.ph());
                            System.out.println("Presença de Parasita:" + fezes.parasita());
                            if (fezes.getParasita()) {
                                System.out.println("Tipo do parasita:" + fezes.getTipoParasita());
                                System.out.println("Presença de Ovos:" + fezes.ovo());
                            }
                            System.out.println("Presença de Sangue:" + fezes.sangue());
                            System.out.println("Presença de Gordura:" + fezes.gordura());
                            System.out.println("Cor: " + fezes.getCor());
                            System.out.println("============================================");
                            cont++;
                        }
                    }
                    break;
                
                case 4:
                    System.out.println("================= Exames Básicos =============");
                    for (Exame exame : ListaExames) {
                        if (exame instanceof Basico) {
                            Basico basicos = (Basico) exame;
                            System.out.println("\t\t" + "Exame " + cont + "\t\n");
                            System.out.println("\t" + "Data do Exame: " + basicos.getData());
                            System.out.println("\t" + "Laboratório: " + basicos.getLaboratorio());
                            System.out.println("Altura: " + basicos.getAltura());
                            System.out.println("Peso: " + basicos.getPeso());
                            System.out.println("Pressão Artérial: " + basicos.getPressao());
                            System.out.println("IMC: " + basicos.getIMC() + "\t" + basicos.IMC());
                            System.out.println("============================================");
                            cont++;
                        }
                    }
                    break;
            }
        }
    }
    


}
