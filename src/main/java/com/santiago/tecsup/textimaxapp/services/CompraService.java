package com.santiago.tecsup.textimaxapp.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.tecsup.textimaxapp.models.Compra;
import com.santiago.tecsup.textimaxapp.repositories.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	public List<Compra> listar(){
		return compraRepository.listar();
	}
	
	public void eliminar(Integer id) {
		compraRepository.eliminar(id);
	}
	
	public Compra obtener(Integer id ) {
		return compraRepository.obtener(id);
	}
	
	public void actualizar(Integer id) {
		compraRepository.actualizar(id);
	}
	
	
}

