package src;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static int menu() 
	{
		int op = JOptionPane.showOptionDialog(null, "Mostrar valores?", "", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Sim", "Não" }, JOptionPane.YES_OPTION);
		return op;
	}

	public static void screen() 
	{
		System.out.println("RELAÇÃO DE JOGADORES E SUAS EQUIPES");
		System.out.println("Seq " + "Cod. " + "Nome de jogador\t\t\t" + "Data Nasc.");
		System.out.println(
				"==============================================================================================================");
	}
	
	public static String formatSeq(int casa, int seq)
	{
        String sequencia = "";
        switch (casa){
        case 3:
            sequencia  = String.format("%03d", seq);
            break;
        case 4:
            sequencia  = String.format("%04d", seq);
            break;
        case 5:
            sequencia  = String.format("%05d", seq);
            break;
        case 6:
            sequencia  = String.format("%06d", seq);
            break;
        }
        return sequencia; 
	}
	
	public static String formatNome(String str)
	{

	    String[] words = str.split("\s");
	    StringBuilder sb = new StringBuilder();

	    for(int i = 0; i < words.length; i++){
	        sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
	        sb.append(" ");
	    }
	    return sb.toString();
	}
	
	public static String formatData(String data) 
	{
		return(data.substring(0, 2) + "/" + data.substring(2, 4) + "/" +
	           data.substring(4, 8));
	}

	public static void main(String[] args) 
	{
		String nome, niver, cod;
		int op = menu(), seq = 0, casa, tSeq = 0;
		ArrayList<Jogador> jogadores = new ArrayList<>();

		if (op == JOptionPane.YES_OPTION) {
			// --------------- SEQUENCIA ---------------------------------------------//
			String sequencia = JOptionPane.showInputDialog("O número inicial da sequência (1 a 99):");
			seq = Integer.parseInt(sequencia);

			if (seq < 1 || seq > 99) {
				sequencia = JOptionPane.showInputDialog("Digite novamente o número da sequência (1 a 99):");
				seq = Integer.parseInt(sequencia);
			}

			String ca = JOptionPane.showInputDialog("Digite o nº de casas (3 a 6):");
			casa = Integer.parseInt(ca);
			if (casa < 3 || casa > 6) {
				ca = JOptionPane.showInputDialog("Digite novamente o nº de casas (3 a 6):");
				casa = Integer.parseInt(ca);
			}

			String Arquivo = "D:\\Meus Arquivos\\Desktop\\teste.txt";
			String textos = LeituraArquivo.Read(Arquivo);
			String linhaTexto[] = textos.split("\n");
			if (textos.isEmpty() == false) {

				screen();
				for (int i = 0; i < linhaTexto.length; i++) {
					Jogador p = new Jogador();
					int x = 42;
					int y = x + 15;
					int z = y + 4;
					ArrayList<Equipe> equipes = new ArrayList<Equipe>();
					cod = linhaTexto[i].substring(0, 4);
					int codg = Integer.parseInt(cod);
					p.setCod(codg);

					nome = linhaTexto[i].substring(4, 34);
					p.setNome(nome);

					niver = linhaTexto[i].substring(34, 42);
					p.setniverDate(niver);

					while (linhaTexto[i].toCharArray().length > x) {
						Equipe eq = new Equipe();
						eq.setEquipe(linhaTexto[i].substring(x, y));
						eq.setDate(linhaTexto[i].substring(y, z));
						equipes.add(eq);
						x = x + 20;
						y = x + 15;
						z = y + 4;
					}

					p.setEquipes(equipes);
					jogadores.add(p);
					Jogador jj = jogadores.get(i);

					tSeq = seq + i;
					System.out.print(formatSeq(casa, tSeq) + " ");
					System.out.println(jj.getCod() + " " + formatNome(jj.getNome()) + "\t\t" + formatData(jj.getniverDate()));
					System.out.println();
					if (equipes.size() == 0) {
						System.out.println("Equipes:(sem informação)");
					} else {
						System.out.println("Equipes:Nome             Dias");
						for (Equipe e : jj.equipes) {
							String e1 = String.valueOf(e.getEquipe());
							String e2 = String.valueOf(e.getDate());
							System.out.println("\t" + e1 + "  " + e2);
						}
					}
					System.out.println(
							"=====================================================================================================================");
				}

			} else {
				System.out.println("Arquivo vazio.");
			}
		}
		if (op == JOptionPane.NO_OPTION)
			System.exit(0);

		if (op == JOptionPane.CANCEL_OPTION)
			System.exit(0);
	}

}
