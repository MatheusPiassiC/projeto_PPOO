import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Representa um item genérico no mapa da simulação.
 */
public abstract class Item { 
    protected Localizacao localizacao;
    protected Image imagem;

    /**
     * Cria um item na localização especificada com a imagem correspondente.
     * 
     * @param localizacao Localização inicial do item.
     * @param caminhoImagem Caminho do arquivo de imagem do item.
     */
    public Item(Localizacao localizacao, String caminhoImagem) {
        this.localizacao = localizacao;
        this.imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }

    /**
     * Retorna a localização atual do item.
     * 
     * @return Localização do item.
     */
    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    /**
     * Define uma nova localização para o item.
     * 
     * @param localizacao Nova localização do item.
     */
    public void setLocalizacaoAtual(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    /**
     * Retorna a imagem do item.
     * 
     * @return Imagem do item.
     */
    public Image getImagem() {
        return imagem;
    }
}
