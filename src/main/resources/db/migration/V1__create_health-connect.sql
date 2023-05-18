
-- Create Patients table
CREATE TABLE patients (
                          patient_id SERIAL PRIMARY KEY,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          dob DATE,
                          gender VARCHAR(10),
                          contact_number VARCHAR(15),
                          address TEXT
);

-- Create Doctors table
CREATE TABLE doctors (
                         doctor_id SERIAL PRIMARY KEY,
                         first_name VARCHAR(255),
                         last_name VARCHAR(255),
                         specialization VARCHAR(255),
                         contact_number VARCHAR(15),
                         email VARCHAR(255)
);

-- Create Appointments table
CREATE TABLE appointments (
                              appointment_id SERIAL PRIMARY KEY,
                              appointment_date DATE,
                              appointment_time TIME,
                              patient_id INTEGER,
                              doctor_id INTEGER,
                              FOREIGN KEY (patient_id) REFERENCES patients (patient_id),
                              FOREIGN KEY (doctor_id) REFERENCES doctors (doctor_id)
);

-- Create Prescriptions table
CREATE TABLE prescriptions (
                               prescription_id SERIAL PRIMARY KEY,
                               prescription_date DATE,
                               prescription_details TEXT,
                               patient_id INTEGER,
                               doctor_id INTEGER,
                               FOREIGN KEY (patient_id) REFERENCES patients (patient_id),
                               FOREIGN KEY (doctor_id) REFERENCES doctors (doctor_id)
);

-- Create Medications table
CREATE TABLE medications (
                             medication_id SERIAL PRIMARY KEY,
                             medication_name VARCHAR(255),
                             dosage VARCHAR(255),
                             prescription_id INTEGER,
                             FOREIGN KEY (prescription_id) REFERENCES prescriptions (prescription_id)
);
