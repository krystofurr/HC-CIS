

package info.hccis.admin.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import info.hccis.admin.client.utility.Utility;
import info.hccis.admin.model.Deliverable;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 
 * 2 REQUESTS / 2 RESPONSES
 * 
 * CLIENT REQUESTS DATA FROM REST SERVER
 * REST SERVER RETURNS JSON DATA
 * 
 * CLIENT POSTS DATA TO REST SERVER
 * REST SERVER RETURNS AVERAGE VALUE
 *
 * 
 * REF: http://examples.javacodegeeks.com/enterprise-java/rest/jersey/json-example-with-jersey-jackson/
 * REF: http://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects
 * 
 */
public class GradesCalculatorRestClient {

    
    private static Client client;
    private static WebResource webResource;
    private static ClientResponse clientResponse;
    
    private static String jsonData;
    private static List<Deliverable> deliverables;
    
    /**
     * Using jersey-client and jersey-json ( Jackson )
     */
    public static void main(String[] args) {
  

        // Request and store JSON data
        
        try {
            
            client = Client.create();
            webResource = client.resource("http://localhost:8080/gradesCalculator/rest/deliverables/get");
            clientResponse = webResource.accept("application/json").get(ClientResponse.class);
            int status = clientResponse.getStatus();
            jsonData = clientResponse.getEntity(String.class);

            if( status != 200 ) {

                throw new RuntimeException("Failed : HTTP error code : " + status);

            } 

            System.out.println("Retrieving deliverables...");
            // Stores the JSON into a List collection ( REF: http://stackoverflow.com/questions/6349421/how-to-use-jackson-to-deserialise-an-array-of-objects )
            ObjectMapper mapper = new ObjectMapper();
            deliverables = mapper.readValue(jsonData, mapper.getTypeFactory().constructCollectionType(List.class, Deliverable.class));
            System.out.println("Server returned " + deliverables.size() + " deliverables\n");

          
          
            /*

              Now that we have the deliverables we can input the grades and send them back for the average

            */
            
            
            getGrades();
            
            // ClientConfig is required to be able to convert the List into JSON
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            client = Client.create(clientConfig);
            webResource = client.resource("http://localhost:8080/gradesCalculator/rest/deliverables/average");
            ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, deliverables);
            
            if (response.getStatus() != 200) {

                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

            }

            String output = response.getEntity(String.class);
            System.out.println("Server response .... \n");
            double average = Double.parseDouble(output);
            System.out.printf("%s%.1f%s%n%n", "AVERAGE: ", average, " %");
            
            
        } catch( RuntimeException | IOException ex ) {
            
            System.out.println("ERROR: " + ex.getMessage());            
        }
  
        
    } // END: MAIN
    
    
    public static void getGrades() {
        Scanner input = Utility.getInput();
        
        for(Deliverable deliverable : deliverables) {
            System.out.println(deliverable);
            System.out.print("Enter your grade for this deliverable: ");
            String grade = input.nextLine();
            deliverable.setStringGrade(grade);
        }
    }
    
}
