package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import GUI.MyFrame;

import javax.swing.*;


/**
 * Created by Greenmeister on 25/11/15.
 */


/**Creating class serverConnection. Created from the prototype of the client. This class communicates with the servers api**/

public class ServerConnection {
    private MyFrame myFrame;

    /** protocol, address and port of the server **/

    public ServerConnection() {
        this.hostAddress = "http://localhost";
        this.port = 3445;

    }

    /**Creating variables to be used in post, delete, put server requests + plus getters **/

    private String hostAddress;
    private int port;

    /** getter thats  get the server address **/

    public String getHostAddress() {
        return hostAddress;
    }

    /** getter that gets the server port**/
    public int getPort() {
        return port;
    }
    /** get request for server. Used to get highscores on server, To get users created games, To get users scores . get takes  a path as parameters.
     * The path will always be a path to one of the methods in the servers api**/

    public String get(String path) {



        /**The Client instance is created to access the servers api**/
        Client client = Client.create();

        /** The WebResource instance is created to access the Web resource **/
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);


        /** the HttpStatus response that client receives from server**/
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);
        System.out.println(response);

        /** If client doesnt receive the right response from the server, then it throws and error MessageDialog and it will print it to terminal too**/

        if (response.getStatus() != 200 && response.getStatus() != 201) {
            JOptionPane.showMessageDialog(myFrame, "Failed",
                    "Error", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);
        System.out.println(output);


        /** returns response from server in a string**/
        return output;

    }


    /** Post request for server. Used for logging in and creating the game. Post takes Json and path as parameters.
    * The path will always be a path to a method in servers api **/

    public String post(String json, String path) {

        /**The Client instance is created to access the servers api**/
        Client client = Client.create();

        /** The WebResource instance is created to access the Web resource **/
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);

        /** the HttpStatus response that client receives from server**/
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);
        System.out.println(response);


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
     * The path will always be a path to a method in the servers api**/


      public String delete(String path) {

        /**The Client instance is created to access the servers api**/
        Client client = Client.create();

        /** The WebResource instance is created to access the Web resource **/
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);


        /** If client receives a bad response from the server, then it throws and error MessageDialog and it will print it to terminal too**/
        if (response.getStatus() != 200 && response.getStatus() != 201) {

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





