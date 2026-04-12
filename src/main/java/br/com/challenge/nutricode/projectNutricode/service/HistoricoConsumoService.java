package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.HistoricoConsumo;
import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.HistoricoConsumoRepository;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.ReceitaRepository;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.UsuarioRepository;
import br.com.challenge.nutricode.projectNutricode.integration.client.ReceitaClient;
import br.com.challenge.nutricode.projectNutricode.messaging.HistoricoProducer;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.ReceitaResumoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoricoConsumoService {

    private final HistoricoConsumoRepository historicoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ReceitaRepository receitaRepository;
    private final ReceitaClient receitaClient;
    private final HistoricoProducer historicoProducer;

    public HistoricoConsumo salvar(HistoricoConsumo historico) {
        if (historico.getUsuario() == null || historico.getUsuario().getId() == null) {
            throw new RuntimeException("O histórico precisa ter um usuário");
        }

        if (historico.getReceita() == null || historico.getReceita().getId() == null) {
            throw new RuntimeException("O histórico precisa ter uma receita");
        }

        Usuario usuario = usuarioRepository.findById(historico.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Receita receita = receitaRepository.findById(historico.getReceita().getId())
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        ReceitaResumoDTO resumoReceita = receitaClient.buscarResumo(receita.getId());

        if (resumoReceita == null) {
            throw new RuntimeException("Não foi possível consultar a receita via Feign");
        }

        historico.setUsuario(usuario);
        historico.setReceita(receita);

        HistoricoConsumo historicoSalvo = historicoRepository.save(historico);

        String mensagem = "Histórico criado -> usuário: " + usuario.getEmail()
                + ", receita: " + resumoReceita.getNome()
                + ", quantidade: " + historico.getQuantidade();

        historicoProducer.enviarMensagem(mensagem);

        return historicoSalvo;
    }

    public List<HistoricoConsumo> listarTodos() {
        return historicoRepository.findAll();
    }

    public Optional<HistoricoConsumo> buscarPorId(Long id) {
        return historicoRepository.findById(id);
    }

    public List<HistoricoConsumo> buscarPorUsuarioId(Long usuarioId) {
        return historicoRepository.findByUsuarioId(usuarioId);
    }

    public List<HistoricoConsumo> buscarPorReceitaId(Long receitaId) {
        return historicoRepository.findByReceitaId(receitaId);
    }

    public HistoricoConsumo atualizar(Long id, HistoricoConsumo historico) {
        HistoricoConsumo existente = historicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Histórico não encontrado"));

        existente.setDataConsumo(historico.getDataConsumo());
        existente.setQuantidade(historico.getQuantidade());

        return historicoRepository.save(existente);
    }

    public void deletar(Long id) {
        historicoRepository.deleteById(id);
    }
}