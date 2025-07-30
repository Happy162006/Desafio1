package controller;


import sv.edu.udb.inventariodes1.controller.ProductoController;
import sv.edu.udb.inventariodes1.model.Producto;
import sv.edu.udb.inventariodes1.service.ProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductoControllerTest {

    @Test
    public void testRegistrarProducto() {
        ProductoService service = mock(ProductoService.class);
        ProductoController controller = new ProductoController(service);
        Producto producto = new Producto("Teleee", 32320.99, 2);

        when(service.registrar(producto)).thenReturn("Producto registrado exitosamente.");

        ResponseEntity<String> response = controller.crearProducto(producto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Producto registrado exitosamente.", response.getBody());
    }
}

