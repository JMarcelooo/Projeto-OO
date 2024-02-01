public class ServidorPublico{
    String nome;
    int matricula;
    char sexo;
    String departamento;
    int dataNascimento;
    float peso;
    float altura;
    float pressão;
    float imc;
    CarteiraVacina vacinas = new CarteiraVacina();
    ListaExames exames = new ListaExames();


    public void cadastrar(String nome, int matricula, char sexo, String departamento, int dataNascimento){
        this.nome = nome;
        this.matricula = matricula;
        this.sexo = sexo;
        this.departamento = departamento;
        this.dataNascimento = dataNascimento;
    }


}