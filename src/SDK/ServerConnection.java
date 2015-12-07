package SDK;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import GUI.MyFrame;

import javax.swing.*;


/**
 * Created by Greenmeister on 25/11/15.
 */


/**Creating class serverConnection. Created from the prototype of the client**/

public class ServerConnection {
    private MyFrame myFrame;


    public ServerConnection() {
        this.hostAddress = "http://localhost";
        this.port = 3445;

    }

    /**Creating variables to be used in post, delete, put server requests + plus getters **/

    private String hostAddress;
    private int port;


    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }
    /** get request for server. Not using it yet . get takes Json and path as parameters.
     * The path will always be a path in the servers API **/

    public String get(String path) {



        /**The Client instance is created to access the servers api**/
        Client client = Client.create();

        /** The WebResource instance is created to access the Web resource **/
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);


        /** the HttpStatus response that client receives from server**/
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);
        System.out.println(response);

        /** If client doesnt receive the right response from the server, then it throws and error MessageDialog and it will print it to terminal too**/

        if (response.getStatus() != 200 && response.getStatus() != 201) {
           // JOptionPane.showMessageDialog(myFrame, "Failed",
             //       "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);


        /** returns response from server in a string**/
        return output;

    }


/** Post request for server. Used for logging in and creating the game. Post takes Json and path as parameters.
 * The path will always be a path in the servers API **/

    public String post(String json, String path) {

        /**The Client instance is created to access the servers api**/
        Client client = Client.create();

        /** The WebResource instance is created to access the Web resource **/
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

        /** the HttpStatus response that client receives from server**/
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);


        /** If client receives a bad response from the server, then it throws and error MessageDialog and it will print it to terminal too**/
        if (response.getStatus() != 200 && response.getStatus() != 201) {
            JOptionPane.showMessageDialog(myFrame, "Failed",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());

        }

        String output = response.getEntity(String.class);

        /** returns response from server in a string**/
        return output;

    }
    /** Delete request for server. Used for deleting games. Delete takes path as parameter.
     * The path will always be a path in the servers API **/


    public String Delete(String path) {

        /**The Client instance is created to access the servers api**/
        Client client = Client.create();

        /** The WebResource instance is created to access the Web resource **/
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);


        /** If client receives a bad response from the server, then it throws and error MessageDialog and it will print it to terminal too**/
        if (response.getStatus() != 200 && response.getStatus() != 201) {
            JOptionPane.showMessageDialog(myFrame, "Failed",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);

        /** returns response from server in  a string**/
        return output;
    }


    /** put request for server. Used for Joining game. put takes Json and path as parameters.
     * The path will always be a path in the servers API **/

    public String put(String json, String path) {

        /**The Client instance is created to access the servers api**/
        Client client = Client.create();

        /** The WebResource instance is created to access the Web resource **/
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

        /** the HttpStatus response that client receives from server**/

        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        /** If client receives a bad response from the server, then it throws and error MessageDialog and it will print it to terminal too**/

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            JOptionPane.showMessageDialog(myFrame, "Failed",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);

        /** returns response from server in a string**/
        return output;
    }











}





