public class Carro extends Veiculo {
    private double peso;

    public Carro(Localizacao localizacao, double peso) {
        super(localizacao, "Imagens/carro.png");
        this.peso = peso;

    }

    @Override
    public int getTempoAtendimento() {
        return (int)peso/100; // Tempo de atendimento para carros
    }
}