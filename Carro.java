public class Carro extends Veiculo {
    public Carro(Localizacao localizacao) {
        super(localizacao, "Imagens/carro.png");
    }

    @Override
    public void executarAcao() {
        super.executarAcao();
        // Adicione ações específicas para Carro, se necessário
    }
}