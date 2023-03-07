package View;

import javax.swing.JOptionPane;
import Controller.RedesController;
public class Main 
{

	public static void main(String[] args) 
	{
		RedesController cont = new RedesController();
		int opc = 0;
		do
		{
			opc = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de acordo com a tabela abaixo\n 1 - Encontrar os Adaptadores com IPv4\n 2 - Descobrir o tempo medio do ping\n 9 - finalizado"));
			switch (opc)
			{
			case 1: cont.Ip();
			break;
			case 2: cont.ping();
			break;
			case 9: JOptionPane.showMessageDialog(null, "Finalizado");
			break;
			default: JOptionPane.showMessageDialog(null, "Invalido");
			break;
			}
		}while(opc !=9);
	}

}

