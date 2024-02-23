public class Basicos extends Exames {
    private float altura;
    private float peso;
    private float pressaoArterial;
    private float imc;
    


    public Basicos(float altura, float peso, float pressaoArterial){
        this.altura = altura;
        this.peso = peso;
        this.pressaoArterial = pressaoArterial;
    }
    
    private void calcularIMC() {
        this.imc = peso / (altura * altura);
    }

    public float getAltura(){
        return this.altura;
    }
    public float getPeso(){
        return this.peso;
    }
    public float getPressao(){
        return this.pressaoArterial;
    }
    public float getIMC(){
        calcularIMC();
        return this.imc;
    }
    
    

}
