package fitlife.data.cl.servicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import fitlife.data.cl.servicios.model.asesorias;
import fitlife.data.cl.servicios.repository.asesoriasRepository;

@Service
@Transactional
public class asesoriasService {


    @Autowired
    private asesoriasRepository asesoriasRepository;

    public List<asesorias> fetchAll() {
        return asesoriasRepository.findAll();
    }

    public asesorias fetchById(Integer id) {
        return asesoriasRepository.findById(id.longValue()).get();
    }

    public asesorias save(asesorias asesorias) {
        return asesoriasRepository.save(asesorias);
    }

    public void delete(Integer id) {
        asesoriasRepository.deleteById(id.longValue());
    }
}

