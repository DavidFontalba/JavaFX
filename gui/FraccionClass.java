package ejercicios.gui;

/**
 * Implementación de la clase Fracción.
 * 
 * @author Rafael del Castillo
 */

public class FraccionClass implements Comparable<FraccionClass> {
  private int num;      // numerador
  private int den;      // denominador

  /**
   * Constructor de la Fracción.
   * @param x numerador de la fracción.
   * @param y denominador de la fracción, debe ser mayor que cero.
   */
  public FraccionClass(int x, int y) {
    setNum(x);
    setDen(y);
  }

  /**
   * @return numerador de la fracción.
   */
  public int getNum() {
    return num;
  }

  /**
   * Asigna numerador a la fracción.
   * @param num numerador de la fracción.
   */
  public void setNum(int num) {
    this.num = num;
  }

  /**
   * @return denominador de la fracción.
   */
  public int getDen() {
    return den;
  }

  /**
   * Asigna denominador a la fracción.
   * @param den denominador de la fracción. Debe ser mayor o igual que cero.
   * @throws ArithmeticException
   */
  public void setDen(int den) throws ArithmeticException {
    if (den == 0) {
      throw new ArithmeticException();
    }
    this.den = den;
  }

  /**
   * Suma fracciones.
   * @param a primer sumando.
   * @param b segundo sumando.
   * @return suma de las fracciones.
   */
  public static FraccionClass sumar(FraccionClass a, FraccionClass b) {
    FraccionClass f = new FraccionClass(a.num * b.den + b.num * a.den, a.den * b.den);
    f.simplifica();
    return f;
  }
  
  /**
   * Suma una fracción con un entero.
   * @param a primer sumando.
   * @param b segundo sumando.
   * @return suma.
   */
  public static FraccionClass sumar(FraccionClass a, int b) {
    return sumar(a, new FraccionClass(b, 1));
  }
  
  /**
   * Suma un entero con una fracción.
   * @param a primer sumando.
   * @param b segundo sumando.
   * @return suma.
   */
  public static FraccionClass sumar(int a, FraccionClass b) {
    return sumar(b, a);
  }
  
