import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.awt.*;

import java.applet.*;

 

import javax.swing.*;

 

 

public class FileSearch extends JFrame implements ActionListener {

     

      static JTextField h=new JTextField(16);

      static JTextField h1=new JTextField(16);

    

      

      public static void main(String[] args) {

           

         FileSearch fs = new FileSearch();

         fs.go();

             

      }

     

      public void go(){

         JFrame f1=new JFrame("textfield");

         

          

          JButton calbtn = new JButton("Submit");

           

            JPanel p = new JPanel();

           

            p.add(calbtn);

           

            p.add(h);

            p.add(h1);

            f1.add(p);

            f1.setSize(300, 300);

            f1.show();

            String s =h.getText().toString();

                      

            calbtn.addActionListener(this);

      }

      @Override

      public void actionPerformed(ActionEvent ae) {

         String line="";

         String cont=" ";

            //System.out.println("working");

            // TODO Auto-generated method stub

            String s=h.getText().toString();

            String s1=h1.getText().toString();

           

            

            System.out.println("Path: "+ s);

            System.out.println("Search Key: "+ s1);

            File file = new File(s);

            File[] files = file.listFiles();

             int count = files.length;

            String[] fp = new String[count];

           // String[] fp = new String[count];

        int i=0;

        for(File f: files){

            //System.out.print(f.getName());

          // System.out.println( f.getAbsolutePath());

           fp[i++]=f.getAbsolutePath().toString();

         //  f.lastModified()

                              

          /*if(f.isDirectory())

                  System.out.println("  folder");

            else

            {

                  System.out.println("  File");

                 

                  System.out.println(f.getAbsolutePath());

            } */

}

       for(int ind=0;ind<fp.length;ind++)

       {

        try {

             //System.out.println();

                     FileReader fileReader =

                             new FileReader(fp[ind]);

                     BufferedReader bufferedReader =

                       new BufferedReader(fileReader);

                     while((line = bufferedReader.readLine()) != null) {

                if(line.contains(s1)){

                    System.out.println("Line Working");

                           System.out.println(line);

                           File file1 = new File(fp[ind]);

                           System.out.println(file1.lastModified());

                }

                          

                cont=cont+line;

               

            }  

                    

 

              } catch (Exception e) {

                     // TODO Auto-generated catch block

                     e.printStackTrace();

              }

       // System.out.println(cont);

        /*if(cont.contains(s1))

              {

                    

                     System.out.println("keyword found"+fp[ind]);

                     System.out.println(cont);

              }

              else

              {

                     System.out.println("key word not found in"+fp[ind]);

              }*/

        cont="";

        }

        /*for(String g:fp)

        {

             System.out.println("working");

             System.out.println(g);

            

        }*/

           

      }

     

       

 

}