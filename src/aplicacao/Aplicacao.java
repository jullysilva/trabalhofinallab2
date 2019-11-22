package aplicacao;

import java.io.IOException;
import java.util.Scanner;

import arquivo.ArquivoTextoEscrita;
import arquivo.ArquivoTextoLeitura;
import candidato.*;
import Empresa.*;

public class Aplicacao {
	public static void main(String[] args) throws Exception {
		int op = 0, opUser = 0;
		int identidade = 0;
		String nomeEmpresa;
		boolean mostraMenu = true;
		//String[] categorias = new String[5];
		
		String[] C = new String[7];
		String[] E = new String[5];
		String lixo;
		Candidato candidato;
		Empresa empresa;
		Scanner leitor = new Scanner(System.in);
		ArquivoTextoLeitura leitorArquivo = new ArquivoTextoLeitura();
		ArquivoTextoEscrita escritorArquivo = new ArquivoTextoEscrita();

		
		System.out.println("Bem vindo a Associa��o para Empregos Dipon�veis!\n");
		
		System.out.println("Para come�ar, informe o nome do banco de dados dos candidatos: ");
		String arqC = leitor.nextLine();
		lixo = leitor.nextLine();
		manipulaCandidato manipuladorC = new manipulaCandidato(leitorArquivo, escritorArquivo, arqC);
		leitorArquivo.abrirArquivo(arqC);
		manipuladorC.carregaDadosArquivo();
		leitorArquivo.fecharArquivo();
		
		leitorArquivo = new ArquivoTextoLeitura();
		escritorArquivo = new ArquivoTextoEscrita();
		System.out.println("Tamb�m, informe o nome do banco de dados das empresas: ");
		String arqE = leitor.nextLine();
		lixo = leitor.nextLine();
		manipulaEmpresa manipuladorE = new manipulaEmpresa(leitorArquivo, escritorArquivo, arqE);
		leitorArquivo.abrirArquivo(arqE);
		manipuladorE.carregaDadosArquivo();
		leitorArquivo.fecharArquivo();
		
		do {
			if (mostraMenu == true) {
				System.out.print("\n\t\t\tMENU DE OP��ES\n\n");
				System.out.print("\t\t1- Candidato\n\t\t2- Empresa\n\t\t"
						+ "3- Buscar vagas\n\t\t4- Candidatos por empresa\n\t\t5- Relatorio\n\t\t"
						+ "6- Sair: ");
				do {
					op = leitor.nextInt();
					lixo = leitor.nextLine();
					if (op < 1 || op > 6)
						System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 5: ");
				} while (op < 1 || op > 6);
			}
			switch(op) {
			case 1:
				do {
					System.out.print("\t\t\t**** CANDIDATO ****\n\t\t1- Buscar\n\t\t" + "2- Inserir\n\t\t3- Alterar\n\t\t4- Remover\n\t\t" + "5- Sair: ");
					opUser = leitor.nextInt();
					lixo = leitor.nextLine();
					switch(opUser) {
					case 1:
						System.out.print("Para pesquisa, Informe a identidade: ");
						do {
							identidade = leitor.nextInt();
							lixo = leitor.nextLine();
							if (identidade <= 0) {
								System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
							}
						} while (identidade <= 0);
						if (manipuladorC.getArvore().pesquisar(identidade) != null)
							System.out.println(manipuladorC.getArvore().pesquisar(identidade).toString());
						else {
							System.out.println("A identidade " + identidade + " n�o consta nos registros.");
							mostraMenu = true;
						}
						break;
					/***********************************************************************************************************/
					case 2:
						System.out.print("\nInforme os dados abaixo:\nIdentidade: ");
						do {
							C[0] = String.valueOf(leitor.nextInt());
							lixo = leitor.nextLine();
							if (Integer.parseInt(C[0]) <= 0)
								System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
						} while (Integer.parseInt(C[0]) <= 0);
						
						if (manipuladorC.getArvore().pesquisar(Integer.parseInt(C[0])) == null) {

							System.out.print("Nome completo: ");
							C[1] = leitor.nextLine();
							System.out.print("Idade: ");
							do {
								C[2] = String.valueOf(leitor.nextInt());
								if (Integer.parseInt(C[2]) < 0)
									System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
							} while (Integer.parseInt(C[2]) < 0);
							
							System.out.print("Sexo ( m / f ): ");
							do {
								C[3] = String.valueOf(leitor.next().charAt(0));
								lixo = leitor.nextLine();
								if (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
										&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"))
									System.out.print("\tInforma��o inv�lida. Informe novamente o sexo ( m / f ): ");
							} while (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
									&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"));

							System.out.print("Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
							do {
								C[4] = leitor.nextLine();
								if (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("pos-doutorado") 
										&& !C[4].equalsIgnoreCase("P�s-Doutorado") && !C[4].equalsIgnoreCase("Gradua��o") 
										&& !C[4].equalsIgnoreCase("graduacao") && !C[4].equalsIgnoreCase("P�s-Gradua��o") 
										&& !C[4].equalsIgnoreCase("pos-graduacao") && !C[4].equalsIgnoreCase("doutorado") 
										&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("mestrado") 
										&& !C[4].equalsIgnoreCase("Doutorado"))
									System.out.print("\tInforma��o inv�lida. Informe novamente a Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
							} while (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("pos-doutorado") 
									&& !C[4].equalsIgnoreCase("P�s-Doutorado") && !C[4].equalsIgnoreCase("Gradua��o") 
									&& !C[4].equalsIgnoreCase("graduacao") && !C[4].equalsIgnoreCase("P�s-Gradua��o") 
									&& !C[4].equalsIgnoreCase("pos-graduacao") && !C[4].equalsIgnoreCase("doutorado") 
									&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("mestrado") 
									&& !C[4].equalsIgnoreCase("Doutorado"));

							
							System.out.print("�rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
							do {
								C[5] = leitor.nextLine();
								if (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
										&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
										&& !C[5].equalsIgnoreCase("administracao") && !C[5].equalsIgnoreCase("Engenharia") 
										&& !C[5].equalsIgnoreCase("engenharia") && !C[5].equalsIgnoreCase("Arte e Design") 
										&& !C[5].equalsIgnoreCase("arte e design") && !C[5].equalsIgnoreCase("Meio Ambiente") 
										&& !C[5].equalsIgnoreCase("meio ambiente") && !C[5].equalsIgnoreCase("Sa�de")
										&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("saude") 
										&& !C[5].equalsIgnoreCase("Tecnologia") && !C[5].equalsIgnoreCase("tecnologia")
										&& !C[5].equalsIgnoreCase("Sociais e Humanas") && !C[5].equalsIgnoreCase("sociais e humanas"))
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente a �rea de atua��o (Administra��o / Engenharia / Arte e Design /"
											+ " Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
							} while (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
									&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
									&& !C[5].equalsIgnoreCase("administracao") && !C[5].equalsIgnoreCase("Engenharia") 
									&& !C[5].equalsIgnoreCase("engenharia") && !C[5].equalsIgnoreCase("Arte e Design") 
									&& !C[5].equalsIgnoreCase("arte e design") && !C[5].equalsIgnoreCase("Meio Ambiente") 
									&& !C[5].equalsIgnoreCase("meio ambiente") && !C[5].equalsIgnoreCase("Sa�de")
									&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("saude") 
									&& !C[5].equalsIgnoreCase("Tecnologia") && !C[5].equalsIgnoreCase("tecnologia")
									&& !C[5].equalsIgnoreCase("Sociais e Humanas") && !C[5].equalsIgnoreCase("sociais e humanas"));
							
							System.out.print("Pretens�o Salarial: ");
							do {
								C[6] = String.valueOf(leitor.nextFloat());
								if (Float.parseFloat(C[6]) < 0.0)
									System.out.print("\tInforma��o inv�lida. Informe novamente o sal�rio pretendido (valor n�o nulo): ");
							} while (Float.parseFloat(C[6]) < 0.0);
							candidato = new Candidato(Integer.parseInt(C[0]), C[1], Integer.parseInt(C[2]), C[3], C[4], C[5], Float.parseFloat(C[6]));
							manipuladorC.gravaDadosArquivo(candidato);
						} else {
							System.out.print("\nCandidato da identidade " + identidade + " j� consta em nosso bando de dados!\n");
							mostraMenu = true;
						}
						break;
					/***********************************************************************************************************/
					case 3:
						int opAtualizar;
							System.out.print("Para atualiza��o de dados, informe a identidade para verificar os dados atuais: ");
							identidade = leitor.nextInt();
							lixo = leitor.nextLine();
							
							if(manipuladorC.getArvore().pesquisar(identidade) != null) {
							do {
								System.out.print("\nOs dados atualiz�veis s�o:\n\t1- Nome\n\t2- Idade\n\t3- Sexo\n\t4- Escolaridade\n\t"
												+ "5- �rea de atua��o\n\t6- Pretens�o Salarial\n\t7- Cancelar\nInforme a op��o desejada: ");
								do {
									opAtualizar = leitor.nextInt();
									lixo = leitor.nextLine();
									if (opAtualizar < 1 || opAtualizar > 7)
										System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 7: ");
								} while (opAtualizar < 1 || opAtualizar > 7);
								
								if(opAtualizar == 1) {
									System.out.print("Informe o nome para atualiza��o: ");
									C[1] = leitor.nextLine();
										manipuladorC.getArvore().pesquisar(identidade).setNome(C[1]);
										manipuladorC.getLista().localizar(identidade).setNome(C[1]);
								}
								else if(opAtualizar == 2) {
									System.out.print("Informe a idade para atualiza��o: ");
									do {
										C[2] = String.valueOf(leitor.nextInt());
										lixo = leitor.nextLine();
										
										if (Integer.parseInt(C[2]) < 0)
											System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
									} while (Integer.parseInt(C[2]) < 0);
										manipuladorC.getArvore().pesquisar(identidade).setIdade(Integer.parseInt(C[2]));
										manipuladorC.getLista().localizar(identidade).setIdade(Integer.parseInt(C[2]));
								}
								else if(opAtualizar == 3) {
									System.out.print("Informe o sexo para atualiza��o ( m / f ): ");
									do {
										C[3] = String.valueOf(leitor.next().charAt(0));
										if (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
												&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"))
											System.out.print("\tInforma��o inv�lida. Informe novamente o sexo ( m / f ): ");
									} while (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
											&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"));
										manipuladorC.getArvore().pesquisar(identidade).setSexo(C[3].toUpperCase());
										manipuladorC.getLista().localizar(identidade).setSexo(C[3].toUpperCase());
								}
								else if(opAtualizar == 4) {
									System.out.print("Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
									do {
										C[4] = leitor.nextLine();
										if (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("P�s-Doutorado") 
												&& !C[4].equalsIgnoreCase("Gradua��o") && !C[4].equalsIgnoreCase("P�s-Gradua��o")
												&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("Doutorado"))
											System.out.print(
													"\tInforma��o inv�lida. Informe novamente a Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
									} while (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("P�s-Doutorado") 
											&& !C[4].equalsIgnoreCase("Gradua��o") && !C[4].equalsIgnoreCase("P�s-Gradua��o")
											&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("Doutorado"));

										manipuladorC.getArvore().pesquisar(identidade).setEscolaridade(C[4]);
										manipuladorC.getLista().localizar(identidade).setEscolaridade(C[4]);
								}
								else if(opAtualizar == 5) {
									System.out.print("�rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
									do {
										C[5] = leitor.nextLine();
										//lixo = leitor.nextLine();
										if (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
												&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
												&& !C[5].equalsIgnoreCase("administracao") && !C[5].equalsIgnoreCase("Engenharia") 
												&& !C[5].equalsIgnoreCase("engenharia") && !C[5].equalsIgnoreCase("Arte e Design") 
												&& !C[5].equalsIgnoreCase("arte e design") && !C[5].equalsIgnoreCase("Meio Ambiente") 
												&& !C[5].equalsIgnoreCase("meio ambiente") && !C[5].equalsIgnoreCase("Sa�de")
												&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("saude") 
												&& !C[5].equalsIgnoreCase("Tecnologia") && !C[5].equalsIgnoreCase("tecnologia")
												&& !C[5].equalsIgnoreCase("Sociais e Humanas") && !C[5].equalsIgnoreCase("sociais e humanas"))
											System.out.print(
													"\tInforma��o inv�lida. Informe novamente a �rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
									} while (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
											&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
											&& !C[5].equalsIgnoreCase("administracao") && !C[5].equalsIgnoreCase("Engenharia") 
											&& !C[5].equalsIgnoreCase("engenharia") && !C[5].equalsIgnoreCase("Arte e Design") 
											&& !C[5].equalsIgnoreCase("arte e design") && !C[5].equalsIgnoreCase("Meio Ambiente") 
											&& !C[5].equalsIgnoreCase("meio ambiente") && !C[5].equalsIgnoreCase("Sa�de")
											&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("saude") 
											&& !C[5].equalsIgnoreCase("Tecnologia") && !C[5].equalsIgnoreCase("tecnologia")
											&& !C[5].equalsIgnoreCase("Sociais e Humanas") && !C[5].equalsIgnoreCase("sociais e humanas"));
										manipuladorC.getArvore().pesquisar(identidade).setAtuacao(C[5]);
										manipuladorC.getLista().localizar(identidade).setAtuacao(C[5]);
								}
								else if(opAtualizar == 6) {
									System.out.print("Informe nova pretens�o salarial para atualiza��o: ");
									do {
										C[6] = String.valueOf(leitor.nextFloat());
										lixo = leitor.nextLine();
										if (Float.parseFloat(C[6]) < 0.0)
											System.out.print("\tInforma��o inv�lida. Informe novamente a pretens�o: ");
									} while (Float.parseFloat(C[6]) < 0.0);
										manipuladorC.getArvore().pesquisar(identidade).setPretensao(Float.parseFloat(C[6]));
										manipuladorC.getLista().localizar(identidade).setPretensao(Float.parseFloat(C[6]));
								}
								else{}
							}while(opAtualizar != 7);
							manipuladorC.atualizarArquivo();
						}
						break;
					/***********************************************************************************************************/
					case 4:
						System.out.print("Informe a identidade: ");
						do {
							identidade = leitor.nextInt();
							lixo = leitor.nextLine();
							
							if (identidade < 0)
								System.out.print("\tInforma��o inv�lida. Informe novamente a identidade: ");
						} while (identidade < 0);
						if(manipuladorC.getArvore().pesquisar(identidade) != null)
							manipuladorC.removerDadosAL(identidade);
						else
							System.out.print("\nCandidato n�o foi localizado no banco de dados!");
						break;
					/***********************************************************************************************************/
					default:
						System.out.print("\nFavor, digite novamente op��o v�lida!\n");
						break;
					}
				}while(opUser != 5);
				break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/				
			case 2:
				do {
					System.out.print("\t\t\t**** EMPRESA ****\n\t\t1- Buscar\n\t\t" + "2- Inserir\n\t\t3- Alterar\n\t\t4- Remover\n\t\t" + "5- Sair: ");
					opUser = leitor.nextInt();
					lixo = leitor.nextLine();
					switch(opUser) {
					case 1:
						System.out.print("Para pesquisa, Informe o nome da Empresa: ");
						nomeEmpresa = leitor.nextLine();
							
						if (manipuladorE.getLista().localizar(nomeEmpresa) != null)
							System.out.println(manipuladorE.getLista().localizar(nomeEmpresa).toString());
						else {
							System.out.println("A Empresa " + nomeEmpresa + " n�o consta nos registros.");
							mostraMenu = true;
						}
						break;
					/***********************************************************************************************************/
					case 2:
						System.out.print("\nInforme os dados abaixo:\nEmpresa: ");
						do {
							E[0] = leitor.nextLine();
							lixo = leitor.nextLine();
							if (manipuladorE.getLista().localizar(E[0]) != null)
								System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
						}while(manipuladorE.getLista().localizar(E[0]) != null);
						
						nomeEmpresa = E[0];
						if (manipuladorE.getLista().localizar(E[0]) == null) {

							System.out.print("�rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
							do {
								E[1] = leitor.nextLine();
								if (!E[1].equalsIgnoreCase("Administra��o") && !E[1].equalsIgnoreCase("Administrac�o")
										&& !E[1].equalsIgnoreCase("Administra�ao") && !E[1].equalsIgnoreCase("Administracao") 
										&& !E[1].equalsIgnoreCase("administracao") && !E[1].equalsIgnoreCase("Engenharia") 
										&& !E[1].equalsIgnoreCase("engenharia") && !E[1].equalsIgnoreCase("Arte e Design") 
										&& !E[1].equalsIgnoreCase("arte e design") && !E[1].equalsIgnoreCase("Meio Ambiente") 
										&& !E[1].equalsIgnoreCase("meio ambiente") && !E[1].equalsIgnoreCase("Sa�de")
										&& !E[1].equalsIgnoreCase("Saude") && !E[1].equalsIgnoreCase("saude") 
										&& !E[1].equalsIgnoreCase("Tecnologia") && !E[1].equalsIgnoreCase("tecnologia")
										&& !E[1].equalsIgnoreCase("Sociais e Humanas") && !E[1].equalsIgnoreCase("sociais e humanas"))
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente a �rea de atua��o (Administra��o / Engenharia / Arte e Design /"
											+ " Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
							} while (!E[1].equalsIgnoreCase("Administra��o") && !E[1].equalsIgnoreCase("Administrac�o")
									&& !E[1].equalsIgnoreCase("Administra�ao") && !E[1].equalsIgnoreCase("Administracao") 
									&& !E[1].equalsIgnoreCase("administracao") && !E[1].equalsIgnoreCase("Engenharia") 
									&& !E[1].equalsIgnoreCase("engenharia") && !E[1].equalsIgnoreCase("Arte e Design") 
									&& !E[1].equalsIgnoreCase("arte e design") && !E[1].equalsIgnoreCase("Meio Ambiente") 
									&& !E[1].equalsIgnoreCase("meio ambiente") && !E[1].equalsIgnoreCase("Sa�de")
									&& !E[1].equalsIgnoreCase("Saude") && !E[1].equalsIgnoreCase("saude") 
									&& !E[1].equalsIgnoreCase("Tecnologia") && !E[1].equalsIgnoreCase("tecnologia")
									&& !E[1].equalsIgnoreCase("Sociais e Humanas") && !E[1].equalsIgnoreCase("sociais e humanas"));
							
							System.out.print("N�mero de vagas: ");
							do {
								E[2] = String.valueOf(leitor.nextInt());
								if (Integer.parseInt(E[2]) < 0)
									System.out.print("\tInforma��o inv�lida. Informe novamente a quantidade de vagas: ");
							} while (Integer.parseInt(E[2]) < 0);
							
							System.out.print("Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
							do {
								E[3] = leitor.nextLine();
								if (!E[3].equalsIgnoreCase("Pos-Doutorado") && !E[3].equalsIgnoreCase("pos-doutorado") 
										&& !E[3].equalsIgnoreCase("P�s-Doutorado") && !E[3].equalsIgnoreCase("Gradua��o") 
										&& !E[3].equalsIgnoreCase("graduacao") && !E[3].equalsIgnoreCase("P�s-Gradua��o") 
										&& !E[3].equalsIgnoreCase("pos-graduacao") && !E[3].equalsIgnoreCase("doutorado") 
										&& !E[3].equalsIgnoreCase("Mestrado") && !E[3].equalsIgnoreCase("mestrado") 
										&& !E[3].equalsIgnoreCase("Doutorado"))
									System.out.print("\tInforma��o inv�lida. Informe novamente a Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
							} while (!E[3].equalsIgnoreCase("Pos-Doutorado") && !E[3].equalsIgnoreCase("pos-doutorado") 
									&& !E[3].equalsIgnoreCase("P�s-Doutorado") && !E[3].equalsIgnoreCase("Gradua��o") 
									&& !E[3].equalsIgnoreCase("graduacao") && !E[3].equalsIgnoreCase("P�s-Gradua��o") 
									&& !E[3].equalsIgnoreCase("pos-graduacao") && !E[3].equalsIgnoreCase("doutorado") 
									&& !E[3].equalsIgnoreCase("Mestrado") && !E[3].equalsIgnoreCase("mestrado") 
									&& !E[3].equalsIgnoreCase("Doutorado"));

							System.out.print("Sal�rio ofertado: ");
							do {
								E[4] = String.valueOf(leitor.nextFloat());
								if (Float.parseFloat(E[4]) < 0.0)
									System.out.print("\tInforma��o inv�lida. Informe novamente o sal�rio oferecido: ");
							} while (Float.parseFloat(E[4]) < 0.0);
							empresa = new Empresa(E[0], E[1], Integer.parseInt(E[2]), E[3], Float.parseFloat(E[4]));
							manipuladorE.gravaDadosArquivo(empresa);
						} else {
							System.out.print("\nA Empresa " + nomeEmpresa + " j� consta em nosso bando de dados!\n");
							mostraMenu = true;
						}
						break;
					/***********************************************************************************************************/
					case 3:
						int opAtualizar;
						System.out.print("Para atualiza��o de dados, informe o nome da empresa para verificar os dados atuais: ");
						E[0] = leitor.nextLine();
						
						if(manipuladorE.getLista().localizar(E[0]) != null) {
						do {
							System.out.print("\nOs dados atualiz�veis s�o:\n\t1- �rea de atua��o\n\t2- Vagas\n\t3- Escolaridade\n\t"
											+ "4- Sal�rio\n\t5- Cancelar\nInforme a op��o desejada: ");
							do {
								opAtualizar = leitor.nextInt();
								lixo = leitor.nextLine();
								if (opAtualizar < 1 || opAtualizar > 5)
									System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 6: ");
							} while (opAtualizar < 1 || opAtualizar > 5);
							
							if(opAtualizar == 1) {
								System.out.print("�rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
								do {
									E[1] = leitor.nextLine();
									//lixo = leitor.nextLine();
									if (!E[1].equalsIgnoreCase("Administra��o") && !E[1].equalsIgnoreCase("Administrac�o")
											&& !E[1].equalsIgnoreCase("Administra�ao") && !E[1].equalsIgnoreCase("Administracao") 
											&& !E[1].equalsIgnoreCase("administracao") && !E[1].equalsIgnoreCase("Engenharia") 
											&& !E[1].equalsIgnoreCase("engenharia") && !E[1].equalsIgnoreCase("Arte e Design") 
											&& !E[1].equalsIgnoreCase("arte e design") && !E[1].equalsIgnoreCase("Meio Ambiente") 
											&& !E[1].equalsIgnoreCase("meio ambiente") && !E[1].equalsIgnoreCase("Sa�de")
											&& !E[1].equalsIgnoreCase("Saude") && !E[1].equalsIgnoreCase("saude") 
											&& !E[1].equalsIgnoreCase("Tecnologia") && !E[1].equalsIgnoreCase("tecnologia")
											&& !E[1].equalsIgnoreCase("Sociais e Humanas") && !E[1].equalsIgnoreCase("sociais e humanas"))
										System.out.print(
												"\tInforma��o inv�lida. Informe novamente a �rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
								} while (!E[1].equalsIgnoreCase("Administra��o") && !E[1].equalsIgnoreCase("Administrac�o")
										&& !E[1].equalsIgnoreCase("Administra�ao") && !E[1].equalsIgnoreCase("Administracao") 
										&& !E[1].equalsIgnoreCase("administracao") && !E[1].equalsIgnoreCase("Engenharia") 
										&& !E[1].equalsIgnoreCase("engenharia") && !E[1].equalsIgnoreCase("Arte e Design") 
										&& !E[1].equalsIgnoreCase("arte e design") && !E[1].equalsIgnoreCase("Meio Ambiente") 
										&& !E[1].equalsIgnoreCase("meio ambiente") && !E[1].equalsIgnoreCase("Sa�de")
										&& !E[1].equalsIgnoreCase("Saude") && !E[1].equalsIgnoreCase("saude") 
										&& !E[1].equalsIgnoreCase("Tecnologia") && !E[1].equalsIgnoreCase("tecnologia")
										&& !E[1].equalsIgnoreCase("Sociais e Humanas") && !E[1].equalsIgnoreCase("sociais e humanas"));
									manipuladorE.getLista().localizar(E[0]).setAtuacao(C[1]);
							}
							else if(opAtualizar == 2) {
								System.out.print("N�mero de vagas: ");
								do {
									E[2] = String.valueOf(leitor.nextInt());
									if (Integer.parseInt(E[2]) < 0)
										System.out.print("\tInforma��o inv�lida. Informe novamente a quantidade de vagas: ");
								} while (Integer.parseInt(E[2]) < 0);
								manipuladorE.getLista().localizar(E[0]).setVagas(Integer.parseInt(E[2]));
							}
							else if(opAtualizar == 3) {
								System.out.print("Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
								do {
									E[3] = leitor.nextLine();
									if (!E[3].equalsIgnoreCase("Pos-Doutorado") && !E[3].equalsIgnoreCase("pos-doutorado") 
											&& !E[3].equalsIgnoreCase("P�s-Doutorado") && !E[3].equalsIgnoreCase("Gradua��o") 
											&& !E[3].equalsIgnoreCase("graduacao") && !E[3].equalsIgnoreCase("P�s-Gradua��o") 
											&& !E[3].equalsIgnoreCase("pos-graduacao") && !E[3].equalsIgnoreCase("doutorado") 
											&& !E[3].equalsIgnoreCase("Mestrado") && !E[3].equalsIgnoreCase("mestrado") 
											&& !E[3].equalsIgnoreCase("Doutorado"))
										System.out.print(
												"\tInforma��o inv�lida. Informe novamente a Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
								} while (!E[3].equalsIgnoreCase("Pos-Doutorado") && !E[3].equalsIgnoreCase("pos-doutorado") 
										&& !E[3].equalsIgnoreCase("P�s-Doutorado") && !E[3].equalsIgnoreCase("Gradua��o") 
										&& !E[3].equalsIgnoreCase("graduacao") && !E[3].equalsIgnoreCase("P�s-Gradua��o") 
										&& !E[3].equalsIgnoreCase("pos-graduacao") && !E[3].equalsIgnoreCase("doutorado") 
										&& !E[3].equalsIgnoreCase("Mestrado") && !E[3].equalsIgnoreCase("mestrado") 
										&& !E[3].equalsIgnoreCase("Doutorado"));
									manipuladorE.getLista().localizar(E[0]).setEscolaridade(E[3]);
							}
							else if(opAtualizar == 4) {
								System.out.print("Informe um novo sal�rio ofertado: ");
								do {
									E[4] = String.valueOf(leitor.nextFloat());
									lixo = leitor.nextLine();
									if (Float.parseFloat(E[4]) < 0.0)
										System.out.print("\tInforma��o inv�lida. Informe novamente o sal�rio: ");
								} while (Float.parseFloat(E[4]) < 0.0);
								manipuladorE.getLista().localizar(E[0]).setAtuacao(E[4]);
							}
							else{}
						}while(opAtualizar != 5);
						manipuladorE.atualizarArquivo();
					}
						break;
					/***********************************************************************************************************/	
					case 4:
						System.out.print("Informe o nome da empresa: ");
						do {
							nomeEmpresa = leitor.nextLine();
							
							if (manipuladorE.getLista().localizar(nomeEmpresa) == null)
								System.out.print("\tInforma��o inv�lida. Informe novamente o nome: ");
						} while (manipuladorE.getLista().localizar(nomeEmpresa) == null);
						if(manipuladorE.getLista().localizar(nomeEmpresa) != null) {
							manipuladorE.getLista().remover(nomeEmpresa);
							manipuladorE.carregaDadosArquivo();
						}
						else
							System.out.print("\nEmpresa n�o foi localizada no banco de dados!");
						break;
					/***********************************************************************************************************/
					default:
						System.out.print("\nFavor, digite novamente op��o v�lida!\n");
						break;
					}	
				}while(opUser != 5);
				break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			case 3:
				
				System.out.print("\t\t****** PESQUISA DE VAGA *******\nInforme �rea de atua��o: ");
				String oportunidade = leitor.nextLine();
				System.out.print("Informe a escolaridade m�xima exigidada: ");
				String escolaridade = leitor.nextLine();
				
				break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/					
			case 4:
				
				break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/	
			case 5:
				
				break;
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/					
			case 6:
				System.out.println("\n\n\t\t************************ OBRIGADA!!! ************************\n\n");
				break;
			default:
				break;
			}
			/*if (mostraMenu == true) {
				System.out.print("\n\t\t\tMENU DE OP��ES\n\n");
				System.out.print("\t\t1- Buscar\n\t\t2- Alterar dados\n\t\t"
						+ "3- Excluir dado\n\t\t4- Inserir dado\n\t\t5- Excluir dados de uma pessoa\n\t\t"
						+ "6- Relat�rio de categoriza��o\n\t\t7- Relat�rio estat�stico\n\t\t8- Sair\n\nInforme a op��o desejada: ");
				do {
					op = leitor.nextInt();
					lixo = leitor.nextLine();
					if (op < 1 || op > 8)
						System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 5: ");
				} while (op < 1 || op > 8);
			}
			switch (op) {
			case 1:
				System.out.print("\t\t1 - Candidato\n\t\t2 - Empresa\nRealizar busca: ");
				opUser = leitor.nextInt();
				switch(opUser) {
				case 1:
					if (mostraMenu == true)
						System.out.print("Para pesquisa, informe a identidade: ");
					else
						op = 4;
					do {
						identidade = leitor.nextInt();
						lixo = leitor.nextLine();
						if (identidade <= 0) {
							System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
						}
					} while (identidade <= 0);
					if (manipuladorC.getArvore().pesquisar(identidade) != null)
						System.out.println(manipuladorC.getArvore().pesquisar(identidade).toString());
					else {
						System.out.println("A identidade " + identidade + " n�o consta nos registros.");
						mostraMenu = true;
					}
				break;
				}
			case 2:
				System.out.print("\t\t1 - Candidato\n\t\t2 - Empresa\nRealizar altera��o de dados: ");
				opUser = leitor.nextInt();
				switch(opUser) {
				case 1:
				int opAtualizar;
					if (mostraMenu == true) {
						System.out.print("Para atualiza��o de dados, informe a identidade para verificar os dados atuais: ");
						mostraMenu = false;
						op = 3;
					} 
					else {
						
						do {
							System.out.print("\nOs dados atualiz�veis s�o:\n\t1- Nome\n\t2- Idade\n\t3- Sexo\n\t4- Escolaridade\n\t"
											+ "5- �rea de atua��o\n\t6- Pretens�o Salarial\n\t7- Cancelar\nInforme a op��o desejada: ");
							do {
								opAtualizar = leitor.nextInt();
								lixo = leitor.nextLine();
								if (opAtualizar < 1 || opAtualizar > 7)
									System.out.print("Op��o inv�lida. Informe novamente uma das op��o entre 1 e 8: ");
							} while (opAtualizar < 1 || opAtualizar > 7);
							
							if(opAtualizar == 1) {
								System.out.print("Informe o nome para atualiza��o: ");
								C[1] = leitor.nextLine();
								if (manipuladorC.getArvore().pesquisar(identidade) != null) {
									manipuladorC.getArvore().pesquisar(identidade).setNome(C[1]);
									manipuladorC.armazenaDadosArquivo(identidade);
								}
							}
							else if(opAtualizar == 2) {
								System.out.print("Informe a idade para atualiza��o: ");
								do {
									C[2] = String.valueOf(leitor.nextInt());
									lixo = leitor.nextLine();
									if (Integer.parseInt(C[2]) < 0)
										System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
								} while (Integer.parseInt(C[2]) < 0);
								if (manipuladorC.getArvore().pesquisar(identidade) != null) {
									manipuladorC.getArvore().pesquisar(identidade).setIdade(Integer.parseInt(C[2]));
									manipuladorC.armazenaDadosArquivo(identidade);
								}
							}
							else if(opAtualizar == 3) {
								System.out.print("Informe o sexo para atualiza��o ( m / f ): ");
								do {
									C[3] = String.valueOf(leitor.next().charAt(0));
									if (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
											&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"))
										System.out.print("\tInforma��o inv�lida. Informe novamente o sexo ( m / f ): ");
								} while (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
										&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"));
								if (manipuladorC.getArvore().pesquisar(identidade) != null) {
									manipuladorC.getArvore().pesquisar(identidade).setSexo(C[3]);
									manipuladorC.armazenaDadosArquivo(identidade);
								}
							}
							else if(opAtualizar == 4) {
								System.out.print("Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
								do {
									C[4] = leitor.nextLine();
									if (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("P�s-Doutorado") 
											&& !C[4].equalsIgnoreCase("Gradua��o") && !C[4].equalsIgnoreCase("P�s-Gradua��o")
											&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("Doutorado"))
										System.out.print(
												"\tInforma��o inv�lida. Informe novamente a Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
								} while (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("P�s-Doutorado") 
										&& !C[4].equalsIgnoreCase("Gradua��o") && !C[4].equalsIgnoreCase("P�s-Gradua��o")
										&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("Doutorado"));
								
								if (manipuladorC.getArvore().pesquisar(identidade) != null) {
									manipuladorC.getArvore().pesquisar(identidade).setEscolaridade(C[4]);
									manipuladorC.armazenaDadosArquivo(identidade);
								}
							}
							else if(opAtualizar == 5) {
								System.out.print("�rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
								do {
									C[5] = leitor.nextLine();
									if (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
											&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
											&& !C[5].equalsIgnoreCase("Engenharia") && !C[5].equalsIgnoreCase("Arte e Desgin") 
											&& !C[5].equalsIgnoreCase("Meio Ambiente") && !C[5].equalsIgnoreCase("Sa�de")
											&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("Tecnologia")
											&& !C[5].equalsIgnoreCase("Sociais e Humanas"))
										System.out.print(
												"\tInforma��o inv�lida. Informe novamente a �rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
								} while (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
										&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
										&& !C[5].equalsIgnoreCase("Engenharia") && !C[5].equalsIgnoreCase("Arte e Desgin") 
										&& !C[5].equalsIgnoreCase("Meio Ambiente") && !C[5].equalsIgnoreCase("Sa�de")
										&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("Tecnologia")
										&& !C[5].equalsIgnoreCase("Sociais e Humanas"));
								if (manipuladorC.getArvore().pesquisar(identidade) != null) {
									manipuladorC.getArvore().pesquisar(identidade).setAtuacao(C[5]);
									manipuladorC.armazenaDadosArquivo(identidade);
								}
							}
							else if(opAtualizar == 6) {
								System.out.print("Informe nova pretens�o salarial para atualiza��o: ");
								do {
									C[6] = String.valueOf(leitor.nextFloat());
									lixo = leitor.nextLine();
									if (Float.parseFloat(C[6]) < 0.0)
										System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
								} while (Float.parseFloat(C[6]) < 0.0);
								if (manipuladorC.getArvore().pesquisar(identidade) != null) {
									manipuladorC.getArvore().pesquisar(identidade).setPretensao(Float.parseFloat(C[6]));
									manipuladorC.armazenaDadosArquivo(identidade);
								}
							}
							else{}
						}while(opAtualizar != 7);
					}
			break;
				}
			case 3:
				System.out.print("\t\t1 - Candidato\n\t\t2 - Empresa\nRealizar exclus�o de dado: ");
				opUser = leitor.nextInt();
				
				switch(opUser) {
				case 1:
					System.out.print("Para excluir um registra, digite a identidade do candidato: ");
					do {
						identidade = leitor.nextInt();
						lixo = leitor.nextLine();
						if (identidade <= 0)
							System.out.print("\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
					} while (identidade <= 0);
					candidato = manipuladorC.getArvore().pesquisar(identidade);
					if(candidato == null) {
						System.out.println("A identidade " + identidade + " n�o consta nos registros.");
					} else {
						manipuladorC.getArvore().remover(identidade);
						/*C[0] = String.valueOf(candidato.getId());
						C[1] = candidato.getNome();
						C[2] = String.valueOf(candidato.getIdade());
						C[3] = String.valueOf(candidato.getSexo());
						C[4] = candidato.getEscolaridade();
						C[5] = candidato.getAtuacao();
						C[6] = String.valueOf(candidato.getPretensao());
						categorias = manipuladorC.defineCategorias(C);
						for (int i = 0; i < 5; i++)
							manipuladorC.getEstruturaLista().getLista(categorias[i]).retirar(candidato.getId());
						manipuladorC.armazenaDadosArquivo();
					}
					break;
				}
			case 4:
				System.out.print("\t\t1 - Candidato\n\t\t2 - Empresa\nInseir dados: ");
				opUser = leitor.nextInt();
				switch(opUser) {
				case 1:
					if (mostraMenu == true) {
						System.out.print("\nInforme os dados abaixo:\nIdentidade: ");
						do {
							C[0] = String.valueOf(leitor.nextInt());
							lixo = leitor.nextLine();
							if (Integer.parseInt(C[0]) <= 0)
								System.out.print(
										"\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
						} while (Integer.parseInt(C[0]) <= 0);
					} else {
						System.out.print("\nInforme os dados abaixo (para sair, escreva \"sair\"):\nIdentidade: ");
						do {
							C[0] = leitor.nextLine();
							if (C[0].equalsIgnoreCase("sair")) {
								mostraMenu = true;
								break;
							} else {
								if (Integer.parseInt(C[0]) > 0)
									C[0] = String.valueOf(C[0]);
								else
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente a identidade (n�mero maior que zero): ");
							}
						} while (!C[0].equalsIgnoreCase("sair") && Integer.parseInt(C[0]) <= 0);
						
					}

					if (!C[0].equalsIgnoreCase("sair")) {
						if (manipuladorC.getArvore().pesquisar(Integer.parseInt(C[0])) == null) {

							System.out.print("Nome completo: ");
							C[1] = leitor.nextLine();
							
							System.out.print("Idade: ");
							do {
								C[2] = String.valueOf(leitor.nextInt());
								lixo = leitor.nextLine();
								if (Integer.parseInt(C[2]) < 0)
									System.out.print("\tInforma��o inv�lida. Informe novamente a idade (valor n�o nulo): ");
							} while (Integer.parseInt(C[2]) < 0);
							
							System.out.print("Sexo ( m / f ): ");
							do {
								C[3] = String.valueOf(leitor.next().charAt(0));
								if (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
										&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"))
									System.out.print("\tInforma��o inv�lida. Informe novamente o sexo ( m / f ): ");
							} while (!C[3].equalsIgnoreCase("m") && !C[3].equalsIgnoreCase("M")
									&& !C[3].equalsIgnoreCase("f") && !C[3].equalsIgnoreCase("F"));

							System.out.print("Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
							do {
								C[4] = leitor.nextLine();
								if (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("P�s-Doutorado") 
										&& !C[4].equalsIgnoreCase("Gradua��o") && !C[4].equalsIgnoreCase("P�s-Gradua��o")
										&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("Doutorado"))
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente a Escolaridade (Gradua��o / P�s-Gradua��o / Mestrado / Doutorado / P�s-Doutorado): ");
							} while (!C[4].equalsIgnoreCase("Pos-Doutorado") && !C[4].equalsIgnoreCase("P�s-Doutorado") 
									&& !C[4].equalsIgnoreCase("Gradua��o") && !C[4].equalsIgnoreCase("P�s-Gradua��o")
									&& !C[4].equalsIgnoreCase("Mestrado") && !C[4].equalsIgnoreCase("Doutorado"));

							
							System.out.print("�rea de atua��o (Administra��o / Engenharia / Arte e Design / Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
							do {
								C[5] = leitor.nextLine();
								if (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
										&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
										&& !C[5].equalsIgnoreCase("Engenharia") && !C[5].equalsIgnoreCase("Arte e Desgin") 
										&& !C[5].equalsIgnoreCase("Meio Ambiente") && !C[5].equalsIgnoreCase("Sa�de")
										&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("Tecnologia")
										&& !C[5].equalsIgnoreCase("Sociais e Humanas"))
									System.out.print(
											"\tInforma��o inv�lida. Informe novamente a �rea de atua��o (Administra��o / Engenharia / Arte e Design /"
											+ " Meio Ambiente / Sa�de / Tecnologia / Sociais e Humanas): ");
							} while (!C[5].equalsIgnoreCase("Administra��o") && !C[5].equalsIgnoreCase("Administrac�o")
									&& !C[5].equalsIgnoreCase("Administra�ao") && !C[5].equalsIgnoreCase("Administracao") 
									&& !C[5].equalsIgnoreCase("Engenharia") && !C[5].equalsIgnoreCase("Arte e Desgin") 
									&& !C[5].equalsIgnoreCase("Meio Ambiente") && !C[5].equalsIgnoreCase("Sa�de")
									&& !C[5].equalsIgnoreCase("Saude") && !C[5].equalsIgnoreCase("Tecnologia")
									&& !C[5].equalsIgnoreCase("Sociais e Humanas"));
							
							System.out.print("Pretens�o Salarial: ");
							do {
								C[6] = String.valueOf(leitor.nextFloat());
								lixo = leitor.nextLine();
								if (Float.parseFloat(C[6]) < 0.0)
									System.out.print("\tInforma��o inv�lida. Informe novamente o sal�rio pretendido (valor n�o nulo): ");
							} while (Float.parseFloat(C[6]) < 0.0);
							candidato = new Candidato(Integer.parseInt(C[0]), C[1], Integer.parseInt(C[2]), C[3], C[4], C[5], Float.parseFloat(C[6]));
							manipuladorC.gravaDadosArquivo(candidato);
						} else
							mostraMenu = true;
					}
					break;
				}
				break;
			case 5:
				
				break;
			case 6:
			case 7:
				RelatorioCandidato relatorioC = manipuladorC.geraIndicadores();
				float totalCandidato = relatorioC.getTotalCandidato();
				float candidatoF = relatorioC.getCandidatoF();
				float candidatoM = relatorioC.getCandidatoM();
				
				float EscGrad = relatorioC.getEscGrad();
				float EscPosGrad = relatorioC.getEscPosGrad();
				float EscMest = relatorioC.getEscMest();
				float EscDout = relatorioC.getEscDout();
				float EscPosDout = relatorioC.getEscPosDout();
				
				float Adm = relatorioC.getTotalAdm();
				float Eng = relatorioC.getTotalEng();
				float MeioAmb = relatorioC.getTotalMeioAmb();
				float SociaHuman =relatorioC.getTotalSociaHuman();
				float ArteDesi = relatorioC.getTotalArteDesi();
				float Tec = relatorioC.getTotalTecno();
				float Saude = relatorioC.getTotalSaude();
				
				float AdmSalario = relatorioC.getAdmSalario();
				float EngSalario = relatorioC.getEngSalario();
				float ArteDesiSalario = relatorioC.getArteDesiSalario();
				float SaudeSalario = relatorioC.getSaudeSalario();
				float MeioAmbSalario = relatorioC.getMeioAmbSalario();
				float TecnoSalario = relatorioC.getTecnoSalario();
				float SociaHumanSalario = relatorioC.getSociaHumanSalario();
				
				System.out.println("\n********** RELAT�RIO DE CATEGORIZA��O **********");
				System.out.printf("Popula��o total: %.0f\n", totalCandidato);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nCaracteriza��o\nSexo\nFeminino: %.0f (%.2f%%)\n", candidatoF, candidatoF/totalCandidato*100);
				System.out.printf("Masculino: %.0f (%.2f%%)\n", candidatoM, candidatoM/totalCandidato*100);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\nEscolaridade\nGradu��o: %.0f (%.2f%%)\n", EscGrad, EscGrad/totalCandidato*100);
				System.out.printf("P�s-Gradua��o: %.0f (%.2f%%)\n", EscPosGrad, EscPosGrad/totalCandidato*100);
				System.out.printf("Mestrado: %.0f (%.2f%%)\n", EscMest, EscMest/totalCandidato*100);
				System.out.printf("Doutorado: %.0f (%.2f%%)\n", EscDout, EscDout/totalCandidato*100);
				System.out.printf("P�s-doutorado: %.0f (%.2f%%)\n", EscPosDout, EscPosDout/totalCandidato*100);
				System.out.printf("____________________________________________________________________________________________________\n");
				System.out.printf("\n�rea de atua��o\nAdministra��o: %.0f (%.2f%%)\n", Adm, AdmSalario);
				System.out.printf("Engenharia: %.0f (%.2f%%)\n", Eng, EngSalario);
				System.out.printf("Meio Ambiente: %.0f (%.2f%%)\n", MeioAmb, MeioAmbSalario);
				System.out.printf("Sociais e Humanas: %.0f (%.2f%%)\n", SociaHuman, SociaHumanSalario);
				System.out.printf("Arte e Design: %.0f (%.2f%%)\n", ArteDesi, ArteDesiSalario);
				System.out.printf("Tecnologia: %.0f (%.2f%%)\n", Tec, TecnoSalario);
				System.out.printf("Sa�de: %.0f (%.2f%%)\n", Saude, SaudeSalario);
				System.out.printf("____________________________________________________________________________________________________\n");
				
				break;
			case 8:
				System.out.println("\n\n\t\t************************ OBRIGADA!!! ************************\n\n");
				break;
			default:
				break;
			}*/
		}while (op != 6);
	}
}
