package models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Personas", schema = "public")
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "nombre", length = 32)
    private String nombre;

    @Column(name = "apellido", length = 32)
    private String apellido;

    @Column(name = "salario")
    private BigDecimal salario;

    public Personas(String nombre, String apellido, BigDecimal salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public Personas() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Personas: " +
                "\nid: " + id +
                "\nnombre: " + nombre +
                "\napellido: " + apellido+
                "\nsalario: " + salario;
    }
}
