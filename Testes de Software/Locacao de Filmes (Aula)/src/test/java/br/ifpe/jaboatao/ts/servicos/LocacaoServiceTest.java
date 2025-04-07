package br.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoServiceTest {

    @Test
    public void deveAlugarFilmeComSucesso() {
        // Cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 01");
        Filme filme = new Filme("Titulo 1", 2, 4.0);

        // Ação
        Locacao locacao = service.alugarFilme(usuario, filme);

        // Verificação
        assertEquals(4.0, locacao.getValorLocacao());
        assertEquals("Usuario 01", locacao.getUsuario().getNome());
        assertEquals("Titulo 1", locacao.getFilme().getTitulo());
        assertEquals(2, locacao.getFilme().getEstoque());
        assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataLocacao(), new Date()));
        assertTrue(ManipulandoDatas.boDatasIguais(locacao.getDataRetorno(), ManipulandoDatas.novaDataComDiferencaDeDias(1)));
    }
}
