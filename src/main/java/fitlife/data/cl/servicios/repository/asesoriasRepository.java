package fitlife.data.cl.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fitlife.data.cl.servicios.model.asesorias;

@Repository
public interface asesoriasRepository extends JpaRepository <asesorias, Long> {

}
