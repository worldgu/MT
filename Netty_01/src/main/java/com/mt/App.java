package com.mt;

import com.uber.h3core.H3Core;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        H3Core h3 = H3Core.newInstance();

        double lat = 37.775938728915946;
        double lng = -122.41795063018799;
        int res = 9;

        String hexAddr = h3.geoToH3Address(lat, lng, res);

        System.out.println(">>>>>>>" + hexAddr);
    }
}
