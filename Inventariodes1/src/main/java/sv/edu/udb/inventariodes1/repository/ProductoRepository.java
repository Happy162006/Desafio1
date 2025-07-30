package sv.edu.udb.inventariodes1.repository;


import sv.edu.udb.inventariodes1.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ProductoRepository {

    private final List<Producto> productos = new CopyOnWriteArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> obtenerTodos() {
        return new ArrayList<>(productos);
    }

    public Producto buscarPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
}
