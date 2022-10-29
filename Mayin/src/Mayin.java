
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Locale;

public class Mayin {

    int input;
    int input2;
    int mayinSayisi;
    int g1;
    int g2;
    int cnt;
    int bilgi;

    String[][] matrix;
    String[][] oyuncu;


    Mayin(int input,int input2)
    {
        this.input=input;
        this.input2=input2;
        this.matrix=new String[this.input][this.input2];
        this.oyuncu=new String[this.input][this.input2];
        this.mayinSayisi=mayinSayisi;
        this.g1=g1;
        this.g2=g2;
        this.cnt=cnt;
        this.bilgi=bilgi;

    }


    void mayinYerlesimi()
    {
        int counter=0;
        this.mayinSayisi = ((this.input*this.input2)/4);
        System.out.println("Oyunda ki mayın sayısı :"+ this.mayinSayisi);
        for(int i=0;i<this.mayinSayisi+2;i++)
        {
            Random rand1=new Random();
            int a1 =rand1.nextInt(this.input);
            int a2 =rand1.nextInt(this.input2);
            if(!this.matrix[a1][a2].equals("*"))
            {
                this.matrix[a1][a2] = "*";
                counter++;
            }
            System.out.println(counter);
            if(counter==mayinSayisi) break;
        }
    }

    void mayinYazdirma()
    {
        for(int i=0;i<this.input;i++)
        {
            for(int j=0;j<this.input2;j++)
            {
            System.out.print(matrix[i][j]+" ");

            }
            System.out.println();
        }
    }


    void matrixOlusturma()
    {
        for(int i=0;i<this.input;i++)
        {
            for (int j=0;j<this.input2;j++)
            {
                this.matrix[i][j]="-";
                this.oyuncu[i][j]="-";
                System.out.print(this.matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    void oyuncuMatris()
    {
        for(int i=g1-1;i<=g1+1;i++)
        {
            for(int j=g2-1;j<=g2+1;j++)
            {
                if(i<0 || j<0|| i>this.input-1 || j>this.input2-1 )
                {
                    continue;
                }
                if(matrix[i][j].equals("*")) cnt ++;

            }
        }
        String sayi=Integer.toString(cnt);
        matrix[this.g1][this.g2]=sayi;
        for(int i=0;i<this.input;i++)
        {
            for (int j=0;j<this.input2;j++)
            {
                oyuncu[this.g1][this.g2]=sayi;
                System.out.print(this.oyuncu[i][j]+" ");
            }
            System.out.println();
        }

    }


    public boolean kontrol() {
        for (int i = 0; i < this.input; i++) {
            for (int j = 0; j < this.input2; j++) {
                if (this.matrix[i][j].equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    void kGiris() {
        while (true)
        {
            this.cnt=0;
            Scanner giris1 = new Scanner(System.in);
            Scanner giris2 = new Scanner(System.in);
            System.out.println("Satır numarısını giriniz:\t");
            this.g1= giris1.nextInt();
            System.out.println("Sütun numarısını giriniz:\t");
            this.g2= giris1.nextInt();
            if (this.g1> this.input || this.g2 > this.input2)
            {
                System.out.println("Yanlış bir tuşlama yaptınız tekrar deneyiniz.!!");
                continue;
            }
            oyuncuMatris();
            if (kontrol())
            {

                System.out.println("Tebrikler kazandiniz :)))))");
                break;
            }
            if(this.matrix[this.g1][this.g2].equals("*"))
            {
                System.out.println("Oyunu kaybettiniz");
                break;
            }


        }
    }
}
