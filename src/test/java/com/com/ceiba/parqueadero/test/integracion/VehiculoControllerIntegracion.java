package com.com.ceiba.parqueadero.test.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import static org.hamcrest.Matchers.equalTo;
import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class VehiculoControllerIntegracion {
	
	private static final String PLACA = "BBC312";
	private static final int ID_VEHICULO = 1;
	private static final int CILINDRAJE = 120;
	private static final int ID_TIPO_VEHICULO=1;
	public static final  String NOMBRE="CARRO";
	
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void listarVehiculos() throws Exception {
		mvc.perform(get("/vehiculo/listado-vehiculos").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void consultarPorPlaca()throws Exception{
		mvc.perform(get("/vehiculo/"+PLACA).contentType(MediaType.APPLICATION_JSON))
		                                      .andExpect(jsonPath("$.idVehiculo",equalTo(ID_VEHICULO)))
		                                      .andExpect(jsonPath("$.placa",equalTo(PLACA)))
		                                      .andExpect(jsonPath("$.cilindraje",equalTo(CILINDRAJE)))
		                                      .andExpect(jsonPath("$.tipoVehiculo.idTipoVehiculo",equalTo(ID_TIPO_VEHICULO)))
		                                      .andExpect(jsonPath("$.tipoVehiculo.nombre",equalTo(NOMBRE)))
		                                      .andExpect(status().isOk());
		
	}
	
	@Test
	public void registrarVehiculos() throws Exception {
		
		 Vehiculo vehiculo = new VehiculoTestBuilder().build();
		 mvc.perform(post("/vehiculo").content(AbstractRestControllerTest.asJsonString(vehiculo))
				                       .contentType(MediaType.APPLICATION_JSON))
				                       .andExpect(status().isCreated());

	}
	
	

	

}
