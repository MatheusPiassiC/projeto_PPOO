import java.util.ArrayList;
import java.util.Random;
/**
 * Responsavel pela simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Pedagio> pedagios;
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    
    public Simulacao() {
        Random rand = new Random(12345);
        mapa = new Mapa();
        int largura = mapa.getLargura();
        int altura = mapa.getAltura();
        veiculos = new ArrayList<Veiculo>();
        pedagios = new ArrayList<Pedagio>();

        // Inicializa veículos
        for (int i = 0; i < 10; i++) {
            Veiculo veiculo = new Veiculo(new Localizacao(rand.nextInt(largura), rand.nextInt(altura)));
            veiculo.setLocalizacaoDestino(new Localizacao(34, 34));
            veiculos.add(veiculo);
            mapa.adicionarItem(veiculo);
        }

        // Inicializa pedágios
        for (int i = 0; i < 6; i++) {
            Pedagio pedagio = new Pedagio(new Localizacao(10+3*i, 10));
            pedagios.add(pedagio);
            // Adicionar pedágio ao mapa em uma posição específica
            mapa.adicionarItem(pedagio); // Supondo que o mapa possa adicionar pedágios
        }

        janelaSimulacao = new JanelaSimulacao(mapa);
    }
    
    public void executarSimulacao(int numPassos){
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(1000); //Define a velocidade da animação
        }        
    }

    private void executarUmPasso() {
        /* 
        for (Veiculo veiculo : veiculos){
            mapa.removerItem(veiculo); //apaga o veiculo
            veiculo.executarAcao(); //anda uma posição
            mapa.adicionarItem(veiculo); //adiciona o veículo em sua nova posição
        }
        */

        Veiculo v;
        for (Pedagio pedagio: pedagios){
            int x = pedagio.getLocalizacaoAtual().getX();
            int y = pedagio.getLocalizacaoAtual().getY();
            v = new Veiculo(new Localizacao(x+1, y+7));
            v.setLocalizacaoDestino(new Localizacao(x+1, y));
            pedagio.adicionarCarro(v);
            
            for(Veiculo vQueue: pedagio.getFilaCarros()){
                mapa.removerItem(vQueue);
                vQueue.executarAcao();
                mapa.adicionarItem(vQueue);
            }
            mapa.adicionarItem(v);
        }

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
