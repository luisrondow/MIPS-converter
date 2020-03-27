package mips.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;

import mips.converter.io.ReadFile;

public class Main {

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		Locale.setDefault(new Locale("pt", "BR"));

		System.out.println("\nUse o comando sair para sair do terminal.\n");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		Boolean errorMsg = true;
		String[] terminalArgs;
		try {
			while(!input.equalsIgnoreCase("sair")){
				input = reader.readLine();
				terminalArgs = input.split(" ");
				if (input.length() > 0 && terminalArgs[0].equals("mips32-decode") &&
					(!terminalArgs[1].isEmpty()) && (!terminalArgs[2].isEmpty()))	{
						List<String> MIPScommands = ReadFile.getCommands(terminalArgs[1]);
						if (!MIPScommands.isEmpty()){
							errorMsg = false;
							MIPScommands.forEach(c -> System.out.println(c));
						}
				}
				if (errorMsg) {
					System.out.println("Error: mips32-decode [input path] [output path]");
				}
				errorMsg = true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}