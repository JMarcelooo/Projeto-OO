public class Fezes extends Exames {
    
    private boolean presencaParasitas;
    private boolean presencaOvosParasitas;
    private String tipoParasita;
    private String consistenciaCor;
    private boolean sangueOculto;
    private boolean presencaGordura;
    private double pH;

    public Fezes(boolean presencaParasitas, boolean presencaOvosParasitas,String tipoParasita, String consistenciaCor, boolean sangueOculto, boolean presencaGordura, double pH) {
            this.presencaParasitas = presencaParasitas;
            this.presencaOvosParasitas = presencaOvosParasitas;
            this.tipoParasita = tipoParasita;
            this.consistenciaCor = consistenciaCor;
            this.sangueOculto = sangueOculto;
            this.presencaGordura = presencaGordura;
            this.pH = pH;
    }

}
