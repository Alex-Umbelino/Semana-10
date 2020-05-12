import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RelogioPanel extends JFrame implements ActionListener
{
  // private JTextField tempo;
   private JLabel  tempo;
   private JButton ticTac,hora,minuto;
   
   
   Relogio relogio=new Relogio();
  //Ações dos botoes
   public void actionPerformed(ActionEvent e)
   {  
      if(e.getSource()==ticTac)
      { String a=relogio.mostra();
        
         tempo.setFont(new Font("Serif", Font.BOLD, 200));
        
     
          tempo.setText(relogio.mostra());
         
         relogio.ticTac();
         
      }
      if(e.getSource()==hora)
      {//edita a hora
        tempo.setFont(new Font("Serif", Font.BOLD, 200));
        relogio.setHora();
        tempo.setText(relogio.mostra());
      }
      if(e.getSource()==minuto)
      {//edita o minuto
        tempo.setFont(new Font("Serif", Font.BOLD, 200));
        relogio.setMinuto();
        tempo.setText(relogio.mostra());
      }
   
   }
  
   public RelogioPanel()
   { 
     
      //titulo
      super ("RELÓGIO");
    //Ficarão posicionados dois objetos,um em cada linha (duas linhas) e em uma coluna
      JPanel painelPrincipal = new JPanel(new GridLayout(2,1));
    //Painel do relogio:
      JPanel painelTime=new JPanel(new FlowLayout());
    //texto do relogio
       tempo=new JLabel("Hora");
      //tempo=new JTextField("Hora",5);
    //adicionando no painel na parte de cima
       
      painelPrincipal.add(tempo);
    
    //Painel dos botões
      JPanel painelBotoes= new JPanel(new GridLayout(1,3));
    //Criando os botoes:
      ticTac=new JButton("TicTac");
      hora=new JButton("HORA");
      minuto=new JButton("MINUTO");
    //adicionando os botoes no painel de botoes
      painelBotoes.add(ticTac);
      painelBotoes.add(hora);
      painelBotoes.add(minuto);
    
    //atribuindo observador aos botoes
      ticTac.addActionListener(this);
      hora.addActionListener(this);
      minuto.addActionListener(this);
    //motando a tela toda
      Container retrato=getContentPane();
      retrato.setLayout(new BorderLayout());
      retrato.add(painelPrincipal,BorderLayout.CENTER);
      retrato.add(painelBotoes,BorderLayout.SOUTH);
    
    //definindo tamanho da tela 
      setSize(800,600);
      painelTime.setSize(500, 150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
    
    
   }
   
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(
         new Runnable ()
         {
            public void run()
            {
               new RelogioPanel();
            }
         
         });
   
   //System.out.println(relogio.mostra());
         //relogio.ticTac();
   }
}

