package view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import control.Controller;
import model.Funcionario;

/**
 * @author Diogo
 *
 */
public class TelaMenuMedico extends Tela {

	private static final long serialVersionUID = 1L;
	private JMenuBar jmPrincipal = new JMenuBar();
	private JMenu jmBusca = new JMenu("Busca");
	private JMenu jmOpcoes = new JMenu("Opções");
	private JMenuItem jmBuscProntuario = new JMenuItem("Buscar Prontuário");
	private JMenuItem jmBuscPaciente = new JMenuItem("Buscar Paciente");
	private JMenuItem jmAgBus = new JMenuItem("Buscar Agendamentos");
	private JMenuItem jmSair = new JMenuItem("Sair");
	private JPanel jp = new JPanel();
	private JTable tabela;
	private JScrollPane barraRolagem;
	public JDesktopPane jdPane = new JDesktopPane();
	private Controller controle;
	private JLabel titulo;

	public TelaMenuMedico(Funcionario f) {
		
		preencherCabecalhoTabela();
		controle = new Controller(this, f);
		getContentPane().add(jdPane);
		jdPane.setBounds(0, 0, this.getWidth(), this.getHeight());
		jmPrincipal.add(jmOpcoes);
		jmPrincipal.add(jmBusca);
		
		jmBusca.add(jmBuscProntuario);
		jmBusca.add(jmAgBus);
		jmBusca.add(jmBuscPaciente);
		jmOpcoes.add(jmSair);
		
		setJMenuBar(jmPrincipal);		
		
		titulo = new JLabel("Consultas do dia");
		titulo.setBounds(15, 0, 300, 40);
		titulo.setFont(new Font("Serif", 30, 25));
		
		barraRolagem.setBounds(0, 40, 200, this.getHeight()-40);
		jp.setLayout(null);
		jp.setBounds(this.getWidth()-200, 0, 200, this.getHeight());
		jp.add(titulo);
		jp.add(barraRolagem);
		
		jdPane.add(jp);
		
		jmBuscProntuario.addActionListener(controle);
		jmAgBus.addActionListener(controle);
		jmBuscPaciente.addActionListener(controle);
		jmSair.addActionListener(controle);
		setVisible(true);
		
		this.tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getClickCount()==2){
					Date data = new Date();
					String CPF = tabela.getValueAt(tabela.getSelectedRow(), 2).toString();
					jmBuscProntuario.doClick();
					controle.gettProntuario().setCampoCpf(CPF);
					controle.gettProntuario().getPesquisar().doClick();
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					df.format(data);
					controle.gettProntuario().getComboData().setSelectedItem(df.format(data).toString());
					controle.gettProntuario().getComboHorario().setSelectedItem(tabela.getValueAt(tabela.getSelectedRow(), 1).toString());
				}
			}
		});
	}
	
	
	public void preencherCabecalhoTabela() {

		tabela = new JTable() {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		
		
		tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] {"Paciente", "Horário", "CPF"}));
		barraRolagem = new JScrollPane(barraRolagem);
		barraRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(10, 70, 575, 280);
	}
	

	

	public JMenuItem getJmAgBus() {
		return jmAgBus;
	}



	public void setJmAgBus(JMenuItem jmAgBus) {
		this.jmAgBus = jmAgBus;
	}


	public JMenuBar getJmPrincipal() {
		return jmPrincipal;
	}

	public void setJmPrincipal(JMenuBar jmPrincipal) {
		this.jmPrincipal = jmPrincipal;
	}

	public JDesktopPane getJdPane() {
		return jdPane;
	}

	public void setJdPane(JDesktopPane jdPane) {
		this.jdPane = jdPane;
	}

	public JMenu getJmBusca() {
		return jmBusca;
	}

	public void setJmBusca(JMenu jmBusca) {
		this.jmBusca = jmBusca;
	}

	public Controller getControle() {
		return controle;
	}

	public void setControle(Controller controle) {
		this.controle = controle;
	}

	public JMenuItem getJmBuscProntuario() {
		return jmBuscProntuario;
	}

	public void setJmBuscProntuario(JMenuItem jmBuscProntuario) {
		this.jmBuscProntuario = jmBuscProntuario;
	}

	public JMenuItem getJmBuscPaciente() {
		return jmBuscPaciente;
	}

	public void setJmBuscPaciente(JMenuItem jmBuscPaciente) {
		this.jmBuscPaciente = jmBuscPaciente;
	}

	public JMenu getJmOpcoes() {
		return jmOpcoes;
	}

	public void setJmOpcoes(JMenu jmOpcoes) {
		this.jmOpcoes = jmOpcoes;
	}

	public JMenuItem getJmSair() {
		return jmSair;
	}

	public void setJmSair(JMenuItem jmSair) {
		this.jmSair = jmSair;
	}


	public JPanel getJp() {
		return jp;
	}


	public void setJp(JPanel jp) {
		this.jp = jp;
	}


	public JTable getTabela() {
		return tabela;
	}


	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}


	public JScrollPane getBarraRolagem() {
		return barraRolagem;
	}


	public void setBarraRolagem(JScrollPane barraRolagem) {
		this.barraRolagem = barraRolagem;
	}
	
	
	

}
