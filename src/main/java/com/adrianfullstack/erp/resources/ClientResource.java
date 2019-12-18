/**
 * 
 */
package com.adrianfullstack.erp.resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianfullstack.erp.models.Client;
import com.adrianfullstack.erp.resources.vo.ClientVo;
import com.adrianfullstack.erp.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author AdrianFullStack
 *
 */
@RestController
@RequestMapping("/api/v1/")
@Api(tags = "clients")
public class ClientResource {
	private final ClienteService clienteService;
	
	public ClientResource(ClienteService clienteService)
	{
		this.clienteService = clienteService;
	}
	
	@RequestMapping("listclientes")
	@GetMapping
	@ApiOperation(value = "Listar Clientes", notes = "Servico para listar todos los clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Clientes encontrados ")
	})
	public ResponseEntity<List<ClientVo>> findAll()
	{
		List<Client> datos = this.clienteService.findAll();
		List<ClientVo> data = new ArrayList<ClientVo>();
		datos.forEach(client -> {
			ClientVo client_vo = new ClientVo();
			client_vo.setNameCli(client.getNameCli());
			client_vo.setLastNameCli(client.getLastNameCli());
			client_vo.setAgeCli(client.getAgeCli());
			client_vo.setDateCli(client.getDateCli());
			
			Calendar date = Calendar.getInstance();
		    date.setTime(client.getDateCli());
		    date.add(Calendar.YEAR, 80);			
			client_vo.setDateEndCli(date.getTime());
			data.add(client_vo);
		});
		
		return ResponseEntity.ok(data);
	}
	
	@RequestMapping("kpideclientes")
	@GetMapping
	@ApiOperation(value = "Kpi Clientes", notes = "Servico los kpis de clientes")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Kpis de Clientes ")
	})
	public ResponseEntity<Map<String, Double>> kpi()
	{
		List<Client> datos = this.clienteService.findAll();
		double n = datos.size();
		Integer sum = n > 0 ? datos.stream().reduce(0, (partialAgeResult, client) -> partialAgeResult + client.getAgeCli(), Integer::sum) : 0;
		double prom = sum > 0 ? sum / ( double ) n : 0;
		
		double sum_2 = n > 0 ? datos.stream().reduce(0.0, (partialAgeResult, client) -> partialAgeResult + Math.pow(client.getAgeCli() - prom, 2), Double::sum) : 0;
		double de = sum > 0 ? Math.sqrt( sum_2 / ( double ) n ) : 0;
		
		Map<String, Double> res = new HashMap<String, Double>();
		res.put("promedio", prom);
		res.put("desviacion", de);
		
		return ResponseEntity.ok(res);
	}
	
	@RequestMapping("creacliente")
	@PostMapping
	@ApiOperation(value = "Crear Cliente", notes = "Servico para crear un nuevo cliente")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 500, message = "Error")
	})
	public ResponseEntity<Client> create(@RequestBody  ClientVo clientVo)
	{
		Client cli = new Client();
		cli.setNameCli(clientVo.getNameCli());
		cli.setLastNameCli(clientVo.getLastNameCli());
		cli.setAgeCli(clientVo.getAgeCli());
		cli.setDateCli(clientVo.getDateCli());
		return new ResponseEntity<>(this.clienteService.createOrUpdate(cli), HttpStatus.CREATED);
	}
}
