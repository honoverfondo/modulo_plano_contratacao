package mz.gov.misau.mpc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import mz.gov.misau.mpc.controller.AcessoController;
import mz.gov.misau.mpc.model.Acesso;
import mz.gov.misau.mpc.repository.AcessoRepository;
import mz.gov.misau.mpc.service.AcessoService;

@SpringBootTest(classes = ModuloPlanoContratacaoApplication.class)
public class ModuloPlanoContratacaoApplicationTests {

	
	@Autowired
	private AcessoController  acessoController;
	
	@Test
	public void testCadastrarAcesso() {
		Acesso acesso=new Acesso();
		
		acesso.setDescricao("ROLE_ADMIN");
		
		acessoController.salvaAcesso(acesso);
	}

}
