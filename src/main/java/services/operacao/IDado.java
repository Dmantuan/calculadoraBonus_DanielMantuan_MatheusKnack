package services.operacao;

import java.util.ArrayList;
import model.Resultado;

public interface IDado {
    public ArrayList<Double> getDados();
        
    public void addDados( ArrayList<Double> pesos );
    
    public void addResultados( String nome, Double valor );

    public ArrayList<Resultado> getResultados();
    
    public void limpaResultados();
}
