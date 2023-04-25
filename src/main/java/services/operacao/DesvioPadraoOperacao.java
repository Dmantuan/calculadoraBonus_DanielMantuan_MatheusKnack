package services.operacao;

public class DesvioPadraoOperacao implements IOperacao {

	@Override
	public void calcular( IDado dados ) {
		double soma = 0;
		{
			double p1 = 1 / Double.valueOf( dados.getDados().size() - 1 );
			double somaAoQuadrado = 0;
			for( int count = 0; count < dados.getDados().size(); count++ ) {
				somaAoQuadrado += Math.pow( dados.getDados().get( count ), 2 );
			}
			for( int counter = 0; counter < dados.getDados().size(); counter++ ) {
				soma += dados.getDados().get( counter );
			}
			double p2 = somaAoQuadrado - ( Math.pow( soma, 2 ) / Double.valueOf( dados.getDados().size() ) );
			dados.addResultados( "DesvioPadrao", Math.sqrt( p1 * p2 ) );
		}

	}
}
