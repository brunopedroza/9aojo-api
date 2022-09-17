package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.model.Servico;
import br.com.fiap.abctechapi.repository.ServicoRepository;
import br.com.fiap.abctechapi.service.impl.ServicoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ServicoServiceTest {

    @Mock
    private ServicoRepository servicoRepository;
    private ServicoService servicoService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
        servicoService = new ServicoServiceImpl(servicoRepository);
    }

    @DisplayName("Listando serviços disponíveis, quantidade e posição de serviços na lista correspondem :: Sucesso")
    @Test
    public void listaservicos_successo(){
        Servico servico1 = new Servico(1L, "NomeMock1", "DescricaoMock1", "CategoriaMock1");
        Servico servico2 = new Servico(2L, "NomeMock2", "DescricaoMock2", "CategoriaMock2");
        Servico servico3 = new Servico(3L, "NomeMock3", "DescricaoMock3", "CategoriaMock3");

        when(servicoRepository.findAll()).thenReturn(List.of(servico1, servico2, servico3));

        List<Servico> values = servicoService.getServicoList();

        Assertions.assertEquals(3, values.size());
        Assertions.assertSame(values.get(0), servico1);
        Assertions.assertSame(values.get(1), servico2);
        Assertions.assertSame(values.get(2), servico3);

    }

    @DisplayName("Listando serviços indisponíveis, banco de dados vazio :: Erro")
    @Test
    public void listaservicosvazia_retornaerro() {
        when(servicoRepository.findAll()).thenReturn(List.of());

        List<Servico> values = servicoService.getServicoList();

        Assertions.assertEquals(0,values.size());

    }
}
