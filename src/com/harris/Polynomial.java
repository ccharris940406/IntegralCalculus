package com.harris;

public class Polynomial {

    private int [] coef;
    private int degree;

    private void Reduce(){

        int i = 0;

        for(; coef[i] == 0 && i < degree; i++);
        for(int j = i; j < degree + 1; j++){
            coef[j-i] = coef[j];
        }
        degree -= i;


    }

    public Polynomial(int[] c, int d){
        if (d <= 0){
            throw new IllegalArgumentException("degree must be grather than 0" + d);
        }
        degree = d;
        coef = new int[d + 1];

        for (int i = 0; i <= d ; i++){
            coef[i] = c[i];
        }
        Reduce();
    }

    public double TrapMethodIntegral(final int step, double start, double end){
        double h = (end - start)/step;
        double sum_Fx = Evaluate(start)/2;
               sum_Fx += Evaluate(end)/2;
        for(double i = start + h; i < end - h; i+=h){
            sum_Fx += Evaluate(i);

        }
        return h*sum_Fx;
    }

    public double RectangleMethodIntegral(final int step, double start, double end){
        double h = (end - start)/step;
        double sum_Fx = 0;
        for(double i = start; i < end; i+=h){
            sum_Fx += Evaluate(i);
        }
        return h*sum_Fx;
    }

    private double Evaluate(final double x){
        double f_x = 0;
            for (int i = 0; i <= degree; i++){
                f_x += coef[i]*Math.pow(x, degree - i);
            }
        return f_x;
    }

    @Override
    public String toString() {
        String toPrint = new String();
        toPrint += "( ";
        for (int i = 0; i <= degree; i++){
            toPrint+= coef[i];
            /*if(coef[i] == 1){
                toPrint += ("x^" + (degree - i));
            }*/
            if(i < degree){
                toPrint+= ", ";
            }
        }
        toPrint += " ) : ";
        toPrint += degree;

        return toPrint;
    }
}
