package com.com.ceiba.parqueadero.test.integracion;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
import com.com.ceiba.parqueadero.test.databuilder.ReservaTestBuilder;
import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;
import co.com.ceiba.parqueadero.domain.model.Reserva;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class ReservaControllerIntegracion {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	private Reserva reserva;
	private static final int REALIZAR_SALIDA_RESERVA = 1;


	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		ReservaTestBuilder reservaTestBuilder=new ReservaTestBuilder();
		reserva=reservaTestBuilder.build();
	
	}

	@Test
	public void listarReservas() throws Exception {
		mvc.perform(
				get("/reserva/listar-reservas").contentType(MediaType.APPLICATION_JSON))
				                               .andExpect(status().isOk());
	}

	@Test
	public void listarReservasPendientes() throws Exception {
		mvc.perform(get("/reserva/listar-reservas-pendientes").contentType(MediaType.APPLICATION_JSON))
		                                                      .andExpect(status().isOk());
	}
	
	
	@Test
	public void registrarEntrada() throws Exception {
		mvc.perform(post("/reserva").content(AbstractRestControllerTest.asJsonString(reserva))
				                     .characterEncoding("utf-8")
				                     .contentType(MediaType.APPLICATION_JSON))
		                             .andExpect(jsonPath("$.idReserva").value(reserva.getIdReserva()))
		                             .andExpect(jsonPath("$.fechaRetiro").value(reserva.getFechaRetiro()))
		                             .andExpect(jsonPath("$.valorTotal").value(reserva.getValorTotal()))
		                             .andExpect(jsonPath("$.vehiculo.idVehiculo").value(reserva.getVehiculo().getIdVehiculo()))
		                             .andExpect(jsonPath("$.vehiculo.placa").value(reserva.getVehiculo().getPlaca()))
		                             .andExpect(jsonPath("$.vehiculo.cilindraje").value(String.valueOf(reserva.getVehiculo().getCilindraje())))
		                             .andExpect(jsonPath("$.vehiculo.tipoVehiculo.idTipoVehiculo").value(reserva.getVehiculo().getTipoVehiculo().getIdTipoVehiculo()))
		                             .andExpect(jsonPath("$.vehiculo.tipoVehiculo.nombre").value("CARRO"))
		                             .andExpect(jsonPath("$.puesto.idPuesto").value(reserva.getPuesto().getIdPuesto()))
		                             .andExpect(jsonPath("$.puesto.estado").value(reserva.getPuesto().isEstado()))
		                             .andExpect(jsonPath("$.puesto.tipoPuestoVehiculo").value(reserva.getPuesto().getTipoPuestoVehiculo()))
		                             .andExpect(status().isCreated());
		                            
	}
	
	@Test 
	public void registrarSalida()throws Exception{
		
		mvc.perform(patch("/reserva/"+REALIZAR_SALIDA_RESERVA).characterEncoding("utf-8")
				                                              .contentType(MediaType.APPLICATION_JSON))
									                          .andExpect(status().isOk());
		
	}
    
   
	
	


}
