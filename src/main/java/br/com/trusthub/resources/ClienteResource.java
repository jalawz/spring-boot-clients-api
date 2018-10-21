package br.com.trusthub.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.trusthub.domain.Cliente;
import br.com.trusthub.domain.enums.Risco;
import br.com.trusthub.dto.ClienteDTO;
import br.com.trusthub.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteDTO dto) {
		Cliente cliente = service.clienteDTO(dto);
		cliente = service.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = service.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ClienteDTO dto, @PathVariable Integer id) {
		Cliente cliente = new Cliente(dto.getNome(), dto.getLimiteCredito(), Risco.valueOf(dto.getRisco()));
		cliente.setId(id);
		service.update(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
