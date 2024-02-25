public class Basico extends Exame {

    private float altura;
    private float peso;
    private float pressaoArterial;
    private float imc;
    private indiceBasico indices = new indiceBasico();

    public Basico(float altura, float peso, float pressaoArterial){
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

    public String IMC(){
        if (this.imc<indices.imcBaixo)
            return "Abaixo do peso";
        else if(this.imc>=indices.imcBaixo&&this.imc<indices.imcNormal)
            return "Normal";
        else if(this.imc>=indices.imcNormal&&this.imc<indices.imcAlto)
            return "Sobrepeso";
        else
            return "Obeso";
    }
    
    

}
