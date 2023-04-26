package presenter;

import view.ImportarDadosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import services.ImportacaoArquivoService;

import services.operacao.IDado;

public class ImportarDadosPresenter {
    private final ImportarDadosView view;
    private final IDado dados;

    public ImportarDadosPresenter(IDado dados) {
        this.dados = dados;
        view = new ImportarDadosView();
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                fechar();
            }
        });
        
        view.setVisible(true);
    }
    
    public ImportarDadosView getImportarDadosView(){
        return this.view;
    }
    
    private void fechar(){
        view.dispose();
    }
    
    public void salvar(){
        
        String path = view.getTxtDiretorio().getText();
        
        ImportacaoArquivoService importar = new ImportacaoArquivoService();
        ArrayList<Double> newDados = importar.importarArquivo(path);
        
        if (newDados != null){
            dados.addDados(newDados);
            JOptionPane.showMessageDialog(view, "Dados adicionados com sucesso.");
        }
        else{
            JOptionPane.showMessageDialog(view, "Erro ao adicionar os dados.");
        }
        
    }
}
