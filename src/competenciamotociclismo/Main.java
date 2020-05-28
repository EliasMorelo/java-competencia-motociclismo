package competenciamotociclismo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    static ArrayList<Participante> participante = new ArrayList();
    //Método para mostrar el total de participantes

    public static void total() {
        int total = participante.size();
        JOptionPane.showMessageDialog(null, "El total de participantes es: " + total);
    }
    //Método para mostar el total de participantes por categoria

    public static void totalCategorias() {
        int p = 0, s = 0, t = 0, c = 0, q = 0;

        for (int i = 0; i < participante.size(); i++) {
            if (participante.get(i).getCategoria().equals("Primera")) {
                p += 1;
            } else if (participante.get(i).getCategoria().equals("Segunda")) {
                s += 1;
            } else if (participante.get(i).getCategoria().equals("Tercera")) {
                t += 1;
            } else if (participante.get(i).getCategoria().equals("Cuarta")) {
                c += 1;
            } else {
                q += 1;
            }
        }
        JOptionPane.showMessageDialog(null,
                "Categoria Primera: " + p
                + "\n Categoria Segunda: " + s
                + "\n Categoria Tercera: " + t
                + "\n Categoria Cuarta: " + c
                + "\n Categoria Quinta: " + q);
    }

    public static void main(String[] args) {
        String op = "";
        int opcion = 0;
        do {
            op = JOptionPane.showInputDialog("¿Qué desea hacer?\n\n1. Inscribir participante"
                    + "\n2. Ver cantidad de participantes por categoria"
                    + "\n3. Ver total de participantes aceptados"
                    + "\n4. Salir");

            opcion = Integer.parseInt(op);
            switch (opcion) {
                case 1:
                    Participante part = new Participante();
                    String nombre = JOptionPane.showInputDialog("Ingrese los nombres del participante");
                    part.setNombre(nombre);
                    int iden = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la identificacion"));
                    part.setId(iden);
                    String categ = JOptionPane.showInputDialog("Ingrese la categoria\n\n"
                            + "1. Primera: motos hasta 100cc"
                            + "\n2. Segunda: motos de 101cc hasta 250cc"
                            + "\n3. Tercera: motos de 251cc hasta 350cc"
                            + "\n4. Cuarta: motos de 351cc hasta 500cc"
                            + "\n5. Quinta: motos de más de 500cc");
                    part.setCategoria(categ);
                    int cc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje"));
                    part.setCilindraje(cc);
                    if (part.vallidarCategoria(part)) {
                        participante.add(part);
                        part.mostarDatos(part);
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR!\n La categoria no coincide con el cilindraje de su moto, intentelo de nuevo");
                    }
                    break;
                case 2:
                    Main.totalCategorias();
                    break;
                case 3:
                     Main.total();
                    break;
            }
        } while (opcion <= 3);

    }

}
