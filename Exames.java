public abstract class Exames {
    private String dataExame;
    private String hospital;
    private Exames prox;


    public void setData(String data){
        this.dataExame = data;
    }
    public String getData(){
        return this.dataExame;
    }
    public void setHospital(String hospital){
        this.hospital = hospital;
    }
    public String getHospital(){
        return this.hospital;
    }

    public void setProx(Exames prox){
        this.prox = prox;
    }
    public Exames getProx(){
        return this.prox;
    }
}
