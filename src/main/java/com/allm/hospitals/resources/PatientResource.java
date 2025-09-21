package com.allm.hospitals.resources;

import com.allm.hospitals.exceptions.HospitalApiException;
import com.allm.hospitals.models.ScheduleVisitRequest;
import com.allm.hospitals.models.ScheduleVisit;
import com.allm.hospitals.response.CancelVisitResponse;
import com.allm.hospitals.response.ScheduleVisitResponse;
import com.allm.hospitals.service.PatientService;
import com.allm.hospitals.validator.PatientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import static com.allm.hospitals.constants.HospitalsAPIConstants.MEDIA_JSON_UTF8;
import static com.allm.hospitals.constants.HospitalsAPIConstants.SC_OK;

@Controller
@Path("/patients")
public class PatientResource {

    private final PatientService patientService;
    private final PatientValidator patientValidator;

    @Autowired
    public PatientResource(PatientService patientService, PatientValidator patientValidator) {
        this.patientService = patientService;
        this.patientValidator = patientValidator;
    }

    @POST
    @Path("/schedulevisit")
    @Consumes(MEDIA_JSON_UTF8)
    @Produces(MEDIA_JSON_UTF8)
    public Response scheduleVisit(@HeaderParam("authorization") final String authString, ScheduleVisitRequest scheduleVisitRequest) throws HospitalApiException {
        patientValidator.validatePatient(authString);
        patientValidator.validatePatientSchedule(scheduleVisitRequest);
        ScheduleVisitResponse response = patientService.scheduleVisit(scheduleVisitRequest);
        return Response.status(SC_OK).entity(response).build();
    }

    @POST
    @Path("/cancelvisit")
    @Consumes(MEDIA_JSON_UTF8)
    @Produces(MEDIA_JSON_UTF8)
    public Response cancelVisit(@HeaderParam("authorization") final String authString, ScheduleVisit cancelVisitRequest) throws HospitalApiException {
        patientValidator.validatePatient(authString);
        patientValidator.validatePatientCancelSchedule(cancelVisitRequest);
        CancelVisitResponse response = patientService.cancelScheduledVisit(cancelVisitRequest);
        return Response.status(SC_OK).entity(response).build();
    }
}
