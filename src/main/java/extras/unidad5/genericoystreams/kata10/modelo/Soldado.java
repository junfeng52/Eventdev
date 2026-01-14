package extras.unidad5.genericoystreams.kata10.modelo;

public class Soldado {
    private String gamerTag;
    private int bajas;
    private boolean esVip;

    public Soldado(String gamerTag, int bajas, boolean esVip) {
        this.gamerTag = gamerTag;
        this.bajas = bajas;
        this.esVip = esVip;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    public int getBajas() {
        return bajas;
    }

    public void setBajas(int bajas) {
        this.bajas = bajas;
    }

    public boolean isEsVip() {
        return esVip;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }

}
