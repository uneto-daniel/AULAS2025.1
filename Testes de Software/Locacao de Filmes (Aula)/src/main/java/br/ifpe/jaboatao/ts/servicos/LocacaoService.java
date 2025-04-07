package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import javax.xml.crypto.Data;

import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(filme.getValor());

		//Entrega no dia seguinte
		locacao.setDataRetorno(ManipulandoDatas.novaDataComDiferencaDeDias(1));
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}
   
}







