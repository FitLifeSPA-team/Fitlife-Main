package fitlife.data.cl.servicios.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import fitlife.data.cl.servicios.model.nutricionistas;
import fitlife.data.cl.servicios.repository.nutricionistasRepository;

@Service
@Transactional
public class nutricionistasService {

    @Autowired
    private nutricionistasRepository nutricionistasRepository;

    public List<nutricionistas> fetchAll() {
        return nutricionistasRepository.findAll();
    }

    public nutricionistas fetchById(Long id) {
        return nutricionistasRepository.findById(id).get();
    }

    public nutricionistas save(nutricionistas nutricionista) {
        return nutricionistasRepository.save(nutricionista);
    }

    public void delete(Long id) {
        nutricionistasRepository.deleteById(id);
    }
}
