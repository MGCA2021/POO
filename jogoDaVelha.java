package AC1;

/*  	MATHEUS DE JESUS OLIVEIRA
 * 	GABRIELA RODRIGUES OLIVEIRA LIMA
 * 	AC1
 * 	CIENCIA DA COMPUTAÇÃO (MANHÃ)
 */

import java.util.Scanner;

public class jogoDaVelha {
	public static void main(String[] args) {
		game();
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static char[][] initialize() {
		char[][] matriz = new char[3][3];
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				matriz[linha][coluna] = ' ';
			}
		}
		return matriz;

		// --------------------------------------------------------------------------------------------------------------------

	}

	public static boolean step(char M[][], int lin, int col, char gamer) {
		
		if (M[lin][col] == ' ') {
			M[lin][col] = gamer;
			return true;
		} else {
			return false;
		}

	}

	// --------------------------------------------------------------------------------------------------------------------

	public static int status(char M[][]) {

		int valor = 9;

		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				if (M[linha][coluna] == ' ') {
					// tem algum valor vazio, então segue o jogo
					valor = -1;
				}
			}
		}

		// Verificar horizontal se ganhou
		if ((M[0][0] == 'X' && M[0][1] == 'X' && M[0][2] == 'X') || (M[1][0] == 'X' && M[1][1] == 'X' && M[1][2] == 'X')
				|| (M[2][0] == 'X' && M[2][1] == 'X' && M[2][2] == 'X') ||
				// Verificar vertical se ganhou
				(M[0][0] == 'X' && M[1][0] == 'X' && M[2][0] == 'X')
				|| (M[0][1] == 'X' && M[1][1] == 'X' && M[2][1] == 'X')
				|| (M[0][2] == 'X' && M[1][2] == 'X' && M[2][2] == 'X') ||
				// Verificar em cruz se ganhou
				(M[0][2] == 'X' && M[1][1] == 'X' && M[2][0] == 'X')
				|| (M[0][0] == 'X' && M[1][1] == 'X' && M[2][2] == 'X')) {
			valor = 2;

		}
		if ((M[0][0] == 'O' && M[0][1] == 'O' && M[0][2] == 'O') || (M[1][0] == 'O' && M[1][1] == 'O' && M[1][2] == 'O')
				|| (M[2][0] == 'O' && M[2][1] == 'O' && M[2][2] == 'O') ||
				// Verificar vertical se ganhou
				(M[0][0] == 'O' && M[1][0] == 'O' && M[2][0] == 'O')
				|| (M[0][1] == 'O' && M[1][1] == 'O' && M[2][1] == 'O')
				|| (M[0][2] == 'O' && M[1][2] == 'O' && M[2][2] == 'O') ||
				// Verificar em cruz se ganhou
				(M[0][2] == 'O' && M[1][1] == 'O' && M[2][0] == 'O')
				|| (M[0][0] == 'O' && M[1][1] == 'O' && M[2][2] == 'O')) {
			valor = 1;
		}
		// em caso de empate
		if (valor == 9) {
			valor = 0;
		}
		return valor;
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static void printMatriz(char[][] tabuleiro) {
		for (int linha = 0; linha < 3; linha++) {
			System.out.println();
			for (int coluna = 0; coluna < 3; coluna++) {
				System.out.print(tabuleiro[linha][coluna] + "|");
			}
		}
	}


	//----------------------------------------------------------------------------------------------------------------------
	public static void game(){
        char[][] tabuleiro = initialize();
        char player1 = 'X';
        char player2 = 'O';
        System.out.println("O jogador " +player2+ " vai jogar primeiro");
        do {
        	
        	// O
            Scanner entrada = new Scanner(System.in);
            System.out.println("\njogador '" +player2+ "' informe a linha: possíveis valores: 0, 1, 2");
            int linhaO = entrada.nextInt();
            System.out.println("jogador '" +player2+ "' informa a coluna: possíveis valores: 0, 1, 2");
            int colunaO = entrada.nextInt();
            if (step(tabuleiro, linhaO, colunaO, player2)) {
            	printMatriz(tabuleiro);
                if (status(tabuleiro) == 1) {
                    System.out.println("\nVITORIA DO 'O'!!!");
                    break;
                } else if (status(tabuleiro) == 2) {
                    System.out.println("\nVITORIA DO 'X'!!!");
                    break;
                } else if (status(tabuleiro) == 0) {
                    System.out.println("\nDEU VELHA!!!");
                    break;
                } else {
                	
                	// X
                    System.out.println("\njogador '" +player1+ "' informe a linha: possíveis valores: 0, 1, 2");
                    int linhaX = entrada.nextInt();
                    System.out.println("jogador '" +player1+ "' informe a coluna: possíveis valores: 0, 1, 2");
                    int colunaX = entrada.nextInt();
                    while (step(tabuleiro, linhaX, colunaX, player1) == false) {
                    	printMatriz(tabuleiro);
                        System.out.println("\nessa posição já está ocupada");
                        System.out.println("jogador '" +player1+ "'\n informe a linha: possíveis valores: 0, 1, 2");
                        linhaX = entrada.nextInt();
                        System.out.println("jogador '" +player1+ "' informe a coluna: possíveis valores: 0, 1, 2");
                        colunaX = entrada.nextInt();
                            
                    }
                    printMatriz(tabuleiro);
                    if (status(tabuleiro) == 1) {
                        System.out.println("\nVITORIA DO 'O'!!!");
                        break;
                    } else if (status(tabuleiro) == 2) {
                        System.out.println("\nVITORIA DO 'X'!!!");
                        break;
                    } else if (status(tabuleiro) == 0) {
                        System.out.println("\nDEU VELHA!!!");
                        break;
                    } else {
                        continue;
                    }   
                }
                
            }else{
                System.out.println("essa posição já está ocupada, jogue em outra posição");
                continue;
            }
            
        } while (true);
    }

}
