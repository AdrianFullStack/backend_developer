package com.adrianfullstack.erp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrianfullstack.erp.models.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
		
}
