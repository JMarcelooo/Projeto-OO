public class Urina extends Exames {
    // Parasitologia
    private boolean positivoParasitas;
    private String tipoParasita;
    private boolean testeSangueOculto;
    


    public Urina(boolean parasita, String tipo, boolean sangue){
        this.positivoParasitas = parasita;
        this.tipoParasita = tipo;
        this.testeSangueOculto = sangue;
    } 
}
