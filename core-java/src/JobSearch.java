//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.net.http.HttpHeaders;
//
//
//public class JobSearch {
//
//
//    public static void main(String[] args) {
//        // Create an instance of HttpClient
//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        String microsoftPortal = "https://gcsservices.careers.microsoft.com/search/api/v1/search?p=Software%20Engineering&l=en_us&pg=1&pgSz=20&o=Recent&flt=true";
//
//        // Create an HttpRequest
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(microsoftPortal))
//                .GET()
//                .build();
//
//        // Send the request and retrieve the response
//        try {
//            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // Print response status code and body
//            System.out.println("Response Code: " + response.statusCode());
//            System.out.println("Response Body:\n" + response.body());
//
//            postingDate
//
//                    title
//
//            // Print response headers
//            HttpHeaders headers = response.headers();
//            headers.map().forEach((key, value) -> System.out.println(key + ":" + value));
//
//        } catch (Exception e) {
//            System.err.println("Error: " + e.getMessage());
//        }
//    }
//
//
//}
