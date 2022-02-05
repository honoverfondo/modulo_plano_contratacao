package mz.gov.misau.mpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mz.gov.misau.mpc.model.Acesso;
import mz.gov.misau.mpc.repository.AcessoRepository;
import mz.gov.misau.mpc.service.AcessoService;

@Controller
@RestController
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@Autowired
	private AcessoRepository acessoRepository;

	@ResponseBody /* PODER DAR UM RETORNO DA API */
	@PostMapping(value = "**/salvarAcesso") /* MAPEANDO A url PARA RECEBER JSON */
	public ResponseEntity<Acesso> salvaAcesso(@RequestBody Acesso acesso) {
		
		Acesso acessoSalvo = acessoService.save(acesso);
		
		return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
	}

	@ResponseBody /* PODER DAR UM RETORNO DA API */
	@PostMapping(value = "**/deleteAcesso") /* MAPEANDO A url PARA RECEBER JSON */
	public ResponseEntity<?> deleteAcesso(@RequestBody Acesso acesso) {
		
		acessoRepository.deleteById(acesso.getId());
		
		return new ResponseEntity("Acesso Removido",HttpStatus.OK);
	}
}
