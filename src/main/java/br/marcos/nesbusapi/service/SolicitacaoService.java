package br.marcos.nesbusapi.service;


import br.marcos.nesbusapi.model.solicitacao.Solicitacao;
import br.marcos.nesbusapi.model.usuario.Usuario;
import br.marcos.nesbusapi.model.viagem.ViagemRepository;
import br.marcos.nesbusapi.model.usuario.UsuarioRepository;
import br.marcos.nesbusapi.model.solicitacao.SolicitacaoDTO;
import br.marcos.nesbusapi.model.solicitacao.SolicitacaoRepository;
import br.marcos.nesbusapi.model.viagemData.ViagemDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ViagemRepository solicitacaoRepository;

    @Autowired
    private SolicitacaoRepository viagemRepository;

    @Autowired
    private ViagemDataRepository viagemDataRepository;


    public SolicitacaoService(UsuarioRepository usuarioRepository, ViagemRepository solicitacaoRepository, SolicitacaoRepository viagemRepository, ViagemDataRepository viagemDataRepository) {
        this.usuarioRepository = usuarioRepository;
        this.solicitacaoRepository = solicitacaoRepository;
        this.viagemRepository = viagemRepository;
        this.viagemDataRepository = viagemDataRepository;
    }

    public void cadastrarViagem(SolicitacaoDTO viagemDTO) {

    }



}
