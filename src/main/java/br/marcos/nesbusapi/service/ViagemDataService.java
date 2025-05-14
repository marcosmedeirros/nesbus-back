package br.marcos.nesbusapi.service;


import br.marcos.nesbusapi.model.viagemData.viagemData;
import br.marcos.nesbusapi.model.viagemData.ViagemDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ViagemDataService {

    private final ViagemDataRepository viagemDataRepository;

    public ViagemDataService(ViagemDataRepository viagemDataRepository) {
        this.viagemDataRepository = viagemDataRepository;
    }

    public viagemData buscarViagemDataPorID(Long id) {
        return viagemDataRepository.getReferenceById(id);
    }
}
