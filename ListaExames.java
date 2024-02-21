import java.util.Scanner;

public class ListaExames {

    Exames refExames;
    ServidorPublico pessoa;
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);

    public void inserirExame(int tipo) {

        Exames novo = null;
        String data = null; 
        String hospital = null;
        System.out.println("Informe qual a data do exame:");
        data = sc1.nextLine().trim();
        System.out.println("Informe o Hospital onde o exame foi realizado:");
        hospital = sc1.nextLine().trim();

        switch (tipo) {
            case 1:
                double h, p, l;

                System.out.println("Informe o nível das Hemácias:");    
                h = sc1.nextDouble();
                System.out.println("Informe o nível das Plaquetas:");
                p = sc1.nextDouble();
                System.out.println("Informe o nível dos Leucócitos:");
                l = sc1.nextDouble();
                novo = new Sangue(h,l,p);
                novo.setData(data);
                novo.setHospital(hospital);
                break;

            case 2:
            
                boolean para = false; 
                boolean s= false;
                String t = null;

        
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
                novo = new Urina(para, t, s);
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
                op = sc1.nextLine().trim();
                if(op.equals("S") || op.equals("s")){
                    parasita = true;
                }
                if(parasita){
                    System.out.println("Informe o tipo do parasita:");
                    tipoParasita = sc1.nextLine().trim();
                    System.out.println("Foram encontrados ovos do parasita[S/N]:");
                    op = sc1.nextLine().trim();
                    if(op.equals("S") || op.equals("s")){
                        ovoParasita = true;
                    }
                }
                System.out.println("Informe a cor:");
                cor = sc1.nextLine().trim();
                System.out.println("Informe se houve sangue[S/N]:");
                op = sc1.nextLine().trim();
                if(op.equals("S") || op.equals("s")){
                    sangue = true;
                }
                System.out.println("Informe se houve gordura[S/N]:");
                op = sc1.nextLine().trim();
                if(op.equals("S") || op.equals("s")){
                    gordura = true;
                }
                System.out.println("Informe o nível de PH:");
                ph = sc1.nextDouble();
                novo = new Fezes(parasita, ovoParasita, tipoParasita, cor, sangue, gordura, ph);
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

    public void retirarVacina(Exames remov) {
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
}
