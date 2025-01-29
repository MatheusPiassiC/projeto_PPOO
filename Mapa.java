/**
 * Representa um mapa bidimensional onde os itens da simulação são posicionados.
 * Pode conter veículos, pedágios e outros objetos.
 * 
 * @author Matheus Piassi
 * @author Bernardo Pavani
 */
public class Mapa {
    private Item[][] itens;
    private int largura;
    private int altura;

    private static final int LARGURA_PADRAO = 35;
    private static final int ALTURA_PADRAO = 35;

    /**
     * Cria um mapa com as dimensões especificadas.
     * 
     * @param largura Largura do mapa.
     * @param altura  Altura do mapa.
     */
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        itens = new Item[altura][largura];
    }

    /**
     * Cria um mapa com dimensões padrão (35x35).
     */
    public Mapa() {
        this(LARGURA_PADRAO, ALTURA_PADRAO);
    }

    /**
     * Adiciona um item ao mapa na posição correspondente.
     * Se for um pedágio, também adiciona seus cones.
     * 
     * @param item Item a ser adicionado.
     */
    public void adicionarItem(Item item) {
        Localizacao loc = item.getLocalizacaoAtual();
        itens[loc.getX()][loc.getY()] = item;

        if (item instanceof Pedagio) {
            for (Cone cone : ((Pedagio) item).getCones()) {
                itens[cone.getLocalizacaoAtual().getX()][cone.getLocalizacaoAtual().getY()] = cone;
            }
        }
    }

    /**
     * Remove um item do mapa.
     * Se for um pedágio, também remove seus cones.
     * 
     * @param item Item a ser removido.
     */
    public void removerItem(Item item) {
        Localizacao loc = item.getLocalizacaoAtual();
        itens[loc.getX()][loc.getY()] = null;

        if (item instanceof Pedagio) {
            for (Cone cone : ((Pedagio) item).getCones()) {
                itens[cone.getLocalizacaoAtual().getX()][cone.getLocalizacaoAtual().getY()] = null;
            }
        }
    }

    /**
     * Atualiza a posição de um item no mapa.
     * 
     * @param item Item a ser atualizado.
     */
    public void atualizarMapa(Item item) {
        removerItem(item);
        adicionarItem(item);
    }

    /**
     * Retorna o item presente em uma posição específica do mapa.
     * 
     * @param x Coordenada X.
     * @param y Coordenada Y.
     * @return Item na posição especificada ou {@code null} se estiver vazio.
     */
    public Item getItem(int x, int y) {
        return itens[x][y];
    }

    /**
     * Retorna a largura do mapa.
     * 
     * @return Largura do mapa.
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Retorna a altura do mapa.
     * 
     * @return Altura do mapa.
     */
    public int getAltura() {
        return altura;
    }

    /**
     * Verifica se uma posição está ocupada.
     * 
     * @param loc Localização a ser verificada.
     * @return {@code true} se a posição estiver ocupada, {@code false} caso contrário.
     */
    public boolean estaOcupado(Localizacao loc) {
        return itens[loc.getX()][loc.getY()] != null;
    }
}
