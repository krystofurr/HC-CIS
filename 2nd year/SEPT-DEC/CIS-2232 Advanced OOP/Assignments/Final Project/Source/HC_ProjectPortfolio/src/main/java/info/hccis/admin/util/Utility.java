package info.hccis.admin.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * General program utilities
 * @author bjmaclean
 * @since 20150918
 */
public class Utility {
    



    
    private static Scanner input = new Scanner(System.in);

    public static Scanner getInput() {
        return input;
    }
    
    public static String getResponseFromRest(String urlString){
        // Initialize
        int httpStatusCode = 0;
        ClientResponse clientResponse = null;
        
        Client client = Client.create();
        WebResource webResource = null;
        webResource = client.resource(urlString);
        clientResponse = webResource.accept("application/json").get(ClientResponse.class);
        httpStatusCode = clientResponse.getStatus();

        
        
        if( httpStatusCode != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + httpStatusCode);
        }
        
        String serverResponse = clientResponse.getEntity(String.class);
        System.out.println("SERVER RETURNED..." + serverResponse);
        return serverResponse;
    }
    
    
//    public static String getResponseFromRest(String urlString){
//            try {
//
//            URL url = new URL(urlString);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            if (conn.getResponseCode() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : "
//                        + conn.getResponseCode());
//            }
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//            String output;
//            String theOutput = "";
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//                theOutput += output;
//                System.out.println(output);
//            }
//
//            conn.disconnect();
//
////            ObjectMapper om = new ObjectMapper();
////            Address address = om.readValue(theOutput, Address.class);
//            return theOutput;
//            //JOptionPane.showMessageDialog(null, theOutput);
////            JOptionPane.showMessageDialog(null, address.toString());
//        } catch (MalformedURLException e) {
//
//            e.printStackTrace();
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }
//            
//        return null;
//    }
    
}
