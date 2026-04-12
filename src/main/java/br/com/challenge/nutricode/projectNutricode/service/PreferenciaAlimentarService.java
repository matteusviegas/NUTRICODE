package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.PreferenciaAlimentar;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.PreferenciaAlimentarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PreferenciaAlimentarService {

    private final PreferenciaAlimentarRepository preferenciaRepository;
    private final br.com.challenge.nutricode.projectNutricode.domain.model.repository.UsuarioRepository usuarioRepository;

    public PreferenciaAlimentar salvar(PreferenciaAlimentar preferencia) {
        if (preferencia.getUsuario() == null || preferencia.getUsuario().getId() == null) {
            throw new RuntimeException("A preferência precisa estar ligada a um usuário");
        }

        Long usuarioId = preferencia.getUsuario().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        preferencia.setUsuario(usuario);
        return preferenciaRepository.save(preferencia);
    }

    public List<PreferenciaAlimentar> listarTodas() {
        return preferenciaRepository.findAll();
    }

    public Optional<PreferenciaAlimentar> buscarPorId(Long id) {
        return preferenciaRepository.findById(id);
    }

    public List<PreferenciaAlimentar> buscarPorUsuarioId(Long usuarioId) {
        return preferenciaRepository.findByUsuarioId(usuarioId);
    }

    public PreferenciaAlimentar atualizar(Long id, PreferenciaAlimentar preferencia) {
        PreferenciaAlimentar existente = preferenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preferência não encontrada"));

        existente.setNomePreferencia(preferencia.getNomePreferencia());
        return preferenciaRepository.save(existente);
    }

    public void deletar(Long id) {
        preferenciaRepository.deleteById(id);
    }
}