public class Urina extends Exame {
    // Parasitologia
    private boolean positivoParasitas;
    private String tipoParasita;
    private boolean testeSangueOculto;
    private float ph;
    private indiceUrina indices = new indiceUrina();
    


    public Urina(boolean parasita, String tipo, boolean sangue, float ph){
        this.positivoParasitas = parasita;
        this.tipoParasita = tipo;
        this.testeSangueOculto = sangue;
        this.ph = ph;
    } 


    public boolean getParasita(){
        return this.positivoParasitas;
    }

    public String getTipoParasita(){
        return this.tipoParasita;
    }

    public boolean getSangue(){
        return this.testeSangueOculto;
    }

    public float getPh(){
        return this.ph;
    }

    public String ph(){
        if(this.ph>=indices.phUrinaMin||this.ph<=indices.phUrinaMax){
            return "Concentração Saudável";
        } else if(this.ph>indices.phUrinaMax){
            return "Concentração Alta";
        } else {
            return "Concentração Baixa";
        }
    }

    public String parasita(){
        if(this.positivoParasitas)
            return "Sim";
         else 
            return "Não"; 
    }

    public String sangue(){
        if(this.testeSangueOculto)
            return "Sim";
        else
            return "Não";
    }





}
