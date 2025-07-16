DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS hospitals;
DROP TABLE IF EXISTS visits;

CREATE TABLE patients (
  patient_id IDENTITY,
  name VARCHAR NOT NULL,
  password VARCHAR NOT NULL
);
CREATE TABLE hospitals (
  hospital_id IDENTITY,
  name VARCHAR NOT NULL,
  city VARCHAR NOT NULL
);
CREATE TABLE visits (
  visit_id IDENTITY,
  hospital_id NUMBER,
  patient_id NUMBER,
  schedule_date DATE,
  FOREIGN KEY (hospital_id) REFERENCES hospitals(hospital_id),
  FOREIGN KEY (patient_id) REFERENCES patients(patient_id)
);