package org.sebi.incident;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("rest/incidents")
public class IncidentResource {
    
    @Inject
    @RestClient
    IncidentWebResource incidentWebResource;

    @ConfigProperty(name = "secret.apiKey", defaultValue = "secret")
    private String apiKey;

    @GET
    public List<Incident> getIncidents(){
       return incidentWebResource.getIncidents(apiKey);
    } 
}
