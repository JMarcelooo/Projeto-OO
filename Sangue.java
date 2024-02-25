public class Sangue extends Exames{
    
    private double hemacias;
    private double leucocitos;
    private double plaquetas;

    
    public Sangue(double hemacias, double leucocitos, double plaquetas){
        this.hemacias = hemacias;
        this.leucocitos = leucocitos;
        this. plaquetas = plaquetas;
    }
    
    
    public String hemacias(){
        if(this.hemacias>indices.hemaciasMin&&this.hemacias<indices.hemaciasMax){
            return "Saudável";
        }
        else if(this.hemacias<indices.hemaciasMin){
            return "Concentração Baixa";
        }
        else{
            return "Concentração Alta";
        }

    }

    public String leucocitos(){
        if(this.leucocitos>indices.leucocitosMin&&this.leucocitos<indices.leucocitosMax){
            return "Saudável";
        }
        else if(this.leucocitos<indices.leucocitosMin){
            return "Concentração Baixa";
        }
        else{
            return "Concentração Alta";
        }

    }

    public String plaquetas(){
        if(this.plaquetas>indices.plaquetasMin&&this.plaquetas<indices.plaquetasMax){
            return "Saudável";
        }
        else if(this.plaquetas<indices.plaquetasMin){
            return "Concentração Baixa";
        }
        else{
            return "Concentração Alta";
        }

    }

    public double getHemacias(){
        return this.hemacias;
    }
    
    public double getLeucocitos(){
        return this.leucocitos;
    }

    public double getPlaquetas(){
        return this.plaquetas;
    }
}