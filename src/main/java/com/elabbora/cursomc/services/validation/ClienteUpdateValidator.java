package com.elabbora.cursomc.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.elabbora.cursomc.domain.Cliente;
import com.elabbora.cursomc.dto.ClienteDTO;
import com.elabbora.cursomc.repositories.ClienteRepository;
import com.elabbora.cursomc.resourcers.exception.FieldMessage;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

	//Serve para conseguirmos pegar o ID que está sendo passado com a URI
	@Autowired
	private HttpServletRequest request;
	
	
	@Autowired
	private ClienteRepository repo;

	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
		
		//Muito interessante, é a forma de pegar um atributo passado via URI
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer urlId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();		
		
		//Testa para ver se não está tentando alterar o email para o de algum outro cliente que já existe
		Cliente aux = repo.findByEmail(objDto.getEmail());		
		
		System.out.println("aux.getId() : " + aux.getId() + " URLId : " + urlId);
		if (aux != null && !aux.getId().equals(urlId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		} 
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation(); 
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
