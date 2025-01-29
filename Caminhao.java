public class Caminhao extends Veiculo {
    private int numeroDeEixos;

    public Caminhao(Localizacao localizacao, int numeroDeEixos) {
        super(localizacao, "Imagens/caminhao.png");
        this.numeroDeEixos = numeroDeEixos;
    }

    @Override
    public int getTempoAtendimento() {
        return numeroDeEixos; // Tempo de atendimento para caminhões
    }
}