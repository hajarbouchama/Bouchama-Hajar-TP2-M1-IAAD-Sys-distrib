package ma.bouchama.hospital.repositories;

import ma.bouchama.hospital.entities.Medecin;
import ma.bouchama.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
