/*
 * Copyright (C) 2016 mguzmana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Universidad Nacional de Costa Rica, Prof: Maikol Guzman Alan.
 */
package ac.cr.una.frontend.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import ac.cr.una.frontend.Constants;
import ac.cr.una.frontend.model.Student;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;

/**
 * Service to get the data from the service
 *
 * @author mguzmana
 */
public class StudentService {

    /**
     * Empty Constructor
     */
    public StudentService() {
    }

    /**
     * Wrapper to return the list of students from the File
     *
     * @return Object[][] data
     * @throws com.fasterxml.jackson.core.JsonGenerationException
     * @throws com.fasterxml.jackson.databind.JsonMappingException
     * @throws java.io.IOException
     */
    public Object[][] loadStudentsObjWrapper() throws JsonGenerationException,
            JsonMappingException, IOException, Exception {
        
        //Student[] students = loadStudentsFromFile();
        Student[] students = loadJsonFromWebService();
        
        Object[][] data = null;

        if (students != null && students.length > 0) {
            data = new Object[students.length][4]; // filas y columnas
            int i = 0;
            for (Student student : students) {
                data[i][0] = checkIfNull(student.getId());
                data[i][1] = checkIfNull(student.getName());
                data[i][2] = checkIfNull(student.getCourse());
                data[i][3] = checkIfNull(student.getRating());
                i++;
            }
        }

        return data;
    }

    private Student[] loadStudentsFromFile() throws JsonGenerationException,
            JsonMappingException, IOException {
        // Library Jackson parse JSon
        // http://wiki.fasterxml.com/JacksonHome
        Student[] students;

        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string from file to Object

        students = mapper.readValue(new File(Constants.FILENAME), Student[].class);

        return students;
    }

    private String checkIfNull(Object obj) {
        String text;
        if (obj == null) {
            text = "";
        } else {
            text = obj.toString();
        }
        return text;
    }

    private Student[] loadJsonFromWebService() throws Exception {
        Student[] students;
        String jSonFile;
        ObjectMapper mapper = new ObjectMapper();

        Client client = Client.create();

        WebResource webResource = client
                .resource(Constants.WS_URL);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        jSonFile = response.getEntity(String.class);

        students = mapper.readValue(jSonFile, Student[].class);

        return students;
    }
}
