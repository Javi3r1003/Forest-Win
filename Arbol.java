import java.io.Serializable;

public class Arbol implements Serializable {
    //Atributos
    String Especie;
    float PrMax;
    float PrMin;
    String Iluminacion;
    float TempMax;
    float TempMin;
    String Utilidades;
    //**********************************************************************

    //Constructor Arbol
    public Arbol(String especie, float prMax, float prMin, String iluminacion, float tempMax, float tempMin, String utilidades){
        this.Especie = especie;
        this.PrMax = prMax;
        this.PrMin = prMin;
        this.Iluminacion = iluminacion;
        this.TempMax = tempMax;
        this.TempMin = tempMin;
        this.Utilidades = utilidades;
    }


    //Getters de los atributos de un Arbol
    public String getEspecie() {
        return Especie;
    }
    public float getPrMax() {
        return PrMax;
    }
    public float getPrMin() {
        return PrMin;
    }
    public String getIluminacion() {
        return Iluminacion;
    }
    public float getTempMax() {
        return TempMax;
    }
    public float getTempMin() {
        return TempMin;
    }
    public String getUtilidades() {
        return Utilidades;
    }


    //Setters de los atributos de un Arbol
    public void setEspecie(String especie) {
        Especie = especie;
    }
    public void setPrMax(float prMax) {
        PrMax = prMax;
    }
    public void setPrMin(float prMin) {
        PrMin = prMin;
    }
    public void setIluminacion(String iluminacion) {
        Iluminacion = iluminacion;
    }
    public void setTempMax(float tempMax) {
        TempMax = tempMax;
    }
    public void setTempMin(float tempMin) {
        TempMin = tempMin;
    }
    public void setUtilidades(String utilidades) {
        Utilidades = utilidades;
    }


}
