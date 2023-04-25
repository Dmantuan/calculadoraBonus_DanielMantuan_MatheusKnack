package services.operacao;

import java.util.Collections;

public class MaiorOperacao implements IOperacao {

	@Override
	public void calcular( IDado dados ) {
		dados.addResultados( "Maior", Collections.max( dados.getDados() ) );
	}
}
