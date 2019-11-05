package fr.housseofcode.dap.dap.cmd;

import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkUtil {

    public  HttpURLConnection createConnexion (URL url) throws Exception {
    final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    return conn;
    
    }
}
