package ma.bouchama.hospital.repositories;

import ma.bouchama.hospital.entities.Patient;
import ma.bouchama.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
