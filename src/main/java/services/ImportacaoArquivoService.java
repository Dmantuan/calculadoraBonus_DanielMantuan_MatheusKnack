package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ImportacaoArquivoService {

	public ArrayList<Double> importarArquivo( String path ) {

		try ( BufferedReader br = new BufferedReader( new FileReader( path ) ) ) {
			ArrayList<Double> dados = new ArrayList<>();

			String line = br.readLine();

			while( line != null ) {
				dados.add( Double.valueOf( line ) );
				line = br.readLine();
			}

			return dados;

		} catch ( IOException e ) {
			System.out.println( "Error: " + e.getMessage() );

			return null;
		}
	}
}
