package services.operacao;

import java.util.Collections;

import model.DadosPesos;

public class MenorOperacao implements IOperacao {

	@Override
	public void calcular( IDado dados ) {
            dados.addResultados( "Menor", Collections.min( dados.getDados() ) );
	}
}
