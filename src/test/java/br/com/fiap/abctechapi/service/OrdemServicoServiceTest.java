package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.model.OrdemServico;
import br.com.fiap.abctechapi.model.Servico;
import br.com.fiap.abctechapi.repository.OrdemServicoRepository;
import br.com.fiap.abctechapi.repository.ServicoRepository;
import br.com.fiap.abctechapi.service.impl.OrdemServicoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static org.mockito.Mockito.*;

@SpringBootTest
public class OrdemServicoServiceTest {

    @Mock
    private ServicoRepository servicoRepository;

    @Mock
    private OrdemServicoRepository ordemServicoRepository;

    private OrdemServicoService ordemServicoService;

    @BeforeEach
    public void init() {
        ordemServicoService = new OrdemServicoServiceImpl(ordemServicoRepository, servicoRepository);
        when(servicoRepository.findById(any())).
                thenReturn(
                        Optional.of(new Servico(1L, "Teste", "Teste description:", "Categoria Teste")));

    }

    @Test
    public void os_nao_nula() {
        Assertions.assertNotNull(ordemServicoService);
    }

    @Test
    public void os_nao_possui_minimo_servicos() {
        OrdemServico novaOs = new OrdemServico();
        novaOs.setIdPrestador(111L);

        Assertions.assertThrows(Exception.class,() -> ordemServicoService.salvarOrdemServico(novaOs, List.of()));
        verify(ordemServicoRepository, times(0)).save(novaOs);
    }

    @Test
    public void os_excede_maximo_servicos() {
        OrdemServico novaOs = new OrdemServico();
        novaOs.setIdPrestador(999L);

        Assertions.assertThrows(Exception.class, () -> ordemServicoService.salvarOrdemServico(novaOs, List.of(1L,2L,3L,4L,5L,6L,7L,8L,9L,10L,11L,12L,13L,14L,15L,16L)));
        verify(ordemServicoRepository, times(0)).save(novaOs);
    }

    @Test
    public void os_criada_com_sucesso() throws Exception {
        OrdemServico novaOs = new OrdemServico();
        novaOs.setIdPrestador(777L);

        ordemServicoService.salvarOrdemServico(novaOs, List.of(1L,2L,3L,4L,5L));
        verify(ordemServicoRepository, times(1)).save(novaOs);
    }



}
