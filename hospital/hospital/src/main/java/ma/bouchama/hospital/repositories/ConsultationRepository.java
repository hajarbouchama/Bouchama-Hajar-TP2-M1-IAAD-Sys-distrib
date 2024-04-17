package ma.bouchama.hospital.repositories;

import ma.bouchama.hospital.entities.Consultation;
import ma.bouchama.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
