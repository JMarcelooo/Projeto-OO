public abstract class Exame {
    private String dataExame;
    private String laboratorio;



    public void setData(String data){
        this.dataExame = data;
    }
    public String getData(){
        return this.dataExame;
    }
    public void setLaboratorio(String hospital){
        this.laboratorio = hospital;
    }
    public String getLaboratorio(){
        return this.laboratorio;
    }

   
    
}
