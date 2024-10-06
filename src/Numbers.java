public class Numbers
{
    private double num_real, num_comp;
    public Numbers()
    {
        this(0, 0);
    }

    public Numbers(double num_real)
    {
        this(num_real, 0);
    }

    public  Numbers(double num_real, double num_comp)
    {
        this.num_real = num_real; this.num_comp = num_comp;
    }

    public void addition(Numbers first_num, Numbers second_num)
    {
        this.num_real = first_num.num_real + second_num.num_real;
        this.num_comp = first_num.num_comp + second_num.num_comp;
    }

    public void setter(double num_real)
    {
        this.setter(num_real, 0);
    }

    public void setter(double num_real, double num_comp)
    {
        this.num_real = num_real;
        this.num_comp = num_comp;
    }

    public double getNum_real()
    {
        return this.num_real;

    }

    public double getNum_comp()
    {
        return this.num_comp;
    }

    public void subtraction(Numbers first_num, Numbers second_num)
    {
        this.num_real = first_num.num_real - second_num.num_real;
        this.num_comp = first_num.num_comp - second_num.num_comp;
    }

    public void multiplication(Numbers first_num, Numbers second_num)
    {
        Numbers res_mult = new Numbers(0, 0);
        res_mult.num_real = first_num.num_real * second_num.num_real
                + (-1)*(first_num.num_comp * second_num.num_comp);
        res_mult.num_comp = first_num.num_real * second_num.num_comp
                + first_num.num_comp * second_num.num_real;
        this.num_real = res_mult.num_real; this.num_comp = res_mult.num_comp;
    }

    public void print_number()
    {
        if (this.num_comp < 0)
        {
            System.out.print(this.num_real + " - " + -this.num_comp + "i");
        }
        else if (this.num_comp >= 0)
        {
            System.out.print(this.num_real + " + " + this.num_comp + "i");
        }
    }
}
