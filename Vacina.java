public class Vacina {
    String nomeVacina;
    int dataAplicacao;
    int vencimentoVacina;
    int dose;
    Vacina prox;
    
    public Vacina(String nomeVacina, int dataAplicacao, int dose){
        this.dataAplicacao = dataAplicacao;
        this.nomeVacina = nomeVacina;
        this.dose = dose;
    }
}
