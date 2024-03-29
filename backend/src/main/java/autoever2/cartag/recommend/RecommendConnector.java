package autoever2.cartag.recommend;

import autoever2.cartag.quotes.dtos.QuoteRequestDto;
import autoever2.cartag.exception.ErrorCode;
import autoever2.cartag.exception.ServerException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecommendConnector {

    @Value("${python.url}")
    private String requestURL;

    public List<List<Integer>> request(QuoteRequestDto quoteRequestDto) {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestURL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(getJsonFromEstimate(quoteRequestDto))).build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (IOException e) {
            throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return parseResponse(response.body());
    }


    private String getJsonFromEstimate(QuoteRequestDto quoteRequestDto) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("carId", quoteRequestDto.getCarId());
        jsonObject.put("powerTrain", quoteRequestDto.getPowerTrainId());
        jsonObject.put("bodyType", quoteRequestDto.getBodyTypeId());
        jsonObject.put("operation", quoteRequestDto.getOperationId());
        jsonObject.put("options", quoteRequestDto.getOptionIdList());

        return jsonObject.toJSONString();
    }

    private List<List<Integer>> parseResponse(String responseBody) {
        JSONParser parser = new JSONParser();
        JSONArray resultArray = null;
        try {
            resultArray = (JSONArray) parser.parse(responseBody);
        } catch (ParseException e) {
            throw new ServerException(ErrorCode.PARSE_ERROR, e.getMessage());
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Object o : resultArray) {
            JSONArray optionArray = (JSONArray) o;
            List<Integer> options = new ArrayList<>();

            for (Object option : optionArray) {
                options.add(Math.toIntExact((Long) option));
            }

            result.add(options);
        }
        return result;
    }
}
