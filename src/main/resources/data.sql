INSERT INTO patient (id, name, gender, birth_date, email, blood_group, created_date)
VALUES
(1, 'Amit Sharma', 'Male', '1990-05-15', 'amit.sharma@gmail.com', 6, now()),
(2, 'Neha Verma', 'Female', '1995-08-20', 'neha.verma@gmail.com', 0, now());

INSERT INTO insurance (id, policy_number, provider, valid_until, created_at, patient_id)
VALUES
(1, 'POL12345', 'Star Health', '2026-12-31', now(), 1),
(2, 'POL67890', 'HDFC Ergo', '2025-10-31', now(), 2);


INSERT INTO doctor (id, name, specialization, email, created_at)
VALUES
(1, 'Dr. Rajesh Kumar', 'Cardiologist', 'rajesh.kumar@hospital.com', now()),
(2, 'Dr. Priya Singh', 'Orthopedic Surgeon', 'priya.singh@hospital.com', now());

INSERT INTO department (id, name, created_at, head_doctor_id)
VALUES
(1, 'Cardiology', now(), 1),
(2, 'Orthopedics', now(), 2);


--INSERT INTO appointment (id, appointment_time, reason, status, patient_id, doctor_id)
--VALUES
--(1, now() + interval '1 day', 'Chest pain', 'SCHEDULED', 1, 1),
--(2, now() + interval '2 days', 'Knee pain', 'CONFIRMED', 2, 2);
