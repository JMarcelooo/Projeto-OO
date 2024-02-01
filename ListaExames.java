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
                novo = new Urina();
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
