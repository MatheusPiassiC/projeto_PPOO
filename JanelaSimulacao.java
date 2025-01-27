import java.awt.*;
import javax.swing.*;

/**
 * Fornece a visualizacao da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class JanelaSimulacao extends JFrame{
    private Mapa mapa;
    private VisaoMapa visaoMapa;
    
    public JanelaSimulacao(Mapa mapa){
        this.mapa = mapa;
        visaoMapa = new VisaoMapa(mapa.getLargura(),mapa.getAltura());
        getContentPane().add(visaoMapa);
        setTitle("Simulator");
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    /**
     * Mostra o estado atual do mapa.
     */
    public void executarAcao(){
        //Atualiza a janela. Passa por todos os espaços, e caso exista um objeto, o imprime na tela
        visaoMapa.preparePaint();
        for(int i = 0; i < mapa.getAltura(); i++){
            for(int j = 0; j < mapa.getLargura(); j++){
                if(mapa.getItem(i, j) != null){//Se existir algum objeto na posicao (i,j)
                    Veiculo veiculo = mapa.getItem(i, j);//Cria um onjeto Veiculos que é igual ao que está nesta posição do mapa
                    Localizacao localizacao = veiculo.getLocalizacaoAtual();//Pega a localização do veiculo
                    visaoMapa.desenharImagem(localizacao.getX(), localizacao.getY(), veiculo.getImagem());//Imprime o veiculo na posição que ele foi
                }
            }
        }
        for (int i = 0; i < mapa.getAltura(); i++) {
            for (int j = 0; j < mapa.getLargura(); j++) {
                if (mapa.getCancela(i, j) != null) { // Se existir uma cancela na posição (i, j)
                    Cancela cancela = mapa.getCancela(i, j); // Cria um objeto Cancela que é igual ao que está nesta posição do mapa
                    Localizacao localizacaoCabine = cancela.getLocalizacaoCabine(); // Pega a localização da cancela
                    visaoMapa.desenharImagem(localizacaoCabine.getX(), localizacaoCabine.getY(), cancela.getImagem()); // Imprime a cancela na posição que ela foi
                    
                    // Desenha os cones associados à cancela
                    for (Localizacao localizacaoCone : cancela.getCones()) {
                        visaoMapa.desenharImagem(localizacaoCone.getX(), localizacaoCone.getY(), cancela.getImagemCones()); // Imprime o cone na posição que ele foi
                    }
                }
            }
        }

        visaoMapa.repaint();
    }

    /**
     * Fornece uma visualizacao grafica do mapa. Esta eh 
     * uma classe interna que define os componentes da GUI.
     * Ela contém alguns detalhes mais avancados sobre GUI 
     * que voce pode ignorar para realizacao do seu trabalho.
     */    
    private class VisaoMapa extends JPanel{

        private final int VIEW_SCALING_FACTOR = 6;


        private int larguraMapa, alturaMapa;
        private int xScale, yScale;
        private Dimension tamanho;
        private Graphics g;
        private Image imagemMapa;

        /**
         * Cria um novo componente VisaoMapa.
         */
        public VisaoMapa(int largura, int altura)
        {
            larguraMapa = largura;
            alturaMapa = altura;
            setBackground(Color.white);
            tamanho = new Dimension(0, 0);
        }

        /**
         * Informa para o gerenciador GUI o tamanho.
         */
        public Dimension getPreferredSize()
        {
            return new Dimension(larguraMapa * VIEW_SCALING_FACTOR,
                                 alturaMapa * VIEW_SCALING_FACTOR);
        }
        
        /**
         * Prepara para um novo ciclo de exibicao. Uma vez que o componente
         * pode ser redimensionado, calcula o "fator de escala" novamente.
         */
        public void preparePaint()
        {
            if(!tamanho.equals(getSize())) {  // se o tamanho mudou...
                tamanho = getSize();
                imagemMapa = visaoMapa.createImage(tamanho.width, tamanho.height);
                g = imagemMapa.getGraphics();

                xScale = tamanho.width / larguraMapa;
                if(xScale < 1) {
                    xScale = VIEW_SCALING_FACTOR;
                }
                yScale = tamanho.height / alturaMapa;
                if(yScale < 1) {
                    yScale = VIEW_SCALING_FACTOR;
                }
            }
            g.setColor(Color.white);
            g.fillRect(0, 0, tamanho.width, tamanho.height);
            g.setColor(Color.gray);
            for(int i = 0, x = 0; x < tamanho.width; i++, x = i * xScale) {
                g.drawLine(x, 0, x, tamanho.height - 1);
            }
            for(int i = 0, y = 0; y < tamanho.height; i++, y = i * yScale) {
                g.drawLine(0, y, tamanho.width - 1, y);
            }
        }
        
        /**
         * Desenha a imagem para um determinado item.
         */
        public void desenharImagem(int x, int y, Image image)
        {
            g.drawImage(image, x * xScale + 1, y * yScale + 1,
                        xScale - 1, yScale - 1, this);
        }

        /**
         * O componente VisaoMapa precisa ser reexibido. Copia a
         * imagem interna para a tela.
         */
        public void paintComponent(Graphics g)
        {
            if(imagemMapa != null) {
                g.drawImage(imagemMapa, 0, 0, null);
            }
        }
    }
    
}
