package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.Role;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        usuario.setRole(Role.ROLE_USER);

        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
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

        if (!passwordEncoder.matches(usuario.getSenha(), usuarioExistente.getSenha())) {
            throw new BadCredentialsException("Senha incorreta");
        }

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());

        if (usuario.getRole() != null) {
            usuarioExistente.setRole(usuario.getRole());
        }

        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }

}
