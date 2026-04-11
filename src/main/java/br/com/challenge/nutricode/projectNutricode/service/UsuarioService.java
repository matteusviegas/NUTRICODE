package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final br.com.challenge.nutricode.projectNutricode.domain.repository.UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setSenha(usuario.getSenha());

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }
}