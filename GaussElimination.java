import javax.swing.*;
import java.util.*;

public class GaussElimination {
    public static void main(String[] args) {
        int prop;
        int k;
        int i;
        int j;
        
        prop= Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a proporção da matriz: "));
        double matriz[][]= new double[prop][prop+1];
        JOptionPane.showMessageDialog(null, "Matriz(" + prop +"x" + prop+")"); 
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                int MatrizAuxiliar;
                if (prop + 1 != coluna+1) {
                    MatrizAuxiliar= Integer.parseInt(JOptionPane.showInputDialog("Insira o termo da linha " + (linha + 1) + " e coluna " + (coluna + 1) + ": "));
                }
                else {
                    MatrizAuxiliar= Integer.parseInt(JOptionPane.showInputDialog("Qual o Resultado da equação da linha " + (linha + 1) + "? "));
                }

                matriz[linha][coluna] = (MatrizAuxiliar);
            }
        }

        String resultado="";
        for (i=0;i<prop;i++){   // imprimindo a matriz inicial
            for (j=0;j<=prop;j++){
                resultado+=matriz[i][j];
                resultado+="  "; //4º termo da linha= resultado de cada equação.
            }
            resultado+="\n";
        }
        JOptionPane.showMessageDialog(null, resultado);

    }
}
