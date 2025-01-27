
class CancelaPresencial extends Cancela {

    public CancelaPresencial(Localizacao localizacaoCabine) {
        super(localizacaoCabine, 5); // Tempo de espera maior
    }
}
