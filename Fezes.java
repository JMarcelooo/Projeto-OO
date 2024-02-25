public class Fezes extends Exames {
    
    private boolean presencaParasitas;
    private boolean presencaOvosParasitas;
    private String tipoParasita;
    private String cor;
    private boolean sangueOculto;
    private boolean presencaGordura;
    private double pH;

    public Fezes(boolean presencaParasitas, boolean presencaOvosParasitas,String tipoParasita, String cor, boolean sangueOculto, boolean presencaGordura, double pH) {
            this.presencaParasitas = presencaParasitas;
            this.presencaOvosParasitas = presencaOvosParasitas;
            this.tipoParasita = tipoParasita;
            this.cor = cor;
            this.sangueOculto = sangueOculto;
            this.presencaGordura = presencaGordura;
            this.pH = pH;
    }

    public boolean getParasita(){
        return this.presencaParasitas;
    }

    public boolean getOvo(){
        return this.presencaOvosParasitas;
    }

    public boolean getSangue(){
        return this.sangueOculto;
    }

    public boolean getGordura(){
        return this.presencaGordura;
    }

    public String getCor(){
        return this.cor;
    }

    public double getPH(){
        return this.pH;
    }

    public String getTipoParasita(){
        return this.tipoParasita;
    }

    public String parasita(){
        if(presencaParasitas)
            return "Sim";
        else 
            return "Não";
    }
    
    public String ovo(){
        if(presencaOvosParasitas)
            return "Sim";
        else    
            return "Não";
    }

    public String sangue(){
        if(this.sangueOculto)
            return "Sim";
        else
            return "Não";
    }

    public String gordura(){
        if(presencaGordura)
            return "Sim";
        else    
            return "Não";
    }

    public String ph(){
        if(this.pH>=indices.phFezesMin||this.pH<=indices.phFezesMax){
            return "Concentração Saudável";
        } else if(this.pH>indices.phFezesMax){
            return "Concentração Alta";
        } else {
            return "Concentração Baixa";
        }
    }
    
    
}
