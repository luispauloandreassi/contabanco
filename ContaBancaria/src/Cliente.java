import java.util.Scanner;

public class Cliente {

    Scanner scan = new Scanner(System.in);
    private String scann = "";
    private String nome;
    private String cpf;



    public Cliente ( String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
        System.out.println("Cliente ---" + this.nome +  " ---Cadastrado com sucesso!!!");
        System.out.print("Digite qualquer tecla para continuar:");
        this.scann = scan.nextLine();

    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public String getScann() {
        return scann;
    }

    public void setScann(String scann) {
        this.scann = scann;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}

