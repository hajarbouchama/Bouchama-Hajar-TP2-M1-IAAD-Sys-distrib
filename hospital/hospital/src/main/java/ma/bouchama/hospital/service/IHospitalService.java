package ma.bouchama.hospital.service;

import ma.bouchama.hospital.entities.Consultation;
import ma.bouchama.hospital.entities.Medecin;
import ma.bouchama.hospital.entities.Patient;
import ma.bouchama.hospital.entities.RendezVous;

public interface IHospitalService {
      Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);


}
