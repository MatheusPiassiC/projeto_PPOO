public class PedagioPessoa extends Pedagio {
    public PedagioPessoa(Localizacao localizacao) {
        super(localizacao, "Imagens/pedagioPessoa.png");
    }

    @Override
    public int getTempoAtendimento() {
        return 4; // Tempo de atendimento para pedágios com pessoas
    }
}