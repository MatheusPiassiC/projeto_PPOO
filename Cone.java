/**
 * Representa um cone de sinalização no mapa da simulação.
 */
public class Cone extends Item {

    /**
     * Cria um cone na localização especificada.
     * 
     * @param localizacao Localização do cone no mapa.
     */
    public Cone(Localizacao localizacao) {
        super(localizacao, "Imagens/cone.png");
    }
}
