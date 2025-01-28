public class Mapa {
    private Item[][] itens;
    private int largura;
    private int altura;

    private static final int LARGURA_PADRAO = 35;
    private static final int ALTURA_PADRAO = 35;

    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        itens = new Item[altura][largura];
    }

    public Mapa() {
        this(LARGURA_PADRAO, ALTURA_PADRAO);
    }

    public void adicionarItem(Item item) {
        Localizacao loc = item.getLocalizacaoAtual();
        itens[loc.getX()][loc.getY()] = item;

        if (item instanceof Pedagio) {
            Pedagio pedagio = (Pedagio) item; //converte item para a classe Pedagio
            for (Cone cone : pedagio.getCones()) { //Para conseguir chamar os métodos de Pedágio
                Localizacao locCone = cone.getLocalizacaoAtual();
                itens[locCone.getX()][locCone.getY()] = cone;
            }
        }
    }

    public void removerItem(Item item) {
        Localizacao loc = item.getLocalizacaoAtual();
        itens[loc.getX()][loc.getY()] = null;

        if (item instanceof Pedagio) {
            Pedagio pedagio = (Pedagio) item;
            for (Cone cone : pedagio.getCones()) {
                Localizacao locCone = cone.getLocalizacaoAtual();
                itens[locCone.getX()][locCone.getY()] = null;
            }
        }
    }

    public void atualizarMapa(Item item) {
        removerItem(item);
        adicionarItem(item);
    }

    public Item getItem(int x, int y) {
        return itens[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public boolean estaOcupado(int x, int y) {
        return itens[x][y] != null;
    }
}