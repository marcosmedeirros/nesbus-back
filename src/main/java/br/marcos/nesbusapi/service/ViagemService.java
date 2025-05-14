package br.marcos.nesbusapi.service;


import br.marcos.nesbusapi.model.viagem.Viagem;
import br.marcos.nesbusapi.model.viagem.ViagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ViagemService {

    private ViagemRepository repository;

    public ViagemService(ViagemRepository repository) {
        this.repository = repository;
    }

    public List<Viagem> listar(){
        return this.repository.findAll();
    }

    public void salvar(Viagem produto){
        this.repository.save(produto);
    }


    public Viagem getViagemUUID(String uuid){
        UUID uuidformatado = UUID.fromString(uuid);
        return this.repository.findViagemByUuid(uuidformatado);
    }
}
