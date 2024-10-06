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
    public void summ_matrix(Matrix matrix_1, Matrix matrix_2)
    {

        if (check_compatibility(matrix_1, matrix_2) == 2)
        {
            Matrix matrix_summ = new Matrix(matrix_1.n, matrix_2.m);
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    matrix_summ.chisla[i][j].addition(matrix_1.chisla[i][j], matrix_2.chisla[i][j]);
                }
            }
            matrix_1.print_matrix();
            System.out.println("  +  ");
            matrix_2.print_matrix();
            System.out.println("  =  ");
            matrix_summ.print_matrix();

        }
        else{System.out.println("Матрицы не совместимы");}
    }

    public void substract_matrix(Matrix matrix_1, Matrix matrix_2)
    {
        if  (check_compatibility(matrix_1, matrix_2) == 2)
        {
            Matrix matrix_sub = new Matrix(matrix_1.n, matrix_2.m);
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    matrix_sub.chisla[i][j].subtraction(matrix_1.chisla[i][j], matrix_2.chisla[i][j]);
                }
            }
            matrix_1.print_matrix();
            System.out.println("  -  ");
            matrix_2.print_matrix();
            System.out.println("  =  ");
            matrix_sub.print_matrix();

        }
        else{System.out.println("Матрицы не совместимы");}
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
    public void determinant()
    {
        Numbers deter_num_res= new Numbers(0, 0);
        Numbers mult = new Numbers(1, 0);
        if ((this.n == this.m) && (this.n == 1))
        {
            System.out.print("Детерминант равен " );
            this.chisla[0][0].print_number();
            System.out.println();
        }
        else if ((this.n == this.m) && (this.n == 2))
        {
            mult.multiplication(this.chisla[0][0],this.chisla[1][1]);
            deter_num_res.addition(deter_num_res, mult);
            mult.multiplication(this.chisla[1][0],this.chisla[0][1]);
            deter_num_res.subtraction(deter_num_res, mult);
            System.out.print("Детерминант равен ");
            deter_num_res.print_number();
            System.out.println();
        }
        else if ((this.n == this.m) && (this.n > 2))
        {
            for (int start = 0; start < this.n; start++)
            {
                int ind_i = 0, ind_j = start;
                while (ind_i < this.n)
                {
                    mult.multiplication(mult, this.chisla[(ind_i % n)][(ind_j % m)]);
                    ind_i++;
                    ind_j++;
                }
                deter_num_res.addition(deter_num_res, mult);
                mult.setter(1, 0);
            }
            mult.setter(1, 0);
            for (int start = 0; start < this.n; start++)
            {
                int ind_i = this.n - 1, ind_j = start;
                while (ind_i >= 0)
                {
                    mult.multiplication(mult, this.chisla[(ind_i % n)][(ind_j % m)]);
                    ind_i--;
                    ind_j++;
                }
                deter_num_res.subtraction(deter_num_res, mult);
                mult.setter(1, 0);

            }
            System.out.print("Детерминант равен ");
            deter_num_res.print_number();
            System.out.println();
        }
        else{System.out.println("Кол-во строк не равно кол-ву стобцов");}
    }
}
