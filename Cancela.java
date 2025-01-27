import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma Cancela genérica.
 */
abstract class Cancela {
    private Image imagemCabine;
    private Image imagemCones;
    protected Localizacao localizacaoCabine;
    protected List<Localizacao> cones;
    protected List<Localizacao> filaDeCarros;
    protected int tempoEspera;

    public Cancela(Localizacao localizacaoCabine, int tempoEspera) {
        this.localizacaoCabine = localizacaoCabine;
        this.tempoEspera = tempoEspera;
        this.cones = new ArrayList<>();
        this.filaDeCarros = new ArrayList<>();
        criarCones();
        criarFilaDeCarros();
        imagemCabine = new ImageIcon(getClass().getResource("Imagens/cabine.png")).getImage();
        imagemCones = new ImageIcon(getClass().getResource("Imagens/cones.png")).getImage();
    }

    private void criarCones() {
        int xBase = localizacaoCabine.getX() + 2;
        int yBase = localizacaoCabine.getY();
        for (int i = 0; i < 3; i++) {
            cones.add(new Localizacao(xBase, yBase - i));
        }
    }

    private void criarFilaDeCarros() {
        int xBase = localizacaoCabine.getX() + 1;
        int yBase = localizacaoCabine.getY();
        for (int i = 0; i < 3; i++) {
            filaDeCarros.add(new Localizacao(xBase, yBase - i));
        }
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public Localizacao getLocalizacaoCabine() {
        return localizacaoCabine;
    }

    public Image getImagem() {
        return imagemCabine;
    }

    public Image getImagemCones() {
        return imagemCones;
    }

    public List<Localizacao> getCones() {
        return cones;
    }

    public List<Localizacao> getFilaDeCarros() {
        return filaDeCarros;
    }
}
