package com.allm.hospitals.resources;

import com.allm.hospitals.exceptions.HospitalApiException;
import com.allm.hospitals.models.Hospital;
import com.allm.hospitals.models.HospitalSearchStringRequest;
import com.allm.hospitals.service.HospitalService;
import com.allm.hospitals.validator.HospitalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;

import static com.allm.hospitals.constants.HospitalsAPIConstants.MEDIA_JSON_UTF8;
import static com.allm.hospitals.constants.HospitalsAPIConstants.SC_OK;

@Controller
@Path("/hospitalsearch")
public class HospitalSearchResource {

    private final HospitalService hospitalService;
    private final HospitalValidator hospitalValidator;

    @Autowired
    public HospitalSearchResource(HospitalService hospitalService, HospitalValidator hospitalValidator) {
        this.hospitalService = hospitalService;
        this.hospitalValidator = hospitalValidator;
    }

    @POST
    @Consumes(MEDIA_JSON_UTF8)
    @Produces(MEDIA_JSON_UTF8)
    public Response searchHospitals(HospitalSearchStringRequest searchRequest) throws HospitalApiException {
        hospitalValidator.validateHospitalSearch(searchRequest);
        List<Hospital> searchResult = hospitalService.searchHospitals(searchRequest.getQuery(), searchRequest.getFilter());
        return Response.status(SC_OK).entity(searchResult).build();
    }
}
