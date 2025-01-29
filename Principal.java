/**
 * Classe principal para executar a simulação.
 * Contém o método {@link main} que inicia o processo de simulação.
 * 
 * @author Luiz Merschmann
 */
public class Principal {

    /**
     * Método principal que executa a simulação.
     * 
     * @param args Argumentos de linha de comando (não utilizados neste caso).
     */
    public static void main(String[] args) { 
        // Cria uma instância da classe Simulacao
        Simulacao sim = new Simulacao();
        
        // Executa a simulação com o valor 200
        sim.executarSimulacao(200);
    }
}
