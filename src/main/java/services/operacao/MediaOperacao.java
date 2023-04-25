package services.operacao;

public class MediaOperacao implements IOperacao {

	@Override
	public void calcular( IDado dados ) {
            double total = 0;
            for( int i = 0; i < dados.getDados().size(); i++ ) {
                    total += dados.getDados().get( i );
            }
            dados.addResultados( "Media", total / dados.getDados().size() );
	}
}
