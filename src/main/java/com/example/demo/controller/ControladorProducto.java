package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.documentos.Producto;
import com.example.demo.interfaces.IProductoService;

@RequestMapping("/productos") 
@RestController
public class ControladorProducto {
	
	@Autowired
	IProductoService productoservice;
	
	@PostMapping("/add")
	public int add(@RequestBody Producto producto) {
		productoservice.registrar_producto(producto);
		return 0;
	}
	
	@GetMapping("/list_all")
	public List<Producto> list_all() {
		
		return productoservice.listar_productos();
	}
	
	@DeleteMapping("/delete_by_id/{id}")
	public int delete_by_id(@PathVariable("id") int id) {
		productoservice.eliminar_producto_by_id(id);
		return 0;
	}
	
	@GetMapping("/find_by_id/{id}")
	public Optional<Producto> find_by_id(@PathVariable("id") int id) {
		return productoservice.buscar_producto_by_id(id);
	}

}
