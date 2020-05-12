import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora  extends JFrame implements ActionListener
{ //textos,titulos e botões
 
  private JLabel visor;
  private JButton mais,menos,vezes,dividir,igual,zero ,um,dois,tres,quatro,cinco,seis,sete,oito,nove,c;
  private String escolha="",dig=""; 
   Pilha p1 = new Pilha(10);
   Pilha digitacao = new Pilha(10);
  //Efeito dos botoes
    public void actionPerformed (ActionEvent e)
    { 
     
     if(e.getSource()==zero||e.getSource()==um||e.getSource()==dois||e.getSource()==tres||e.getSource()==tres||e.getSource()==quatro||e.getSource()==cinco||e.getSource()==seis||e.getSource()==sete||e.getSource()==oito||e.getSource()==nove)
     {
      if(e.getSource()==zero)
      { 
        dig+="0";
        visor.setText(dig);
        
        
      }
      if(e.getSource()==um)
      {
        dig+="1";
        visor.setText(dig);
      
      }
      if(e.getSource()==dois)
      {
        dig+="2";
      visor.setText(dig);
       
      }
      if(e.getSource()==tres)
      { 
        dig+="3";
       visor.setText(dig);
       
      }
      if(e.getSource()==quatro)
      {
        dig+="4";
       visor.setText(dig);
       
      }
      if(e.getSource()==cinco)
      { 
        dig+="5" ;
      visor.setText(dig);
     
      }
      if(e.getSource()==seis)
      {  
        dig+="6";
       visor.setText(dig);
       
      }
      if(e.getSource()==sete)
      {
        dig+="7";
       visor.setText(dig);
       
      }
      if(e.getSource()==oito)
      { 
        dig+="8";
      visor.setText(dig);
          
      }
      if(e.getSource()==nove)
      {
        dig+="9"; 
       visor.setText(dig);
        
      }

     } 
      
      if(e.getSource()==c)
      {
         visor.setText("0");
      }
     
      if(e.getSource()== mais)
      { visor.setText("+");
       if(dig.equals(dig)!=dig.equals(""))
       {
        p1.empilhar( Integer.parseInt(dig));
       }
        
        dig="";
        escolha="+";
      }
      if(e.getSource()==menos)
      { visor.setText("-");
        if(dig.equals(dig)!=dig.equals(""))
       {
        p1.empilhar( Integer.parseInt(dig));
       }
        
        escolha="-";
      }
      if(e.getSource()==vezes)
      { visor.setText("x");
        if(dig.equals(dig)!=dig.equals(""))
       {
        p1.empilhar( Integer.parseInt(dig));
       }
        dig="";
       
        escolha="x";
      }
      
      if(e.getSource()==dividir)
      { visor.setText("/");
        if(dig.equals(dig)!=dig.equals(""))
       {
        p1.empilhar( Integer.parseInt(dig));
       }
        dig="";
        visor.setText(dig);
        escolha="/";
      }
      if(e.getSource()==igual)
      {p1.empilhar( Integer.parseInt(dig));
        dig="";
           //Soma         
           if(escolha.equals(escolha)==escolha.equals("+"))
           { 
             int a1 = p1.desempilhar();   
             int b1=  p1.desempilhar();
             int soma=a1+b1;
            String saida=""+b1+ "+" +a1 +" = "+soma;
              visor.setText(saida);
              p1.empilhar( soma);
              escolha="";
             
           } 
         
           //Subtração       
           if(escolha.equals(escolha)==escolha.equals("-"))
           {
            
            int a1 = p1.desempilhar();   
            int b1=p1.desempilhar();
            int resultado=b1-a1;
               
                  String saida=""+b1+ "-" +a1 +" = "+resultado;
                  visor.setText(saida);
                  p1.empilhar( resultado);
                  escolha="";
                         
           } 

            //divisão        
           if(escolha.equals(escolha)==escolha.equals("/"))
           {
             int a1 = p1.desempilhar();   
             int b1=p1.desempilhar();
            double ad=a1;
            double bd=b1;
            
            double resultado=ad/bd;
            String s = String.format ("%.2f", resultado);
            int r=Integer.parseInt(s);
              String saida=""+a1+ "/" +b1 +" = "+s;
              visor.setText(saida);
            
                p1.empilhar( r);
                escolha="";
           } 

            //Multiplicação         
             if(escolha.equals(escolha)==escolha.equals("x"))
           {
              
            int a1 = p1.desempilhar();   
            int b1=p1.desempilhar();
            int resultado=a1*b1;
            String saida=""+a1+ "x" +b1 +" = "+resultado;
            visor.setText(saida);
            p1.empilhar( resultado);
            escolha="";
           } 

      }
      
    }
  
    
  //Classe do painel
  public Calculadora()
  { //titulo do painel/aba
    super ("CALCULADORA HP 2020");
    //painel do display
    JPanel pDisplay=new JPanel(new GridLayout(2,1));
    //painel do display
    JPanel display=new JPanel(new FlowLayout());
    //texto não editavel que aparecerá no display
    visor=new JLabel ("0");
    visor.setFont(new Font("Serif", Font.BOLD, 30));
    //Adicionando displey no painel
    pDisplay.add(visor);
    
    //------Criando painel para os botoes--------------------
    JPanel painelBotoes=new JPanel(new GridLayout(4,4));
    //criando os botoes
       c=new JButton("C");
    mais=new JButton("+");
   menos=new JButton("-");
   vezes=new JButton("x");
 dividir=new JButton("/");
   igual=new JButton("=");
    zero=new JButton("0");
      um=new JButton("1");
    dois=new JButton("2");
    tres=new JButton("3");
  quatro=new JButton("4");
   cinco=new JButton("5");
    seis=new JButton("6");
    sete=new JButton("7");
    oito=new JButton("8");
    nove=new JButton("9");
    //aumentando a fonte
       c.setFont(new Font("Serif", Font.BOLD, 20));
    mais.setFont(new Font("Serif", Font.BOLD, 20));
   menos.setFont(new Font("Serif", Font.BOLD, 20));
   vezes.setFont(new Font("Serif", Font.BOLD, 20));
 dividir.setFont(new Font("Serif", Font.BOLD, 20));
   igual.setFont(new Font("Serif", Font.BOLD, 20));
    zero.setFont(new Font("Serif", Font.BOLD, 20));
      um.setFont(new Font("Serif", Font.BOLD, 20));
    dois.setFont(new Font("Serif", Font.BOLD, 20));
    tres.setFont(new Font("Serif", Font.BOLD, 20));
  quatro.setFont(new Font("Serif", Font.BOLD, 20));
   cinco.setFont(new Font("Serif", Font.BOLD, 20));
    seis.setFont(new Font("Serif", Font.BOLD, 20));
    sete.setFont(new Font("Serif", Font.BOLD, 20));
    oito.setFont(new Font("Serif", Font.BOLD, 20));
    nove.setFont(new Font("Serif", Font.BOLD, 20));
    

    
    //adicionando os botoes no painel de botoes
   painelBotoes.add(sete);
   painelBotoes.add(oito);
   painelBotoes.add(nove);
   painelBotoes.add(mais);
   painelBotoes.add(quatro);
   painelBotoes.add(cinco);
   painelBotoes.add(seis);
   painelBotoes.add(menos);
   painelBotoes.add(um);
   painelBotoes.add(dois);
   painelBotoes.add(tres);
   painelBotoes.add(vezes);
   painelBotoes.add(zero);
   painelBotoes.add(c);
   painelBotoes.add(igual);
   painelBotoes.add(dividir);
   //Adicionado um observador aos botões, assim serão reconhecidos quando clicados
      c.addActionListener(this);
   mais.addActionListener(this);
  menos.addActionListener(this);
  vezes.addActionListener(this);
dividir.addActionListener(this);
  igual.addActionListener(this);
   zero.addActionListener(this);
     um.addActionListener(this);
   dois.addActionListener(this);
   tres.addActionListener(this);
 quatro.addActionListener(this);
  cinco.addActionListener(this);
   seis.addActionListener(this);
   sete.addActionListener(this);
   oito.addActionListener(this);
   nove.addActionListener(this);

  
  //toda a tela
  Container tela=getContentPane();
      
 // criando borda pro painel
  tela.setLayout(new BorderLayout());
  tela.add(pDisplay,BorderLayout.NORTH);
  tela.add(painelBotoes,BorderLayout.CENTER);
  
  setSize(300,400);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  setVisible(true);

  }
  //Metodo main (principal)
   public static void main(String[] args)
   {
     SwingUtilities.invokeLater(new Runnable()
     { 
        public void run()
        {
         new Calculadora();
        }
        
     });
   }
}