  /**
   * Incrementa el objeto Fracción actual.
   * @param a fracción a incrementar.
   */
  public void incrementa(FraccionClass a) {
    FraccionClass f = sumar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Incrementa el objeto Fracción actual.
   * @param a entero a incrementar.
   */
  public void incrementa(int a) {
    incrementa(new FraccionClass(a, 1));
  }
  
  /**
   * Resta fracciones.
   * @param a minuendo.
   * @param b sustraendo.
   * @return resta de las fracciones
   */
  public static FraccionClass restar(FraccionClass a, FraccionClass b) {
    FraccionClass f = new FraccionClass(a.num * b.den - b.num * a.den, a.den * b.den);
    f.simplifica();
    return f;
  }
  
  /**
   * Resta a una fracción un entero.
   * @param a minuendo.
   * @param b sustraendo.
   * @return resta.
   */
  public static FraccionClass restar(FraccionClass a, int b) {
    return restar(a, new FraccionClass(b, 1));
  }
  
  /**
   * Resta a un entero una fracción.
   * @param a minuendo.
   * @param b sustraendo.
   * @return resta.
   */
  public static FraccionClass restar(int a, FraccionClass b) {
    return restar(new FraccionClass(a, 1), b);
  }
  
  /**
   * Decrementa el objeto Fracción actual.
   * @param a fracción a decrementar.
   */
  
  public void decrementa(FraccionClass a) {
    FraccionClass f = restar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Decrementa el objeto Fracción actual.
   * @param a entero a decrementar.
   */
  
  public void decrementa(int a) {
    FraccionClass f = restar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Multiplica fracciones.
   * @param a factor multiplicando.
   * @param b factor multiplicador.
   * @return producto de las fracciones.
   */
  public static FraccionClass multiplicar(FraccionClass a, FraccionClass b) {
    FraccionClass f = new FraccionClass(a.num * b.num, a.den * b.den);
    f.simplifica();
    return f;
  }
  
  /**
   * Multiplicación escalar.
   * @param a factor multiplicando.
   * @param b factor multiplicador.
   * @return producto.
   */
  public static FraccionClass multiplicar(FraccionClass a, int b) {
    return multiplicar(a, new FraccionClass(b, 1));
  }
  
  /**
   * Multiplicación escalar.
   * @param a factor multiplicando.
   * @param b factor multiplicador.
   * @return producto.
   */
  public static FraccionClass multiplicar(int a, FraccionClass b) {
    return multiplicar(b, a);
  }
  
  /**
   * Multiplica la fracción actual por la recibida como parámetro y actualiza numerador y denominador.
   * @param a fracción a multiplicar.
   */
  public void multiplica(FraccionClass a) {
    FraccionClass f = multiplicar(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Multiplica la fracción actual por el entero recibido como parámetro y actualiza numerador y denominador.
   * @param a entero a multiplicar.
   */
  public void multiplica(int a) {
    FraccionClass f = multiplicar(this, a);
    this.num = f.num;
    this.den = f.den;
  }

  /**
   * Divide fracciones.
   * @param a dividendo.
   * @param b divisor.
   * @return cociente de las fracciones.
   */
  public static FraccionClass dividir(FraccionClass a, FraccionClass b) {
    FraccionClass f = new FraccionClass(a.num * b.den, a.den * b.num);
    f.simplifica();
    return f;
  }
  
  /**
   * División escalar.
   * @param a dividendo.
   * @param b divisor.
   * @return cociente.
   */
  public static FraccionClass dividir(FraccionClass a, int b) throws ArithmeticException {
    if (b == 0) {
      throw new ArithmeticException();
    }  
    return dividir(a, new FraccionClass(b, 1));
  }
  
  /**
   * División escalar.
   * @param a dividendo.
   * @param b divisor.
   * @return cociente.
   */
  public static FraccionClass dividir(int a, FraccionClass b) { 
    return dividir(new FraccionClass(a, 1), b);
  }
  
  /**
   * Divide el objeto Fracción actual por la fracción recibida como parámetro y actualiza numerador y denominador.
   * @param a
   */
  public void divide(FraccionClass a) {
    FraccionClass f = dividir(this, a);
    this.num = f.num;
    this.den = f.den;
  }

  /**
   * Divide el objeto Fracción actual por el entero recibido como parámetro y actualiza numerador y denominador.
   * @param a
   */
  public void divide(int a) {
    FraccionClass f = dividir(this, a);
    this.num = f.num;
    this.den = f.den;
  }
  
  /**
   * Calcula el máximo común divisor de dos números.
   * @param m primer número.
   * @param n segundo número.
   * @return máximo común divisor.
   */
  private static int mcd(int m, int n) {
    int u = Math.abs(m);
    int v = Math.abs(n);
    if (v == 0) {
      return u;
    }
    int r;
    while (v != 0) {
      r = u % v;
      u = v;
      v = r;
    }
    return u;
  }

  /**
   * Simplifica la fracción.
   */
  public void simplifica() {
    int d = mcd(this.num, this.den);
    this.num /= d;
    this.den /= d;
  }

  /**
   * @return Resultado de dividir numerador entre denominador.
   */
  public double resultado() {
    return (double) this.num / this.den;
  }
  
  public String toString() {
    return this.num + "/" + this.den;
  }
  
  public boolean equals(FraccionClass a) {
    return (this.num*a.den == this.den*a.num);   
  }
  
  public boolean equals(int a) {
    return equals(new FraccionClass(a, 1));   
  }

  @Override
  public int compareTo(FraccionClass a) {
    return (this.num*a.den - a.num*this.den);
  }
  
  public int compareTo(int a) {
    return this.compareTo(new FraccionClass(a, 1));
  }
  
}