package com.plugin.android.juanpedrogil.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,punto,div,suma,igual,mul,resta;
    TextView display;
    boolean clear=true;//Cuando es falso quiere decir que el usuario escribió un número
    boolean operador=false;//Cuando es verdadero quiere decir que ya hay un operador
    boolean dot=false;//Cuando es verdadero quiere decir que ya hay un punto
    boolean negativo=false;//Cuando es verdadero quiere decir que que hay un signo negativo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=(TextView) findViewById(R.id.display);
        btn1=(Button) findViewById(R.id.btn1);
        btn2=(Button) findViewById(R.id.btn2);
        btn3=(Button) findViewById(R.id.btn3);
        btn4=(Button) findViewById(R.id.btn4);
        btn5=(Button) findViewById(R.id.btn5);
        btn6=(Button) findViewById(R.id.btn6);
        btn7=(Button) findViewById(R.id.btn7);
        btn8=(Button) findViewById(R.id.btn8);
        btn9=(Button) findViewById(R.id.btn9);
        btn0=(Button) findViewById(R.id.btn0);
        punto=(Button) findViewById(R.id.punto);
        div=(Button) findViewById(R.id.div);
        mul=(Button) findViewById(R.id.mul);
        suma=(Button) findViewById(R.id.suma);
        igual=(Button) findViewById(R.id.igual);
        resta=(Button) findViewById(R.id.resta);
    }
    public void clickOn1(View v){
        if(!clear) {
            display.setText(display.getText() + "1");
        }else{
            display.setText("1");
            clear =false;
        }
    }
    public void clickOn2(View v){
        if(!clear) {
            display.setText(display.getText() + "2");
        }else{
            display.setText("2");
            clear =false;
        }
    }
    public void clickOn3(View v){
        if(!clear) {
            display.setText(display.getText() + "3");
        }else{
            display.setText("3");
            clear =false;
        }
    }
    public void clickOn4(View v){
        if(!clear) {
            display.setText(display.getText() + "4");
        }else{
            display.setText("4");
            clear =false;
        }
    }
    public void clickOn5(View v){
        if(!clear) {
            display.setText(display.getText() + "5");
        }else{
            display.setText("5");
            clear =false;
        }
    }
    public void clickOn6(View v){
        if(!clear) {
            display.setText(display.getText() + "6");
        }else{
            display.setText("6");
            clear =false;
        }
    }
    public void clickOn7(View v){
        if(!clear) {
            display.setText(display.getText() + "7");
        }else{
            display.setText("7");
            clear =false;
        }
    }
    public void clickOn8(View v){
        if(!clear) {
            display.setText(display.getText() + "8");
        }else{
            display.setText("8");
            clear =false;
        }
    }
    public void clickOn9(View v){
        if(!clear) {
            display.setText(display.getText() + "9");
        }else{
            display.setText("9");
            clear =false;
        }
    }
    public void clickOn0(View v){
        if(!clear) {
            display.setText(display.getText() + "0");
        }else{
            display.setText("0");
            clear =false;
        }
    }
    public void clickOnPunto(View v){
        if(!clear) {
            if(!dot) {
                display.setText(display.getText() + ".");
                dot=true;
            }
        }else{
            display.setText("0.");
            clear =false;
        }
    }
    public void clickOnSuma(View v){
        if(!clear) {
            if(!operador) {
                display.setText(display.getText() + "+");
                operador=true;
                dot=false;
            }
        }else{
            display.setText("Primero escribe un número");
        }
    }
    public void clickOnResta(View v){
        if(!clear) {
            if(!operador) {
                display.setText(display.getText() + "-");
                operador=true;
                dot=false;
            }
        }else{
            display.setText("Primero escribe un número");
        }
    }
    public void clickOnMul(View v){
        if(!clear) {
            if(!operador) {
                display.setText(display.getText() + "*");
                operador=true;
                dot=false;
            }
        }else{
            display.setText("Primero escribe un número");
        }
    }
    public void clickOnDiv(View v){
        if(!clear) {
            if(!operador) {
                display.setText(display.getText() + "/");
                operador=true;
                dot=false;
            }
        }else{
            display.setText("Primero escribe un número");
        }
    }
    public void clickOnIgual(View v){
        char op='x';//Guarda el operador de la expresión
        String cad=display.getText().toString();//Representa la cadena del display que será modificada

        //Recorre toda la expresión en busca de un operador aritmético, y si lo encuentra lo guarda en la variable op
        for(int i=0;i<display.getText().toString().length();i++){
            switch (display.getText().toString().charAt(i)){
                case '+':
                    op=',';//Representa la suma ya que el símbolo de mas no lo puedo utilizar más adelante
                    cad=display.getText().toString().substring(0,i)+","+display.getText().toString().substring(i+1,display.getText().toString().length());
                    break;
                case '-':
                    op='-';
                    break;
                case '*':
                    op='<';//Representa la multiplicación ya que el asterisco no lo puedo utilizar más adelante
                    cad=display.getText().toString().substring(0,i)+"<"+display.getText().toString().substring(i+1,display.getText().toString().length());
                    break;
                case '/':
                    op='/';
                    break;
            }
        }
        if(op!='x'){
            String[] exp;//Guarda los dos números a evaluar
            double res=0;//Guarda el resultado de la operación
            exp=cad.split(op+"");
            switch (op){
                case ',':
                    res=Double.parseDouble(exp[0])+Double.parseDouble(exp[1]);
                    break;
                case '-':
                    res=Double.parseDouble(exp[0])-Double.parseDouble(exp[1]);
                    break;
                case '<':
                    res=Double.parseDouble(exp[0])*Double.parseDouble(exp[1]);
                    break;
                case '/':
                    res=Double.parseDouble(exp[0])/Double.parseDouble(exp[1]);
                    break;
            }
            display.setText(res+"");
            operador=false;
            clear=true;
            dot=false;
        }
    }
    public void clickOnBorrar(View v){
        if(display.getText().toString().charAt(display.getText().toString().length()-1)=='+' ||
                display.getText().toString().charAt(display.getText().toString().length()-1)=='-' ||
                display.getText().toString().charAt(display.getText().toString().length()-1)=='*' ||
                display.getText().toString().charAt(display.getText().toString().length()-1)=='/'){
            operador=false;
        }
        if(display.getText().toString().charAt(display.getText().toString().length()-1)=='.'){
            dot=false;
        }
        if(!clear){
            if(display.getText().toString().length()>1) {
                display.setText(display.getText().toString().substring(0, display.getText().toString().length() - 1));
            }else{
                display.setText("0");
                clear=true;
            }
        }else{
            display.setText("0");
            clear=true;
            operador=false;
        }
        if(display.getText().toString().charAt(display.getText().toString().length()-1)=='.'){
            dot=false;
        }
    }

}
