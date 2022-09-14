import java.util.Random;
import java.util.Scanner;

public class ContaCorrente {

    private float saldo = 0;
    private final String agencia = "123";
    private Integer numConta;
    private Integer senhaPrevia;
    private Integer senha;
    private Random random = new Random();
    private Scanner scan = new Scanner(System.in);

    //CONSTRUTOR
    public ContaCorrente(){

        System.out.print("Informe a senha para cadastro: ");
        senhaPrevia = scan.nextInt();
        String s = Integer.toString(senhaPrevia);
        System.out.println("Quantidade de digitos: " + s.length());

        if ( s.length() == 4){
            this.numConta = random.nextInt(99999);
            senha = senhaPrevia;
            System.out.println("Senha cadastrada com sucesso!!!");
        }else{
            System.out.println("A senha deve conter 4 digitos");
            System.out.println("Voce esta sendo direcionado ao MENU principal, inicie o processo novamente.");
        }
    }//Fim Construtor


    public void calculoSaldoContaCorrenteDeposito(float deposito){
        if (deposito <= 0){
            System.out.println("Valor do deposito nao pode ser igual ou menor que 0-zero!!!");
        }else{
            this.saldo = this.saldo + deposito;
            System.out.println("Deposito Realizado com sucesso!!!");
        }
    }

    public void calculoSaldoContaCorrenteSaque(float saque){
        if (saque <=0){
            System.out.println("Valor nao pode ser menor ou igual a 0-Zero!!!");
        }
        if (saque > this.saldo){
            System.out.println("Valor do saque maior que o saldo disponivel!!!");
            System.out.println("Valor Saque: " + saque);
            System.out.println("Valor Saldo: " + this.saldo);
        }
        if (saque > 0 && saque <=this.saldo){
            this.saldo = this.saldo - saque;
            System.out.println("Salque realizado com sucesso!!!");
            System.out.println("Saldo atual: " + this.saldo);
        }
    }



    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getAgencia() {
        return agencia;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public void setNumConta(Integer numConta) {
        this.numConta = numConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
