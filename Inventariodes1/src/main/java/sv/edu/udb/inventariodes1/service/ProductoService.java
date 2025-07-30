package sv.edu.udb.inventariodes1.service;


import sv.edu.udb.inventariodes1.model.Producto;
import sv.edu.udb.inventariodes1.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public String registrar(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            return "Error: nombre es obligatorio";
        }
        if (producto.getPrecio() < 0 || producto.getCantidad() < 0) {
            return "Error: precio y cantidad deben ser positivos";
        }
        Producto existente = repository.buscarPorNombre(producto.getNombre());
        if (existente != null) {
            return "Error: producto ya registrado";
        }
        repository.agregarProducto(producto);
        return "Producto registrado con éxito";
    }

    public List<Producto> listarProductos() {
        return repository.obtenerTodos();
    }

    public Producto buscarProducto(String nombre) {
        return repository.buscarPorNombre(nombre);
    }


}

