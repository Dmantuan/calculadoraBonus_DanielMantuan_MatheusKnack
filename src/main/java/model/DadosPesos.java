package model;

import java.util.ArrayList;
import services.operacao.IDado;

public class DadosPesos implements IDado {

	private ArrayList<Double> pesos;
	private ArrayList<Resultado> resultados;

	public DadosPesos() {
		this.pesos = new ArrayList<>();
		this.resultados = new ArrayList<>();
	}
        
        @Override
	public ArrayList<Double> getDados() {
		return this.pesos;
	}
        
        @Override
        public void addDados( ArrayList<Double> pesos ){
            this.pesos = pesos;
        }
        
        @Override
	public void addResultados( String nome, Double valor ) {
		Resultado resultado = new Resultado( nome, valor );
		this.resultados.add( resultado );
	}

        @Override
	public ArrayList<Resultado> getResultados() {
		return this.resultados;
	}
        
        public void limpasResultados(){
            this.resultados = new ArrayList<>();
        }
}
