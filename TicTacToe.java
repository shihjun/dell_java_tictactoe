import javax.xml.stream.events.Characters;

/**
 * TicTacToe
 */
public class TicTacToe {

  static Character checkRows(String[] rows) {
    for (int i = 0; i < rows.length; i++) {
      String row = rows[i];

      if (row.equals("XXX")) {
        return 'X';
      }
      if (row.equals("OOO")) {
        return 'O';
      }
    }
    return null;
  }

  static Character checkCols(String[] rows) {
    String[] cols = { "", "", "" };

    for (int rowNum = 0; rowNum < 3; rowNum++) {
      char[] rowArr = rows[rowNum].toCharArray();

      for (int colNum = 0; colNum < 3; colNum++) {
        cols[colNum] = cols[colNum] + rowArr[colNum];
      }
    }

    for (int i = 0; i < cols.length; i++) {
      String col = cols[i];

      if (col.equals("XXX")) {
        return 'X';
      }
      if (col.equals("OOO")) {
        return 'O';
      }
    }
    return null;
  }

  static Character checkDiags(String[] rows) {
    String[] diags = { "", "" };

    for (int rowNum = 0; rowNum < rows.length; rowNum++) {
      char[] rowArr = rows[rowNum].toCharArray();
      for (int colNum = 0; colNum < rows.length; colNum++) {
        // check left diagonal
        if (rowNum == colNum) {
          diags[0] = diags[0] + rowArr[colNum];
        }
        // check right diagonal
        if (rowNum + colNum == rows.length - 1) {
          diags[1] = diags[1] + rowArr[colNum];
        }
      }
    }

    for (int i = 0; i < diags.length; i++) {
      String dia = diags[i];

      if (dia.equals("XXX")) {
        return 'X';
      }
      if (dia.equals("OOO")) {
        return 'O';
      }
    }
    return null;
  }

  static String[] generateRows(String board) {
    String[] rows = { "", "", "" };
    char[] boardChars = board.toCharArray();

    for (int i = 0; i < boardChars.length; i++) {
      if (i >= 0 && i < 3) {
        rows[0] = rows[0] + boardChars[i];
      }
      if (i >= 3 && i < 6) {
        rows[1] = rows[1] + boardChars[i];
      }
      if (i >= 6 && i < 9) {
        rows[2] = rows[2] + boardChars[i];
      }
    }

    return rows;
  }

  static void print(String[] rows) {
    for (int i = 0; i < rows.length; i++) {
      System.out.println(rows[i]);
    }
  }

  static boolean checkWinner(String[] rows) {
    Character winner = null;

    // check the rows
    winner = checkRows(rows);

    // check the columns
    winner = checkCols(rows);

    // check the diagonals
    winner = checkDiags(rows);

    // if any of them have 3 pieces from the same player, that player won
    System.out.println(winner + " win");

    return true;
  }

  public static void main(String[] args) {
    String board = "X---X---X";
    // --X-X-X--
    // X---X---X
    String[] rows = generateRows(board);
    print(rows);
    checkWinner(rows);
  }
}
