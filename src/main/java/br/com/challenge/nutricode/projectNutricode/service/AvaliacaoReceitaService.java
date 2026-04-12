package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.AvaliacaoReceita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.AvaliacaoReceitaRepository;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvaliacaoReceitaService {

    private final AvaliacaoReceitaRepository avaliacaoRepository;
    private final br.com.challenge.nutricode.projectNutricode.domain.model.repository.UsuarioRepository usuarioRepository;
    private final ReceitaRepository receitaRepository;

    public AvaliacaoReceita salvar(AvaliacaoReceita avaliacao) {
        if (avaliacao.getUsuario() == null || avaliacao.getUsuario().getId() == null) {
            throw new RuntimeException("A avaliação precisa ter um usuário");
        }

        if (avaliacao.getReceita() == null || avaliacao.getReceita().getId() == null) {
            throw new RuntimeException("A avaliação precisa ter uma receita");
        }

        Usuario usuario = usuarioRepository.findById(avaliacao.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Receita receita = receitaRepository.findById(avaliacao.getReceita().getId())
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        avaliacao.setUsuario(usuario);
        avaliacao.setReceita(receita);

        return avaliacaoRepository.save(avaliacao);
    }

    public List<AvaliacaoReceita> listarTodas() {
        return avaliacaoRepository.findAll();
    }

    public Optional<AvaliacaoReceita> buscarPorId(Long id) {
        return avaliacaoRepository.findById(id);
    }

    public List<AvaliacaoReceita> buscarPorUsuarioId(Long usuarioId) {
        return avaliacaoRepository.findByUsuarioId(usuarioId);
    }

    public List<AvaliacaoReceita> buscarPorReceitaId(Long receitaId) {
        return avaliacaoRepository.findByReceitaId(receitaId);
    }

    public AvaliacaoReceita atualizar(Long id, AvaliacaoReceita avaliacao) {
        AvaliacaoReceita existente = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        existente.setNota(avaliacao.getNota());
        existente.setComentario(avaliacao.getComentario());

        return avaliacaoRepository.save(existente);
    }

    public void deletar(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}