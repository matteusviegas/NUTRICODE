package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.CondicaoMedica;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.CondicaoMedicaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CondicaoMedicaService {

    private final CondicaoMedicaRepository condicaoRepository;
    private final br.com.challenge.nutricode.projectNutricode.domain.model.repository.UsuarioRepository usuarioRepository;

    public CondicaoMedica salvar(CondicaoMedica condicao) {
        if (condicao.getUsuario() == null || condicao.getUsuario().getId() == null) {
            throw new RuntimeException("A condição médica precisa estar ligada a um usuário");
        }

        Long usuarioId = condicao.getUsuario().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        condicao.setUsuario(usuario);
        return condicaoRepository.save(condicao);
    }

    public List<CondicaoMedica> listarTodas() {
        return condicaoRepository.findAll();
    }

    public Optional<CondicaoMedica> buscarPorId(Long id) {
        return condicaoRepository.findById(id);
    }

    public List<CondicaoMedica> buscarPorUsuarioId(Long usuarioId) {
        return condicaoRepository.findByUsuarioId(usuarioId);
    }

    public CondicaoMedica atualizar(Long id, CondicaoMedica condicao) {
        CondicaoMedica existente = condicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Condição médica não encontrada"));

        existente.setDescricaoMedica(condicao.getDescricaoMedica());
        return condicaoRepository.save(existente);
    }

    public void deletar(Long id) {
        condicaoRepository.deleteById(id);
    }
}