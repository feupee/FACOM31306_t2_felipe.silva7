public class NotificacaoPagamento extends Notificacao {
    public NotificacaoPagamento(ContaBancaria contaBancaria, Transacao transacao) {
        super(contaBancaria, transacao);
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Notificação de pagamento: Você realizou um pagamento de R$ " + transacao.getValor() + " na conta " + contaBancaria.getNumeroConta());

        // Se for uma Conta Salário, avisa sobre os limites de saque e transferência
        if (contaBancaria instanceof ContaSalario) {
            double limiteSaque = ((ContaSalario) contaBancaria).getLimite_saque();
            double limiteTransferencia = ((ContaSalario) contaBancaria).getLimite_transferencia();
            System.out.println("Aviso: Seu limite de saque é R$ " + limiteSaque + " e o limite de transferência é R$ " + limiteTransferencia);
        }
    }
}