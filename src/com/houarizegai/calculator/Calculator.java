import java.awt.Cursor;
import java.awt.Desktop;
import java.math.*;
import java.net.URL;
import java.text.DecimalFormat;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Math;

public class Calculator {

    private JFrame window; // This is Main Window
    private JTextField inText, affichageCalc; // Input Text
    private JButton btnC, btnBack, btnMod, btnDiv, btn7, btn8, btn9,
            btnMul, btn4, btn5, btn6, btnSub, btn1, btn2, btn3, btnAdd, btnPoint, btn0, btnEqual,btnSqrt,btnCos,
            btnMC, btnMR, btnMplus,btnMS, colorChoice,btnBMI,btnTan,btnSin, btnFactorial ,btnInverse, btnLog,btnln,
            btnExponential,btnSquare, btnArcCos, btn10powX, btnSineInverse, btnArcTan,btnCubeRoot,btnXpowX,btnSinH,btnTanH,btnCosh,
            btnBinarytoDecimal,btnNthRoot,btnEpowX,btnDecimalToBinary,btnnPr,btnnCr,btnans,btnMax,btnMin,btnComma,btnAbs
            ,btnCot;

            

    private char opt = ' ';             // Storage Oparator
    private boolean go = true,          // Faire Calcule Avec Opt != (=)
            addWrite = true;    // RacordÈ des Nombres dans l'Affichage
    private double val = 0; // Storage Values For Calcule
    private boolean bool = false;
    static String ans = null;
    private int i=0;
  

