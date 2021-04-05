
package com.rest.test;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;



public class RestClient {

    public static void main(String[] args)  {
       
      
    }


    static class Register_JerseyClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8081/RESTAPI/api";

        public Register_JerseyClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("userPost");
        }

        public Register_JerseyClient(String username, String password) {
            this();
            setUsernamePassword(username, password);
        }

        public <T> T postValueMethod(Object requestEntity, Class<T> responseType) throws ClientErrorException {
            return webTarget.path("post").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
        }

        public void close() {
            client.close();
        }

        public final void setUsernamePassword(String username, String password) {
            webTarget.register(new org.glassfish.jersey.client.filter.HttpBasicAuthFilter(username, password));
        }
    }

    static class LogIn_JerseyClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "https://localhost:8081/RESTAPI/api";

        public LogIn_JerseyClient() {
            client = javax.ws.rs.client.ClientBuilder.newBuilder().sslContext(getSSLContext()).build();
            webTarget = client.target(BASE_URI).path("userlogin");
        }

        public LogIn_JerseyClient(String username, String password) {
            this();
            setUsernamePassword(username, password);
        }

        public <T> T getValueMethod(Class<T> responseType, String password, String id, String email) throws ClientErrorException {
            WebTarget resource = webTarget;
            if (password != null) {
                resource = resource.queryParam("password", password);
            }
            if (id != null) {
                resource = resource.queryParam("id", id);
            }
            if (email != null) {
                resource = resource.queryParam("email", email);
            }
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public void close() {
            client.close();
        }

        public final void setUsernamePassword(String username, String password) {
            webTarget.register(new org.glassfish.jersey.client.filter.HttpBasicAuthFilter(username, password));
        }

        private HostnameVerifier getHostnameVerifier() {
            return new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                    return true;
                }
            };
        }

        private SSLContext getSSLContext() {
            // for alternative implementation checkout org.glassfish.jersey.SslConfigurator
            javax.net.ssl.TrustManager x509 = new javax.net.ssl.X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
                    return;
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
                    return;
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            SSLContext ctx = null;
            try {
                ctx = SSLContext.getInstance("SSL");
                ctx.init(null, new javax.net.ssl.TrustManager[]{x509}, null);
            } catch (java.security.GeneralSecurityException ex) {
            }
            return ctx;
        }
    }
    
}
