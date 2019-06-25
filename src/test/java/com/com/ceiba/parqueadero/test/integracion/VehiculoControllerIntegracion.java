package com.com.ceiba.parqueadero.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.com.ceiba.parqueadero.test.databuilder.VehiculoTestBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.com.ceiba.parqueadero.domain.model.Parqueadero;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Parqueadero.class)
@AutoConfigureMockMvc
public class VehiculoControllerIntegracion {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void listarVehiculos() throws Exception {
		mvc.perform(get("/vehiculo//listado-vehiculos").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());

	}

	@Test
	public void registrarVehiculos() throws Exception {
		Vehiculo vehiculo = new VehiculoTestBuilder().build();
		mvc.perform(post("/vehiculo").content(asJsonString(vehiculo)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());

	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
