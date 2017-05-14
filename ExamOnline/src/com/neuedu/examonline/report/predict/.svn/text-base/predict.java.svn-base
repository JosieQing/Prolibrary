package com.neuedu.examonline.report.predict;

public class predict {
public double[] sanx(double[] arr){
	double Ey = 0.000000;
    double Ex = 0.000000;
    for (int i = 0; i < arr.length; i++)
    {
        Ey = Ey + arr[i];
        Ex = Ex + i;
    }
    double Exy = 0.000000;
    double Exx = 0.000000;
    for (int i = 0; i < arr.length; i++)
    {
        Exy = Exy + arr[i] * i;
        Exx = Exx + i * i;
    }
    double Exxy = 0.000000;
    double Exxx = 0.000000;
    for (int i = 0; i < arr.length; i++)
    {
        Exxy = Exxy + arr[i] * i * i;
        Exxx = Exxx + i * i * i;
    }
    double Exxxy = 0.000000;
    double Exxxx = 0.000000;
    for (int i = 0; i < arr.length; i++)
    {
        Exxxy = Exxy + arr[i] * i * i * i;
        Exxxx = Exxx + i * i * i * i;
    }
    double Exxxxx = 0.00;
    for (int i = 0; i < arr.length; i++)
    {
        Exxxxx = Exxxx + i * i * i * i * i;
    }
    double Exxxxxx = 0.00;
    for (int i = 0; i < arr.length; i++)
    {
        Exxxxxx = Exxxxxx +i* i * i * i * i * i;
    }
    double[] s0 = {Exxxxxx,Exxxxx, Exxxx, Exxx, Exxxy};

    double[] s1 = {Exxxxx,Exxxx, Exxx, Exx, Exxy};
    double[] s2 = {Exxxx,Exxx, Exx, Ex, Exy};
    double[] s3 = {Exxx,Exx, Exx, arr.length, Ey};
    double s23 = Exxx / Exxxx;
    for (int i = 0; i < 5; i++)
    {
        s3[i] = s3[i] - s23 * s2[i];

    }

    double s12 = Exxxx / Exxxxx;
    for (int i = 0; i < 5; i++)
    {
        s2[i] = s2[i] - s12 * s1[i];

    }
    double s01=Exxxxx/Exxxxxx;
    for (int i = 0; i < 5; i++)
    {
        s1[i] = s1[i] - s01 * s0[i];

    }
    s23 = s3[1] / s2[1];
    for (int i = 0; i < 5; i++)
    {
        s3[i] = s3[i] - s23 * s2[i];
    }
    s12 = s2[1] / s1[1];
    for (int i = 0; i < 5; i++)
    {
        s2[i] = s2[i] - s12 * s1[i];

    }
    s23 = s3[2] / s2[2];
    for (int i = 0; i < 5; i++)
    {
        s3[i] = s3[i] - s23 * s2[i];
    }
    double d = s3[4] / s3[3];
    double c;
    double b;
    double a;
    c=(s2[4]-s2[3]*d)/s2[3];
    b = (s1[4]-d*s1[3]-c*s1[2])/s1[1];
    a = (s0[4]-d*s0[3]-c*s0[2]-b*s0[1])/s0[0];
    double s111 = Exx * Ey / Exy - Ex;
    double s112 = arr.length - Ex * Ey / Exy;
    double a1 = Ey / (Ex + arr.length * (s111 / s112));
    double b1 = (Ey - a1 * Ex) / arr.length;
    
    System.out.println(d);
    System.out.println(c);

    double[] brr=new double[arr.length+1];
    for(int i=0;i<brr.length;i++){
    	brr[i]=a1*i+b1;
    }
	return brr;
}
}
