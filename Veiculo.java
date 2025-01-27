public class Veiculo extends Item {
    private Localizacao localizacaoDestino;

    public Veiculo(Localizacao localizacao) {
        super(localizacao, "Imagens/veiculo.png");
        this.localizacaoDestino = null;
    }

    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    @Override
    public void executarAcao() {
        Localizacao destino = getLocalizacaoDestino();
        if (destino != null) {
            Localizacao proximaLocalizacao = localizacao.proximaLocalizacao(localizacaoDestino);
            setLocalizacaoAtual(proximaLocalizacao);
        }
    }
}