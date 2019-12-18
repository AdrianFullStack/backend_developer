package com.adrianfullstack.erp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adrianfullstack.erp.models.Client;
import com.adrianfullstack.erp.repositories.ClientRepository;

@Service
@Transactional(readOnly = true)
public class ClienteService {
	private final ClientRepository clientRepository;

	public ClienteService(ClientRepository clientRepository)
	{
		this.clientRepository = clientRepository;
	}
	
	@Transactional
	public Client createOrUpdate(Client client)
	{
		return this.clientRepository.save(client);
	}
	
	public List<Client> findAll()
	{
		return this.clientRepository.findAll();
	}
}
