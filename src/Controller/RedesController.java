package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class RedesController 
{
	public RedesController()
	{
		super();
	}
	//Codigo para identificar qual é o tipo de SO
	public String os() 
	{
		
		String os = System.getProperty("os.name");
		String[] vt = os.split(" ");
		
		if(os.contains("Windows")) 
		{
			os = vt[0];
		} else 
		{
			if(os.contains("Linux"))
			{
				os = vt[0];
			}
		}
		
		return os;
	}
	//Codigo que chama o IP e mostra se tiver IPv4
	public void Ip()
	{
		String cod = os();
		String adapt = "";
		if(cod.contains("Windows"))
		{
			cod = "ipconfig";
		}else
		  {
			if(cod.contains("Linux"))
			{
				cod = "ifconfig";
			}
			
		  }
		try
		{
			Process p =Runtime.getRuntime().exec(cod);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha!=null)
			{
				if(linha.contains("adapt"))
				{
					adapt = linha;
				}else
				 {
					if(linha.contains("IPv4"))
					{
						System.out.println(adapt + " " + linha);
						
					}
				 }
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}catch (IOException e)
		 {
			e.printStackTrace();
		 }
	}
	//Codigo para saber o tempo médio do ping
	public void ping()
	{
		String Sist=os();
		String cod = "";
		if (Sist.contains("Windows"))
		{
			cod = " PING -4 -n 10 www.google.com.br";
		}else
		 {
			if(Sist.contains("Linux"))
			{
				cod = "PING -4 -c 10 www.google.com.br";
			}
		 }
		try 
		{
			Process p = Runtime.getRuntime().exec(cod);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null)
			{
				if(Sist.contains("Windows"))
				{
					if(linha.contains("dia"))
					{
						String vt[]= linha.split(" = ");
						System.out.println(" A media eh " + vt[3]);
					}
				}
				if(Sist.contains("Linux"))
				{
					if(linha.contains("rtt"))
					{
						String vt[]= linha.split("/");
						System.out.println("A media eh " + vt[4]);
					}
				}
				linha = buffer.readLine();
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}


