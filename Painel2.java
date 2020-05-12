import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painel2 extends JFrame implements ActionListener
{ 
  private JLabel jlbDigite ;
  private JTextField txtDigite;
  private JButton limpar,mostrar,sair;
  private JTextArea dig;
  
  public void actionPerformed (ActionEvent e)
  {
    if(e.getSource()==mostrar)
    {String texto=dig.getText();
      JOptionPane.showMessageDialog(null,texto);
    }
    if(e.getSource()==limpar)
    {
      dig.setText("");
    }
    if(e.getSource()==sair)
    { 
      System.exit(0);
     }
  }
  
  
  public Painel2()
  {
    
   //titulo 
   super ("Bloco de anotações");
   //painel de digitação
   JPanel painelPrincipal=new JPanel (new GridLayout(2,1));
   
   //painel da digitação
   JPanel painelDigitacao=new JPanel(new FlowLayout());
   //Criando a etiqueta
  // jlbDigite = new JLabel ("TEXTO:");
   
   //CRiando espaço e tamanho da parte de digitar
    dig=new JTextArea("TEXTO");
  // txtDigite=new JTextField  ("TEXTO",10);
   //Adicionando os objetos na tela
   //painelPrincipal.add(jlbDigite);
   
   //---------------------------------------------------------------------
   //Painel dos botoes
      JPanel painelBotoes=new JPanel (new GridLayout(1,3));
      //Criando os botões
       mostrar=new JButton("Mostrar");
        limpar=new JButton("Limpar");
          sair=new JButton("Sair");
      
      //Adicionando os botoes ao painel botoes
      painelBotoes.add(mostrar);
      painelBotoes.add(limpar);
      painelBotoes.add(sair);
      //Atrinuir observador aos botoes
      mostrar.addActionListener(this);
      limpar.addActionListener(this);
      sair.addActionListener(this);
     //---------------------------------------------------------------------
   //Tela toda
   Container retrato=getContentPane();
     retrato.setLayout(new BorderLayout());
   retrato.add(dig,BorderLayout.CENTER);
   retrato.add(painelBotoes,BorderLayout.SOUTH);
   
   
   
   //Caracteristicas finais
   setSize(700,300);
   
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLocationRelativeTo(null);
   setVisible(true);
   
   
  } 
   //Metodo principal
   public static void main (String [] args)
   {
      SwingUtilities.invokeLater(new Runnable ()
      {
         public void run ()
         {
            new Painel2();
         }
      });
   } 

   
}