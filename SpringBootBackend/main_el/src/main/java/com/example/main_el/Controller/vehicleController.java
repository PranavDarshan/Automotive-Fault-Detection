package com.example.main_el.Controller;


import com.example.main_el.DTO.PredictionRequest;
import com.example.main_el.DTO.PredictionRequest1;
import com.example.main_el.DTO.PredictionResponse;
import com.example.main_el.DTO.PredictionResponse1;
import com.example.main_el.Service.VehicleService;
import com.example.main_el.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Provider;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class vehicleController {


    @Autowired
    private VehicleService predictionService;

    @PostMapping("/response")
    public ResponseEntity<PredictionResponse1> predict(@RequestBody PredictionRequest1 request) {
        PredictionResponse1 response = predictionService.getResponse(request);
        return ResponseEntity.ok(response);
    }

    @Autowired
    private VehicleService vehicleService;

    // Endpoint to get vehicles by vehicleId
    @PostMapping("/vehicles")
    public List<Vehicle> getVehiclesById(@RequestBody VehicleRequest request) {
        return vehicleService.getVehiclesById(request.getVehicleId());
    }
    @PostMapping("/predict")
    public ResponseEntity<PredictionResponse> predict(@RequestBody PredictionRequest request) {
        // Save the request
        predictionService.saveRequest(request);

        // Get the prediction probability
        double probability = predictionService.getPrediction(request);

        // Fetch all vehicle sensor data for the vehicle ID
        String vehicleId = request.getId();
        List<Vehicle> vehicles = predictionService.findAllByVehicleId(vehicleId);

        if (vehicles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Return 404 if no entries found
        }

        // Create the response object with both probability and sensor data
        PredictionResponse response = new PredictionResponse(probability, vehicles);

        // Return the response entity
        return ResponseEntity.ok(response);
    }


    @PostMapping("/report")
    public Optional<Vehicle> getLatestVehicleById(@RequestBody VehicleRequest request) {
        return vehicleService.getLatestVehicleById(request.getVehicleId());
    }


}

class VehicleRequest {
    private String vehicleId;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}