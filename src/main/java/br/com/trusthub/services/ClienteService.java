package br.com.trusthub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.trusthub.domain.Cliente;
import br.com.trusthub.domain.enums.Risco;
import br.com.trusthub.dto.ClienteDTO;
import br.com.trusthub.repositories.ClienteRepository;
import br.com.trusthub.services.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente findById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente " + id + " não encontrado"));
	}
	
	public Cliente clienteDTO(ClienteDTO dto) {
		return new Cliente(dto.getNome(), dto.getLimiteCredito(), Risco.valueOf(dto.getRisco()));
	}
	
	public Cliente insert(Cliente cliente) {
		return repo.save(cliente);
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
	public Cliente update(Cliente obj) {
		this.findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		this.findById(id);
		repo.deleteById(id);
	}
}
