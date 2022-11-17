import javax.swing.*;

public class GaussElimination {
    public static void main(String[] args) {
        int prop;
        int k=0;
        int i;
        int j=0;
        

        prop= Integer.parseInt(JOptionPane.showInputDialog(null, "ÁLGEBRA LINEAR\n" +
                                 "Método de Gauss\n\nInforme a proporção da matriz: "));
        double matriz[][]= new double[prop][prop+1];
        double vetorResultado[]= new double[prop];
        JOptionPane.showMessageDialog(null, "Matriz(" + prop +"x" + prop+")"); 

        //Processo de obtenção dos dados da matriz
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (prop + 1 != coluna+1) {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("Insira o termo da linha " + (linha + 1) + " e coluna " + (coluna + 1) + ": "));
                }
                else {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("Insira o resultado da equação da linha " + (linha + 1) + ": "));
                }

            }
        }

        //Imprimindo Matriz Inicial
        String imprimeMatriz="";
        for (i=0;i<prop;i++){
            for (j=0;j<=prop;j++){
                imprimeMatriz+=matriz[i][j];
                imprimeMatriz+="    ";
            }
            imprimeMatriz+="\n";
        }
        JOptionPane.showMessageDialog(null, "MATRIZ INICIAL:\n" +imprimeMatriz);

    
        //Transformando matriz inicial em matriz pivô
        for (i=0;i<prop;i++){               
            for (k=1;k<prop;k++){
                if (matriz[i][i]==0){ //realiza a troca das linhas caso um termo pivô seja igual a zero
                    for (j=0;j<=prop;j++){
                        double pivo=matriz[i][j];
                        matriz[i][j]=matriz[k][j]; 
                        matriz[k][j]=pivo;
                    }
                }
                else if(matriz[i][i]>matriz[k][i] && matriz[k][i]>=1){ //Verifica se há algum termo a21 menor que o a11 para realizar a troca de linha
                    for (j=0;j<=prop;j++){
                        double pivo=matriz[i][j];
                        matriz[i][j]=matriz[k][j]; 
                        matriz[k][j]=pivo;
                    }
                }    
            }
        }
        //Imprimindo Matriz Pivô
        String imprimeMatrizPivo="";
            for (k=0;k<prop;k++){
                for (int q=0;q<=prop;q++){
                    imprimeMatrizPivo+=matriz[k][q];
                    imprimeMatrizPivo+="    ";
                }
                imprimeMatrizPivo+="\n";
            } 
        JOptionPane.showMessageDialog(null, "MATRIZ PIVÔ:\n" +imprimeMatrizPivo);    


        
        /*for (k = 0; k < matriz.length - 1; k++) {
                //realiza o escalonamento
                for (int m = k + 1; m < matriz.length; m++) {
                    double F = -matriz[m][k] / matriz[k][k];
                    matriz[m][k] = 0; //evita uma iteração
                    for (int l = k + 1; l < matriz.length; l++) {
                        matriz[m][l] = matriz[m][l] + F * matriz[k][l];
                        JOptionPane.showMessageDialog(null, matriz[m][l]);
                    }
                }
        }
        //ETAPA DE RESOLUÇÃO DO SISTEMA
        double[] X = new double[matriz.length];
        for (i = matriz.length - 1; i >= 0; i--) {
            X[i] = b[i];
            for (int j = i + 1; j < matriz.length; j++) {
                X[i] = X[i] - X[j] * matriz[i][j];
            }

            X[i] = X[i] / matriz[i][i];
        }
        return X;
*/
    }

}


