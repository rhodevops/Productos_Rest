package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.documentos.Producto;

public interface IProductoService {
	
	// contiene los métodos del DAO (del ActividadRepository)
	// nombres : los que quiera
	
	public void registrar_producto(Producto producto);
	public List<Producto> listar_productos();
	
	public Optional<Producto> buscar_producto_by_id(int id);
	public void eliminar_producto_by_id(int id);

}
