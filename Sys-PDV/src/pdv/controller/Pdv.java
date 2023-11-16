package pdv.controller;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import pdv.dao.EstoqueDao;
import pdv.dao.PessoaDao;
import pdv.dao.ProdutoDao;
import pdv.model.Caixa;
import pdv.model.Estoque;
import pdv.model.Funcionario;
import pdv.model.ItemVenda;
import pdv.model.Produto;
import pdv.model.Venda;
import pdv.view.AdminView;
import pdv.view.EntradaView;
import pdv.view.GerenciadorProdutosView;
import pdv.view.Login;
import pdv.view.VendasView;

public class Pdv {
	public static final String USUARIO = "admin";
	public static final String SENHA	= "qwe123";
	
	private Estoque estoque;
	private Map<Integer, Venda> 	  vendas;
	private Map<Integer, Caixa> 	  caixas;
	private ArrayList<Funcionario> funcionarios;
	private Venda venda;
	private VendasView vendasView;
	private AdminView adminView;
	private GerenciadorProdutosView gerenciadorProdutosView;
	private ProdutoDao produtoDao;
	private EstoqueDao estoqueDao;
	private PessoaDao  pessoaDao;
	
	public Pdv() {
		this.produtoDao = new ProdutoDao();
		this.estoqueDao = new EstoqueDao();
		this.pessoaDao  = new PessoaDao();
		
		this.estoque		 = this.estoqueDao.getEstoqueDB();
		this.funcionarios 	 = this.pessoaDao.getFuncionarios();

		this.vendas 	 	 = new HashMap<Integer, Venda>();
		this.caixas 	 	 = new HashMap<Integer, Caixa>();
		this.venda		 = new Venda();
		this.vendasView	 = new VendasView();
		this.gerenciadorProdutosView = new GerenciadorProdutosView();
		this.adminView = new AdminView();
		
		new EntradaView(adminView);
		this.setAcoesBtns();
	}
	//inicia caixa com saldo indicado
	public void abrirCaixa(double saldoInicial) {
		
	}
	public void fecharCaixa() {
		
	}
	public void adicionarFuncionario() {
		
	}
	public void removerFuncionario() {
		
	}
	
	//metodos da mainView-------------------------------------------------------------------------------------------
	public void setAcoesBtns() {	
		
		this.vendasView.getTextCod().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
              Produto produto = vendasView.getProduto(Integer.parseInt(vendasView.getTextCod().getText()), estoque);
               if(produto == null){
            	   //throw new MsgException("Produto não encontrado!");
            	   JOptionPane.showMessageDialog(vendasView, "Produto não encontrado!");
            	   return;
               }

               int      quantidade  = Integer.parseInt(vendasView.getTextQtd().getText());
               double   total       = (double) (produto.getPreco() * quantidade); 
                
                ItemVenda itemVenda = new ItemVenda(produto, quantidade, total);

                if(venda == null){ venda = new Venda(); }

                venda.adicionarItem(itemVenda);
                venda.setData(LocalDate.now());
              
                vendasView.atualizarVenda(venda);
            }
        });
        vendasView.getBtnAdd().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendasView.add();     
            }
        });
        vendasView.getBtnRem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vendasView.rem();     
            }
        });
        
        vendasView.getBtnCancelar().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		vendasView.cancelar(venda);
        	}
        });

        vendasView.getBtnPainelAdm().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(venda.getItens().size() > 0) {
        			JOptionPane.showMessageDialog(vendasView.getBtnPainelAdm(), "Finalize a venda primeiro!");
        			return;
        		}
        		new Login(vendasView,adminView);
        	}
        });
        
        vendasView.getBtnFinalizar().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {        		
        		vendasView.showJanelaFinalizacao(venda);
        		venda = new Venda();
        	}
        });
        vendasView.getSelectVendedor().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
        vendasView.addVendedores(this.funcionarios);
        
        adminView.getBtnGerenciarCaixas().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        adminView.getBtnGerenciarProdutos().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		adminView.hiddenAdminView();
        		gerenciadorProdutosView.showGerencioadorProdutos();
        	}
        });
        adminView.getBtnVender().addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		adminView.hiddenAdminView();
        		vendasView.showVendasView();
        	}
        });
        
        gerenciadorProdutosView.getBtnAtualizar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gerenciadorProdutosView.getTextEstoque().setText(estoque.toString());
				
			}
		});
        
        this.gerenciadorProdutosView.getBtnCadastrar().addActionListener(new ActionListener() {        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		produtoDao.inserirProdutoDB(gerenciadorProdutosView.getProduto());
        	}
        });
        this.gerenciadorProdutosView.getbtnPainelAdmin().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				gerenciadorProdutosView.hiddenGerenciadorProdutos();
				adminView.showAdminView();				
			}
		});
        this.gerenciadorProdutosView.getBtnRemover().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int cod = 0;

				while (true) {
				    String input = JOptionPane.showInputDialog("Digite um valor inteiro:");

				    if (input.matches("\\d+")) {
				        cod = Integer.parseInt(input);
				        produtoDao.removerProdutoDB(cod);
				        break;
				    } else {
				        JOptionPane.showMessageDialog(null, "Entrada inválida! Digite apenas números inteiros.");
				    }
				}
				
				
			}
		});
        
        filtrarNumeros(gerenciadorProdutosView.getTextQtdEstoque());
        filtrarNumeros(gerenciadorProdutosView.getTextPreco());
        filtrarNumeros(vendasView.getTextCod());
	}
	  public static void showMensagem(Component componet, String mensagem, String titulo,int tipoMensagem) {
	        JOptionPane.showMessageDialog(componet, mensagem, titulo, tipoMensagem);
	  }
	  public static int showMessageOpcao(Component componente, String mensagem, String titulo, int tipoMensagem) {
	        return JOptionPane.showConfirmDialog(componente, mensagem, titulo, tipoMensagem);
	  }
	  public static String showInput(Component componente, String mensagem, String titulo, int tipoMensagem) {
	        return JOptionPane.showInputDialog(componente, mensagem, titulo, tipoMensagem);
      }
	public static void filtrarNumeros(JTextField text) {
        ((AbstractDocument) text.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String novoTexto = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (isNumero(novoTexto)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isNumero(String text) {
                for (char c : text.toCharArray()) {
                    if (!Character.isDigit(c) && c != '.') {
                        return false;
                    }
                }

                if (text.indexOf('.') != text.lastIndexOf('.')) {
                    return false;
                }

                return true;
            }
        });
    }
	
}
