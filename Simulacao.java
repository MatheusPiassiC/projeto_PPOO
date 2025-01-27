import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Responsavel pela simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private Veiculo veiculo;
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    private Cancela cancelas; // Lista de cancelas
    
    public Simulacao() {
        Random rand = new Random(12345);
        mapa = new Mapa();
        int largura = mapa.getLargura();
        int altura = mapa.getAltura();
        //veiculo = new Veiculo(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Cria um veiculo em uma posicao aleatoria
        veiculo = new Veiculo(new Localizacao(0,0));
        //veiculo.setLocalizacaoDestino(new Localizacao(rand.nextInt(largura),rand.nextInt(altura)));//Define a posicao destino aleatoriamente
        veiculo.setLocalizacaoDestino(new Localizacao(34,34)); //Vai de um canto ao outro da janela
        mapa.adicionarItem(veiculo);//Inicializando o mapa com o veículo

        // Inicializa as cancelas
        inicializarCancelas();

        janelaSimulacao = new JanelaSimulacao(mapa);//Cria a janela com as informações do mapa
    }

    private void inicializarCancelas() {
        
        // Coordenadas iniciais para as cancelas
        int xBase = 8; // Base horizontal para posicionamento das cancelas
        int yBase = 5; // Posição vertical fixa
        
        // Cria 3 cancelas automáticas
        for (int i = 0; i < 3; i++) {
            CancelaAutomatica cancela = new CancelaAutomatica(new Localizacao(xBase + i * 3, yBase));
            mapa.adicionarCancela(cancela);
        }

        // Cria 3 cancelas presenciais
        for (int i = 3; i < 6; i++) {
            CancelaPresencial cancela = new CancelaPresencial(new Localizacao(xBase + i * 3, yBase));
            mapa.adicionarCancela(cancela);
        }
    }
    
    public void executarSimulacao(int numPassos){
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(300); //Define a velocidade da animação
        }        
    }

    private void executarUmPasso() {
        mapa.removerItem(veiculo); //apaga o eiculo
        veiculo.executarAcao(); //anda uma posição
        mapa.adicionarItem(veiculo); //adiciona o veículo em sua nova posição
        janelaSimulacao.executarAcao(); //atualiza a janela
    }
    
    private void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
}
