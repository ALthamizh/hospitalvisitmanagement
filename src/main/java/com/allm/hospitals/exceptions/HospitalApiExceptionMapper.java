package com.allm.hospitals.exceptions;

import com.allm.hospitals.response.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import static com.allm.hospitals.constants.HospitalsAPIConstants.MEDIA_JSON_UTF8;

@Provider
public class HospitalApiExceptionMapper implements ExceptionMapper<HospitalApiException> {
    @Override
    public Response toResponse(HospitalApiException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), exception.getLocalizedMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).type(MEDIA_JSON_UTF8).build();
    }
}
