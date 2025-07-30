package sv.edu.udb.inventariodes1.controller;


import sv.edu.udb.inventariodes1.model.Producto;
import sv.edu.udb.inventariodes1.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        String resultado = service.registrar(producto);
        if (resultado.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(service.listarProductos());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> obtenerPorNombre(@PathVariable String nombre) {
        Producto producto = service.buscarProducto(nombre);
        if (producto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró el producto con nombre: " + nombre);
        }
        return ResponseEntity.ok(producto);
    }


}
