package services.operacao;

import model.DadosPesos;

public class QuantidadeOperacao implements IOperacao {

	@Override
	public void calcular( IDado dados ) {
		dados.addResultados( "Quantidade", Double.valueOf( dados.getResultados().size() ) );
	}
}
