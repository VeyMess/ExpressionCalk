package expression;

class FinalExpres
{
    private int defin;

    public FinalExpres(String inStr)
    {
        LinkList temp = new LinkList();
        String numb = "";
        for (int i = 0; i < inStr.length(); i++)
        {
            char symb = inStr.charAt(i);
            if (Character.isDigit(symb))
            {
                numb += symb;
                continue;
            }
            else if (symb == ',')
            {
                temp.insertFirst(Integer.parseInt(numb));
                numb = "";
                continue;
            }
            if(!numb.isEmpty())
            {
                temp.insertFirst(Integer.parseInt(numb));
                numb = "";                
            }
            int first, second, answer=0;
            second = temp.popFirst().getNum();
            first = temp.popFirst().getNum();
            switch (symb)
            {
                case '+':
                    answer = first + second;
                    break;
                case '-':
                    answer = first - second;
                    break;
                case '*':
                    answer = first * second;
                    break;
                case '/':
                    answer = first / second;
                    break;
            }
            temp.insertFirst(answer);
        }
        defin=temp.popFirst().getNum();
    }
    
    public int getAnswer()
    {
        return defin;
    }
    
}
