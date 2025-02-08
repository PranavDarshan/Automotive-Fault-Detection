CREATE TABLE vehicles (
    entry_no int auto_increment primary key,
    id VARCHAR(10),
    type VARCHAR(50),
    transmission VARCHAR(50),
    mileage_km INT,
    status VARCHAR(50),
    engine_rpm INT,
    lube_oil_pressure INT,
    fuel_pressure INT,
    coolant_pressure INT,
    lube_oil_temp INT,
    coolant_temp INT,
    engine_status VARCHAR(50),
    last_updated DATE
);
