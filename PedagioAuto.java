public class PedagioAuto extends Pedagio {
    public PedagioAuto(Localizacao localizacao) {
        super(localizacao, "Imagens/pedagioAuto.png");
    }

    @Override
    public int getTempoAtendimento() {
        return 2; // Tempo de atendimento para pedágios automáticos
    }
}