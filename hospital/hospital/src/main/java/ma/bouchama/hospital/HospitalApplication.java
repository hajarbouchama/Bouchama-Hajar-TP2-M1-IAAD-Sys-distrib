package ma.bouchama.hospital;

import ma.bouchama.hospital.entities.*;
import ma.bouchama.hospital.repositories.ConsultationRepository;
import ma.bouchama.hospital.repositories.MedecinRepository;
import ma.bouchama.hospital.repositories.PatientRepository;
import ma.bouchama.hospital.repositories.RendezVousRepository;
import ma.bouchama.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
	@Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository){
		return args -> {
			Stream.of("Mohammed","Farid","Khalid")
					.forEach(name->{
						Patient patient=new Patient();
						patient.setNom(name);
						patient.setDateNaissanec(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);

					});

			Stream.of("Hajar","Kaotar","hind")
					.forEach(name->{
						Medecin medecin=new Medecin();
						medecin.setNom(name);
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
						medecin.setEmail(name+"@gmail.com");
						hospitalService.saveMedecin(medecin);

					});

			Patient patient=patientRepository.findAll().get(0);
			Patient patient1=patientRepository.findByNom("Farid");

			Medecin medecin= medecinRepository.findByNom("Hajar");

			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous saveDRDV = hospitalService.saveRendezVous(rendezVous);
			System.out.println(saveDRDV.getId());



			RendezVous rendezVous1= rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation=new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport de la consultation ....");
			hospitalService.saveConsultation(consultation);





		};
	}
}
