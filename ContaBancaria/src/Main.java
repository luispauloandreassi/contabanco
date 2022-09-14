import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        Scanner nrConta = new Scanner (System.in);
        Scanner valor = new Scanner (System.in);
        float valorDeposito = 0;
        float valorSaque = 0;
        float valorTranferencia = 0;
        int opcaoSaque;
        int opcaoDeposito;
        int opcaoTranferencia;
        int opcao = 0;
        int conta;
        int senhaSaque = 0;
        int senhaTransferencia = 0;
        int contaTransferencia = 0;
        String nomeCliente;
        String cpfCliente;
        String cpfCadastroContaCorrente = null;
        String cpfCadastroContaPoupanca = null;

        Hashtable<String, String> contaBancaria = new Hashtable<String, String>();
        Hashtable<String, Cliente> cliente = new Hashtable<String, Cliente>();
        Hashtable<String, ContaCorrente> contaCorrente = new Hashtable<String, ContaCorrente>();
        Hashtable<String, ContaPoupanca> contaPoupanca = new Hashtable<String, ContaPoupanca>();


        System.out.println("-----PROGRAMA CONTA BANCARIA-----");

        while (opcao != 7) {
            System.out.println("");
            System.out.println("	************* MENU **************");
            System.out.println(" 	1 - Cadastrar Cliente            ");
            System.out.println(" 	2 - Cadastrar Conta Corrente     ");
            System.out.println(" 	3 - Cadastrar Conta Poupanca     ");
            System.out.println(" 	4 - Efetuar Deposito             ");
            System.out.println(" 	5 - Efetuar Saque                ");
            System.out.println(" 	6 - Efetuar Transferencia        ");
            System.out.println(" 	7 - Sair                         ");
            System.out.println("	********************************");
            System.out.print("\nDigite aqui sua opcao: ");
            opcao = scan.nextInt();

            switch(opcao){
                case 1:
                    System.out.print("----C A D A S T R A R - Cliente----:");
                    System.out.print("\nNome:");
                    scan.nextLine();
                    nomeCliente = scan.nextLine();
                    System.out.print("CPF:");
                  //  scan.nextLine();
                    cpfCliente = scan.nextLine();
                    //Abaixo estou jogando o CPF para dentro da HashTable e instanciando um cliente
                    cliente.put(cpfCliente, new Cliente(cpfCliente,nomeCliente));
                    break;

                case 2:
                    scan.nextLine();
                    System.out.print("----C A D A S T R A R - Conta Corrente----:");
                    System.out.print("\nInforme seu CPF: ");
                    cpfCadastroContaCorrente = scan.nextLine();
                   // if(!cliente.containsKey(cpfCadastroContaCorrente)){
                     //   System.out.println("CPF Inexistente!");
                    //    break;
                   // }else {
                        contaCorrente.put(cpfCadastroContaCorrente, new ContaCorrente());
                        ContaCorrente contaCorrenteConsulta = contaCorrente.get(cpfCadastroContaCorrente);
                        System.out.println("Agencia: " + contaCorrenteConsulta.getAgencia() + " ContaCorrente: " + contaCorrenteConsulta.getNumConta());
                        break;
                   // }

                case 3:
                    scan.nextLine();
                    System.out.print("----C A D A S T R A R - Conta Poupanca----:");
                    System.out.print("\nInforme seu CPF: ");
                    cpfCadastroContaPoupanca = scan.nextLine();
                    contaPoupanca.put(cpfCadastroContaPoupanca, new ContaPoupanca());
                    ContaPoupanca contaPoupancaConsulta = contaPoupanca.get(cpfCadastroContaPoupanca);
                    System.out.println("Agencia: "+ contaPoupancaConsulta.getAgencia() + " ContaPoupanca: " + contaPoupancaConsulta.getNumConta());
                break;

                case 4:
                    scan.nextLine();
                    System.out.print("----E F E T U A R deposito----:");
                    System.out.print("\nInforme Conta corrente (1) ou Poupanca (2): ");
                    opcaoDeposito = scan.nextInt();

                    while (opcaoDeposito != 1 && opcaoDeposito != 2){
                        System.out.print("Informe 1 para Corrente ou 2 para Poupanca: ");
                        opcaoDeposito = scan.nextInt();
                        System.out.println("Opcao Deposito: " + opcaoDeposito);
                    }

                    if (opcaoDeposito == 1) {
                        System.out.print("Informe seu CPF: ");
                        scan.nextLine();
                        cpfCliente = scan.nextLine();

                        if (!contaCorrente.containsKey(cpfCliente)) {
                            System.out.print("CPF Inexistente!");
                            break;
                        }
                        ContaCorrente contaCorrente1 = contaCorrente.get(cpfCliente);
                        System.out.print("Informe o Numero da Conta: ");
                        conta = nrConta.nextInt();
                        System.out.print("Informe o Valor: ");
                        valorDeposito = valor.nextFloat();
                        contaCorrente1.calculoSaldoContaCorrenteDeposito(valorDeposito);
                        System.out.println("Saldo Atual: " + contaCorrente1.getSaldo());
                    }

                        if (opcaoDeposito == 2) {
                            System.out.print("Informe seu CPF: ");
                            scan.nextLine();
                            cpfCliente = scan.nextLine();

                            if (!contaPoupanca.containsKey(cpfCliente)) {
                                System.out.print("CPF Inexistente!");
                                break;
                            }
                            ContaPoupanca contaPoupanca1 = contaPoupanca.get(cpfCliente);
                            System.out.print("Informe o Numero da Conta: ");
                            conta = nrConta.nextInt();
                            System.out.print("Informe o Valor: ");
                            valorDeposito = valor.nextFloat();
                            contaPoupanca1.calculoSaldoContaPoupancaDeposito(valorDeposito);
                            System.out.println("Saldo Atual: " + contaPoupanca1.getSaldo());
                        }
                    break;
                case 5:
                    System.out.print("----E F E T U A R saque----:");

                    System.out.print("\nInforme Conta corrente (1) ou Poupanca (2): ");
                    opcaoSaque = scan.nextInt();

                    while (opcaoSaque != 1 && opcaoSaque != 2){
                        System.out.print("Informe 1 para Corrente ou 2 para Poupanca: ");
                        opcaoSaque = scan.nextInt();
                    }

                    if (opcaoSaque == 1){
                        System.out.print("Informe seu CPF: ");
                        scan.nextLine();
                        cpfCliente = scan.nextLine();
                        System.out.print("Informe o Valor: ");
                        valorSaque = scan.nextFloat();
                        ContaCorrente contaCorrente1 = contaCorrente.get(cpfCliente);
                        System.out.print("Senha: ");
                        senhaSaque = scan.nextInt();
                        if (senhaSaque == contaCorrente1.getSenha()){
                        contaCorrente1.calculoSaldoContaCorrenteSaque(valorSaque);
                        }else{
                            System.out.println("Senha Invalida");
                            break;
                        }
                    }else {
                        System.out.print("Informe seu CPF: ");
                        scan.nextLine();
                        cpfCliente = scan.nextLine();
                        System.out.print("Informe o Valor: ");
                        valorSaque = scan.nextFloat();
                        ContaPoupanca contaPoupanca1 = contaPoupanca.get(cpfCliente);
                        System.out.print("Senha: ");
                        senhaSaque = scan.nextInt();
                        if (senhaSaque == contaPoupanca1.getSenha()){
                            contaPoupanca1.calculoSaldoContaPoupancaSaque(valorSaque);
                        }else{
                            System.out.println("Senha Invalida");
                            break;
                        }

                    }

                    break;
                case 6:
                    System.out.print("----E F E T U A R transferencia----:");

                    System.out.print("\nInforme Conta corrente (1) ou Poupanca (2): ");
                    opcaoTranferencia = scan.nextInt();

                    while (opcaoTranferencia != 1 && opcaoTranferencia != 2){
                        System.out.print("Informe 1 para Corrente ou 2 para Poupanca: ");
                        opcaoSaque = scan.nextInt();
                    }

                    if (opcaoTranferencia == 1){
                        System.out.println("Informe a Conta para Transferencia: ");
                        contaTransferencia = scan.nextInt();
                        System.out.print("Informe seu CPF: ");
                        scan.nextLine();
                        cpfCliente = scan.nextLine();
                        System.out.print("Informe o Valor: ");
                        valorTranferencia = scan.nextFloat();
                        ContaCorrente contaCorrente1 = contaCorrente.get(cpfCliente);
                        System.out.print("Senha: ");
                        senhaTransferencia = scan.nextInt();
                        if (senhaTransferencia == contaCorrente1.getSenha()){
                            contaCorrente1.calculoSaldoContaCorrenteSaque(valorTranferencia);
                        }else{
                            System.out.println("Senha Invalida");
                            break;
                        }
                    }else {
                        System.out.println("Informe a Conta para Transferencia: ");
                        contaTransferencia = scan.nextInt();
                        System.out.print("Informe seu CPF: ");
                        scan.nextLine();
                        cpfCliente = scan.nextLine();
                        System.out.print("Informe o Valor: ");
                        valorTranferencia = scan.nextFloat();
                        ContaPoupanca contaPoupanca1 = contaPoupanca.get(cpfCliente);
                        System.out.print("Senha: ");
                        senhaTransferencia = scan.nextInt();
                        if (senhaTransferencia == contaPoupanca1.getSenha()){
                            contaPoupanca1.calculoSaldoContaPoupancaSaque(valorTranferencia);
                        }else{
                            System.out.println("Senha Invalida");
                            break;
                        }

                    }



                    break;
                case 7:
                    System.out.println("O programa esta sendo finalizado....");
                    break;
                default:
                    System.out.println("Opcao Invalida! Digite Novamente...");
            }//FIM switch
        }//FIM while
    }//FIM Main
}

