package com.shopshopista.productoss.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Linis
 */
@Entity
@Table(name = "\"ProductosCategorias\"")
public class ProductosCategorias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto_categoria", nullable = false)
    private Long id_producto_categoria;
    
    @JoinColumn(name = "id_producto")
    @JsonBackReference(value="rf_producto")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Productos id_producto;

    @JoinColumn(name = "id_categoria")
    @JsonBackReference(value="rf_categoria")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Categorias id_categoria;

    @Column(name = "prca_activo", columnDefinition = "BOOLEAN DEFAULT 'true'")
    private boolean prca_activo;

    public Long getId_producto_categoria() {
        return id_producto_categoria;
    }

    public void setId_producto_categoria(Long id_producto_categoria) {
        this.id_producto_categoria = id_producto_categoria;
    }

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

    public Categorias getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categorias id_categoria) {
        this.id_categoria = id_categoria;
    }

    public boolean isPrca_activo() {
        return prca_activo;
    }

    public void setPrca_activo(boolean prca_activo) {
        this.prca_activo = prca_activo;
    }

    @Override
    public String toString() {
        return "ProductosCategorias{"
                + "id_producto_categoria="
                + id_producto_categoria + ", id_producto="
                + id_producto
                + ", id_categoria="
                + id_categoria
                + ", prca_activo="
                + prca_activo + '}';
    }

}
