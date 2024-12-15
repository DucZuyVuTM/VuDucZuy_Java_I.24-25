import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class UnitConverterHttpServer {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Unit Converter HTTP Server is running on port " + PORT);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    handleClient(clientSocket);
                }
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

        String line = in.readLine();
        if (line == null) return;

        String[] requestParts = line.split(" ");
        if (requestParts.length < 2) {
            handleBadRequest(out);
            return;
        }

        String method = requestParts[0];
        String path = requestParts[1];

        if (method.equals("GET") && path.equals("/")) {
            handleHomePage(out);
        } else if (method.equals("GET") && path.startsWith("/convert")) {
            handleConversion(path, out);
        } else {
            handleNotFound(out);
        }

        out.flush();
    }

    private static void handleHomePage(PrintWriter out) {
        StringBuilder response = new StringBuilder();
        response.append("<html><body style='font-family: Arial, sans-serif; background-color: #f9f9f9; margin: 0; padding: 20px;'>");
        response.append("<h1 style='color: blue; text-align: center;'>Welcome to Unit Converter</h1>");
        response.append("<p style='text-align: center; color: #555;'>Use this server to convert between units of length, weight, and temperature.</p>");

        // Form for meters -> kilometers
        response.append("<div style='margin-bottom: 20px;'>");
        response.append("<h2 style='color: #333;'>Meters to Kilometers</h2>");
        response.append("<form action='/convert' method='get'>");
        response.append("<input type='hidden' name='from' value='meters'>");
        response.append("<input type='hidden' name='to' value='kilometers'>");
        response.append("<input type='number' name='value' step='any' required style='padding: 5px; margin-right: 10px;'>");
        response.append("<button type='submit' style='padding: 5px 10px; background-color: blue; color: white; border: none; border-radius: 5px;'>Convert</button>");
        response.append("</form>");
        response.append("</div>");

        // Form for kilometers -> meters
        response.append("<div style='margin-bottom: 20px;'>");
        response.append("<h2 style='color: #333;'>Kilometers to Meters</h2>");
        response.append("<form action='/convert' method='get'>");
        response.append("<input type='hidden' name='from' value='kilometers'>");
        response.append("<input type='hidden' name='to' value='meters'>");
        response.append("<input type='number' name='value' step='any' required style='padding: 5px; margin-right: 10px;'>");
        response.append("<button type='submit' style='padding: 5px 10px; background-color: blue; color: white; border: none; border-radius: 5px;'>Convert</button>");
        response.append("</form>");
        response.append("</div>");

        // Form for grams -> kilograms
        response.append("<div style='margin-bottom: 20px;'>");
        response.append("<h2 style='color: #333;'>Grams to Kilograms</h2>");
        response.append("<form action='/convert' method='get'>");
        response.append("<input type='hidden' name='from' value='grams'>");
        response.append("<input type='hidden' name='to' value='kilograms'>");
        response.append("<input type='number' name='value' step='any' required style='padding: 5px; margin-right: 10px;'>");
        response.append("<button type='submit' style='padding: 5px 10px; background-color: blue; color: white; border: none; border-radius: 5px;'>Convert</button>");
        response.append("</form>");
        response.append("</div>");

        // Form for kilograms -> grams
        response.append("<div style='margin-bottom: 20px;'>");
        response.append("<h2 style='color: #333;'>Kilograms to Grams</h2>");
        response.append("<form action='/convert' method='get'>");
        response.append("<input type='hidden' name='from' value='kilograms'>");
        response.append("<input type='hidden' name='to' value='grams'>");
        response.append("<input type='number' name='value' step='any' required style='padding: 5px; margin-right: 10px;'>");
        response.append("<button type='submit' style='padding: 5px 10px; background-color: blue; color: white; border: none; border-radius: 5px;'>Convert</button>");
        response.append("</form>");
        response.append("</div>");

        // Form for celsius -> fahrenheit
        response.append("<div style='margin-bottom: 20px;'>");
        response.append("<h2 style='color: #333;'>Celsius to Fahrenheit</h2>");
        response.append("<form action='/convert' method='get'>");
        response.append("<input type='hidden' name='from' value='celsius'>");
        response.append("<input type='hidden' name='to' value='fahrenheit'>");
        response.append("<input type='number' name='value' step='any' required style='padding: 5px; margin-right: 10px;'>");
        response.append("<button type='submit' style='padding: 5px 10px; background-color: blue; color: white; border: none; border-radius: 5px;'>Convert</button>");
        response.append("</form>");
        response.append("</div>");

        // Form for fahrenheit -> celsius
        response.append("<div style='margin-bottom: 20px;'>");
        response.append("<h2 style='color: #333;'>Fahrenheit to Celsius</h2>");
        response.append("<form action='/convert' method='get'>");
        response.append("<input type='hidden' name='from' value='fahrenheit'>");
        response.append("<input type='hidden' name='to' value='celsius'>");
        response.append("<input type='number' name='value' step='any' required style='padding: 5px; margin-right: 10px;'>");
        response.append("<button type='submit' style='padding: 5px 10px; background-color: blue; color: white; border: none; border-radius: 5px;'>Convert</button>");
        response.append("</form>");
        response.append("</div>");

        response.append("</body></html>");
        sendHttpResponse(out, 200, response.toString());
    }

    private static void handleConversion(String path, PrintWriter out) {
        try {
            Map<String, String> queryParams = parseQueryParams(path);

            double value = Double.parseDouble(queryParams.getOrDefault("value", "0"));
            String from = queryParams.get("from");
            String to = queryParams.get("to");

            double result = convertUnits(value, from, to);

            sendHttpResponse(out, 200, "<html><body style='font-family: Arial, sans-serif;'><h1>Result: " + result + "</h1></body></html>");
        } catch (IllegalArgumentException e) {
            sendHttpResponse(out, 400, "<html><body style='font-family: Arial, sans-serif;'><h1>Invalid input</h1></body></html>");
        }
    }

    private static double convertUnits(double value, String from, String to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Missing 'from' or 'to' parameter");
        }

        switch (from + "->" + to) {
            case "meters->kilometers":
                return value / 1000;
            case "kilometers->meters":
                return value * 1000;
            case "grams->kilograms":
                return value / 1000;
            case "kilograms->grams":
                return value * 1000;
            case "celsius->fahrenheit":
                return (value * 9 / 5) + 32;
            case "fahrenheit->celsius":
                return (value - 32) * 5 / 9;
            default:
                throw new IllegalArgumentException("Unsupported conversion");
        }
    }

    private static Map<String, String> parseQueryParams(String path) {
        Map<String, String> queryParams = new HashMap<>();
        int queryStart = path.indexOf("?");
        if (queryStart == -1) return queryParams;

        String[] pairs = path.substring(queryStart + 1).split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                queryParams.put(keyValue[0], URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8));
            }
        }

        return queryParams;
    }

    private static void handleBadRequest(PrintWriter out) {
        sendHttpResponse(out, 400, "<html><body style='font-family: Arial, sans-serif;'><h1>Bad Request</h1></body></html>");
    }

    private static void handleNotFound(PrintWriter out) {
        sendHttpResponse(out, 404, "<html><body style='font-family: Arial, sans-serif;'><h1>404 Not Found</h1></body></html>");
    }

    private static void sendHttpResponse(PrintWriter out, int statusCode, String body) {
        out.println("HTTP/1.1 " + statusCode + " OK");
        out.println("Content-Type: text/html; charset=UTF-8");
        out.println("Content-Length: " + body.length());
        out.println();
        out.println(body);
    }
}
