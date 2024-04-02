package ma.emsi.hopital.repositories;

import ma.emsi.hopital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    Patient findPatientByNom(String name);
    Page<Patient> findPatientByNomContains(String keyword, Pageable pageable);
    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercher(@Param("x") String x, Pageable pageable);
}
