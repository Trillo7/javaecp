package calculadora;

public class calculadora {
private int num1;
private int num2;

public calculadora(int a, int b) { // TODO Auto-generated constructor stub
num1=a; num2=b;
}

public int suma() {
int resultado=num1+num2;
return resultado;
}

public int resta() {
int resultado=num1-num2;
return resultado;
}

public int multiplica() {
int resultado=num1*num2;
return resultado;
}

public int divide() {
int resultado=num1/num2;
return resultado;
}

public static void main(String[] args) {
// TODO Auto-generated method stub
}
}