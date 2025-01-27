/**
 * Representa um mapa com todos os itens que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private Cancela[][] itensCancelas;
    private Veiculo[][] itens;
    private int largura;
    private int altura;
    
    private static final int LARGURA_PADRAO = 35; //define o número de quadras na janela/mapa
    private static final int ALTURA_PADRAO = 35;
    
    /**
     * Cria mapa para alocar itens da simulacao.
     * @param largura: largura da área de simulacao.
     * @param altura: altura da área de simulação.
     */
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        itens = new Veiculo[altura][largura]; //Matriz de veículos? Para saber onde cada um está na matriz
        itensCancelas = new Cancela[altura][largura]; // Matriz de cancelas 
    }
    /**
     * Cria mapa com tamanho padrao.
     */
    public Mapa(){
        this(LARGURA_PADRAO,ALTURA_PADRAO);
    }
    
    public void adicionarItem(Veiculo v){//adiciona um veiculo em suas respectivas coordenadas
        itens[v.getLocalizacaoAtual().getX()][v.getLocalizacaoAtual().getY()] = v;
    }

    public void adicionarCancela(Cancela cancela) {
        itensCancelas[cancela.getLocalizacaoCabine().getX()][cancela.getLocalizacaoCabine().getY()] = cancela;
    }
    
    public void removerItem(Veiculo v){//remove um item de sua coordenada
        itens[v.getLocalizacaoAtual().getX()][v.getLocalizacaoAtual().getY()] = null;
    }
    
    public void atualizarMapa(Veiculo v){//
        removerItem(v);
        adicionarItem(v);
    }
    
    public Veiculo getItem(int x, int y){
        return itens[x][y];
    }

    public Cancela getCancela(int x, int y) {
        return itensCancelas[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
}
