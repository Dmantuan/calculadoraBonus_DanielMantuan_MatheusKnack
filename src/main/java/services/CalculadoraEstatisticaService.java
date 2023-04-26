package services;

import java.util.ArrayList;
import services.operacao.IDado;
import services.operacao.DesvioPadraoOperacao;
import services.operacao.IOperacao;
import services.operacao.MaiorOperacao;
import services.operacao.MediaOperacao;
import services.operacao.MenorOperacao;
import services.operacao.QuantidadeOperacao;
import services.operacao.SomatorioOperacao;
import services.operacao.VarianciaOperacao;

public class CalculadoraEstatisticaService {

	private final ArrayList<IOperacao> metodosOperacoes;

	public CalculadoraEstatisticaService() {

		metodosOperacoes = new ArrayList<>();

		this.metodosOperacoes.add( new DesvioPadraoOperacao() );
		this.metodosOperacoes.add( new MaiorOperacao() );
		this.metodosOperacoes.add( new MediaOperacao() );
		this.metodosOperacoes.add( new MenorOperacao() );
		this.metodosOperacoes.add( new SomatorioOperacao() );
		this.metodosOperacoes.add( new VarianciaOperacao() );
		this.metodosOperacoes.add( new QuantidadeOperacao() );
	}

	public void calcular( IDado dados ) {
            for( IOperacao metodoOperacoes : metodosOperacoes ) {
		metodoOperacoes.calcular( dados );
            }
	}
}
