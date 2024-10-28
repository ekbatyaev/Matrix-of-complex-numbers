public class Matrix
{
    private Numbers[][] chisla;
    private int n, m;

    public Matrix(int n, int m)
    {
        chisla = new Numbers[n][m];
        this.n = n; this.m = m;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                chisla[i][j] = new Numbers(0, 0);
            }
        }
    }

    public void print_matrix()
    {
        for (int i = 0; i < this.n; i++)
        {
            for (int j = 0; j < this.m; j++)
            {
                System.out.print("(");
                this.chisla[i][j].print_number();
                System.out.print(") ");
            }
            System.out.println();
        }
    }

    public void add_elem(Numbers num, int i, int j)
    {
        this.chisla[i][j].setter(num.getNum_real(), num.getNum_comp());
    }

    private int check_compatibility(Matrix matrix_1, Matrix matrix_2)
    {
        if ((matrix_1.n == matrix_2.n) & (matrix_1.m == matrix_2.m))
        {return 2;}
        if (matrix_1.m == matrix_2.n) {return 1;}
        else {return 0;}
    }
    public Matrix summ_matrix(Matrix matrix_1, Matrix matrix_2)
    {
        Matrix matrix_summ = new Matrix(matrix_1.n, matrix_2.m);
        if (check_compatibility(matrix_1, matrix_2) == 2)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    matrix_summ.chisla[i][j].addition(matrix_1.chisla[i][j], matrix_2.chisla[i][j]);
                }
            }

        }
        else{System.out.println("Матрицы не совместимы");}
        return matrix_summ;
    }

    public Matrix substract_matrix(Matrix matrix_1, Matrix matrix_2)
    {
        Matrix matrix_sub = new Matrix(matrix_1.n, matrix_2.m);
        if  (check_compatibility(matrix_1, matrix_2) == 2)
        {

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    matrix_sub.chisla[i][j].subtraction(matrix_1.chisla[i][j], matrix_2.chisla[i][j]);
                }
            }

        }
        else{System.out.println("Матрицы не совместимы");}
        return matrix_sub;
    }

    public void multiplication_matrix(Matrix matrix_1, Matrix matrix_2)
    {
        Numbers mult = new Numbers(0, 0);
        if (check_compatibility(matrix_1, matrix_2) == 1)
        {
            Matrix result_matrix = new Matrix(matrix_1.n, matrix_2.m);
            for (int i = 0; i < result_matrix.n; i++)
            {
                for (int j = 0; j < result_matrix.m; j++)
                {
                    for (int k = 0; k < matrix_2.n; k++)
                    {
                        mult.multiplication(matrix_1.chisla[i][k], matrix_2.chisla[k][j]);
                        result_matrix.chisla[i][j].addition(result_matrix.chisla[i][j], mult) ;
                    }
                }
            }
            matrix_1.print_matrix();
            System.out.println("  *  ");
            matrix_2.print_matrix();
            System.out.println("  =  ");
            result_matrix.print_matrix();

        }
        else{System.out.println("Матрицы не совместимы");}

    }

    public Matrix transporation()
    {
        Matrix result_transp_matrix = new Matrix(this.m, this.n);
        for (int i = 0; i < this.n; i++)
        {
            for (int j = 0; j < this.m; j++)
            {
                result_transp_matrix.chisla[j][i] = this.chisla[i][j];
            }
        }
        return result_transp_matrix;
    }

public void determinant() {
    if (n != m) {
        System.out.println("Матрица не квадратная, детерминант не определен");
        return;
    }
    Numbers deter_num_res = calculate_determinant(this);
    System.out.print("Детерминант равен ");
    deter_num_res.print_number();
    System.out.println();
}

    private Numbers calculate_determinant(Matrix matrix) {
        int dimension = matrix.n;
        if (dimension == 1) {
            return matrix.chisla[0][0];
        } else if (dimension == 2) {
            Numbers result = new Numbers(0, 0);
            Numbers temp1 = new Numbers(0, 0), temp2 = new Numbers(0, 0);
            temp1.multiplication(matrix.chisla[0][0], matrix.chisla[1][1]);
            temp2.multiplication(matrix.chisla[0][1], matrix.chisla[1][0]);
            result.addition(result, temp1);
            result.subtraction(result, temp2);
            return result;
        }

        Numbers deter_num_res = new Numbers(0, 0);
        for (int i = 0; i < dimension; i++) {
            Matrix sub_matrix = new Matrix(dimension - 1, dimension - 1);
            for (int line = 1; line < dimension; line++) {
                int colIndex = 0;
                for (int col = 0; col < dimension; col++) {
                    if (col == i) continue;
                    sub_matrix.chisla[line - 1][colIndex++] = matrix.chisla[line][col];
                }
            }
            Numbers subDet = calculate_determinant(sub_matrix);
            if (i % 2 == 0) {
                subDet.multiplication(matrix.chisla[0][i], subDet);
                deter_num_res.addition(deter_num_res, subDet);
            } else {
                subDet.multiplication(matrix.chisla[0][i], subDet);
                deter_num_res.subtraction(deter_num_res, subDet);
            }
        }
        return deter_num_res;
    }
}
