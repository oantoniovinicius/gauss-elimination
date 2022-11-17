import javax.swing.*;

public class GaussElimination {
    public static void main(String[] args) {
        int prop;
        int k;
        int i;
        int j;
        

        prop= Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a proporção da matriz: "));
        double matriz[][]= new double[prop][prop+1];
        double matrizResultado[][]= new double[prop][prop+1];
        JOptionPane.showMessageDialog(null, "Matriz(" + prop +"x" + prop+")"); 
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                if (prop + 1 != coluna+1) {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("Insira o termo da linha " + (linha + 1) + " e coluna " + (coluna + 1) + ": "));
                }
                else {
                    matriz[linha][coluna]= Double.parseDouble(JOptionPane.showInputDialog("Insira o resultado da equação da linha " + (linha + 1) + ": "));
                    matrizResultado[linha][coluna]=matriz[linha][coluna];
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
        for (i=0;i<prop;i++)                
            for (k=i+1;k<prop;k++)
                if ((matriz[i][i])<(matriz[k][i]))
                    for (j=0;j<=prop;j++){
                        double temp=matriz[i][j];
                        matriz[i][j]=matriz[k][j];
                        matriz[k][j]=temp;
                    }
    
        //Imprimindo Matriz Pivô
        String imprimeMatrizPivo="";
            for (i=0;i<prop;i++){
                for (j=0;j<=prop;j++){
                    imprimeMatrizPivo+=matriz[i][j];
                    imprimeMatrizPivo+="    ";
                }
                imprimeMatrizPivo+="\n";
            } 
            JOptionPane.showMessageDialog(null, "MATRIZ PIVÔ:\n" +imprimeMatrizPivo);            
                


    }
}
