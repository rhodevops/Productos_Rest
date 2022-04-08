package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.documentos.Producto;
import com.example.demo.interfaces.IProductoService;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public void registrar_producto(Producto producto) {
		productoRepository.save(producto);
		
	}

	@Override
	public List<Producto> listar_productos() {
		return productoRepository.findAll();
	}

	@Override
	public Optional<Producto> buscar_producto_by_id(int id) {
		return productoRepository.findById(id);
	}

	@Override
	public void eliminar_producto_by_id(int id) {
		productoRepository.deleteById(id);
		
	}


}
