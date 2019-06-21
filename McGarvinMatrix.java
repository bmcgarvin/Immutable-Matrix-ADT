/**
 * An implementation of the Matrix ADT. Provides four basic
 * operations over an
 * immutable type. These operations include scaling the
 * matrix by the provided
 * integer scalar, multiplying, adding, and subtracting two
 * matrixes. We can also
 * test to see if two matrixes equal one another.
 * 
 * Completion Time: 12 hours
 *
 * @author Bradley McGarvin, Ruben Acuna, tutorialspoint.com
 *         regarding Stringbuffer
 * @version 3/19/2019
 */

public class McGarvinMatrix implements Matrix {

   // instance variables
   private final int[][] myMatrix;

   private final int     xRows;

   private final int     yCols;

// ctor to make and assign to myMatrix
   public McGarvinMatrix(int[][] matrix) {

      // assigning 0 to rows and columns of length if matrix is
      // 0.
      if ( matrix.length == 0 ) {
         xRows = 0;
         yCols = 0;

      }
      else {
         xRows = matrix.length;
         yCols = matrix[0].length;

      }
      // deep cloning in order to make immutable
      myMatrix = new int[xRows][yCols];
      for ( int r = 0; r < xRows; r++ ) {
         for ( int c = 0; c < yCols; c++ ) {
            myMatrix[r][c] = matrix[r][c];
         }
      }

   }

   /**
    * Accesses the element at particular point in the
    * matrix.
    *
    * @return int element
    */

   public int getElement(int y , int x) {

      return myMatrix[y][x];

   }

   /**
    * Returns the number of rows in the matrix.
    * 
    * @return rows
    */
   public int getRows() {

      return xRows;

   }

   /**
    * Returns the number of columns in the matrix.
    * 
    * @return columns
    */
   public int getColumns() {

      return yCols;

   }

   /**
    * Returns this matrix scaled by a factor, essentially
    * multiplying each element in array by this factor and
    * using the result to create a new array.
    *
    * @param int
    *           scalar
    * @return matrix
    */
   public McGarvinMatrix scale(int scalar) {

      // variables to determine size, assign sum, and create
      // array same size
      int x = this.getRows();
      int y = this.getColumns();
      int[][] arrayScale = new int[x][y];
      int result = 0;
      int scaledResult = 0;

      // RuntimeException check
      if ( x != this.getRows() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal rows" );
      }
      if ( y != this.getColumns() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal columns" );
      }

      // nest for loop to get all elements is current matrix
      // 1-by-1
      // and to perform scale function, storing it in new
      // array.
      for ( int r = 0; r < arrayScale.length; r++ ) {
         for ( int c = 0; c < arrayScale[r].length; c++ ) {
            result = this.getElement( r, c );
            scaledResult = result * scalar;
            arrayScale[r][c] = scaledResult;
         }
      }

      return new McGarvinMatrix( arrayScale );

   }

   /**
    * Returns this matrix added with another matrix. That
    * is, computes A+B
    * where A and B are matrices (this object, and another
    * respectively).
    *
    * @return matrix
    * @throws RuntimeException
    *            if matrices do not have matching
    *            dimensions.
    */
   public McGarvinMatrix plus(Matrix other) {

      // variables to determine size, assign sum, and create
      // array same size
      int x = other.getRows();
      int y = other.getColumns();
      int[][] arrayPlus = new int[x][y];
      int result = 0;

      // RuntimeException check
      if ( x != this.getRows() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal rows" );
      }
      if ( y != this.getColumns() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal columns" );
      }

      // loop through each matrix to add each element of
      // each matrix located at same indexes
      // then add this result to the same indexes of a new
      // matrix.
      if ( (x == this.getRows()) && (y == this.getColumns()) ) {
         for ( int r = 0; r < this.getRows(); r++ ) {
            for ( int c = 0; c < this.getColumns(); c++ ) {
               result = this.getElement( r, c ) + other.getElement( r, c );
               arrayPlus[r][c] = result;
            }
         }
      }

      return new McGarvinMatrix( arrayPlus );

   }

   /**
    * Returns this matrix subtracted by another matrix.
    * 
    * @param other subtrahend
    * @return matrix
    * @throws RuntimeException
    *            if matrices do not have matching
    *            dimensions.
    */
   public McGarvinMatrix minus(Matrix other) {

      // variables to determine size, assign sum, and create
      // array same size
      int x = other.getRows();
      int y = other.getColumns();
      int[][] arrayMinus = new int[x][y];
      int result = 0;

      // RuntimeException check
      if ( x != this.getRows() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal rows" );
      }
      if ( y != this.getColumns() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal columns" );
      }

      // nested for loop to go through 2d array, perform
      // subtraction between
      // two arrays and store the result in a new 2d array.
      if ( (x == this.getRows()) && (y == this.getColumns()) ) {
         for ( int r = 0; r < this.getRows(); r++ ) {
            for ( int c = 0; c < this.getColumns(); c++ ) {
               result = other.getElement( r, c ) - this.getElement( r, c );
               arrayMinus[r][c] = result;
            }
         }
      }

      return new McGarvinMatrix( arrayMinus );

   }

