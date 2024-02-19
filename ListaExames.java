import java.util.Scanner;

public class ListaExames {

    Exames refExames;
    ServidorPublico pessoa;
    Scanner sc1 = new Scanner(System.in);

    public void inserirExame(int tipo) {
        Exames novo = null;

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
                break;

            case 2:
                boolean para, s;
                String t;
                System.out.println("Informe se foram detectados parasitas[S/N]");
                String op = sc1.nextLine();
                switch(op){
                    case "S":
                    case "s":
                        para = true;
                        System.out.println("Informe o tipo do parasita:");
                        t = sc1.nextLine();
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
                op = sc1.nextLine();
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
                break;

            case 3:
                novo = new Fezes();
                break;
        }

        if (refExames == null) {
            refExames = novo;
        } else {
            Exames aux = refExames;
            while (aux.prox != null) {
                aux = aux.prox;
            }
            aux.prox = novo;
        }
    }

    public void retirarVacina(Exames remov) {
        if (remov == null || refExames == null) {
            return;
        }
        if (refExames == remov) {
            refExames = refExames.prox;
            return;
        }
        Exames aux = refExames;
        while (aux.prox != null && aux.prox != remov) {
            aux = aux.prox;
        }
        if (aux.prox == remov) {
            aux.prox = aux.prox.prox;
        }
    }
}
