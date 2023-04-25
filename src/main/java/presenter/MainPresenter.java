package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.DadosPesos;
import services.CalculadoraEstatisticaService;
import view.PrincipalView;
import view.ImportarDadosView;
import services.operacao.IDado;

public class MainPresenter {
    private DefaultTableModel tmDados;
    private IDado dados;
    private PrincipalView view;
    private ResultadosEstatisticaPresenter resultadosPresenter;
    
    public void MainPresenter(){
        dados = new DadosPesos();
        
        this.resultadosPresenter = new ResultadosEstatisticaPresenter();
        
        this.view = new PrincipalView(dados);
        
        view.getTxtQuantidade().setEditable(false);
        
        //-----Tabela
        tmDados = new DefaultTableModel(
            new Object[][]{},
            new String[]{"peso"}
        );
        
        view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tmDados.setNumRows(0);
        
        view.getTable().setModel(tmDados);
        
        //----Botoes do menu
        view.getBtn_importarDados().addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                importarDados(dados);                
            }
        });
        
        view.getBtn_CalcularEstatistica().addActionListener( new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae){
               calcularEstatisticas(dados);
           }
        });
        
        view.getBtn_VisualizarResultado().addActionListener( new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent ae){
               visualizarResultados();
           }
        });
        
        view.setVisible(true);
    }
    
    private void importarDados(IDado dados){
        ImportarDadosPresenter importarPresenter = new ImportarDadosPresenter(dados);
        
        ImportarDadosView importarView = importarPresenter.getImportarDadosView();
        importarView.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                importarPresenter.salvar();
                atualizarTabela(dados);
            }
        });
        view.getTable().repaint();
    }
    
    private void calcularEstatisticas(IDado dados){
        if(!dados.getDados().isEmpty()){
            CalculadoraEstatisticaService calculo = new CalculadoraEstatisticaService();
            calculo.calcular(dados);
            addResultadoList_ResultadosPresenter(dados);
            JOptionPane.showMessageDialog(view, "Estatisticas calculadas com sucesso");
            dados.limpasResultados();
        }
        else{
            JOptionPane.showMessageDialog(view, "Falhas em carcular as estatisticas");
        }
    }
    
    private void addResultadoList_ResultadosPresenter(IDado dados){
        this.resultadosPresenter.addResultados(dados);
    }
    
    private void visualizarResultados(){
        if(this.resultadosPresenter.getResultadosListConjunto().isEmpty()){
            JOptionPane.showMessageDialog(view, "Nao tem resultados para mostrar, por favor execute o calculador de estatisticas");
        }
        else{
            this.resultadosPresenter.getView().setVisible(true);
        }
    }
    
    private void atualizarTabela(IDado dados){
        
        tmDados.setNumRows(0);
        
        int quantidade = 0;
        ListIterator<Double> it = dados.getDados().listIterator();
        Double peso;
        while (it.hasNext()){
            peso = it.next();
            tmDados.addRow(new Object[]{peso});
            quantidade++;
        }
        view.getTxtQuantidade().setText(String.valueOf(quantidade));
        view.getTable().setModel(tmDados);
    }
}
