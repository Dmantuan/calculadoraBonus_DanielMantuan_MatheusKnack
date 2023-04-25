package services.operacao;

import model.DadosPesos;

public class SomatorioOperacao implements IOperacao {

	@Override
	public void calcular( IDado dados ) {
		double soma = 0;
		for( int counter = 0; counter < dados.getDados().size(); counter++ ) {
			soma += dados.getDados().get( counter );
		}
		dados.addResultados( "Soma", soma );
	}
}
