package br.com.caelum.estoque.ws;

import java.util.Arrays;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "br.com.caelum.estoque.ws.EstoqueWS", serviceName = "EstoqueWS", portName = "EstoqueWS")
public class EstoqueWSImpl implements EstoqueWS {

	@Override
	public ListaItens todosOsItens(Filtros filtros) {
		
		System.out.println("Chamando todo os Itens.");
		ListaItens listaItens = new ListaItens();
		listaItens.item = Arrays.asList(geraItem());
		
		return listaItens;
	}

	@Override
	public CadastrarItemResponse cadastrarItem(CadastrarItem parameters, TokenUsuario tokenUsuario)	throws AutorizacaoFault {
		
		System.out.println("Chamando cadastrarItens");
		CadastrarItemResponse resposta = new CadastrarItemResponse();
		resposta.setItem(geraItem());
		
		return resposta;
	}
	
	public Item geraItem() {
		
		Item item = new Item();
		item.codigo = "MEA";
		item.nome = "MEAN";
		item.quantidade = 5;
		item.tipo = "Livro";
		
		return item;
	}
}