   /**
    * Returns this matrix multiplied by another matrix.
    * 
    * @param other multiplicand
    * @return matrix
    * @throws RuntimeException
    *            if matrices do not have matching
    *            dimensions.
    */
   public McGarvinMatrix multiply(Matrix other) {

      // variables to determine size, assign sum, and create
      // array same size
      int x = other.getRows();
      int y = other.getColumns();
      int[][] arrayMultiply = new int[x][y];
      int result = 0;

      // RuntimeException check
      if ( x != this.getRows() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal rows" );
      }
      if ( y != this.getColumns() ) {
         throw new RuntimeException(
               "The two matrixes do not have equal columns" );
      }

      // nested for loop to go through matrix in order to
      // multiply two matrix
      // storing the result in a new array.
      if ( (x == this.getRows()) && (y == this.getColumns()) ) {
         for ( int r = 0; r < this.getRows(); r++ ) {
            for ( int c = 0; c < this.getColumns(); c++ ) {
               result = this.getElement( r, c ) * other.getElement( r, c );
               arrayMultiply[r][c] = result;
            }
         }
      }

      return new McGarvinMatrix( arrayMultiply );

   }

   /**
    * Returns true if this matrix matches another matrix.
    * 
    * @param other another matrix
    * @return equality
    */
   @Override
   public boolean equals(Object other) {

 //     Matrix cast = (Matrix) other;

      if ( other == null ) {
         return false;
      }

      if ( other == "MATRIX" ) {
         return false;
      }

      if ( other == this ) {
         return true;
      }
      /*
       * I could not figure out how to compare each element
       * of array,
       * to show that m3 and m4 are equal, I kept getting
       * indexoutofbounds. This was my attempt...
       */
      /*
       * Matrix cast = (Matrix) other;
       * 
       * for(int r = 0; r < getRows(); r++){
       *     for(int c = 0; c < getColumns(); c++){
       *        int resultOne = getElement(r, c);
       *        int resultTwo = cast.getElement(r, c);
       *        if( resultOne == resultTwo){
       *           return true;
       *        }
       *     }
       * }
       */

      return false;

   }

   /**
    * Used tutorialspoint.com to learn more about
    * Stringbuffer and how to implement.
    * 
    * This method formats output to have rows separated
    * by new lines, and columns by spaces.
    */
   @Override
   public String toString() {

      StringBuffer output = new StringBuffer();

      for ( int r = 0; r < myMatrix.length; r++ ) {
         for ( int c = 0; c < myMatrix[r].length; c++ ) {
            output.append( (myMatrix[r][c]) + " " );
         }
         output.append( "\n" );

      }

      return output.toString();

   }

   /**
    * Entry point for matrix testing.
    * 
    * @param args
    *           the command line arguments
    */
   public static void main(String[] args) {

      int[][] data1 = new int[0][0];
      int[][] data2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
      int[][] data3 = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };
      int[][] data4 = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } };

      Matrix m1 = new McGarvinMatrix( data1 );
      Matrix m2 = new McGarvinMatrix( data2 );
      Matrix m3 = new McGarvinMatrix( data3 );
      Matrix m4 = new McGarvinMatrix( data4 );

      System.out.println(
            "m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns() );
      System.out.println(
            "m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns() );
      System.out.println(
            "m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns() );

      // check for reference issues
      System.out.println( "m2 -->\n" + m2 );
      data2[1][1] = 101;
      System.out.println( "m2 -->\n" + m2 );

      // test equals
      System.out.println( "m2==null: " + m2.equals( null ) );             // false
      System.out.println( "m3==\"MATRIX\": " + m2.equals( "MATRIX" ) );   // false
      System.out.println( "m2==m1: " + m2.equals( m1 ) );                 // false
      System.out.println( "m2==m2: " + m2.equals( m2 ) );                 // true
      System.out.println( "m2==m3: " + m2.equals( m3 ) );                 // false
      System.out.println( "m3==m4: " + m3.equals( m4 ) );                 // true

      // test operations (valid)
      System.out.println( "2 * m2:\n" + m2.scale( 2 ) );
      System.out.println( "m2 + m3:\n" + m2.plus( m3 ) );
      System.out.println( "m2 - m3:\n" + m2.minus( m3 ) );

      // not tested... multiply(). you know what to do.

      // test operations (invalid)
      // System.out.println("m1 + m2" + m1.plus(m2));
      // System.out.println("m1 - m2" + m1.minus(m2));
   }
}
