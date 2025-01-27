public class Cone extends Item {
    public Cone(Localizacao localizacao) {
        super(localizacao, "Imagens/cone.png");
    }

    @Override
    public void executarAcao() {
        // Cones não executam ações
    }
}