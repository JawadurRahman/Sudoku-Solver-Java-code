package sodukosolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User
 */
public class SodukoSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                sudoku[x][y] = 0;
            }
        }
        //constraints
        sudoku[0][0] = 5;
        sudoku[1][0] = 3;
        sudoku[4][0] = 7;

        sudoku[0][1] = 6;
        sudoku[3][1] = 1;
        sudoku[4][1] = 9;
        sudoku[5][1] = 5;

        sudoku[1][2] = 9;
        sudoku[2][2] = 8;
        sudoku[7][2] = 6;

        sudoku[0][3] = 8;
        sudoku[4][3] = 6;
        sudoku[8][3] = 3;

        sudoku[0][4] = 4;
        sudoku[3][4] = 8;
        sudoku[5][4] = 3;
        sudoku[8][4] = 1;

        sudoku[0][5] = 7;
        sudoku[4][5] = 2;
        sudoku[8][5] = 6;

        sudoku[1][6] = 6;
        sudoku[6][6] = 2;
        sudoku[7][6] = 8;

        sudoku[3][7] = 4;
        sudoku[4][7] = 1;
        sudoku[5][7] = 9;
        sudoku[8][7] = 5;

        sudoku[4][8] = 8;
        sudoku[7][8] = 7;
        sudoku[8][8] = 9;

        ArrayList<Integer>[][] possibles = new ArrayList[9][9];

        sudokuPrinter(sudoku);

        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                possibles[x][y] = new ArrayList<>();
            }
        }

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (sudoku[x][y] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        possibles[x][y].add(i);
                    }

                } else {
                    possibles[x][y].add(sudoku[x][y]);
                }

            }
        }

        int[] s1 = new int[9];
        int sum = 0;
        while (sum != 405) {
            sum = 0;
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    sum = sum+sudoku[x][y];
                }
            }

            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    if (sudoku[x][y] == 0) {
                        for (int a = 0; a < 9; a++) {
                            possibles[x][y].remove(Integer.valueOf(sudoku[a][y]));
                            //if(posibilieties =1 make sudoku = that vales)
                            if (possibles[x][y].size() == 1) {
                                sudoku[x][y] = possibles[x][y].get(0);
                            }
                            possibles[x][y].remove(Integer.valueOf(sudoku[x][a]));
                            //if
                            if (possibles[x][y].size() == 1) {
                                sudoku[x][y] = possibles[x][y].get(0);
                            }
                        }
                        int i = 0;
                        if (x < 3 && y < 3) {
                            //s1
                            int c = 0;
                            int d = 0;

                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }

                        }
                        if ((x < 6 && x > 2) && (y < 3)) {
                            //s2
                            int c = 3;
                            int d = 0;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }

                        }
                        if ((x < 9 && x > 5) && (y < 3)) {
                            //s3
                            int c = 6;
                            int d = 0;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }
                        if ((x < 3) && (y < 6 && y > 2)) {
                            //s4
                            int c = 0;
                            int d = 3;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }
                        if ((x < 6 && x > 2) && (y < 6 && y > 2)) {
                            //s5
                            int c = 3;
                            int d = 3;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }
                        if ((x < 9 && x > 5) && (y < 6 && y > 2)) {
                            //s6
                            int c = 6;
                            int d = 3;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }
                        if ((x < 3) && (y < 9 && y > 5)) {
                            //s7
                            int c = 0;
                            int d = 6;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }
                        if ((x < 6 && x > 2) && (y < 9 && y > 5)) {
                            //s8
                            int c = 3;
                            int d = 6;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }
                        if ((x < 9 && x > 5) && (y < 9 && y > 5)) {
                            //s9
                            int c = 6;
                            int d = 6;
                            for (int a = c; a < c + 3; a++) {
                                for (int b = d; b < d + 3; b++) {
                                    s1[i] = sudoku[a][b];
                                    i++;
                                }
                            }
                        }
                        for (int a = 0; a < 9; a++) {
                            possibles[x][y].remove(Integer.valueOf(s1[a]));
                        }

                        if (possibles[x][y].size() == 1) {
                            sudoku[x][y] = possibles[x][y].get(0);
                        }

                    }
                }
            }
        }
        System.out.println();
        sudokuPrinter(sudoku);

//        for(int x =0; x<9;x++){
//            for(int y = 0; y < 9; y++){
//                System.out.println(possibles[y][x]+" ");
//            }
//        }
    }

    private static void sudokuPrinter(int[][] sudoku) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(sudoku[x][y] + " ");
            }
            System.out.println();
        }
    }

}
