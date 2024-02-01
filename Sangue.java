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
        if(this.hemacias>4.2&&this.hemacias<5.4){
            return "Saudável";
        }
        else if(this.hemacias<4.2){
            return "Concentração Baixa";
        }
        else{
            return "Concentração Alta";
        }

    }

    public String leucocitos(){
        if(this.leucocitos>4.0&&this.leucocitos<11){
            return "Saudável";
        }
        else if(this.leucocitos<4.0){
            return "Concentração Baixa";
        }
        else{
            return "Concentração Alta";
        }

    }

    public String plaquetas(){
        if(this.plaquetas>150&&this.plaquetas<450){
            return "Saudável";
        }
        else if(this.plaquetas<150){
            return "Concentração Baixa";
        }
        else{
            return "Concentração Alta";
        }

    }

}