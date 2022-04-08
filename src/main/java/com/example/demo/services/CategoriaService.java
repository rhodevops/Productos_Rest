package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.ICategoriaService;
import com.example.demo.model.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService {
	
	@Autowired 
	CategoriaRepository categoriaRepository;

	@Override
	public void registrar_categoria(Categoria categoria) {
		categoriaRepository.save(categoria);

	}

	@Override
	public Categoria buscar_categoria_by_id(int id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@Override
	public void modificar_categoria(Categoria categoria) {
		categoriaRepository.save(categoria);

	}

	@Override
	public void eliminar_categoria_by_id(int id) {
		categoriaRepository.deleteById(id);

	}

	@Override
	public ArrayList<Categoria> listar_categorias() {
		return (ArrayList<Categoria>) categoriaRepository.findAll();
	}

}
