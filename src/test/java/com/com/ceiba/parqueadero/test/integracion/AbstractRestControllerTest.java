package com.com.ceiba.parqueadero.test.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractRestControllerTest {
	

	/**
	 * Metodo estatico que permite recibir un objeto y trasformarlo en string
	 * @param obj objeto que se desea transformar en string
	 * @return returna una cadena con los datos del objeto
	 */
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    

}
