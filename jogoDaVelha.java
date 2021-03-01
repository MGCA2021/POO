package AC1;

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

	// --------------------------------------------------------------------------------------------------------------------

    public static void game() {
        char[][] tabuleiro = initialize();
        char player1 = 'X';
        char player2 = 'O';
        System.out.println("O jogador " + player2 + " vai jogar primeiro");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\njogador " + player2 + " informe a linha: possíveis valores: 0, 1, 2");
            int lin = sc.nextInt();
            System.out.println("jogador " + player2 + " informe a coluna: possíveis valores: 0, 1, 2");
            int col = sc.nextInt();

            boolean so = step(tabuleiro, lin, col, player2);

            if (so == true) {
                if (status(tabuleiro) == -1) {
                    printMatriz(tabuleiro);
                    System.out.println("\nvez do jogador X, informe a linha: possíveis valores: 0, 1, 2");
                    int linhaX = sc.nextInt();
                    System.out.println("jogador X, agora informe a coluna: possíveis valores: 0, 1, 2");
                    int colunaX = sc.nextInt();

                    if (step(tabuleiro, linhaX, colunaX, player1) == true) {
                        if (status(tabuleiro) == -1) {
                            printMatriz(tabuleiro);
                            continue;
                        } else if (status(tabuleiro) == 1) {
                            System.out.println("vitória do jogador 'O'");
                            printMatriz(tabuleiro);
                            break;
                        } else if (status(tabuleiro) == 2) {
                            System.out.println("vitória do jogador 'X'");
                            printMatriz(tabuleiro);
                            break;
                        } else if (status(tabuleiro) == 0) {
                            System.out.println("empate!");
                            printMatriz(tabuleiro);
                        }
                        ;
                    }
                    ;
                } else if (status(tabuleiro) == 1) {
                    System.out.println("vitória do jogador 'O'");
                    printMatriz(tabuleiro);
                    break;
                } else if (status(tabuleiro) == 2) {
                    System.out.println("vitória do jogador 'X'");
                    printMatriz(tabuleiro);
                    break;
                } else if (status(tabuleiro) == 0) {
                    System.out.println("empate!");
                    printMatriz(tabuleiro);
                }
                ;
            } else {
                System.out.println("essa posição já está ocupada no tabuleiro, jogue em outra posição");
                continue;
            }

        } while (status(tabuleiro) == -1);
    
}
}
