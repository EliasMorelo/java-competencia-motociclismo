package competenciamotociclismo;

import javax.swing.JOptionPane;

public class Participante {

    private String nombre, categoria;
    private int id, cilindraje;

    Participante() {
        nombre = "";
        categoria = "";
        id = 0;
        cilindraje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    //Método para validar la categoria del participante por medio de su cilindraje

    public boolean vallidarCategoria(Participante part) {
        boolean band = false;
        String categoria;
        if (part.cilindraje <= 100) {
            categoria = "Primera";
        } else if (part.getCilindraje() >= 101 && part.getCilindraje() <= 250) {
            categoria = "Segunda";
        } else if (part.getCilindraje() >= 251 && part.getCilindraje() <= 350) {
            categoria = "Tercera";
        } else if (part.getCilindraje() >= 351 && part.getCilindraje() <= 500) {
            categoria = "Cuarta";
        } else {
            categoria = "Quinta";
        }

        if (categoria.equals(part.getCategoria())) {
            band = true;
        }
        return band;
    }
    //Método para mostrar los datos del participante una vez validad su categoria

    public void mostarDatos(Participante part) {

        JOptionPane.showMessageDialog(null, "Participante inscrito con éxito"
                + "\nIdenticacion: " + part.getId()
                + "\nNombres: " + part.getNombre());
    }

}
