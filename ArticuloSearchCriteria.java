package es.unirioja.paw.controller;

public class ArticuloSearchCriteria {

    private String tipo;

    private String fabricante;

    private String precio;

    private String filtroBusquedaGeneral;
    
    // TODO: dónde implementar la construcción del where para la consulta en BD?

    /**
     * @return Tipo de artículo
     */
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return Fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return Rango de precios (String que viene del filtro)
     */
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * @return Código o nombre del artículo (viene de la búsqueda general)
     */
    public String getFiltroBusquedaGeneral() {
        return filtroBusquedaGeneral;
    }

    public void setFiltroBusquedaGeneral(String filtroBusquedaGeneral) {
        this.filtroBusquedaGeneral = filtroBusquedaGeneral;
    }

}
