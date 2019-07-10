package com.santiago.tecsup.textimaxapp.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.tecsup.textimaxapp.HelloController;
import com.santiago.tecsup.textimaxapp.models.Compra;
import com.santiago.tecsup.textimaxapp.models.ResponseMessage;
import com.santiago.tecsup.textimaxapp.services.CompraService;

@RestController
public class CompraController {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private CompraService compraService;
	
	@GetMapping("/compras")
	public List<Compra> compras() {
		logger.info("call compras"); 
		List<Compra>compras=compraService.listar();
		
		return compras;
	}
	
	@DeleteMapping("/compras/{id}/")
	public ResponseMessage eliminar(@PathVariable Integer id) {
		logger.info("call eliminar: " + id);
		
		compraService.eliminar(id);
		
		return ResponseMessage.success("Registro eliminado");
	}
	
	@GetMapping("/compras/{id}/")
	
	public Compra obtener (@PathVariable Integer id) {
		
		logger.info("call obtener:" + id);
		Compra compra = compraService.obtener(id);
		return compra;
	}
	
	
	@PutMapping("/compras/{id}/")
	
	public ResponseMessage actualizar(@PathVariable Integer id ) {
		
		logger.info("call actualizar:" + id);
		compraService.actualizar(id);
		return ResponseMessage.success("Registro actualizado");
	
	}

}

