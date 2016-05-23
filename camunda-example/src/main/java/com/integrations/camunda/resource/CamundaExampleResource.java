/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.integrations.camunda.resource;

import com.fitness.bpm.engine.services.BpmProcessException;
import com.fitness.bpm.engine.services.BpmProcessService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.integrations.camunda.resource.response.ProcessResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author carlos.mendoza
 */
@Path("/resource")
public class CamundaExampleResource {
    @Inject
    private BpmProcessService service;
    
    private static final Logger log= Logger.getLogger("CamundaExampleResource");
    
    @POST
    @Path("/camundaExampleProcess")
    @Produces(MediaType.APPLICATION_JSON)
    public Response camundaExampleProcess(@QueryParam("emplType") final String emplType) {
        ProcessResponse response = null;
        
        Map<String, String> map = new HashMap<String, String>();
        String lista = "99528";
        map.put("empid", lista);
        lista = "2282F";
        map.put("empid", lista);
        try{
        service.runProcess("staples-process-v1", map);
        response = new ProcessResponse("yeeeeeei", true);
        }catch(BpmProcessException ex){
            log.info(ex.getMessage());
            response = new ProcessResponse("go wrong", true);
            return Response.ok(response).build();
        }
        response = new ProcessResponse("yeeeeeei", true);
        return Response.ok(response).build();
    }

}
