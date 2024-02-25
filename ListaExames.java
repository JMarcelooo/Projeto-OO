import java.util.Scanner;

public class ListaExames {

    Exames refExames;
    ServidorPublico pessoa;
    Scanner sc1 = new Scanner(System.in);
    

    public void inserirExame(int tipo) {
        Scanner sc2 = new Scanner(System.in);
        Exames novo = null;
        String data; 
        String hospital;
        System.out.println("Informe qual a data do exame:");
        data = sc2.nextLine().trim();
        System.out.println("Informe o Hospital onde o exame foi realizado:");
        hospital = sc2.nextLine().trim();

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
                novo.setHospital(hospital);
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
                novo.setHospital(hospital);
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
                novo.setHospital(hospital);
                break;

            case 4:
                float altura, peso, pressaoArterial;
                System.out.println("Informe a sua altura:");
                altura = sc2.nextFloat();
                System.out.println("Informe o seu peso:");
                peso = sc2.nextFloat();
                System.out.println("Informe a presão arterial:");
                pressaoArterial = sc2.nextFloat();
                novo = new Basicos(altura, peso, pressaoArterial);
                novo.setData(data);
                novo.setHospital(hospital);
                break; 
        }

        if (refExames == null) {
            refExames = novo;
        } else {
            Exames aux = refExames;
            while (aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novo);;
        }
    }

    public void retirarExame(Exames remov) {
        if (remov == null || refExames == null) {
            return;
        }
        if (refExames == remov) {
            refExames = refExames.getProx();
            return;
        }
        Exames aux = refExames;
        while (aux.getProx() != null && aux.getProx() != remov) {
            aux.setProx(aux.getProx());
        }
        if (aux.getProx() == remov) {
            aux.getProx().setProx(aux.getProx().getProx().getProx());
        }
    }

    public void mostrarExames(int tipo){
        Exames aux = refExames;
        int cont = 1;
        switch (tipo){
            case 1:

            System.out.println("=================Exames de Sangue=============");
            while(aux!=null){
                if(aux instanceof Sangue){
                    Sangue sangue = (Sangue)aux;
                    System.out.println("\t\t"+"Exame "+ cont + "\t\n");
                    System.out.println("\t" + "Data do Exame:" + sangue.getData());
                    System.out.println("\t" + "Hospital:" + sangue.getHospital() );
                    System.out.println("Nível de Hemácias:" + sangue.getHemacias()+ "\t" + sangue.hemacias());
                    System.out.println("Nível de Leucócitos:" + sangue.getLeucocitos()+ "\t" + sangue.leucocitos());
                    System.out.println("Nível de Plaquetas:" + sangue.getPlaquetas()+ "\t" + sangue.plaquetas());
                    System.out.println("============================================");
                    cont++;
                }
                aux = aux.getProx();
            }
            break;

            case 2:
                System.out.println("=================Exames de Urina=============");
                while(aux!=null){
                    if(aux instanceof Urina){
                        Urina urina = (Urina)aux;
                        System.out.println("\t\t"+"Exame "+ cont + "\t\n");
                        System.out.println("\t" + "Data do Exame:" + urina.getData());
                        System.out.println("\t" + "Hospital:" + urina.getHospital() );
                        System.out.println("Concentração do PH:" + urina.getPh()+ "\t" + urina.ph());
                        System.out.println("Presença de Parasita:" + urina.parasita());
                        if(urina.getParasita()){
                            System.out.println("Tipo do parasita:" + urina.getTipoParasita());
                        }
                        System.out.println("Presença de Sangue:" + urina.sangue());
                        System.out.println("============================================");
                        cont++;
                    }
                    aux = aux.getProx();
                }
                break;
            
            case 3:
                System.out.println("=================Exames de Fezes=============");
                while(aux!=null){
                    if(aux instanceof Fezes){
                        Fezes fezes = (Fezes)aux;
                        System.out.println("\t\t"+"Exame "+ cont + "\t\n");
                        System.out.println("\t" + "Data do Exame:" + fezes.getData());
                        System.out.println("\t" + "Hospital:" + fezes.getHospital() );
                        System.out.println("Concentração do PH:" + fezes.getPH()+ "\t" + fezes.ph());
                        System.out.println("Presença de Parasita:" + fezes.parasita());
                        if(fezes.getParasita()){
                            System.out.println("Tipo do parasita:" + fezes.getTipoParasita());
                            System.out.println("Presença de Ovos:" + fezes.ovo());
                        }
                        System.out.println("Presença de Sangue:" + fezes.sangue());
                        System.out.println("Presença de Gordura:" + fezes.gordura());
                        System.out.println("Cor: " + fezes.getCor());
                        System.out.println("============================================");
                        cont++;
                    }
                    aux = aux.getProx();
                }
                break;
            
                case 4:
                    System.out.println("================= Exames Básicos =============");
                    while (aux != null) {
                        if (aux instanceof Basicos) {
                            Basicos basicos = (Basicos) aux;
                            System.out.println("\t\t" + "Exame " + cont + "\t\n");
                            System.out.println("\t" + "Data do Exame: " + basicos.getData());
                            System.out.println("\t" + "Hospital: " + basicos.getHospital());
                            System.out.println("Altura: " + basicos.getAltura());
                            System.out.println("Peso: " + basicos.getPeso());
                            System.out.println("Pressão Artérial: " + basicos.getPressao());
                            System.out.println("IMC: " + basicos.getIMC() + "\t" + basicos.IMC());
                            System.out.println("============================================");
                            cont++;
                        }
                        aux = aux.getProx();
                    }
                break;
        }
    }
}
