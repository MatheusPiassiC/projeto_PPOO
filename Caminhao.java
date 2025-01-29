public class Caminhao extends Veiculo {
    private double capacidadeDeCarga;
    private int numeroDeEixos;

    public Caminhao(Localizacao localizacao, double capacidadeDeCarga, int numeroDeEixos) {
        super(localizacao, "Imagens/caminhao.png");
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.numeroDeEixos = numeroDeEixos;
    }

    public int getNumeroDeEixos() {
        return numeroDeEixos;
    }

    public void setNumeroDeEixos(int numeroDeEixos) {
        this.numeroDeEixos = numeroDeEixos;
    }

    @Override
    public void executarAcao() {
        super.executarAcao();
        // Adicione ações específicas para Caminhao, se necessário
    }

    @Override
    public int getTempoAtendimento() {
        return 3; // Tempo de atendimento para caminhões
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidade de Carga: " + capacidadeDeCarga + " toneladas, Número de Eixos: " + numeroDeEixos;
    }
}