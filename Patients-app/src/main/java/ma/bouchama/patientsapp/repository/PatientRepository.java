package ma.bouchama.patientsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.bouchama.patientsapp.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    //utiliser cette interface pour ajouter des produit dans la bd
}
