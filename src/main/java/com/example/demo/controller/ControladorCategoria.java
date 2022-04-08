package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.ICategoriaService;
import com.example.demo.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class ControladorCategoria {
	
	// INICIAR SERVICIO
		@Autowired
		ICategoriaService categoriaservice;
		
		
		@GetMapping("/list_all")
		public ArrayList<Categoria> list_all() {
			return categoriaservice.listar_categorias();
		}

		@PostMapping("/add") 
		public Integer add(@RequestBody Categoria categoria) { // se pasa json libro
			System.out.println(categoria);
			Categoria categoriaaux = categoriaservice.buscar_categoria_by_id(categoria.getId()); 
			if (categoriaaux == null) {
				categoriaservice.registrar_categoria(categoria);
				return 0;
			} else {
				return 1; // si ya existe devuelvo 1
			}

		}

		@GetMapping("/find_by_id/{id}")
		public Categoria find_by_id(@PathVariable("id") int id) { 
			Categoria categoriaaux = categoriaservice.buscar_categoria_by_id(id);
			if (categoriaaux == null) {
				return new Categoria(); // si no exite devuelvr libro vacia
			} else {
				return categoriaaux; 
			}

		}

		@DeleteMapping("/delete_by_id/{id}") 
		public Integer delete_user_by_id(@PathVariable("id") int id) { 
			Categoria categoriaaux = categoriaservice.buscar_categoria_by_id(id);
			if (categoriaaux == null) {
				return 1; // si no existe devuelvo 1
			} else {
				categoriaservice.eliminar_categoria_by_id(id);
				return 0; 
			}

		}


		@PutMapping("/update") 
		public Integer update(@RequestBody Categoria categoria) { // se pasa json libro
			System.out.println(categoria);
			Categoria categoriaaux = categoriaservice.buscar_categoria_by_id(categoria.getId()); 
			if (categoriaaux == null) {
				return 1;
			} else {
				categoriaservice.modificar_categoria(categoria);
				return 0; // si existe devuelvo 0
			}

		}

}
