package ma.bouchama.patientsapp;

import ma.bouchama.patientsapp.entities.Patient;
import ma.bouchama.patientsapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientsAppApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Anis",new Date(),false,10));
		patientRepository.save(new Patient(null,"Rachid",new Date(),true,50));
		patientRepository.save(new Patient(null,"Khadija",new Date(),true,49));
		patientRepository.save(new Patient(null,"Amal",new Date(),false,11));
		patientRepository.save(new Patient(null,"Nadir",new Date(),false,13));

		// Consulter tous les patients
		List<Patient> patients = patientRepository.findAll();
		patients.forEach(p->{
			System.out.println(p.toString());
		});


		System.out.println("*************");

		// Consulter un patient par son ID
		Patient p = patientRepository.findById(Long.valueOf(1)).get();
		Patient p2 = patientRepository.findById(Long.valueOf(2)).get();
		System.out.println(p.getId());
		System.out.println(p.getNom());
		System.out.println(p.getDateNaissanec());
		System.out.println(p.getDateNaissanec());
		System.out.println(p.getScore());

		System.out.println("*************");

		// Mettre à jour un patient
		Patient patientUpdate = patientRepository.findById(Long.valueOf(3)).get();
		patientUpdate.setMalade(true);
		patientUpdate.setScore(80);
		patientRepository.save(patientUpdate);
		System.out.println("Patient mis à jour avec succès : " + patientUpdate);


		// Supprimer un patient par son ID
		patientRepository.deleteById(2L);
		System.out.println("Patient avec l'ID 2 supprimé.");


		// Vérifier les patients après la suppression
		List<Patient> remainingPatients = patientRepository.findAll();
		remainingPatients.forEach(pa -> {
			System.out.println(pa.toString());
		});



	}
}