    private Calculator() {
        window = new JFrame("Calculator");

        window.setSize(1200,620); // Width and Height Of Window


        window.setLocationRelativeTo(null); // Move Window To Center
        
        Font btnFont = new Font("Times New Roman", Font.PLAIN, 18);
 
        colorChoice = new JButton();
        colorChoice.setBounds(720, 10, 140, 30);
        colorChoice.setText("Toggle colors");
        colorChoice.setBackground(Color.ORANGE);
        colorChoice.setForeground(Color.BLACK);
        colorChoice.setCursor(new Cursor(Cursor.HAND_CURSOR));
        colorChoice.addActionListener(event -> themeColor());
        window.getContentPane().add(colorChoice);

        int wBtn = 80;// Width Button
        // Height Button
        int hBtn = 70;
        int marginX = 20;
        int marginY = 60;
        int j = -1;
        int k = -1;

        int[] x = {marginX, marginX + 90, 200, 290, marginX+370, marginX+470,marginX + 570 , marginX + 670,marginX+770,marginX+870, marginX+970, marginX + 1070};
        int[] y = {marginY, marginY + 100, marginY + 180, marginY + 260, marginY + 340, marginY + 420, marginY +500, marginY +650};
        

        inText = new JTextField("0");

        inText.setBounds(x[0],y[0],1150,70);

        inText.setBounds(x[0],y[0],1050,70);

        inText.setEditable(false);
        inText.setBackground(Color.WHITE);
        inText.setFont(new Font("Times New Roman", Font.PLAIN, 33));
        inText.setHorizontalAlignment(inText.RIGHT);
        window.getContentPane().add(inText);
        
        btnC = new JButton("C");
        btnC.setBounds(x[0],y[1],wBtn,hBtn);
        btnC.setFont(btnFont);
        btnC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnC.addActionListener(event -> {
            repaintFont();
            inText.setText("0");
            opt = ' ';
            val = 0;
        });
        window.getContentPane().add(btnC);
                
        btnBack = new JButton("<-");
        btnBack.setBounds(x[1],y[1],wBtn,hBtn);
        btnBack.setFont(btnFont);
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBack.addActionListener(event -> {
            repaintFont();
            String str = inText.getText();
            StringBuilder str2 = new StringBuilder();
            for (i = 0; i < (str.length() - 1); i++) {
                str2.append(str.charAt(i));
            }
            if (str2.toString().equals("")) {
                inText.setText("0");
            } else {
                inText.setText(str2.toString());
            }
        });
        window.getContentPane().add(btnBack);
        
        btnSqrt = new JButton("sqrt");
       btnSqrt.setBounds(x[4],y[1],wBtn,hBtn);
       btnSqrt.setFont(btnFont);
       btnSqrt.setCursor(new Cursor(Cursor.HAND_CURSOR));
     btnSqrt.addActionListener(event -> {
            repaintFont();
           if(go) {
               String displayText = inText.getText();
               Double value = Double.valueOf(displayText);
               inText.setText(""+Math.sqrt(value));
               ans = ""+Math.sqrt(value);
           }
           go = false;
           addWrite = false;
        });
        window.getContentPane().add(btnSqrt);
        
        
        
        //start of cosine button
        btnCos = new JButton("Cos");
        btnCos.setBounds(x[5],y[1],wBtn,hBtn);
        btnCos.setFont(btnFont);
        btnCos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCos.addActionListener(event -> {
             repaintFont();
                 if (go) {
                            String displayText = inText.getText();
                            Double value = Double.valueOf(displayText);
                            Double radians = Math.toRadians(value);
                            
                            DecimalFormat format =  new DecimalFormat("##0.00"); 
                            inText.setText("" + format.format(Math.cos(radians)));
                            ans = format.format(Math.cos(radians));
                     }
                     go = false;
                     addWrite = false;
            
         });
         window.getContentPane().add(btnCos);
        //end of cosine button
         
         
         //start of Tan button
         btnTan = new JButton("Tan");
         btnTan.setBounds(x[5],y[2],wBtn,hBtn);
         btnTan.setFont(btnFont);
         btnTan.setCursor(new Cursor(Cursor.HAND_CURSOR));
         btnTan.addActionListener(event -> {
              repaintFont();
                  if (go) {
                            String displayText = inText.getText();
                            Double value = Double.valueOf(displayText);
                            Double radians = Math.toRadians(value);
                            
                            DecimalFormat format =  new DecimalFormat("##0.00"); 
                            inText.setText("" + format.format(Math.tan(radians)));
                            ans = "" + format.format(Math.tan(radians));
                      }
                      go = false;
                      addWrite = false;
             
          });
          window.getContentPane().add(btnTan);
         //end of Tan button
          
          
          //start of sine button
          btnSin = new JButton("Sin");
          btnSin.setBounds(x[5],y[3],wBtn,hBtn);
          btnSin.setFont(btnFont);
          btnSin.setCursor(new Cursor(Cursor.HAND_CURSOR));
          btnSin.addActionListener(event -> {
               repaintFont();
                   if (go) {
                            String displayText = inText.getText();
                            Double value = Double.valueOf(displayText);
                            Double radians = Math.toRadians(value);
                            
                            DecimalFormat format =  new DecimalFormat("##0.00"); 
                            inText.setText("" + format.format(Math.sin(radians)));
                            ans = "" + format.format(Math.sin(radians));
                       }
                       go = false;
                       addWrite = false;
              
           });
           window.getContentPane().add(btnSin);
          //end of sine button
           
        
         
        btnMod = new JButton("%");
        btnMod.setBounds(x[2],y[1],wBtn,hBtn);
        btnMod.setFont(btnFont);
        btnMod.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMod.addActionListener(event -> {
           repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    //Edited
                    
                    //end
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                        ans = String.valueOf((int) val);
                    } else {
                        inText.setText(String.valueOf(val));
                        ans = String.valueOf(val);
                    }
                    opt = '%';
                    go = false;
                    addWrite = false;
                }
        });
        window.getContentPane().add(btnMod);
        
        btnDiv = new JButton("/");
        btnDiv.setBounds(x[3],y[1],wBtn,hBtn);
        btnDiv.setFont(btnFont);
        btnDiv.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnDiv.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                        ans = String.valueOf((int) val);
                    } else {
                        inText.setText(String.valueOf(val));
                        ans = String.valueOf(val);
                    }
                    opt = '/';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '/';
                }
        });
        window.getContentPane().add(btnDiv);
        
        btn7 = new JButton("7");
        btn7.setBounds(x[0],y[2],wBtn,hBtn);
        btn7.setFont(btnFont);
        btn7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn7.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("7");
                } else {
                    inText.setText(inText.getText() + "7");
                }
            } else {
                inText.setText("7");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn7);
        
        btn8 = new JButton("8");
        btn8.setBounds(x[1],y[2],wBtn,hBtn);
        btn8.setFont(btnFont);
        btn8.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn8.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("8");
                } else {
                    inText.setText(inText.getText() + "8");
                }
            } else {
                inText.setText("8");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn8);
        
        btn9 = new JButton("9");
        btn9.setBounds(x[2],y[2],wBtn,hBtn);
        btn9.setFont(btnFont);
        btn9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn9.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("9");
                } else {
                    inText.setText(inText.getText() + "9");
                }
            } else {
                inText.setText("9");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn9);
        
        btnMul = new JButton("*");
        btnMul.setBounds(x[3],y[2],wBtn,hBtn);
        btnMul.setFont(btnFont);
        btnMul.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMul.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                        ans = String.valueOf((int) val);
                    } else {
                        inText.setText(String.valueOf(val));
                        ans = String.valueOf(val);
                    }
                    opt = '*';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '*';
                }
        });
        window.getContentPane().add(btnMul);
        
        btn4 = new JButton("4");
        btn4.setBounds(x[0],y[3],wBtn,hBtn);
        btn4.setFont(btnFont);
        btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn4.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("4");
                } else {
                    inText.setText(inText.getText() + "4");
                }
            } else {
                inText.setText("4");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn4);
        
        btn5 = new JButton("5");
        btn5.setBounds(x[1],y[3],wBtn,hBtn);
        btn5.setFont(btnFont);
        btn5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn5.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("5");
                } else {
                    inText.setText(inText.getText() + "5");
                }
            } else {
                inText.setText("5");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn5);
        
        btn6 = new JButton("6");
        btn6.setBounds(x[2],y[3],wBtn,hBtn);
        btn6.setFont(btnFont);
        btn6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn6.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("6");
                } else {
                    inText.setText(inText.getText() + "6");
                }
            } else {
                inText.setText("6");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn6);
        
        btnSub = new JButton("-");
        btnSub.setBounds(x[3],y[3],wBtn,hBtn);
        btnSub.setFont(btnFont);
        btnSub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSub.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                        ans = String.valueOf((int) val);
                    } else {
                        inText.setText(String.valueOf(val));
                        ans = String.valueOf(val);
                    }

                    opt = '-';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '-';
                }
        });
        window.getContentPane().add(btnSub);
        
        btn1 = new JButton("1");
        btn1.setBounds(x[0],y[4],wBtn,hBtn);
        btn1.setFont(btnFont);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn1.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("1");
                } else {
                    inText.setText(inText.getText() + "1");
                }
            } else {
                inText.setText("1");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn1);
        
        btn2 = new JButton("2");
        btn2.setBounds(x[1],y[4],wBtn,hBtn);
        btn2.setFont(btnFont);
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("2");
                } else {
                    inText.setText(inText.getText() + "2");
                }
            } else {
                inText.setText("2");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn2);
        
        btn3 = new JButton("3");
        btn3.setBounds(x[2], y[4], wBtn, hBtn);
        btn3.setFont(btnFont);
        btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn3.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("3");
                } else {
                    inText.setText(inText.getText() + "3");
                }
            } else {
                inText.setText("3");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn3);
        
        btnAdd = new JButton("+");
        btnAdd.setBounds(x[3], y[4], wBtn, hBtn);
        btnAdd.setFont(btnFont);
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAdd.addActionListener(event -> {
            repaintFont();
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                        ans = String.valueOf((int) val);
                    } else {
                        inText.setText(String.valueOf(val));
                        ans = String.valueOf(val);
                    }
                    opt = '+';
                    go = false;
                    addWrite = false;
                } else {
                    opt = '+';
                }
        });
        window.getContentPane().add(btnAdd);
        
        btnPoint = new JButton(".");
        btnPoint.setBounds(x[0],y[5],wBtn,hBtn);
        btnPoint.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        btnPoint.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnPoint.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                inText.setText(inText.getText() + ".");
            } else {
                inText.setText("0.");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btnPoint);
        
        btn0 = new JButton("0");
        btn0.setBounds(x[1],y[5],wBtn,hBtn);
        btn0.setFont(btnFont);
        btn0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn0.addActionListener(event -> {
            repaintFont();
            if (addWrite) {
                if (Pattern.matches("[0]*", inText.getText())) {
                    inText.setText("0");
                } else {
                    inText.setText(inText.getText() + "0");
                }
            } else {
                inText.setText("0");
                addWrite = true;
            }
            go = true;
        });
        window.getContentPane().add(btn0);
        
        btnEqual = new JButton("=");
        btnEqual.setBounds(x[2],y[5],2*wBtn+10,hBtn);
        btnEqual.setFont(btnFont);
        btnEqual.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEqual.addActionListener(event -> {
            if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                if (go) {
                    val = calc(val, inText.getText(), opt);
                    if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                        inText.setText(String.valueOf((int) val));
                        ans = String.valueOf((int) val);
                    } else {
                        inText.setText(String.valueOf(val));
                        ans = String.valueOf(val);
                    }
                    opt = '=';
                    addWrite = false;
                }
        });
        window.getContentPane().add(btnEqual);
        window.getContentPane().setLayout(null);
       
         btnMC = new JButton("MC");
         btnEqual.setFont(btnFont);
         btnMC.setBounds(x[4],y[3],wBtn,hBtn);
        window.getContentPane().add(btnMC);
        
        btnMR= new JButton("MR");
        btnEqual.setFont(btnFont);
        btnMR.setBounds(x[4],y[4],wBtn,hBtn);
        window.getContentPane().add(btnMR);
        
        btnMS = new JButton("MS");
        btnEqual.setFont(btnFont);
        btnMS.setBounds(x[4],y[5],wBtn,hBtn);
        window.getContentPane().add(btnMS);
        
        btnMplus = new JButton("M+");
        btnEqual.setFont(btnFont);
        btnMplus.setBounds(x[4],y[2],wBtn,hBtn);
        window.getContentPane().add(btnMplus);
        
        
        
       // Add factorial button and its functionality
        btnFactorial = new JButton("X!");
        btnFactorial.setFont(btnFont);
        btnFactorial.setBounds(x[5], y[5], wBtn, hBtn);
        window.getContentPane().add(btnFactorial);
      btnFactorial.setCursor(new Cursor(Cursor.HAND_CURSOR));
      btnFactorial.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

          int n = Integer.parseInt(inText.getText());
          if (e.getSource().equals(btnFactorial)) {
        	  
        	  val= factorial(n);
             inText.setText(String.valueOf("The Factorial of  " + n + " " + "is: " + (int)val));
             ans = String.valueOf("The Factorial of  " + n + " " + "is: " + (int)val);
          }

      }
      });
      
      
      //start of Log button
      btnLog = new JButton("Log");
      btnLog.setBounds(x[5],y[4],wBtn,hBtn);
      btnLog.setFont(btnFont);
      btnLog.setCursor(new Cursor(Cursor.HAND_CURSOR));
      btnLog.addActionListener(event -> {
           repaintFont();
               if (go) {
              	 		String displayText = inText.getText();
              	 		Double value = Double.valueOf(displayText);
              	 		inText.setText("" + (Math.log10(value)));
              	 		ans = "" + (Math.log10(value));
                   }
                   go = false;
                   addWrite = false;
          
       });
       window.getContentPane().add(btnLog);
      //end of Log button
       
       //start of ln button
       btnln = new JButton("ln");
       btnln.setBounds(x[6],y[1],wBtn,hBtn);
       btnln.setFont(btnFont);
       btnln.setCursor(new Cursor(Cursor.HAND_CURSOR));
       btnln.addActionListener(event -> {
            repaintFont();
                if (go) {
               	 		String displayText = inText.getText();
               	 		Double value = Double.valueOf(displayText);
               	 		//Double ln = Math.log(value);
               	 		
               	 		//DecimalFormat format =  new DecimalFormat("##0.00"); 
               	 		inText.setText("" + Math.log(value));
               	 		ans = "" + Math.log(value);
                    }
                    go = false;
                    addWrite = false;
           
        });
       window.getContentPane().add(btnln);
       
    // Inverse button calculates the inverse of a given number
       btnInverse = new JButton("Inv");
       btnInverse.setFont(btnFont);
       btnInverse.setBounds(x[6], y[3], wBtn, hBtn);
       window.getContentPane().add(btnInverse);
       btnInverse.setCursor(new Cursor(Cursor.HAND_CURSOR));
       btnInverse.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           double val = Double.parseDouble(inText.getText());
           double inverse=0;
          if (e.getSource().equals(btnInverse)) {
          inverse=1.0/val;
            inText.setText(String.valueOf(inverse));
            ans = String.valueOf(inverse);
         }

     }
     });
       
    // x^2 button calculates the square of a given number
       btnSquare = new JButton("x^2");
       btnSquare.setFont(btnFont);
       btnSquare.setBounds(x[7], y[1], wBtn, hBtn);
       window.getContentPane().add(btnSquare);
       btnSquare.setCursor(new Cursor(Cursor.HAND_CURSOR));
       btnSquare.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           double val = Double.parseDouble(inText.getText());
           double square=0;
          if (e.getSource().equals(btnSquare)) {
          square=val*val;
          
          	if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
          		inText.setText(String.valueOf((int) square));
          		ans = String.valueOf((int) square);
          	} else {
          		inText.setText(String.valueOf(square));
          		ans = String.valueOf(square);
          	}
         } 
        }});
       
       // cube root button calculates the cube root of a given number
       btnCubeRoot = new JButton("Cbr");
       btnCubeRoot.setFont(btnFont);
       btnCubeRoot.setBounds(x[7], y[5], wBtn, hBtn);
       window.getContentPane().add(btnCubeRoot);
       btnCubeRoot.setCursor(new Cursor(Cursor.HAND_CURSOR));
       btnCubeRoot.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           double val = Double.parseDouble(inText.getText());
           double cubeRoot=0;
          if (e.getSource().equals(btnCubeRoot)) {
          cubeRoot=Math.cbrt(val);
          }
          
          if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(cubeRoot))) {
        		inText.setText(String.valueOf((int) cubeRoot));
        		ans = String.valueOf((int) cubeRoot);
        	} else {
        		inText.setText(String.valueOf(cubeRoot));
        		ans = String.valueOf(cubeRoot);
        	}
       }});  
       
         
     //Start of arc cos button
       btnArcCos = new JButton("aCos");
       btnArcCos.setBounds(x[6],y[5],wBtn,hBtn);
       btnArcCos.setFont(btnFont);
       btnArcCos.setCursor(new Cursor(Cursor.HAND_CURSOR));
       btnArcCos.addActionListener(event -> {
            repaintFont();
                if (go) {
               	 		String displayText = inText.getText();
               	 		Double value = Double.valueOf(displayText);
               	 		
               	 		DecimalFormat format =  new DecimalFormat("##0.00"); 
               	 	 inText.setText("" + format.format(Math.toDegrees(Math.acos(value))) );
               	 	 ans = "" + format.format(Math.toDegrees(Math.acos(value)));
                    }
                    go = false;
                    addWrite = false;
           
        });
        window.getContentPane().add(btnArcCos);
       
        btn10powX = new JButton("10^x");
       btn10powX.setBounds(x[7],y[2],wBtn,hBtn);
       btn10powX.setFont(btnFont);
       btn10powX.setCursor(new Cursor(Cursor.HAND_CURSOR));
       btn10powX.addActionListener(event -> {
             repaintFont();
             if (go) {
     	 		String displayText = inText.getText();
     	 		Double value = Double.valueOf(displayText);
     	 		inText.setText("" + Math.pow(10,value));
     	 		ans = "" + Math.pow(10,value);
          }
          go = false;
          addWrite = false;
 
});
         window.getContentPane().add(btn10powX);
    //End of button 10^x
    
         btnSineInverse = new JButton("aSin");
         btnSineInverse.setBounds(x[7],y[3],wBtn,hBtn);;
         btnSineInverse.setFont(btnFont);
         btnSineInverse.setCursor(new Cursor(Cursor.HAND_CURSOR));
         btnSineInverse.addActionListener(event -> {
              repaintFont();
                  if (go) {
                           String displayText = inText.getText();
                          Double value = Double.valueOf(displayText);
                           DecimalFormat format =  new DecimalFormat("##0.00");
                           inText.setText("" + format.format(Math.toDegrees(Math.asin(value))) );
                           ans = "" + format.format(Math.toDegrees(Math.asin(value)));
                          
                      }
                      go = false;
                      addWrite = false;
             
          });
          window.getContentPane().add( btnSineInverse);   
        
        //Start of arc tan button
          btnArcTan = new JButton("aTan");
          btnArcTan.setBounds(x[7],y[4],wBtn,hBtn);
          btnArcTan.setFont(btnFont);
          btnArcTan.setCursor(new Cursor(Cursor.HAND_CURSOR));
          btnArcTan.addActionListener(event -> {
               repaintFont();
                   if (go) {
                  	 		String displayText = inText.getText();
                  	 		Double value = Double.valueOf(displayText);
                  	 		
                  	 		DecimalFormat format =  new DecimalFormat("##0.00"); 
                  	 		inText.setText("" + format.format(Math.atan(value)));
                  	 		ans = "" + format.format(Math.atan(value));
                       }
                       go = false;
                       addWrite = false;
              
           });
           window.getContentPane().add(btnArcTan);
     //End of arc tan button
          
          
          
       
        
        
        btnExponential = new JButton("^");
        btnExponential.setBounds(x[6],y[2],wBtn,hBtn);
        btnExponential.setFont(btnFont);
        btnExponential.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnExponential.addActionListener(event -> {
             repaintFont();
             if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                 if (go) {
                     val = calc(val, inText.getText(), opt);
                     if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                         inText.setText(String.valueOf((int) val));
                         ans = String.valueOf((int) val);
                     } else {
                         inText.setText(String.valueOf(val));
                         ans = String.valueOf(val);
                     }
                     opt = '^';
                     go = false;
                     addWrite = false;
                 }   
         });
         window.getContentPane().add(btnExponential);
         
         //Start of Button X^x 
         btnXpowX = new JButton("X^x");
        btnXpowX.setBounds(x[8],y[1],wBtn,hBtn);
        btnXpowX.setFont(btnFont);
        btnXpowX.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXpowX.addActionListener(event -> {
              repaintFont();
              if (go) {
      	 		String displayText = inText.getText();
      	 		Double value = Double.valueOf(displayText);
      	 		//Double ln = Math.log(value);
      	 		
      	 		//DecimalFormat format =  new DecimalFormat("##0.00"); 
      	 		inText.setText("" + Math.pow(value,value));
      	 		ans = "" + Math.pow(value,value);
      	 		
           }
           go = false;
           addWrite = false;
  
});
          window.getContentPane().add(btnXpowX);
     //End of button X^x
      
        //Start of hyperbolic sine function button
          btnSinH = new JButton("SinH");
          btnSinH.setBounds(x[8],y[2],wBtn,hBtn);
          btnSinH.setFont(btnFont);
          btnSinH.setCursor(new Cursor(Cursor.HAND_CURSOR));
          btnSinH.addActionListener(event -> {
               repaintFont();
                   if (go) {
                  	 		String displayText = inText.getText();
                  	 		Double value = Double.valueOf(displayText);
                  	 		
                  	 		DecimalFormat format =  new DecimalFormat("##0.00"); 
                  	 		inText.setText("" + format.format(Math.sinh(value)));
                  	 		ans = format.format(Math.sinh(value));
                       }
                       go = false;
                       addWrite = false;
              
           });
           window.getContentPane().add(btnSinH);

         //Start of hyperbolic tan function button
           btnTanH = new JButton("TanH");
           btnTanH.setBounds(x[8],y[3],wBtn,hBtn);
           btnTanH.setFont(btnFont);
           btnTanH.setCursor(new Cursor(Cursor.HAND_CURSOR));
           btnTanH.addActionListener(event -> {
                repaintFont();
                    if (go) {
                   	 		String displayText = inText.getText();
                   	 		Double value = Double.valueOf(displayText);
                   	 		
                   	 		DecimalFormat format =  new DecimalFormat("##0.00"); 
                   	 		inText.setText("" + format.format(Math.tanh(value)));
                   	 		ans = format.format(Math.tanh(value));
                        }
                        go = false;
                        addWrite = false;
               
            });
            window.getContentPane().add(btnTanH);
      //End  of hyperbolic tan function button
      
      //Start of ans button
            btnans = new JButton("ans");
            btnans.setBounds(x[8],y[5],wBtn,hBtn);
            btnans.setFont(btnFont);
            btnTanH.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnans.addActionListener(event -> {
                 repaintFont();
                     if (go) {
                    	      if(ans != null)
                    	    	  inText.setText(ans);
                         }
                         go = false;
                         addWrite = false;
                
             });
            window.getContentPane().add(btnans);
            //End of ans Buttton
           
            btnCosh = new JButton("CosH");
            btnCosh.setBounds(x[8],y[4],wBtn,hBtn);;
            btnCosh.setFont(btnFont);
            btnCosh.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnCosh.addActionListener(event -> {
                 repaintFont();
                     if (go) {
                              String displayText = inText.getText();
                             Double value = Double.valueOf(displayText);
                              DecimalFormat format =  new DecimalFormat("##0.00");
                              inText.setText("" + format.format(Math.cosh(value)));
                              ans = format.format(Math.cosh(value));
                         }
                         go = false;
                         addWrite = false;

             });

             window.getContentPane().add(  btnCosh);   
  
             //start of button nCr
             btnnCr = new JButton("nCr");
             btnnCr.setBounds(x[9],y[4],wBtn,hBtn);
             btnnCr.setFont(btnFont);
             btnnCr.setCursor(new Cursor(Cursor.HAND_CURSOR));
             btnnCr.addActionListener(event -> {
                  repaintFont();
                  if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                      if (go) {
                          val = calc(val, inText.getText(), opt);
                          if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                              inText.setText(String.valueOf((int) val));
                          } else {
                              inText.setText(String.valueOf(val));
                          }
                          opt = 'C';
                          go = false;
                          addWrite = false;
                      }   
              });
              window.getContentPane().add(btnnCr);
             //end of button nCr 
              
              
              btnCot = new JButton("Cot");
              btnCot.setBounds(x[11],y[1],wBtn,hBtn);
              btnCot.setFont(btnFont);
              btnCot.setCursor(new Cursor(Cursor.HAND_CURSOR));
              btnCot.addActionListener(event -> {
                    repaintFont();

                    if (go) {
                              String displayText = inText.getText();
                              Double value = Double.valueOf(displayText);
                              Double radians = Math.toRadians(value);
                              
                              DecimalFormat format =  new DecimalFormat("##0.00"); 
                              inText.setText("" + format.format(1.0/Math.tan(radians)));
                              ans = "" + format.format(1.0/Math.tan(radians));
                        }
                        go = false;
                        addWrite = false;

        
       });
              window.getContentPane().add(btnCot);

  

            //start of button nPr
            btnnPr = new JButton("nPr");
            btnnPr.setBounds(x[9],y[3],wBtn,hBtn);
            btnnPr.setFont(btnFont);
            btnnPr.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnnPr.addActionListener(event -> {
                 repaintFont();
                 if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                     if (go) {
                         val = calc(val, inText.getText(), opt);
                         if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                             inText.setText(String.valueOf((int) val));
                         } else {
                             inText.setText(String.valueOf(val));
                         }
                         opt = 'P';
                         go = false;
                         addWrite = false;
                     }   
             });
             window.getContentPane().add(btnnPr);
             //end of button nPr    
             
             btnMax = new JButton("Max");
             btnMax.setBounds(x[9],y[1],wBtn,hBtn);
             btnMax.setFont(btnFont);
             btnMax.setCursor(new Cursor(Cursor.HAND_CURSOR));
             btnMax.addActionListener(event -> {
                  repaintFont();
                  if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                      if (go) {
                          val = calc(val, inText.getText(), opt);
                          if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                              inText.setText(String.valueOf((int) val));
                          } else {
                              inText.setText(String.valueOf(val));
                          }
                          opt = 'N';
                          go = false;
                          addWrite = false;
                      }   
              });
              window.getContentPane().add(btnMax);
              
              btnComma = new JButton(",");
              btnComma.setBounds(x[9],y[5],wBtn,hBtn);
              btnComma.setFont(btnFont);
              btnComma.setCursor(new Cursor(Cursor.HAND_CURSOR));
              btnComma.addActionListener(event -> {
                   repaintFont();
                       if (go) {
                      	      String displayText = inText.getText();
                      	      inText.setText(displayText + ",");
                           }
                           go = false;
                           addWrite = false;
                  
               });
              window.getContentPane().add(btnComma);
              //End of comma button
              
              
              btnMin = new JButton("Min");
              btnMin.setBounds(x[9],y[2],wBtn,hBtn);
              btnMin.setFont(btnFont);
              btnMin.setCursor(new Cursor(Cursor.HAND_CURSOR));
              btnMin.addActionListener(event -> {
                   repaintFont();
                   if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                       if (go) {
                           val = calc(val, inText.getText(), opt);
                           if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                               inText.setText(String.valueOf((int) val));
                           } else {
                               inText.setText(String.valueOf(val));
                           }
                           opt = 'M';
                           go = false;
                           addWrite = false;
                       }   
               });
               window.getContentPane().add(btnMin);
             
             //Start of Abs button
               btnAbs = new JButton("Abs");
               btnAbs.setBounds(x[10],y[1],wBtn,hBtn);
               btnAbs.setFont(btnFont);
               btnAbs.setCursor(new Cursor(Cursor.HAND_CURSOR));
               btnAbs.addActionListener(event -> {
                    repaintFont();
                    if (go) {
            	 		String displayText = inText.getText();
            	 		Double value = Double.valueOf(displayText);
            	 		DecimalFormat format =  new 		DecimalFormat("##0.00"); 
            	 		inText.setText("" + format.format(Math.abs(value)));
            	 		ans = format.format(Math.abs(value));
                 }
                 go = false;
                 addWrite = false;
           
        });
               window.getContentPane().add(btnAbs);
               //End of Abs button

               //Start of Button ->Dec 
               btnBinarytoDecimal = new JButton("->Dec");
               btnBinarytoDecimal.setBounds(x[10],y[2],wBtn,hBtn);
               btnBinarytoDecimal.setFont(btnFont);
               btnBinarytoDecimal.setCursor(new Cursor(Cursor.HAND_CURSOR));
               btnBinarytoDecimal.addActionListener(event -> {
                    repaintFont();
                    if (go) {
            	 		String displayText = inText.getText();
            	 		for (int i =0; i<displayText.length();i++) {
            	 				}
            	 		int value = Integer.parseInt(displayText,2);
            	 		inText.setText("" + value);
                 }
                 go = false;
                 addWrite = false;
        
     });
                window.getContentPane().add( btnBinarytoDecimal);
           //End 

                //Start of nth root
                btnNthRoot = new JButton("x\u221A");
                btnNthRoot.setBounds(x[10],y[3],wBtn,hBtn);
                btnNthRoot.setFont(btnFont);
                btnNthRoot.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnNthRoot.addActionListener(event -> {
                      repaintFont();
                      if (Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", inText.getText()))
                          if (go) {
                              val = calc(val, inText.getText(), opt);
                              if (Pattern.matches("[-]?[\\d]+[.][0]*", String.valueOf(val))) {
                                  inText.setText(String.valueOf((int) val));
                              } else {
                                  inText.setText(String.valueOf(val));
                              }
                              opt = '\u221A';
                              go = false;
                              addWrite = false;
                          }   
         });
                  window.getContentPane().add(btnNthRoot);
             //End of button nth root 
                  //Start of button e^x
                  btnEpowX = new JButton("e^x");
                  btnEpowX.setBounds(x[10],y[4],wBtn,hBtn);
                  btnEpowX.setFont(btnFont);
                  btnEpowX.setCursor(new Cursor(Cursor.HAND_CURSOR));
                  btnEpowX.addActionListener(event -> {
                        repaintFont();
                        if (go) {
                	 		String displayText = inText.getText();
                	 		Double value = Double.valueOf(displayText);
                	 		
                	 		
                	 		
                	 		inText.setText("" + Math.pow(Math.E,value));
                     }
                     go = false;
                     addWrite = false;
            
           });
                    window.getContentPane().add(btnEpowX);
               //End of button e^x
                    
                    

                    // begin of decimal to binary

                
                    btnDecimalToBinary = new JButton("->Bin");

                    btnDecimalToBinary.setBounds(x[10],y[5],wBtn,hBtn);

                    btnDecimalToBinary.setFont(btnFont);

                    btnDecimalToBinary.setCursor(new Cursor(Cursor.HAND_CURSOR));

                    btnDecimalToBinary.addActionListener(event -> {

                         repaintFont();

                             if (go) {

                                      String displayText = inText.getText();

                                      int value= Integer.valueOf(displayText);

                                      inText.setText( Integer.toBinaryString(value));
             
                                 }

                                 go = false;

                                 addWrite = false;

                     });

                     window.getContentPane().add(btnDecimalToBinary);   


                // end of decimal to binary
                    
        btnBMI = new JButton("BMI");
        btnBMI.setBounds(x[6],y[4],wBtn,hBtn);
        btnBMI.setFont(btnFont);
        window.getContentPane().add(btnBMI);
        btnBMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                open("http://www.debugersbmi.com"); 
            }

            private void open(String string) {
                try {
                    Desktop.getDesktop().browse(new URL("http://www.debuggersbmi.com").toURI());
                } catch (Exception e) {}
                
            }
        });
        
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If Click into The Red Button => End The Processus
        window.setVisible(true);
        
    
    }
  
        
        

    private double calc(double x, String input, char opt) {
        inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
        double y = Double.parseDouble(input);
        if (opt == '+') {
            return x + y;
        } else if (opt == '-') {
            return x - y;
        } else if (opt == '*') {
            return x * y;
        } else if (opt == '/') {
            return x / y;
        } else if (opt == '%') {
            return x % y;
        }
        else if(opt == '^'){
        	return Math.pow(x,y);
        }
        else if(opt == '\u221A') {
        	return Math.pow(y,1/x);
        }
        else if(opt == 'P') {	
        	return nPr(x,y);
        }
        else if(opt == 'C') {	
        	return nCr(x,y);
        }
        else if(opt == 'M') {
            return Math.min(x, y);
        }
        else if(opt == 'N') {
            return Math.max(x, y);
        }
        inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
        return y;
    }
    
    static double factorial(double n) {
    	
    	if (n <= 1) {
    		return 1;
    	}
    	return n * factorial(n-1);
    }
      
    static double nPr(double n, double r) 
    { 
        return factorial(n) / factorial(n - r); 
    } 
    
    static double nCr(double n, double r) 
    { 
        return factorial(n) / (factorial(r) * factorial(n - r)); 
    }  

         
       

    private int factorial(int i) {
    	
    	 int fact = 1;
    	 int n = Integer.parseInt(inText.getText());
         for (i = 1; i <= n; i++) {
             fact = fact * i;
         }
         return fact;
	}
    
    private void repaintFont() {
        inText.setFont(inText.getFont().deriveFont(Font.PLAIN));
    }
    private void themeColor() {

        if (bool) {
        	 colorChoice.setText("Toggle colors");
             colorChoice.setBackground(Color.ORANGE);
             colorChoice.setForeground(Color.BLACK);
             btnC.setBackground(null);
             btnBack.setBackground(null);
             btnMod.setBackground(null);
             btnDiv.setBackground(null);
             btnMul.setBackground(null);
             btnSub.setBackground(null);
             btnAdd.setBackground(null);
             btnEqual.setBackground(null);
             btn0.setBackground(null);
             btn1.setBackground(null);
             btn2.setBackground(null);
             btn3.setBackground(null);
             btn4.setBackground(null);
             btn5.setBackground(null);
             btn6.setBackground(null);
             btn7.setBackground(null);
             btn8.setBackground(null);
             btn9.setBackground(null);
             btnPoint.setBackground(null);

             btnC.setForeground(Color.BLACK);
             btnBack.setForeground(Color.BLACK);
             btnMod.setForeground(Color.BLACK);
             btnDiv.setForeground(Color.BLACK);
             btnMul.setForeground(Color.BLACK);
             btnSub.setForeground(Color.BLACK);
             btnAdd.setForeground(Color.BLACK);
             btnEqual.setForeground(Color.BLACK);
             btnFactorial.setForeground(Color.BLACK);
             
             btnSqrt.setForeground(Color.BLACK);
             btnMS.setForeground(Color.BLACK);
             btnMC.setForeground(Color.BLACK);
             btnMplus.setForeground(Color.BLACK);
             btnMR.setForeground(Color.BLACK);
             btnFactorial.setForeground(Color.BLACK);
             btnSqrt.setBackground(null);
             btnMS.setBackground(null);
             btnMC.setBackground(null);
             btnMplus.setBackground(null);
             btnMR.setBackground(null);
             btnBMI.setBackground(null);
             btnSin.setBackground(null);
             btnCos.setBackground(null);
             btnTan.setBackground(null);
             btnFactorial.setBackground(null);
             btnLog.setBackground(null);
             btnInverse.setBackground(null);
             btnExponential.setBackground(null);
             btnln.setBackground(null);
             btnSquare.setBackground(null);
             btnArcCos.setBackground(null);
             btn10powX.setBackground(null);
             btnSineInverse.setBackground(null);
             btnArcTan.setBackground(null);
             btnCubeRoot.setBackground(null);
             btnXpowX.setBackground(null);
             btnCosh.setBackground(null);
             btnTanH.setBackground(null);
             btnSinH.setBackground(null);
             btnnPr.setBackground(null);
             btnnCr.setBackground(null);
             btnans.setBackground(null);
             btnMin.setBackground(null);
             btnMax.setBackground(null);
             btnComma.setBackground(null);
             btnAbs.setBackground(null);
             btnBinarytoDecimal.setBackground(null);
             btnNthRoot.setBackground(null);
             btnEpowX.setBackground(null);
             btnDecimalToBinary.setBackground(null);
             btnCot.setBackground(null);

             
             bool = false;
         } else {
             colorChoice.setText("Untoggle");
             colorChoice.setBackground(Color.ORANGE);
             colorChoice.setForeground(Color.BLACK);  
             btnC.setBackground(Color.ORANGE);
             btnBack.setBackground(Color.ORANGE);
             btnMod.setBackground(Color.ORANGE);
             btnDiv.setBackground(Color.ORANGE);
             btnMul.setBackground(Color.ORANGE);
             btnSub.setBackground(Color.ORANGE);
             btnAdd.setBackground(Color.ORANGE);
             btnEqual.setBackground(Color.ORANGE);
             btn0.setBackground(Color.LIGHT_GRAY);
             btn1.setBackground(Color.LIGHT_GRAY);
             btn2.setBackground(Color.LIGHT_GRAY);
             btn3.setBackground(Color.LIGHT_GRAY);
             btn4.setBackground(Color.LIGHT_GRAY);
             btn5.setBackground(Color.LIGHT_GRAY);
             btn6.setBackground(Color.LIGHT_GRAY);
             btn7.setBackground(Color.LIGHT_GRAY);
             btn8.setBackground(Color.LIGHT_GRAY);
             btn9.setBackground(Color.LIGHT_GRAY);
             btnPoint.setBackground(Color.LIGHT_GRAY);
             btnC.setForeground(Color.BLACK);
             btnBack.setForeground(Color.BLACK);
             btnMod.setForeground(Color.BLACK);
             btnDiv.setForeground(Color.BLACK);
             btnMul.setForeground(Color.BLACK);
             btnSub.setForeground(Color.BLACK);
             btnAdd.setForeground(Color.BLACK);
             btnEqual.setForeground(Color.BLACK);             
             btnSqrt.setBackground(Color.ORANGE);
             btnMS.setBackground(Color.ORANGE);
             btnMC.setBackground(Color.ORANGE);
             btnMplus.setBackground(Color.ORANGE);
             btnMR.setBackground(Color.ORANGE);
             btnBMI.setBackground(Color.ORANGE);
             btnCos.setBackground(Color.ORANGE);
             btnTan.setBackground(Color.ORANGE);
             btnSin.setBackground(Color.ORANGE);
             btnFactorial.setBackground(Color.ORANGE);
             btnLog.setBackground(Color.ORANGE);
             btnInverse.setBackground(Color.ORANGE);
             btnExponential.setBackground(Color.ORANGE);
             btnln.setBackground(Color.ORANGE);
             btnSquare.setBackground(Color.ORANGE);
             btnArcCos.setBackground(Color.ORANGE);
             btn10powX.setBackground(Color.ORANGE);
             btnSineInverse.setBackground(Color.ORANGE);
             btnArcTan.setBackground(Color.ORANGE);
             btnCubeRoot.setBackground(Color.ORANGE);
             btnXpowX.setBackground(Color.ORANGE);
             btnCosh.setBackground(Color.ORANGE);
             btnTanH.setBackground(Color.ORANGE);
             btnSinH.setBackground(Color.ORANGE);
             btnnPr.setBackground(Color.ORANGE);
             btnnCr.setBackground(Color.ORANGE);
             btnans.setBackground(Color.ORANGE);
             btnMin.setBackground(Color.ORANGE);
             btnMax.setBackground(Color.ORANGE);
             btnComma.setBackground(Color.ORANGE);
             btnAbs.setBackground(Color.ORANGE);
             btnBinarytoDecimal.setBackground(Color.ORANGE);
             btnNthRoot.setBackground(Color.ORANGE);
             btnEpowX.setBackground(Color.ORANGE);
             btnDecimalToBinary.setBackground(Color.ORANGE);

             btnCot.setBackground(Color.ORANGE);

             bool = true;
        }
}
    
    public static void main(String[] args) {
        new Calculator();
    }
}
