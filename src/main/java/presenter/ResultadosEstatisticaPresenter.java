package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.Resultado;
import view.ResultadosEstatisticaView;
import services.operacao.IDado;

public class ResultadosEstatisticaPresenter {
       
    private DefaultTableModel tmResultados;
    private ArrayList<ArrayList<Resultado>> resultadosListConjunto;
    private ResultadosEstatisticaView view;
    
    public ResultadosEstatisticaPresenter(){
        view = new ResultadosEstatisticaView();
        this.resultadosListConjunto = new ArrayList< ArrayList<Resultado> >();
        
        view.getjTable1().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tmResultados = new DefaultTableModel(
            new Object[][]{},
            new String[]{"estatistica", "Valor"}
        );
        
        tmResultados.setNumRows(0);
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                fechar();
            }
        });
        
        view.getCboxDatas().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                atualizarTabelaResultadosSelecionados();
            }
        });
    }
    
    public ResultadosEstatisticaView getView(){
        return this.view;
    }
    
    private void fechar(){
        view.dispose();
    }
    
    public void addResultados(IDado dados){
        this.resultadosListConjunto.add(dados.getResultados());
        
        view.getCboxDatas().addItem(String.valueOf(dados.getResultados().get(0).getData().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))));
    }
    
    private void atualizarTabelaResultadosSelecionados(){
        tmResultados.setNumRows(0);
        
        int index = this.view.getCboxDatas().getSelectedIndex();
        
        ArrayList<Resultado> resultados = this.resultadosListConjunto.get(index);
        
        
        for( Resultado resultado : resultados ){
            tmResultados.addRow(new Object[]{resultado.getNome(), String.valueOf(resultado.getValor())});
        }
        
        view.getjTable1().setModel(tmResultados);
    }
    
    public ArrayList<ArrayList<Resultado>> getResultadosListConjunto(){
        return this.resultadosListConjunto;
    }
}
