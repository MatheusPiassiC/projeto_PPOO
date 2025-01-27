import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Item {
    protected Localizacao localizacao;
    protected Image imagem;

    public Item(Localizacao localizacao, String caminhoImagem) {
        this.localizacao = localizacao;
        this.imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }

    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    public void setLocalizacaoAtual(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Image getImagem() {
        return imagem;
    }

    public abstract void executarAcao();
}