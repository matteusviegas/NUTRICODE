package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.Perfil;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository perfilRepository;
    private final br.com.challenge.nutricode.projectNutricode.domain.repository.UsuarioRepository usuarioRepository;

    public Perfil salvar(Perfil perfil) {
        if (perfil.getUsuario() == null || perfil.getUsuario().getId() == null) {
            throw new RuntimeException("Perfil precisa estar ligado a um usuário");
        }

        Long usuarioId = perfil.getUsuario().getId();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (perfilRepository.existsByUsuarioId(usuarioId)) {
            throw new RuntimeException("Esse usuário já possui perfil");
        }

        perfil.setUsuario(usuario);
        return perfilRepository.save(perfil);
    }

    public List<Perfil> listarTodos() {
        return perfilRepository.findAll();
    }

    public Optional<Perfil> buscarPorId(Long id) {
        return perfilRepository.findById(id);
    }

    public Optional<Perfil> buscarPorUsuarioId(Long usuarioId) {
        return perfilRepository.findByUsuarioId(usuarioId);
    }

    public Perfil atualizar(Long id, Perfil perfil) {
        Perfil perfilExistente = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado"));

        perfilExistente.setIdade(perfil.getIdade());
        perfilExistente.setPeso(perfil.getPeso());
        perfilExistente.setAltura(perfil.getAltura());
        perfilExistente.setObjetivo(perfil.getObjetivo());

        return perfilRepository.save(perfilExistente);
    }

    public void deletarPorId(Long id) {
        if (!perfilRepository.existsById(id)) {
            throw new RuntimeException("Perfil não encontrado");
        }

        perfilRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return perfilRepository.existsById(id);
    }
}