package com.allm.hospitals.constants;

import jakarta.ws.rs.core.MediaType;

public class HospitalsAPIConstants {

    public static final String MEDIA_JSON_UTF8 = MediaType.APPLICATION_JSON + ";charset=utf-8";


    //Http status codes
    public static final int SC_OK = 200;

    public static final int SC_BAD_REQUEST = 400;

    public static final int SC_UNAUTHORIZED = 401;

    public static final int SC_FORBIDDEN = 403;

}
