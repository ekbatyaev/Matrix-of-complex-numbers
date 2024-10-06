//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        //Вносим размерности матриц сложения, вычитания и для вычисления детерминанта
        int n_1 = 3, m_1 = 3, n_2 = 3, m_2 = 3;
        Matrix matrix_one = new Matrix(n_1, m_1);
        Matrix matrix_two = new Matrix(n_2, m_2);
        //Пишем значение для первой и второй матрицы
        Numbers [][] matrix_1_elem = {{new Numbers(1, -2), new Numbers(3, 1), new Numbers(2, -1)},
                {new Numbers(2, 0), new Numbers(4, -3), new Numbers(0, 0)},
                {new Numbers(-3, 0), new Numbers(1, 0), new Numbers(1, 1)}};

        Numbers [][] matrix_2_elem = {{new Numbers(11, 0), new Numbers(0, 1), new Numbers(1, 1)},
                {new Numbers(0, -1), new Numbers(-2, 0), new Numbers(0, 3)},
                {new Numbers(1, -1), new Numbers(0, -3), new Numbers(1, 0)}};
        //Присваиваем эти значения первой и второй матрице
        for (int i = 0; i < n_1; i++)
        {
            for (int j = 0; j < m_1; j++)
            {
                matrix_one.add_elem(matrix_1_elem[i][j], i, j);
            }
        }

        for (int i = 0; i < n_2; i++)
        {
            for (int j = 0; j < m_2; j++)
            {
                matrix_two.add_elem(matrix_2_elem[i][j], i, j);
            }
        }

        //Выводим матрицы и их значение детерминанта
        System.out.println("Матрица: ");
        matrix_one.print_matrix();
        matrix_one.determinant();
        System.out.println();

        System.out.println("Матрица: ");
        matrix_two.print_matrix();
        matrix_two.determinant();
        System.out.println();

        //Сумма и разность матриц
        System.out.println("Сумма матриц: ");
        matrix_one.summ_matrix(matrix_one, matrix_two);
        System.out.println();

        System.out.println("Разность матриц: ");
        matrix_one.substract_matrix(matrix_one, matrix_two);
        System.out.println();

        //Создание матриц для произведения
        int n_3 = 2, m_3 = 3, n_4 = 3, m_4 = 2;
        Matrix matrix_1_proz = new Matrix(n_3, m_3);
        Matrix matrix_2_proz = new Matrix(n_4, m_4);
        //Пишем значение для первой и второй матрицы
        Numbers [][] matrix_1_el_proz = {{new Numbers(1, -2), new Numbers(3, 1), new Numbers(2, -1)},
                {new Numbers(2, 0), new Numbers(4, -3), new Numbers(0, 0)}};

        Numbers [][] matrix_2_el_proz = {{new Numbers(11, 0), new Numbers(0, 1)},
                {new Numbers(0, -1), new Numbers(-2, 0)},
                {new Numbers(1, -1), new Numbers(0, -3)}};
        //Присваиваем эти значения первой и второй матрице
        for (int i = 0; i < n_3; i++)
        {
            for (int j = 0; j < m_3; j++)
            {
                matrix_1_proz.add_elem(matrix_1_el_proz[i][j], i, j);
            }
        }

        for (int i = 0; i < n_4; i++)
        {
            for (int j = 0; j < m_4; j++)
            {
                matrix_2_proz.add_elem(matrix_2_el_proz[i][j], i, j);
            }
        }

        //Перемножение матриц
        System.out.println("Перемножение матриц: ");
        matrix_1_proz.multiplication_matrix(matrix_1_proz, matrix_2_proz);
        System.out.println();

        //Транспонирование матриц
        System.out.println("Транспонирование матриц " + "\n" +
                "Первая матрица до:");
        matrix_1_proz.print_matrix();
        matrix_1_proz = matrix_1_proz.transporation();
        System.out.println("Транспонированная матрица: ");
        matrix_1_proz.print_matrix();
        System.out.println("Вторая матрица до: ");
        matrix_2_proz.print_matrix();
        matrix_2_proz = matrix_2_proz.transporation();
        System.out.println("Транспонированная матрица: ");
        matrix_2_proz.print_matrix();
        System.out.println();
    }
}
