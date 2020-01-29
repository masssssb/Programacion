package arraynotas;

import java.util.Scanner;

public class ArrayNotas {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        String [] nombres;
        double [][] notas;
        double [] mediasAlumno;
        double [] mediasExamen;
        double media;
        int nAlumnos, nExamenes, dificil;
        
        System.out.println("Dime el número de alumnos de la clase:");
        nAlumnos=s.nextInt();
        System.out.println("Dime el número de exámenes de la clase:");
        nExamenes=s.nextInt();
        
        nombres = new String [nAlumnos];
        notas = new double [nAlumnos][nExamenes];
        mediasAlumno = new double [nAlumnos];
        mediasExamen = new double [nExamenes];
        
        leerNombres(nombres);
        leerNotas(notas, nombres);
        media=calculaMedias(notas, mediasAlumno, mediasExamen);
        System.out.println("La media de toda la clase es: "+media);
        muestraMediasAlumno(mediasAlumno, nombres);
        muestraMediasExamen(mediasExamen);
        muestraNotas(notas, nombres);
        dificil=calculaDificil(mediasExamen);
        System.out.println("El exámen mas dificil fue el número "+(dificil+1));
        System.out.println();
        verMejorAlumno(mediasAlumno, nombres);
    }
    
    public static void leerNombres(String[]nombres){
        Scanner s = new Scanner (System.in);
        for (int i=0;i<nombres.length;i++){
            System.out.println("Dime el nombre de alumnos número "+(i+1)+":");
            nombres[i]=s.nextLine();
        }
    }
    public static void leerNotas(double [][]notas, String[]nombres){
        Scanner s = new Scanner (System.in);
        for (int i=0;i<notas.length;i++){
            System.out.println("Notas de "+nombres[i]+":");
            for (int j=0;j<notas[0].length;j++){
                System.out.println("Nota número "+(j+1)+":");
                notas[i][j]=s.nextDouble();
            }
            System.out.println("\n");
        }
    }
    public static double calculaMedias(double [][]notas, double [] ma, double [] me){
        double mediaGeneral=0;
        for (int i=0;i<notas.length;i++){
            for (int j=0;j<notas[0].length;j++){
                ma[i]+=notas[i][j];
                me[j]+=notas[i][j];
                mediaGeneral+=notas[i][j];
            }
        }
        for (int i=0;i<notas.length;i++){
            ma[i]/=notas[0].length;
        }
        for (int i=0;i<notas[0].length;i++){
            me[i]/=notas.length;
        }
        mediaGeneral/=notas.length*notas[0].length;
        return mediaGeneral;
    }
    public static void muestraMediasAlumno(double [] ma, String[]nombres){
        for (int i=0;i<ma.length;i++){
            System.out.println("La media de todos los exámenes de "+nombres[i]+" es: "+ma[i]);
        }
        System.out.println("\n");
    }
    public static void muestraMediasExamen(double [] me){
        for (int i=0;i<me.length;i++){
            System.out.println("La media del exámen número "+(i+1)+" es: "+me[i]);
        }
        System.out.println("\n");
    }
    public static void muestraNotas(double [][]notas, String[]nombres){
        for (int i=0;i<notas.length;i++){
            System.out.print("Notas de "+nombres[i]+": ");
            for (int j=0;j<notas[0].length;j++){
                System.out.print("Exámen "+(j+1)+": "+notas[i][j]+" ");
                
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int calculaDificil(double[]me){
        int dificil=0;
        double mediaBaja=me[0];
        for (int i=0;i<me.length;i++){
            if (me[i]<mediaBaja){
                mediaBaja=me[i];
                dificil=i;
            }
        }
        return dificil;
    }
    public static void verMejorAlumno(double [] ma, String[]nombres){
        int indiceMejorAlumno=0;
        double mejorNota=ma[0];
        for (int i=0;i<ma.length;i++){
            if (ma[i]>mejorNota){
                mejorNota=ma[i];
                indiceMejorAlumno=i;
            }
        }
        System.out.println("El alumno con la media más alta es: "+nombres[indiceMejorAlumno]+" la cual es: "+ma[indiceMejorAlumno]);
    }
    
}
