package mz.gov.misau.mpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import mz.gov.misau.mpc.model.Acesso;

import mz.gov.misau.mpc.service.AcessoService;

@Controller
public class AcessoController {

	@Autowired
	private AcessoService acessoService;

	@PostMapping("/salvarAcesso")
	public Acesso salvaAcesso(Acesso acesso) {
		return acessoService.save(acesso);
	}

}
