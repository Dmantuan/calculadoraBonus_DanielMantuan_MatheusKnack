package services.operacao;

public class VarianciaOperacao implements IOperacao {

	@Override
	public void calcular( IDado dados ) {
		double p1 = 1 / Double.valueOf( dados.getDados().size() - 1 );
		double somaQuadrado = 0;
		for( int counter = 0; counter < dados.getDados().size(); counter++ ) {
			somaQuadrado += Math.pow( dados.getDados().get( counter ), 2 );
		}
		double soma = 0;
		for( int counter = 0; counter < dados.getDados().size(); counter++ ) {
			soma += dados.getDados().get( counter );
		}
		double p2 = somaQuadrado - ( Math.pow( soma, 2 ) / Double.valueOf( dados.getDados().size() ) );
		dados.addResultados( "Variancia", p1 * p2 );
	}
}
