public class CarteiraVacina {
    
    Vacina refVacina;

    public void inserirVacina(String tipoVacina, int dataAplicacao, int dose){
        Vacina novo = new Vacina(tipoVacina,dataAplicacao,dose);
        if(refVacina==null){
            refVacina=novo;
        }else{
            Vacina aux = refVacina;
            while(aux.prox!=null){
                aux= aux.prox;
            }
            aux=novo;
        }
    }

    public void retirarVacina(Vacina vc1) {
        if (vc1 == null || refVacina == null) {
            return;
        }
        if (refVacina == vc1) {
            refVacina = refVacina.prox;
            return;
        }
        Vacina aux = refVacina;
        while (aux.prox != null && aux.prox != vc1) {
            aux = aux.prox;
        }
        if (aux.prox == vc1) {
            aux.prox = aux.prox.prox;
        }
    }


    public void exibirLista(){
        if(refVacina==null){
            return;
        }
        else{
            int i = 1;
            Vacina aux = refVacina;
            System.out.println("Nome da vacina | Data de aplicação | Dose");
            while(aux.prox!=null){
                System.out.format("[%d] - %s %d %d\n", i, aux.nomeVacina, aux.dataAplicacao, aux.dose);
                aux = aux.prox;
                i++;
            }
        }
    }

    
}
