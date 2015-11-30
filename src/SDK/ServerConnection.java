package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
/**
 * Created by Greenmeister on 25/11/15.
 */


public class ServerConnection {

    public ServerConnection() {
        this.hostAddress = "http://localhost";
        this.port = 3445;
    }

    private String hostAddress;
    private int port;


    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

    public ClientResponse get(String path) {

        System.out.println("hej");
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);


        return response;
    }


    public ClientResponse post(String json, String path) {
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        System.out.println(response.getStatus());

        return response;

    }

    public ClientResponse delete(String path){
        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.accept("application/json").delete(ClientResponse.class);

        return response;


    }
}