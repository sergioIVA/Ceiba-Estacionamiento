package com.com.ceiba.parqueadero.test.integracion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.com.ceiba.parqueadero.test.databuilder.PuestoTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.ReservaTestBuilder;

import co.com.ceiba.parqueadero.CeibaEstacionamientoApplication;
import co.com.ceiba.parqueadero.aplication.service.PuestoService;
import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.repositorio.PuestoRepositorio;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CeibaEstacionamientoApplication.class)
@AutoConfigureMockMvc
public class PuestoServiceIntegracion {
	
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	
	@MockBean 
	PuestoRepositorio puestoRepositorio;
	
	
    PuestoService puestoService; 
    

	
   
    
	
	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		this.puestoService=new PuestoService(this.puestoRepositorio);
		
	
		
	}
	
	@Test
	public void listarPuestosService() {
		
		
		PuestoTestBuilder puestoTestBuilder=new PuestoTestBuilder();
		 List<Puesto> puestos=puestoTestBuilder.listaPuestos();
		
		given(puestoRepositorio.listarPuesto()).willReturn(puestos);
		
		
		assertEquals(2,puestoService.listarPuestos().size());
		
	}
	
	
	@Test
	public void listarPuestoLibre() {
		
		
		PuestoTestBuilder puestoTestBuilder=new PuestoTestBuilder();
		List<Puesto> puestosLibres=puestoTestBuilder.listaPuestosLibres();
		
		given(puestoRepositorio.listarPuestoLibre()).willReturn(puestosLibres);
		
		
		assertEquals(false,puestoService.listarPuestosLibres().get(0).isEstado());
		assertEquals(false,puestoService.listarPuestosLibres().get(1).isEstado());
		
		
	}
	
	
	
	
	
	

}
