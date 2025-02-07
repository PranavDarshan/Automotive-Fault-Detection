from flask import Flask, request, jsonify
import joblib
import numpy as np
import random

# Load the trained Gradient Boosted model
model = joblib.load("./hhmodel.pkl")

app = Flask(__name__)

# Min and Max thresholds for the features
thresholds = {
    'engineRpm': {'min': 61.000000, 'max': 2239.000000},
    'lubeOilPressure': {'min': 0.003384, 'max': 10.265566},
    'fuelPressure': {'min': 0.003187, 'max': 30.138326},
    'coolantPressure': {'min': 0.002483, 'max': 10.478505},
    'lubeOilTemp': {'min': 71.321974, 'max': 100.580796},
    'coolantTemp': {'min': 61.673325, 'max': 250.527912},
    'temperatureDifference': {'min': -22.669427, 'max': 250.008526}
}

@app.route('/predict', methods=['POST'])
def predict():
    try:
        data = request.json
        
        # Extract features from JSON request
        features = {
            'engineRpm': data['engineRpm'],
            'lubeOilPressure': data['lubeOilPressure'],
            'fuelPressure': data['fuelPressure'],
            'coolantPressure': data['coolantPressure'],
            'lubeOilTemp': data['lubeOilTemp'],
            'coolantTemp': data['coolantTemp'],
            'temperatureDifference': data['temperatureDifference']
        }
        
        # Check if any feature is beyond its min or max threshold
        out_of_bounds = False
        for feature, value in features.items():
            if value < thresholds[feature]['min'] or value > thresholds[feature]['max']:
                out_of_bounds = True
                break
        
        if out_of_bounds:
            # Generate a random probability between 0.85 and 1 if any feature is out of bounds
            probability = random.uniform(0.85, 1.0)
        else:
            # Convert features into numpy array and reshape for prediction
            features_array = np.array(list(features.values())).reshape(1, -1)
            
            # Make prediction (assuming model.predict_proba returns probability)
            probability = model.predict_proba(features_array)[:, 1][0]
        
        return jsonify({'probability': probability})
    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    app.run(debug=True)