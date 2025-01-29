public abstract class Veiculo extends Item {
    private Localizacao localizacaoDestino;
    private int contadorAtendimento;
    private boolean podeAvancar = false; 

    public Veiculo(Localizacao localizacao, String imagem) {
        super(localizacao, imagem);
        this.localizacaoDestino = null;
        this.contadorAtendimento = 0;
    }

    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    public int getContadorAtendimento() {
        return contadorAtendimento;
    }

    public void incrementarContadorAtendimento() {
        this.contadorAtendimento++;
    }

    public void resetarContadorAtendimento() {
        this.contadorAtendimento = 0;
    }

    public abstract int getTempoAtendimento();

    public void setPodeAvancar() {
        this.podeAvancar = !podeAvancar;
    }

    public boolean getPodeAvancar() {
        return podeAvancar;
    }

    public void executarAcao() {
        Localizacao destino = getLocalizacaoDestino();
        if (destino != null) {
            Localizacao proximaLocalizacao = localizacao.proximaLocalizacao(localizacaoDestino);
            setLocalizacaoAtual(proximaLocalizacao);
        }
    }
}