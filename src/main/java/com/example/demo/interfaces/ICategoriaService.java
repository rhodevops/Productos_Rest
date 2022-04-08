package com.example.demo.interfaces;

import java.util.ArrayList;

import com.example.demo.model.Categoria;

public interface ICategoriaService {
	
	// contiene los métodos del DAO (del ActividadRepository)
	// nombres : los que quiera
	
	public void registrar_categoria(Categoria categoria);
	public Categoria buscar_categoria_by_id(int id);
	public void modificar_categoria(Categoria categoria);
	public void eliminar_categoria_by_id(int id);
	public ArrayList<Categoria> listar_categorias();

}
