package com.bodega.rapida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bodega.rapida.entity.Respuesta;
import com.bodega.rapida.entity.Usuario;
import com.bodega.rapida.http.MessageCode;
import com.bodega.rapida.http.ResponseAjax;
import com.bodega.rapida.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioServiceImpl usuarioService;

	@PostMapping
	@ResponseBody
	public ResponseAjax<String> save( @RequestBody Usuario usuario ){
		
		ResponseAjax<String> result = new ResponseAjax<>();
		
		try {
			
			Usuario find_usuario = usuarioService.findByCelular(usuario.getCelular());
			
			if( find_usuario == null ) {
				usuarioService.save(usuario);
				result.setParametersResponse( MessageCode.SAVE_SUCCESS, true);
			} else {
				result.setParametersResponse("El celular del usuario ingresado ya existe, no se pudo registrar.", false);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: " +e.getMessage(), false);
		}
		return result;
	}
	
	
	@GetMapping("/login")
	@ResponseBody
	public ResponseAjax<Usuario> findByCelular( 
			@RequestParam("celular") String celular,
			@RequestParam("clave") String clave ){
		
		ResponseAjax<Usuario> result=new ResponseAjax<Usuario>();
		
		try {
			
			Usuario find_user = usuarioService.existUser(celular, clave);
			
			result.setObject(find_user);
			result.setParametersResponse("", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setParametersResponse("Error: "+e.getMessage(), false);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
