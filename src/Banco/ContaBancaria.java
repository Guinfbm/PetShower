package Banco;

/**
 * Representa uma conta bancária associada a um cliente.
 * Gerencia saldo, cheque especial e operações bancárias como depósitos e pagamentos.
 */
public class ContaBancaria {

    /**
     * O cliente titular da conta.
     */
    public Cliente titular;
    private double saldo;
    private double limiteChequeEspecial;
    private double valorUsadoCheque;

    /**
     * Verifica se o cliente está utilizando o cheque especial.
     *
     * @return true se o cheque especial estiver sendo usado, false caso contrário.
     */
    public boolean estaUsandoChequeEspecial(){
        return this.valorUsadoCheque > 0;
    }

    /**
     * Obtém o limite do cheque especial disponível para a conta.
     *
     * @return O valor do limite do cheque especial.
     */
    public double getLimiteChequeEspecial(){
        return this.limiteChequeEspecial;
    }

    /**
     * Obtém o valor atualmente utilizado do cheque especial.
     *
     * @return O valor usado do cheque especial.
     */
    public double getValorUsadoCheque() {
        return this.valorUsadoCheque;
    }

    /**
     * Construtor da classe ContaBancaria.
     * Inicializa a conta com um titular e um depósito inicial.
     * O limite do cheque especial é definido com base no depósito inicial.
     *
     * @param titular O cliente titular da conta.
     * @param depositoInicial O valor do depósito inicial.
     */
    public ContaBancaria(Cliente titular, double depositoInicial) {
        this.titular = titular;
        this.saldo = depositoInicial;
        this.valorUsadoCheque = 0;

        if(depositoInicial <= 500.00){
            this.limiteChequeEspecial = 50.00;
        }else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
    }

    /**
     * Consulta e exibe o saldo atual e o limite disponível do cheque especial.
     */
    public void consultarSaldo(){
        System.out.println("Saldo atual: R$ " + this.saldo);
        System.out.println("Limite do Cherque Especial: R$ " + (this.limiteChequeEspecial - this.valorUsadoCheque));
    }

    /**
     * Realiza um depósito na conta.
     * Se houver uso do cheque especial, o valor depositado abate o valor usado, com cobrança de taxa.
     *
     * @param valor O valor a ser depositado.
     */
    public void depositar(double valor){
        if(valor > 0) {
            if (valorUsadoCheque > 0){
                double taxa = valorUsadoCheque * 0.20;
                System.out.println("Cobrando taxa de 10% sobre o uso do che especial: " + taxa);
                this.saldo += (valor - taxa);
                this.valorUsadoCheque = 0;
            } else{
                this.saldo += valor;
            }
            System.out.println("Depósito de R$ " + valor + " realizado com suceso");
        }
    }

    /**
     * Realiza um pagamento ou operação debitando do saldo.
     * Utiliza o cheque especial se o saldo for insuficiente, até o limite disponível.
     *
     * @param valor O valor do pagamento.
     * @param tipoOperação A descrição do tipo de operação realizada.
     */
    public void realizarPagamento(double valor, String tipoOperação){
        double disponivelTotal = this.saldo + (this.limiteChequeEspecial - this.valorUsadoCheque);

        if(valor <= disponivelTotal){
            if(valor <- this.saldo) {
                this.saldo -= valor;
            } else {
                double restante = valor - this.saldo;
                this.saldo = 0;
                this.valorUsadoCheque += restante;
                System.out.println("Atencao: Voce esta utilizando o cheque especial. Valor utilizado: R$ " + restante);
            }
            System.out.println(tipoOperação + " de R$ " + valor + " realizada com sucesso.");
        }else {
            System.out.println("Erro: Saldo insuficiente para realizar a operacao de " + tipoOperação + ". Valor solicitado: R$ " + valor + ", Disponivel: R$ " + disponivelTotal);
        }
    }

}
