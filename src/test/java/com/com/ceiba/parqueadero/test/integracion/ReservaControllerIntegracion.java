package com.com.ceiba.parqueadero.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class ReservaControllerIntegracion {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void listarFacturas() throws Exception {
		mvc.perform(
				get("/reserva/listar-reservas").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void listarFacturasPendientes() throws Exception {
		mvc.perform(get("/reserva/listar-reservas-pendientes").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
	}

}
